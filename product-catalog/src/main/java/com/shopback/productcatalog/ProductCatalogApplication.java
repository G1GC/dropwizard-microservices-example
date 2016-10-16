package com.shopback.productcatalog;

import java.sql.Connection;

import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.shopback.productcatalog.health.ProductCatalogServiceHealthCheck;

import io.dropwizard.Application;
import io.dropwizard.db.ManagedDataSource;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.discovery.DiscoveryBundle;
import io.dropwizard.discovery.DiscoveryFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductCatalogApplication extends Application<ProductCatalogConfiguration> {

	private GuiceBundle<ProductCatalogConfiguration> guiceBundle;

	private final DiscoveryBundle<ProductCatalogConfiguration> discoveryBundle = new DiscoveryBundle<ProductCatalogConfiguration>() {

		@Override
		public DiscoveryFactory getDiscoveryFactory(ProductCatalogConfiguration configuration) {
			return configuration.getDiscoveryFactory();
		}
	};

	public static void main(final String[] args) throws Exception {
		new ProductCatalogApplication().run(args);
	}

	@Override
	public String getName() {
		return "product-catalog";
	}

	@Override
	public void initialize(final Bootstrap<ProductCatalogConfiguration> bootstrap) {
		bootstrap.addBundle(discoveryBundle);
		bootstrap.addBundle(new MigrationsBundle<ProductCatalogConfiguration>() {

			@Override
			public PooledDataSourceFactory getDataSourceFactory(ProductCatalogConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});
		guiceBundle = GuiceBundle.<ProductCatalogConfiguration> newBuilder().addModule(new ProductCatalogModule())
				.enableAutoConfig(getClass().getPackage().getName()).setConfigClass(ProductCatalogConfiguration.class)
				.build(Stage.PRODUCTION);
		bootstrap.addBundle(guiceBundle);
		// Uncomment below to read the yaml file from Jar
		// bootstrap.setConfigurationSourceProvider(new
		// ResourceConfigurationSourceProvider());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.dropwizard.Application#run(io.dropwizard.Configuration,
	 * io.dropwizard.setup.Environment)
	 */
	@Override
	public void run(ProductCatalogConfiguration configuration, Environment environment) throws Exception {
		environment.jersey().setUrlPattern("/api/*");
		environment.healthChecks().register("product catalog service",
				guiceBundle.getInjector().getInstance(ProductCatalogServiceHealthCheck.class));
		// run the migrations as part of startup and prepare the db with sample
		// data
		ManagedDataSource mds = configuration.getDataSourceFactory().build(environment.metrics(), "migrations");
		try (Connection connection = mds.getConnection()) {
			Liquibase migrator = new Liquibase("migrations.xml", new ClassLoaderResourceAccessor(),
					new JdbcConnection(connection));
			migrator.dropAll();
			migrator.clearCheckSums();
			migrator.update("");
		}
	}

}
