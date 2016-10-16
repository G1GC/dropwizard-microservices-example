package com.shopback.productcatalog.core.service.impl;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.shopback.productcatalog.core.domain.ProductCatalog;
import com.shopback.productcatalog.db.ProductCatalogDAO;

import junit.framework.TestCase;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductCatalogServiceImplTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.shopback.productcatalog.core.service.impl.ProductCatalogServiceImpl#getProductDetails(java.lang.String)}
	 * .
	 */
	public void testGetProductDetails() {
		ProductCatalogDAO catalogDAO = mock(ProductCatalogDAO.class);
		ProductCatalog catalog = new ProductCatalog();
		catalog.setCategories("test-category");
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
		when(catalogDAO.findById(anyString())).thenReturn(catalog);
		ProductCatalogServiceImpl impl = new ProductCatalogServiceImpl();
		impl.productCatalogDAO = catalogDAO;
		assertTrue(impl.getProductDetails("SKU-001") == catalog);
	}

	/**
	 * Test method for
	 * {@link com.shopback.productcatalog.core.service.impl.ProductCatalogServiceImpl#getAllProductDetails()}
	 * .
	 */
	public void testGetAllProductDetails() {
		ProductCatalogDAO catalogDAO = mock(ProductCatalogDAO.class);
		ProductCatalog catalog = new ProductCatalog();
		catalog.setCategories("test-category");
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
		List<ProductCatalog> catalogs = new ArrayList<>();
		catalogs.add(catalog);
		when(catalogDAO.findAll()).thenReturn(catalogs);
		ProductCatalogServiceImpl impl = new ProductCatalogServiceImpl();
		impl.productCatalogDAO = catalogDAO;
		assertTrue(impl.getAllProductDetails() == catalogs);

	}

}
