package com.shopback.productcatalog.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Karthik Jayaraman
 *
 */
public class ShippingInfo {
	private double weight;
	private Dimension dimension;

	/**
	 * @return the weight
	 */
	@JsonProperty
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	@JsonProperty
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the dimension
	 */
	@JsonProperty
	public Dimension getDimension() {
		return dimension;
	}

	/**
	 * @param dimension
	 *            the dimension to set
	 */
	@JsonProperty
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

}
