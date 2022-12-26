package soc.contrat.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import soc.contrat.services.Dto.AssureDto;

@FeignClient(value = "assure-service", url = "http://localhost:8082")
public interface APIClient {
    @GetMapping(value = "http://localhost:8082/assure/retrieve-all-Assure")
    AssureDto getAssureById(@PathVariable("id") String assureId);
}
