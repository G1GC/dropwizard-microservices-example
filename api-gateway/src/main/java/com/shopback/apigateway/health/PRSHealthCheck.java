package com.shopback.apigateway.health;

import com.codahale.metrics.health.HealthCheck;
import com.google.inject.Inject;
import com.shopback.apigateway.client.ProductReviewClient;

/**
 * @author Karthik Jayaraman
 *
 */
public class PRSHealthCheck extends HealthCheck {
	@Inject
	private ProductReviewClient client;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.codahale.metrics.health.HealthCheck#check()
	 */
	@Override
	protected Result check() throws Exception {
		if (client.isClientHealthy())
			return Result.healthy();
		return Result.unhealthy("Product review client is unhealthy!");
	}
}
