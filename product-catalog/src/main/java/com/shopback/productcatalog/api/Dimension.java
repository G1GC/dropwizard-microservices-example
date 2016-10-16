package com.shopback.productcatalog.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Karthik Jayaraman
 *
 */
public class Dimension {

	private int width;
	private int height;
	private int depth;
	private DimensionUnit dimensionUnit;

	/**
	 * @return the width
	 */
	@JsonProperty
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	@JsonProperty
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	@JsonProperty
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	@JsonProperty
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the depth
	 */
	@JsonProperty
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth
	 *            the depth to set
	 */
	@JsonProperty
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * @return the dimensionUnit
	 */
	public DimensionUnit getDimensionUnit() {
		return dimensionUnit;
	}

	/**
	 * @param dimensionUnit
	 *            the dimensionUnit to set
	 */
	public void setDimensionUnit(DimensionUnit dimensionUnit) {
		this.dimensionUnit = dimensionUnit;
	}

}
