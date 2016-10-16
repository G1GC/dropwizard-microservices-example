package com.shopback.apigateway.health;

import com.codahale.metrics.health.HealthCheck;
import com.google.inject.Inject;
import com.shopback.apigateway.client.ProductCatalogClient;

/**
 * @author Karthik Jayaraman
 *
 */
public class PCSHealthCheck extends HealthCheck {

	@Inject
	private ProductCatalogClient client;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.codahale.metrics.health.HealthCheck#check()
	 */
	@Override
	protected Result check() throws Exception {
		if (client.isClientHealthy())
			return Result.healthy();
		return Result.unhealthy("Product catalog client is unhealthy!");
	}

}
