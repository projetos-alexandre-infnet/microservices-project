package com.infnet.cliente;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PaisesController{

    private PaisesAPIClient client;

    public PaisesController(PaisesAPIClient client) {
        this.client = client;
    }

    @GetMapping("/phone-code/{country}")
    public ResponseEntity<String> getPhoneCodeByCountryName(String country) {
        String codeByCountryName = client.getCodeByCountryName(country);

        return new ResponseEntity<>(codeByCountryName, HttpStatus.OK);
    }
}
