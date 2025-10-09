package com.mercy.client_side_discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController 
@RequestMapping("/api/aggregator")
public class CustomerClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/customer/{id}")
	public Object getCustomer(@PathVariable long id) {
        
		// uses Eureka client-side discovery
		String url = "http://customer-service/api/customers/" + id;
		
		return restTemplate.getForObject(url, Object.class);
	}
}
