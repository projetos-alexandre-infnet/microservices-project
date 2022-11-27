package com.infnet.paises.web;

import com.infnet.paises.model.service.CountryService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CountryController {

    private CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("/countries")
    public HttpEntity<String> findCodeByCountryName(@RequestParam("name") String name) {
        String founded = service.findByCountryName(name);
        return new HttpEntity<>(founded);
    }
}
