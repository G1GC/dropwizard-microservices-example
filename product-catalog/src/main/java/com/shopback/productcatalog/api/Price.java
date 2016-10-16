package com.shopback.productcatalog.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Karthik Jayaraman
 *
 */
public class Price {
	private int listPrice;
	private int salePrice;
	private PriceUnit unit;

	/**
	 * @return the listPrice
	 */
	@JsonProperty
	public int getListPrice() {
		return listPrice;
	}

	/**
	 * @param listPrice
	 *            the listPrice to set
	 */
	@JsonProperty
	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}

	/**
	 * @return the salePrice
	 */
	@JsonProperty
	public int getSalePrice() {
		return salePrice;
	}

	/**
	 * @param salePrice
	 *            the salePrice to set
	 */
	@JsonProperty
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * @return the unit
	 */
	@JsonProperty
	public PriceUnit getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	@JsonProperty
	public void setUnit(PriceUnit unit) {
		this.unit = unit;
	}

}
