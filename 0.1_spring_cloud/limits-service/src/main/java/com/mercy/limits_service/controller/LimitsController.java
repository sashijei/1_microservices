package com.mercy.limits_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercy.limits_service.model.Limits;
import com.mercy.limits_service.config.*;

@RestController
public class LimitsController {

	@Autowired
	private LimitsConfiguration config;
	
	@GetMapping("/limits")
	public Limits getLimits() {
		
		return new Limits(config.getMinimum(), config.getMaximum());
//		return new Limits(1, 1000);
	} 
} 
 