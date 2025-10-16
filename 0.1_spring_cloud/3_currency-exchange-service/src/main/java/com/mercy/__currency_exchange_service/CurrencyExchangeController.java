package com.mercy.__currency_exchange_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController { 
 
	@Autowired
	private CurrencyExchangeRepository repo;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		var obj = repo.findByFromAndTo(from, to);

		String port = env.getProperty("local.server.port");
		obj.setPort(port);
		
		return obj;
	} 
}
 