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
		
		System.out.println("client-side-discovery : CustomerClient : getCustomer() : \n"
				+ "Going to invoke the customer-service." );
		
		Object object = restTemplate.getForObject(url, Object.class);
		
		System.out.println("client-side-discovery : CustomerClient : getCustomer() : \n"
				+ "calling is completed, returning the object to client (browswer)" );
		
		return object;
	}
}
