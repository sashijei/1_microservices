package com.mercy.product_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	private long id;
	private String name;
	private String description;
}