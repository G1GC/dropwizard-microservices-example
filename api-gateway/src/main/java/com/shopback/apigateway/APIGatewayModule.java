package com.shopback.apigateway;

import javax.ws.rs.client.Client;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;

/**
 * @author Karthik Jayaraman
 *
 */
public class APIGatewayModule extends AbstractModule {

	private Client jerseyClient;

	@Provides
	public Client getJerseyClient(Environment environment, APIGatewayConfiguration configuration) {
		if (jerseyClient == null) {
			jerseyClient = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
					.build(environment.getName());
		}
		return jerseyClient;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}

}
