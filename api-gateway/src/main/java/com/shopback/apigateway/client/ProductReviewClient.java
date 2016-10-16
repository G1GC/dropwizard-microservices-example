package com.shopback.apigateway.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.curator.x.discovery.ServiceInstance;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.shopback.apigateway.APIGatewayConfiguration;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductReviewClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductReviewClient.class);
	private final static String SERVICE_PATH = "/api/product/review/";

	private final static String HEALTH_CHECK_PATH = "/api/product/review/health";

	@Inject
	private Client client;

	@Inject
	private APIGatewayConfiguration configuration;

	public JSONArray getProductReviews(String id) {
		try {
			ServiceInstance instance = this.configuration.getProductReviewDiscoveryClient().getInstance();
			String address = instance.getAddress();
			Integer port = instance.getPort();
			String endpoint = "http://" + address + ":" + port + SERVICE_PATH + id;
			Response response = client.target(endpoint).request(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON).get();
			String responseString = response.readEntity(String.class);
			if (response.getStatus() == 404)
				return new JSONArray("[]");
			return new JSONArray(responseString);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public boolean isClientHealthy() {
		try {
			ServiceInstance instance = this.configuration.getProductCatalogDiscoveryClient().getInstance();
			String address = instance.getAddress();
			Integer port = instance.getPort();
			String endpoint = "http://" + address + ":" + port + HEALTH_CHECK_PATH;
			Response response = client.target(endpoint).request(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON).get();
			return response.getStatus() == 200;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

}
