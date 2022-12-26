package soc.contrat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
// import org.springframework.context.annotation.Bean;
// import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class ContratApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContratApplication.class, args);
	}

	// @Bean
    // public RestTemplate restTemplate(){
    //     return new RestTemplate();
    // }


}
