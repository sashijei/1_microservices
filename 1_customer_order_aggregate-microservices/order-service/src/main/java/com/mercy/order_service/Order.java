package com.mercy.order_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "Orders") 
public class Order {

	@Id 
	private long id;
	private String item;
	private long custId;
}
