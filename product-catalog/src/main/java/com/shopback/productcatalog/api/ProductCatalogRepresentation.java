package com.shopback.productcatalog.api;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductCatalogRepresentation {

	private String skuId;
	private List<ProductDescription> descriptions;
	private String name;
	private ShippingInfo shippingInfo;
	private List<String> categories;
	private Price price;
	private Map<String, Object> additionalAttr;

	/**
	 * @return the skuId
	 */
	@JsonProperty
	public String getSkuId() {
		return skuId;
	}

	/**
	 * @param skuId
	 *            the skuId to set
	 */
	@JsonProperty
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	/**
	 * @return the descriptions
	 */
	@JsonProperty
	public List<ProductDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions
	 *            the descriptions to set
	 */
	@JsonProperty
	public void setDescriptions(List<ProductDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * @return the name
	 */
	@JsonProperty
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the shippingInfo
	 */
	@JsonProperty
	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	/**
	 * @param shippingInfo
	 *            the shippingInfo to set
	 */
	@JsonProperty
	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}

	/**
	 * @return the categories
	 */
	@JsonProperty
	public List<String> getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	@JsonProperty
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	/**
	 * @return the price
	 */
	@JsonProperty
	public Price getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	@JsonProperty
	public void setPrice(Price price) {
		this.price = price;
	}

	/**
	 * @return the additionalAttr
	 */
	@JsonProperty
	public Map<String, Object> getAdditionalAttr() {
		return additionalAttr;
	}

	/**
	 * @param additionalAttr
	 *            the additionalAttr to set
	 */
	@JsonProperty
	public void setAdditionalAttr(Map<String, Object> additionalAttr) {
		this.additionalAttr = additionalAttr;
	}

}
