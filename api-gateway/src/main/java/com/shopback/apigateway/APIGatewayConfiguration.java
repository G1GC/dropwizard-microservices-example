package com.shopback.apigateway;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;
import io.dropwizard.discovery.DiscoveryFactory;
import io.dropwizard.discovery.client.DiscoveryClient;

public class APIGatewayConfiguration extends Configuration {
	@Valid
	@NotNull
	private DiscoveryFactory discovery = new DiscoveryFactory();

	private DiscoveryClient productCatalogDiscoveryClient;

	private DiscoveryClient productReviewDiscoveryClient;

	@Valid
	@NotNull
	private JerseyClientConfiguration jerseyClient = new JerseyClientConfiguration();

	@JsonProperty("discovery")
	public DiscoveryFactory getDiscoveryFactory() {
		return discovery;
	}

	@JsonProperty("discovery")
	public void setDiscoveryFactory(DiscoveryFactory discoveryFactory) {
		this.discovery = discoveryFactory;
	}

	@JsonProperty("jerseyClient")
	public JerseyClientConfiguration getJerseyClientConfiguration() {
		return jerseyClient;
	}

	@JsonProperty("jerseyClient")
	public void setJerseyClientConfiguration(JerseyClientConfiguration jerseyClient) {
		this.jerseyClient = jerseyClient;
	}

	/**
	 * @return the productCatalogClient
	 */
	public DiscoveryClient getProductCatalogDiscoveryClient() {
		return productCatalogDiscoveryClient;
	}

	/**
	 * @param productCatalogClient
	 *            the productCatalogClient to set
	 */
	public void setProductCatalogDiscoveryClient(DiscoveryClient productCatalogDiscoveryClient) {
		this.productCatalogDiscoveryClient = productCatalogDiscoveryClient;
	}

	/**
	 * @return the productReviewDiscoveryClient
	 */
	public DiscoveryClient getProductReviewDiscoveryClient() {
		return productReviewDiscoveryClient;
	}

	/**
	 * @param productReviewDiscoveryClient
	 *            the productReviewDiscoveryClient to set
	 */
	public void setProductReviewDiscoveryClient(DiscoveryClient productReviewDiscoveryClient) {
		this.productReviewDiscoveryClient = productReviewDiscoveryClient;
	}
}
