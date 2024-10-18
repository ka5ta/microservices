package com.example.gateway_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions.circuitBreaker;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;

@Configuration
public class RouteConfiguration {

    	@Bean
	public RouterFunction<ServerResponse> gatewayRouterFunctionsCircuitBreakerNoFallback() {
		return route("product-route")
				.route(path("/catalog/**"), http("http://localhost:8080"))
				.filter(circuitBreaker("CircuitBreaker", "/product-fallback"))
				.build();
	}
}
