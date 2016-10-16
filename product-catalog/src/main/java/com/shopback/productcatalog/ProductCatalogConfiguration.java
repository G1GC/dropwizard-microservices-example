package com.shopback.productcatalog;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.discovery.DiscoveryFactory;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductCatalogConfiguration extends Configuration {

	@Valid
	@NotNull
	@JsonProperty("database")
	private DataSourceFactory database = new DataSourceFactory();

	@Valid
	@NotNull
	private DiscoveryFactory discovery = new DiscoveryFactory();

	public DataSourceFactory getDataSourceFactory() {
		return database;
	}

	@JsonProperty("discovery")
	public DiscoveryFactory getDiscoveryFactory() {
		return discovery;
	}

	@JsonProperty("discovery")
	public void setDiscoveryFactory(DiscoveryFactory discoveryFactory) {
		this.discovery = discoveryFactory;
	}

}
