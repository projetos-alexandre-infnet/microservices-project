package com.infnet.paises;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Países API", version = "1.0", description = "Expõe registros de países com seus respectivos códigos"))
public class PaisesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaisesApplication.class, args);
	}

}
