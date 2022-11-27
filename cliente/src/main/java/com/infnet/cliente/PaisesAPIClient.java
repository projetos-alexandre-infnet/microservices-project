package com.infnet.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "paisesClient", url = "http://localhost:8089")
public interface PaisesAPIClient {

    @GetMapping("/api/v1/countries")
    String getCodeByCountryName(@RequestParam("name") String name);
}
