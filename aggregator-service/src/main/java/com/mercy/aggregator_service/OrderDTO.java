package com.mercy.aggregator_service;

import lombok.Data;

@Data
public class OrderDTO {
	private Long id;
	private String item;
	private Long custId;
}
