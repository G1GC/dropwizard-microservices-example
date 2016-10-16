package com.shopback.productreview.health;

import com.codahale.metrics.health.HealthCheck;
import com.google.inject.Inject;
import com.shopback.productreview.core.service.ProductReviewService;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductReviewServiceHealthCheck extends HealthCheck {

	@Inject
	private ProductReviewService productReviewService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.codahale.metrics.health.HealthCheck#check()
	 */
	@Override
	protected Result check() throws Exception {
		if (!productReviewService.getAllProductReviews("SKU-000").isEmpty()) {
			return Result.healthy();
		}
		return Result.unhealthy("Unable to retrieve the product reviews for id:SKU-000");
	}

}
