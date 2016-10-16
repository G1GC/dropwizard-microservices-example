package com.shopback.productcatalog.core.domain;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductCatalog {

	private String id;
	private String desc;
	private String name;
	private int width;
	private int height;
	private int depth;
	private String dimensionUnit;
	private double weight;
	private String categories;
	private String priceUnit;
	private int listPrice;
	private int salePrice;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the descMap
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param descMap
	 *            the descMap to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth
	 *            the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * @return the dimensionUnit
	 */
	public String getDimensionUnit() {
		return dimensionUnit;
	}

	/**
	 * @param dimensionUnit
	 *            the dimensionUnit to set
	 */
	public void setDimensionUnit(String dimensionUnit) {
		this.dimensionUnit = dimensionUnit;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the categories
	 */
	public String getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(String categories) {
		this.categories = categories;
	}

	/**
	 * @return the priceUnit
	 */
	public String getPriceUnit() {
		return priceUnit;
	}

	/**
	 * @param priceUnit
	 *            the priceUnit to set
	 */
	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	/**
	 * @return the listPrice
	 */
	public int getListPrice() {
		return listPrice;
	}

	/**
	 * @param listPrice
	 *            the listPrice to set
	 */
	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}

	/**
	 * @return the salePrice
	 */
	public int getSalePrice() {
		return salePrice;
	}

	/**
	 * @param salePrice
	 *            the salePrice to set
	 */
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductDetails [id=").append(id).append(", desc=").append(desc).append(", name=").append(name)
				.append(", width=").append(width).append(", height=").append(height).append(", depth=").append(depth)
				.append(", weight=").append(weight).append(", categories=").append(categories).append(", priceUnit=")
				.append(priceUnit).append(", listPrice=").append(listPrice).append(", salePrice=").append(salePrice)
				.append("]");
		return builder.toString();
	}

}
