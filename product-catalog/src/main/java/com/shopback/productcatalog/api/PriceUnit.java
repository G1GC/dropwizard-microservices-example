package com.shopback.productcatalog.api;

/**
 * @author Karthik Jayaraman
 *
 */
public enum PriceUnit {

	CENTS, DOLLARS, RUPEES, PAISE;

	public static PriceUnit getPriceUnit(String s) {
		if (s.equalsIgnoreCase("cents"))
			return CENTS;
		if (s.equalsIgnoreCase("dollars"))
			return DOLLARS;
		if (s.equalsIgnoreCase("rupees"))
			return RUPEES;
		if (s.equalsIgnoreCase("paise"))
			return PAISE;
		return null;

	}

}
