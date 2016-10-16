package com.shopback.productcatalog;

import org.skife.jdbi.v2.DBI;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.shopback.productcatalog.core.service.ProductCatalogService;
import com.shopback.productcatalog.core.service.impl.ProductCatalogServiceImpl;
import com.shopback.productcatalog.db.ProductCatalogDAO;

import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductCatalogModule extends AbstractModule {

	private DBI jdbi;

	@Provides
	public DBI prepareJdbi(Environment environment, ProductCatalogConfiguration configuration)
			throws ClassNotFoundException {
		// setup DB access including DAOs
		// implementing a singleton pattern here but avoiding
		// Guice to initialize DB connection too early
		if (jdbi == null) {
			final DBIFactory factory = new DBIFactory();
			jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
		}
		return jdbi;
	}

	@Provides
	public ProductCatalogDAO prepareProductCatalogDAO(DBI jdbi) {
		return jdbi.onDemand(ProductCatalogDAO.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(ProductCatalogService.class).to(ProductCatalogServiceImpl.class);
	}

}
