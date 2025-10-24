package com.mercy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercy.entity.Payment;
import com.mercy.repository.PaymentRepository;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentRepository paymentRepository;

	@PostMapping
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
		Payment savedPayment = paymentRepository.save(payment);
		return ResponseEntity.ok(savedPayment);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
		Optional<Payment> payment = paymentRepository.findById(id);
		return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping
	public ResponseEntity<List<Payment>> getAllPayments() {
		List<Payment> payments = paymentRepository.findAll();
		return ResponseEntity.ok(payments);
	}
	

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
