package com.mercy.aggregator_service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/aggregate")
public class AggregateController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/customer/{custId}")
	public CustomerOrderResponse getCustomerOrders(@PathVariable Long custId) {
		
		CustomerDTO customer = restTemplate.getForObject("http://localhost:8081/customers/" +custId, CustomerDTO.class);
		
		OrderDTO[] orders = restTemplate.getForObject("http://localhost:8082/orders/customer/" +custId, OrderDTO[].class);
		
		return new CustomerOrderResponse(customer, Arrays.asList(orders));
	}
}

@Configuration
class Config {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}