package com.shopback.apigateway.api;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductRepresentation {

	private HashMap<String, Object> productCatalog;
	private List<HashMap<String, Object>> productReviews;

	/**
	 * @return the productCatalog
	 */
	@JsonProperty
	public HashMap<String, Object> getProductCatalog() {
		return productCatalog;
	}

	/**
	 * @param productCatalog
	 *            the productCatalog to set
	 */
	@JsonProperty
	public void setProductCatalog(HashMap<String, Object> productCatalog) {
		this.productCatalog = productCatalog;
	}

	/**
	 * @return the productReviews
	 */
	@JsonProperty
	public List<HashMap<String, Object>> getProductReviews() {
		return productReviews;
	}

	/**
	 * @param productReviews
	 *            the productReviews to set
	 */
	@JsonProperty
	public void setProductReviews(List<HashMap<String, Object>> productReviews) {
		this.productReviews = productReviews;
	}

}
