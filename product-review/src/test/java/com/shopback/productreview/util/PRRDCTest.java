package com.shopback.productreview.util;

import java.util.Date;

import com.shopback.productreview.api.ProductReviewRepresentation;
import com.shopback.productreview.core.domain.ProductReview;

import junit.framework.TestCase;

/**
 * @author Karthik Jayaraman
 *
 */
public class PRRDCTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.shopback.productreview.util.ProductReviewRepresentationDomainConverter#toRepresentation(com.shopback.productreview.core.domain.ProductReview)}
	 * .
	 */
	public void testToRepresentation() {
		ProductReview review = new ProductReview();
		review.setId(123);
		review.setRating(4.5f);
		review.setReviewComment("Test Comment");
		review.setReviewedBy("Anonymous");
		Date date = new Date();
		review.setReviewedOn(date);
		review.setSkuId("SKU-001");
		ProductReviewRepresentation representation = ProductReviewRepresentationDomainConverter
				.toRepresentation(review);
		assertTrue(representation.getRating() == 4.5f);
		assertTrue(representation.getReviewComment() == "Test Comment");
		assertTrue(representation.getReviewedBy() == "Anonymous");
		assertTrue(representation.getReviewedOn().equals(date));
	}

}
