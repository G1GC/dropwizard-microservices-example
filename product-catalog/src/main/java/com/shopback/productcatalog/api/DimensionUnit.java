package com.shopback.productcatalog.api;

/**
 * @author Karthik Jayaraman
 *
 */
public enum DimensionUnit {
	INCHES, CM, MM;

	public static DimensionUnit getDimensionUnit(String s) {
		if (s.equalsIgnoreCase("inches"))
			return INCHES;
		if (s.equalsIgnoreCase("cm"))
			return CM;
		if (s.equalsIgnoreCase("mm"))
			return MM;
		return null;

	}

}
