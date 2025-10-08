package com.mercy.review_service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface ReviewRepository extends JpaRepository<Review, Long>{
	
	public List<Review> findByProductId(Long productId);
}
