package com.infnet.cliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PaisesController{

    private Client client;

    private static Logger log = (Logger) LoggerFactory.getLogger(PaisesController.class);

    public PaisesController(Client client) {
        this.client = client;
    }

    @GetMapping("/phone-code")
    public ResponseEntity<String> getPhoneCodeByCountryName(@RequestParam("name") String name) {
        log.info("==>>> obtendo codigo do pais: {}", name);
        ResponseEntity<String> country = client.getCountry(name);
        log.info("-->> codigo obtido: {}", country.getBody());
        return country ;
    }
}
