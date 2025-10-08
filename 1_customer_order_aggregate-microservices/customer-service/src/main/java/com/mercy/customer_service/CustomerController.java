package com.mercy.customer_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository repo;

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return repo.save(customer);
	}
	
	@GetMapping("/{id}")
	public Customer retrieveCustomer(@PathVariable long id) {
		return repo.findById(id).orElseThrow();
	}
}
