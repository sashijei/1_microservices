package com.mercy.review_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Review {
	@Id
	private Long id;
	private String comment;
	private Long productId;
}
