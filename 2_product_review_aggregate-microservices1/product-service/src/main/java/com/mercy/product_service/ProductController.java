package com.mercy.product_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository repo;
	
	@PostMapping
	public Product storeProduct(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@GetMapping("/{id}")
	public Product retrieveProduct(@PathVariable Long id) {
		return repo.findById(id).orElseThrow();
	}
}
