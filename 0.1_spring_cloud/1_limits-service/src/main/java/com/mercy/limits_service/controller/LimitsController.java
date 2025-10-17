package com.mercy.limits_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercy.limits_service.model.Limits;
import com.mercy.limits_service.config.*;

/**
 * REST Controller for Limits Microservice.
 * 
 * This controller exposes an endpoint "/limits" that returns the minimum and maximum 
 * limits configured for the service. These configuration values are loaded from an 
 * externalized configuration source - a local Git repository accessed using 
 * Spring Cloud Config Server microservice.
 * 
 * The Spring Cloud Config Server serves properties (such as minimum and maximum limits) 
 * from the local Git repo, and these values are injected into the LimitsConfiguration 
 * class using Spring's @ConfigurationProperties mechanism.
 * 
 * When the client calls the "/limits" endpoint, this controller reads the current 
 * min and max values from `LimitsConfiguration` and returns them wrapped in a 
 * `Limits` object as the response.
 *
 * This design promotes externalized configuration management and supports 
 * centralized configuration updates without redeploying the application.
 * 
 * @author Sasi Kumar
 */
@RestController
public class LimitsController {

	@Autowired
	private LimitsConfiguration config;
	
	@GetMapping("/limits")
	public Limits getLimits() {
		return new Limits(config.getMinimum(), config.getMaximum());
	} 
} 
 