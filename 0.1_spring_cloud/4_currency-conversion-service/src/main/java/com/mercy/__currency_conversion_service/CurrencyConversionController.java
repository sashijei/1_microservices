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
 * REST controller to handle currency conversion requests.
 * It calls another microservice via RestTemplate to get currency exchange rates
 * and calculates the total converted amount based on the requested quantity.
 * 
 * @author Sasi Kumar
 */
@RestController
public class CurrencyConversionController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	  /**
     * Converts a specified quantity from one currency to another.
     *
     * @param from     The source currency code (e.g., USD)
     * @param to       The target currency code (e.g., INR)
     * @param quantity The quantity of the source currency to convert
     * @return A CurrencyConversion object containing exchange rate and calculated total
     *
     * This method constructs the URI to call the currency exchange microservice,
     * expands the path variables in the URI properly, makes a REST GET request, and
     * then computes the total converted amount by multiplying the quantity with the conversion multiple.
     */
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
				quantity,
				obj.getConversionMultiple(), 
				quantity.multiply(obj.getConversionMultiple()), 
				obj.getEnvironment());
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {

		CurrencyConversion obj = proxy.retrieveExchangeValue(from, to);

		return new CurrencyConversion(obj.getId(), 
				obj.getFrom(), 
				obj.getTo(), 
				quantity,
				obj.getConversionMultiple(), 
				quantity.multiply(obj.getConversionMultiple()), 
				obj.getEnvironment() + " : feign");
	}
} 

@Configuration
class AppConfig { 

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	} 
}