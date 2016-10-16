package com.shopback.productreview.core.service.impl;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopback.productreview.core.domain.ProductReview;
import com.shopback.productreview.db.ProductReviewDAO;

import junit.framework.TestCase;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductReviewServiceImplTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.shopback.productreview.core.service.impl.ProductReviewServiceImpl#getAllProductReviews(java.lang.String)}
	 * .
	 */
	public void testGetAllProductReviews() {
		ProductReviewDAO reviewDAO = mock(ProductReviewDAO.class);
		ProductReview review = new ProductReview();
		review.setId(123);
		review.setRating(4.5f);
		review.setReviewComment("Test Comment");
		review.setReviewedBy("Anonymous");
		review.setReviewedOn(new Date());
		review.setSkuId("SKU-001");
		List<ProductReview> reviews = new ArrayList<>();
		when(reviewDAO.getReviews(anyString())).thenReturn(reviews);
		ProductReviewServiceImpl impl = new ProductReviewServiceImpl();
		impl.productReviewDAO = reviewDAO;
		assertTrue(impl.getAllProductReviews("SKU-001") == reviews);
	}

}
