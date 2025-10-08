package com.mercy.aggregator_service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductReviewResponse {
	private ProductDTO product;
	private List<ReviewDTO> reviews;
}
