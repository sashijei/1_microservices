package com.mercy.product_service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
class ProductController {
	
	@GetMapping
	public List<String> getproducts() {
		return List.of("Book", "Laptop", "Smartphone");
	}
}
