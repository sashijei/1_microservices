package com.mercy.customer_service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer-api")
public class CustomerController {

	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	 
	@PostMapping
	public Customer storeCustomer(@RequestBody Customer customer) {
		return repo.save(customer);
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return repo.findById(id).orElseThrow();
	}
	
	@GetMapping("/order/customer/{id}")
	public List<OrderDTO> getCustomerOrder(@PathVariable Long id) {
		String url = "http://localhost:8081//order-api/customer/" +id; 
		OrderDTO[] orders = restTemplate.getForObject(url, OrderDTO[].class);
		return Arrays.asList(orders);
	}
}

@Configuration
class Config {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}