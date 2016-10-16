package com.shopback.apigateway.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.google.inject.Inject;
import com.shopback.apigateway.api.ProductRepresentation;
import com.shopback.apigateway.auth.Admin;
import com.shopback.apigateway.auth.User;
import com.shopback.apigateway.client.ProductCatalogClient;
import com.shopback.apigateway.client.ProductReviewClient;

import io.dropwizard.auth.Auth;
import io.dropwizard.jersey.caching.CacheControl;

/**
 * @author Karthik Jayaraman
 *
 */
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductResource.class);

	@Inject
	private ProductCatalogClient productCatalogClient;

	@Inject
	private ProductReviewClient productReviewClient;

	@GET
	@Path("/{id}")
	@Timed(name = "showAll-timed-get")
	@Metered(name = "showAll-metered-get")
	@ExceptionMetered
	@CacheControl(maxAge = 12, maxAgeUnit = TimeUnit.SECONDS)
	@JacksonFeatures(serializationEnable = { SerializationFeature.INDENT_OUTPUT })
	public ProductRepresentation getProductCatalog(@Auth User user, @PathParam("id") String id) throws Exception {
		LOGGER.info("Fetching the product catalog for the product with id:" + id);
		ProductRepresentation product = new ProductRepresentation();
		JSONObject productCatalog = productCatalogClient.getProductCatalog(id);
		if (productCatalog == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		product.setProductCatalog((HashMap<String, Object>) productCatalog.toMap());
		List<HashMap<String, Object>> reviewList = new ArrayList<>();
		List<Object> reviews = productReviewClient.getProductReviews(id).toList();
		for (Object review : reviews) {
			reviewList.add((HashMap<String, Object>) review);
		}
		product.setProductReviews(reviewList);
		return product;
	}

	@GET
	@Path("/catalog")
	@Timed(name = "showAll-timed-get")
	@Metered(name = "showAll-metered-get")
	@ExceptionMetered
	@CacheControl(maxAge = 12, maxAgeUnit = TimeUnit.SECONDS)
	@JacksonFeatures(serializationEnable = { SerializationFeature.INDENT_OUTPUT })
	public List<Object> getAllProductCatalog(@Auth Admin user) throws Exception {
		LOGGER.info("Fetching all the product catalog for the product ");
		JSONArray productCatalogs = productCatalogClient.getAllProductCatalog();
		if (productCatalogs == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return productCatalogs.toList();
	}

}
