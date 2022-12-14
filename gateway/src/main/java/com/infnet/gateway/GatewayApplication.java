package com.infnet.gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class GatewayApplication {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
								.path("/api/v1/countries/**")
								.uri("http://localhost:8089")
				)
				.route(p -> p
						.path("/api/v1/phone-code/**")
						.filters(f ->f.circuitBreaker(config -> config
								.setName("mycmd")
								.setFallbackUri("forward:/fallback"))
						)
						.uri("http://localhost:8088")
				)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@RequestMapping("/fallback")
	public Mono<String> fallback() {
		return Mono.just("fallback");
	}

}