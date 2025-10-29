package com.mercy.api_gateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration { 
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		 
			// Defining the routing logic and returning 
		
			return builder.routes()
					.route(p -> p.path("/currency-exchange/**")
									.uri("lb://currency-exchange"))
					.route(p -> p.path("/currency-conversion/**")
									.uri("lb://currency-conversion"))
					.route(p -> p.path("/currency-conversion-feign/**")
									.uri("lb://currency-conversion"))
					.build();
	}
}
