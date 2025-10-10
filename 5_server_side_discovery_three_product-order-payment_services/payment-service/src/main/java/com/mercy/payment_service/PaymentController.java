package com.mercy.payment_service;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@GetMapping("/{paymentId}")
	public Map<String, Object> getPaymentStatus(@PathVariable Long paymentId) {
		return Map.of("paymentId", paymentId, "status", "PAID");
	}
}
