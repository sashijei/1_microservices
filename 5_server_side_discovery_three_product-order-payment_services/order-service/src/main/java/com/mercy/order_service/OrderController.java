package com.mercy.order_service;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@GetMapping("/{orderId}")
	public Map<String, Object> getOrder(@PathVariable Long orderId) {
		
		return Map.of("orderId", orderId, "name", "Phone", "status", "IN_PROGRESS", "amount", 50000);
	}
}
