package com.infnet.cliente;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("paises")
public interface Client {

    @GetMapping("/api/v1/countries")
    @LoadBalanced
    ResponseEntity<String> getCountry(@RequestParam("name") String name);
}
