package com.shopback.productreview;

import org.skife.jdbi.v2.DBI;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.shopback.productreview.core.service.ProductReviewService;
import com.shopback.productreview.core.service.impl.ProductReviewServiceImpl;
import com.shopback.productreview.db.ProductReviewDAO;

import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductReviewModule extends AbstractModule {

	private DBI jdbi;

	@Provides
	public DBI prepareJdbi(Environment environment, ProductReviewConfiguration configuration)
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
	public ProductReviewDAO prepareProductCatalogDAO(DBI jdbi) {
		return jdbi.onDemand(ProductReviewDAO.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(ProductReviewService.class).to(ProductReviewServiceImpl.class);
	}

}
