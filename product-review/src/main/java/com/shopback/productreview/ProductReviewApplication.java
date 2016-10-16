package com.shopback.productreview;

import java.sql.Connection;

import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.shopback.productreview.health.ProductReviewServiceHealthCheck;

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

public class ProductReviewApplication extends Application<ProductReviewConfiguration> {

	private GuiceBundle<ProductReviewConfiguration> guiceBundle;

	private final DiscoveryBundle<ProductReviewConfiguration> discoveryBundle = new DiscoveryBundle<ProductReviewConfiguration>() {

		@Override
		public DiscoveryFactory getDiscoveryFactory(ProductReviewConfiguration configuration) {
			return configuration.getDiscoveryFactory();
		}
	};

	public static void main(final String[] args) throws Exception {
		new ProductReviewApplication().run(args);
	}

	@Override
	public String getName() {
		return "product-review";
	}

	@Override
	public void initialize(final Bootstrap<ProductReviewConfiguration> bootstrap) {
		bootstrap.addBundle(discoveryBundle);
		bootstrap.addBundle(new MigrationsBundle<ProductReviewConfiguration>() {

			@Override
			public PooledDataSourceFactory getDataSourceFactory(ProductReviewConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});
		guiceBundle = GuiceBundle.<ProductReviewConfiguration> newBuilder().addModule(new ProductReviewModule())
				.enableAutoConfig(getClass().getPackage().getName()).setConfigClass(ProductReviewConfiguration.class)
				.build(Stage.PRODUCTION);
		bootstrap.addBundle(guiceBundle);
	}

	@Override
	public void run(final ProductReviewConfiguration configuration, final Environment environment) throws Exception {
		environment.jersey().setUrlPattern("/api/*");
		environment.healthChecks().register("product review service",
				guiceBundle.getInjector().getInstance(ProductReviewServiceHealthCheck.class));
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
