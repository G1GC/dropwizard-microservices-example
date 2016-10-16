package com.shopback.productreview.core.service.impl;

import java.util.List;

import com.google.inject.Inject;
import com.shopback.productreview.core.domain.ProductReview;
import com.shopback.productreview.core.service.ProductReviewService;
import com.shopback.productreview.db.ProductReviewDAO;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductReviewServiceImpl implements ProductReviewService {

	@Inject
	ProductReviewDAO productReviewDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shopback.productreviews.core.service.ProductReviewService#
	 * getAllProductReviews(java.lang.String)
	 */
	@Override
	public List<ProductReview> getAllProductReviews(String skuID) {
		return productReviewDAO.getReviews(skuID);
	}

}
