package com.shopback.productcatalog.util;

import com.shopback.productcatalog.api.DimensionUnit;
import com.shopback.productcatalog.api.PriceUnit;
import com.shopback.productcatalog.api.ProductCatalogRepresentation;
import com.shopback.productcatalog.core.domain.ProductCatalog;

import junit.framework.TestCase;

/**
 * @author Karthik Jayaraman
 *
 */
public class PRDCTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.shopback.productcatalog.util.ProductRepresentationDomainConverter#toRepresentation(com.shopback.productcatalog.core.domain.ProductCatalog)}
	 * .
	 */
	public void testToRepresentation() {
		ProductCatalog catalog = new ProductCatalog();
		catalog.setCategories("test1,test2,test3");
		catalog.setDepth(1);
		catalog.setDesc("test-desc");
		catalog.setDimensionUnit("MM");
		catalog.setHeight(1);
		catalog.setId("SKU-001");
		catalog.setListPrice(100);
		catalog.setName("test");
		catalog.setPriceUnit("Dollars");
		catalog.setSalePrice(120);
		catalog.setWeight(100);
		catalog.setWidth(1);
		ProductCatalogRepresentation representation = ProductRepresentationDomainConverter.toRepresentation(catalog);
		assertTrue(representation.getCategories().size() == 3);
		assertTrue(representation.getCategories().contains("test1"));
		assertTrue(representation.getName() == "test");
		assertTrue(representation.getSkuId() == "SKU-001");
		assertTrue(representation.getDescriptions().size() == 1);
		assertTrue(representation.getDescriptions().get(0).getLanguage() == "en");
		assertTrue(representation.getDescriptions().get(0).getDesc() == "test-desc");
		assertTrue(representation.getPrice().getListPrice() == 100);
		assertTrue(representation.getPrice().getSalePrice() == 120);
		assertTrue(representation.getPrice().getUnit() == PriceUnit.DOLLARS);
		assertTrue(representation.getShippingInfo().getDimension().getDepth() == 1);
		assertTrue(representation.getShippingInfo().getDimension().getWidth() == 1);
		assertTrue(representation.getShippingInfo().getDimension().getHeight() == 1);
		assertTrue(representation.getShippingInfo().getDimension().getDimensionUnit() == DimensionUnit.MM);
		assertTrue(representation.getShippingInfo().getWeight() == 100);
	}

}
