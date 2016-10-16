package com.shopback.productreview.core.service;

import java.util.List;

import com.shopback.productreview.core.domain.ProductReview;

/**
 * @author Karthik Jayaraman
 *
 */
public interface ProductReviewService {

	public List<ProductReview> getAllProductReviews(String skuID);

}
