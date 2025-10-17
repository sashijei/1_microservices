package com.mercy.__currency_conversion_service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Author : Sasi Kumar
 */
@RestController
public class CurrencyConversionController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {

		String url = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";

		UriComponents uriComponents = UriComponentsBuilder
				.fromUriString(url)
				.buildAndExpand(from, to);

		CurrencyConversion obj = restTemplate.getForObject(
				uriComponents.toUri(), CurrencyConversion.class);

		return new CurrencyConversion(obj.getId(), 
				obj.getFrom(), 
				obj.getTo(), 
				obj.getQuantity(), obj.getConversionMultiple(), 
				quantity.multiply(obj.getConversionMultiple()), 
				obj.getEnvironment());
	}
}

@Configuration
class AppConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	} 
}