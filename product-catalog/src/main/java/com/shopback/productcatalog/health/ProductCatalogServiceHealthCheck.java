package com.shopback.productcatalog.health;

import com.codahale.metrics.health.HealthCheck;
import com.google.inject.Inject;
import com.shopback.productcatalog.core.service.ProductCatalogService;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductCatalogServiceHealthCheck extends HealthCheck {

	@Inject
	private ProductCatalogService productCatalogService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.codahale.metrics.health.HealthCheck#check()
	 */
	@Override
	protected Result check() throws Exception {
		if (productCatalogService.getProductDetails("SKU-000") != null) {
			return Result.healthy();
		}
		return Result.unhealthy("Unable to retrieve the product catalog details for id:SKU-000");
	}

}
