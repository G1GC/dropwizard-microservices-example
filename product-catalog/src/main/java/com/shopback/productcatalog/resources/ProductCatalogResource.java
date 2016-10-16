package com.shopback.productcatalog.resources;

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
import com.shopback.productcatalog.api.ProductCatalogRepresentation;
import com.shopback.productcatalog.core.domain.ProductCatalog;
import com.shopback.productcatalog.core.service.ProductCatalogService;
import com.shopback.productcatalog.util.ProductRepresentationDomainConverter;

import io.dropwizard.jersey.caching.CacheControl;

/**
 * @author Karthik Jayaraman
 *
 */
@Path("/product/catalog")
@Produces(MediaType.APPLICATION_JSON)
public class ProductCatalogResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCatalogResource.class);

	@Inject
	private ProductCatalogService productCatalogService;

	@GET
	@Path("/health")
	public Response isHealthy() {
		return Response.ok().build();
	}

	@GET
	@Path("/{id}")
	@Timed(name = "showAll-timed-get")
	@Metered(name = "showAll-metered-get")
	@ExceptionMetered
	@CacheControl(maxAge = 12, maxAgeUnit = TimeUnit.SECONDS)
	public ProductCatalogRepresentation getProductCatalog(@PathParam("id") String id) {
		LOGGER.info("Retrieving product catalog details of the product with id:" + id);
		ProductCatalog details = productCatalogService.getProductDetails(id);
		if (details == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		LOGGER.debug("Product details:" + details.toString());
		return ProductRepresentationDomainConverter.toRepresentation(details);
	}

	@GET
	@Timed(name = "showAll-timed-get")
	@Metered(name = "showAll-metered-get")
	@ExceptionMetered
	@CacheControl(maxAge = 12, maxAgeUnit = TimeUnit.HOURS)
	public List<ProductCatalogRepresentation> getAllProductCatalog() {
		LOGGER.info("Retrieving all product catalog details of the product");
		List<ProductCatalog> details = productCatalogService.getAllProductDetails();
		if (details == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		LOGGER.debug("Product details:" + details.toString());
		List<ProductCatalogRepresentation> representations = new ArrayList<>();
		for (ProductCatalog detail : details) {
			representations.add(ProductRepresentationDomainConverter.toRepresentation(detail));
		}
		return representations;
	}

}
