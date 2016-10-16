package com.shopback.productcatalog.core.service;

import java.util.List;

import com.shopback.productcatalog.core.domain.ProductCatalog;

/**
 * @author Karthik Jayaraman
 *
 */
public interface ProductCatalogService {

	public ProductCatalog getProductDetails(String productId);

	public List<ProductCatalog> getAllProductDetails();

}
