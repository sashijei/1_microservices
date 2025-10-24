package com.mercy.order_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-api")
public class OrderController {

	@Autowired
	private OrderRepository repo;
	
	@PostMapping
	public Order storeOrder(@RequestBody Order order) {
		return repo.save(order);
	}
	
	@GetMapping("/customer/{customerId}") 
	public List<Order> getOrderByCustomerId(@PathVariable Long customerId) {
		return repo.findByCustomerId(customerId);
	}
}