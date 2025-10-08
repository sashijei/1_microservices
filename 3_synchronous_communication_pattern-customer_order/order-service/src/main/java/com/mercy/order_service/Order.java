package com.mercy.order_service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "orders")
public class Order {
	@Id
	@Column(name = "id")
	private Long orderId;
	private String product;
	private Long customerId;
}
