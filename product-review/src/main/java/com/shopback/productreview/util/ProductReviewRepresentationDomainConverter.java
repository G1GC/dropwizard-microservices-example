package com.shopback.productreview.util;

import com.shopback.productreview.api.ProductReviewRepresentation;
import com.shopback.productreview.core.domain.ProductReview;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductReviewRepresentationDomainConverter {

	public static ProductReviewRepresentation toRepresentation(ProductReview review) {
		ProductReviewRepresentation representation = new ProductReviewRepresentation();
		representation.setRating(review.getRating());
		representation.setReviewedBy(review.getReviewedBy());
		representation.setReviewedOn(review.getReviewedOn());
		representation.setReviewComment(review.getReviewComment());
		return representation;
	}

}
