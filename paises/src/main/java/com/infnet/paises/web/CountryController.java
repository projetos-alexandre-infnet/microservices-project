package com.infnet.paises.web;

import com.infnet.paises.model.service.CountryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class CountryController {

    private CountryService service;

    private static Logger log = (Logger) LoggerFactory.getLogger(CountryController.class);

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("/countries")
    public ResponseEntity<String> findCodeByCountryName(@RequestParam("name") String name) {
        String founded = service.findByCountryName(name);
        log.info("==>>> obtendo codigo: {}", founded);
        return new ResponseEntity<>(founded, HttpStatus.OK);
    }
}
