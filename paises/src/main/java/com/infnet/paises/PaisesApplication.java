package com.infnet.paises;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
public class PaisesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaisesApplication.class, args);
	}

}
