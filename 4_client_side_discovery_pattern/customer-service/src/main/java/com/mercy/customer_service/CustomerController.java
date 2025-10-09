package com.mercy.customer_service;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@GetMapping("/{id}")
	public Map<String, Object> getCustomer(@PathVariable Long id) {
		// just hard-coding the values
		return Map.of("id", id, "name", "Angel", "email", "mercy@gmail.com");
	}
}
 