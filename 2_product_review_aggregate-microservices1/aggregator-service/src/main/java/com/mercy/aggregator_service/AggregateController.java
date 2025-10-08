package com.mercy.aggregator_service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/aggregator")
public class AggregateController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/Product/{id}")
	public ProductReviewResponse getProductReviews(@PathVariable Long id) {
		ProductDTO product = restTemplate.getForObject("http://localhost:8084/products/" +id, ProductDTO.class);

		ReviewDTO[] reviews = restTemplate.getForObject("http://localhost:8085/reviews/" +id, ReviewDTO[].class);

		return new ProductReviewResponse(product, Arrays.asList(reviews));
	}
}

@Configuration
class Config {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
