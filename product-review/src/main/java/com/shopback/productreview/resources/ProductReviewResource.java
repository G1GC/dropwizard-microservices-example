package com.shopback.productreview.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.shopback.productreview.api.ProductReviewRepresentation;
import com.shopback.productreview.core.domain.ProductReview;
import com.shopback.productreview.core.service.ProductReviewService;
import com.shopback.productreview.util.ProductReviewRepresentationDomainConverter;

import io.dropwizard.jersey.caching.CacheControl;

/**
 * @author Karthik Jayaraman
 *
 */
@Path("/product/review")
@Produces(MediaType.APPLICATION_JSON)
public class ProductReviewResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductReviewResource.class);

	@Inject
	private ProductReviewService productReviewService;

	@GET
	@Path("/health")
	public Response isHealthy() {
		return Response.ok().build();
	}

	@GET
	@Path("/{skuId}")
	@Timed(name = "showAll-timed-get")
	@Metered(name = "showAll-metered-get")
	@ExceptionMetered
	@CacheControl(maxAge = 12, maxAgeUnit = TimeUnit.HOURS)
	public List<ProductReviewRepresentation> getAllProductReviews(@PathParam("skuId") String skuId) {
		LOGGER.info("Retrieving all product reviews of the product:" + skuId);
		List<ProductReview> reviews = productReviewService.getAllProductReviews(skuId);
		if (reviews == null || reviews.isEmpty()) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		List<ProductReviewRepresentation> representations = new ArrayList<>();
		for (ProductReview review : reviews) {
			representations.add(ProductReviewRepresentationDomainConverter.toRepresentation(review));
		}
		return representations;
	}

}
