package com.mercy.customer_service;

import lombok.Data;

@Data
public class OrderDTO {
	private Long orderId;
	private Long customerId;
	private String product;
}
 