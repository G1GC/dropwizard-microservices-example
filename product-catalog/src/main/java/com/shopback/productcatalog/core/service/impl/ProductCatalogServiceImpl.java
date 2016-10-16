package com.shopback.productcatalog.core.service.impl;

import java.util.List;

import com.google.inject.Inject;
import com.shopback.productcatalog.core.domain.ProductCatalog;
import com.shopback.productcatalog.core.service.ProductCatalogService;
import com.shopback.productcatalog.db.ProductCatalogDAO;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductCatalogServiceImpl implements ProductCatalogService {

	@Inject
	ProductCatalogDAO productCatalogDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shopback.productcatalog.core.service.ProductDetailsService#
	 * getProductDetails(java.lang.String)
	 */
	public ProductCatalog getProductDetails(String productId) {
		return productCatalogDAO.findById(productId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shopback.productcatalog.core.service.ProductCatalogService#
	 * getAllProductDetails()
	 */
	@Override
	public List<ProductCatalog> getAllProductDetails() {
		return productCatalogDAO.findAll();
	}

}
