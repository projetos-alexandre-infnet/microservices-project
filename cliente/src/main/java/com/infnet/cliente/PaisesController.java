package com.infnet.cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PaisesController{

    private Client client;

    public PaisesController(Client client) {
        this.client = client;
    }

    @GetMapping("/phone-code")
    public ResponseEntity<String> getPhoneCodeByCountryName(@RequestParam("name") String name) {
        return client.getCountry(name);
    }
}
