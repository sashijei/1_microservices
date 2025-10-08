package com.mercy.aggregator_service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerOrderResponse {
	private CustomerDTO customer;
	private List<OrderDTO> orders;
}
