package com.shopback.apigateway;

import org.whispersystems.dropwizard.simpleauth.AuthDynamicFeature;
import org.whispersystems.dropwizard.simpleauth.AuthValueFactoryProvider;
import org.whispersystems.dropwizard.simpleauth.BasicCredentialAuthFilter;

import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.shopback.apigateway.auth.Admin;
import com.shopback.apigateway.auth.AdminAuthenticator;
import com.shopback.apigateway.auth.User;
import com.shopback.apigateway.auth.UserAuthenticator;
import com.shopback.apigateway.health.PCSHealthCheck;
import com.shopback.apigateway.health.PRSHealthCheck;

import io.dropwizard.Application;
import io.dropwizard.discovery.DiscoveryBundle;
import io.dropwizard.discovery.DiscoveryFactory;
import io.dropwizard.discovery.client.DiscoveryClient;
import io.dropwizard.discovery.client.DiscoveryClientManager;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class APIGatewayApplication extends Application<APIGatewayConfiguration> {

	private GuiceBundle<APIGatewayConfiguration> guiceBundle;

	private final DiscoveryBundle<APIGatewayConfiguration> discoveryBundle = new DiscoveryBundle<APIGatewayConfiguration>() {

		@Override
		public DiscoveryFactory getDiscoveryFactory(APIGatewayConfiguration configuration) {
			return configuration.getDiscoveryFactory();
		}
	};

	public static void main(final String[] args) throws Exception {
		new APIGatewayApplication().run(args);
	}

	@Override
	public String getName() {
		return "api-gateway";
	}

	@Override
	public void initialize(final Bootstrap<APIGatewayConfiguration> bootstrap) {
		bootstrap.addBundle(discoveryBundle);
		guiceBundle = GuiceBundle.<APIGatewayConfiguration> newBuilder().addModule(new APIGatewayModule())
				.enableAutoConfig(getClass().getPackage().getName()).setConfigClass(APIGatewayConfiguration.class)
				.build(Stage.PRODUCTION);
		bootstrap.addBundle(guiceBundle);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void run(final APIGatewayConfiguration configuration, final Environment environment) throws Exception {
		// discover services from ZK
		final DiscoveryClient catalogClient = discoveryBundle.newDiscoveryClient("product-catalog");
		DiscoveryClientManager catalogManager = new DiscoveryClientManager(catalogClient);
		environment.lifecycle().manage(catalogManager);
		configuration.setProductCatalogDiscoveryClient(catalogClient);

		final DiscoveryClient reviewClient = discoveryBundle.newDiscoveryClient("product-review");
		DiscoveryClientManager reviewManager = new DiscoveryClientManager(reviewClient);
		environment.lifecycle().manage(reviewManager);
		configuration.setProductReviewDiscoveryClient(reviewClient);

		// register health checks
		environment.healthChecks().register("product catalog service",
				guiceBundle.getInjector().getInstance(PCSHealthCheck.class));
		environment.healthChecks().register("product review service",
				guiceBundle.getInjector().getInstance(PRSHealthCheck.class));

		// Enable auth
		environment.jersey()
				.register(new AuthDynamicFeature(
						new BasicCredentialAuthFilter.Builder<User>().setAuthenticator(new UserAuthenticator())
								.setPrincipal(User.class).buildAuthFilter(),
						new BasicCredentialAuthFilter.Builder<Admin>().setAuthenticator(new AdminAuthenticator())
								.setPrincipal(Admin.class).buildAuthFilter()));

		environment.jersey().register(new AuthValueFactoryProvider.Binder());
	}

}
