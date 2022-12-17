package soc.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthGlobaleFilter implements GlobalFilter {

    @Autowired
    private WebClient.Builder webClientBuilder;

    final RestTemplate restTemplate;

    public AuthGlobaleFilter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Mono filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String requestPath = exchange.getRequest().getPath().toString();
        boolean header = exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION);
        boolean authPathIsFound = requestPath.contains("/api/auth/");
        boolean MissionPathIsFound = requestPath.contains("mission");
        boolean AssurePathIsFound = requestPath.contains("assure");
        boolean VehiculePathIsFound = requestPath.contains("vehicule");
        boolean ConstatPathIsFound = requestPath.contains("constat");
        boolean ContratPathIsFound = requestPath.contains("contrat");
        boolean AssurancePathIsFound = requestPath.contains("assurance");
        boolean ExpertPathIsFound = requestPath.contains("expert");

        if (!authPathIsFound && !MissionPathIsFound && !AssurePathIsFound && !VehiculePathIsFound && !ConstatPathIsFound
                && !ContratPathIsFound && !AssurancePathIsFound && !ExpertPathIsFound) {

            if (!header) {

                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            String[] parts = authHeader.split(" ");

            if (parts.length != 2 || !"Bearer".equals(parts[0])) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
            boolean isValide = Boolean.TRUE.equals(restTemplate
                    .getForObject("http://localhost:8087/auth-service/api/auth/" + parts[1], Boolean.class));
            if (!isValide) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();

            }
        }


        return chain.filter(exchange);
    }
}