package com.mercy.review_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
class ReviewController {

	@Autowired
	private ReviewRepository repo;
	
	@PostMapping
	public Review storeReview(@RequestBody Review review) {
		return repo.save(review);
	}
	
	@GetMapping("/{id}")
	public List<Review> retrieveForReview(@PathVariable Long id) {
		return repo.findByProductId(id);
	}
}
