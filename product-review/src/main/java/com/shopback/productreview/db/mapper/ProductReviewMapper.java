package com.shopback.productreview.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.shopback.productreview.core.domain.ProductReview;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductReviewMapper implements ResultSetMapper<ProductReview> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.skife.jdbi.v2.tweak.ResultSetMapper#map(int, java.sql.ResultSet,
	 * org.skife.jdbi.v2.StatementContext)
	 */
	@Override
	public ProductReview map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
		ProductReview review = new ProductReview();
		review.setId(resultSet.getLong("id"));
		review.setSkuId(resultSet.getString("sku_id"));
		review.setRating(resultSet.getFloat("rating"));
		review.setReviewedBy(resultSet.getString("reviewed_by"));
		review.setReviewedOn(resultSet.getDate("reviewed_on"));
		review.setReviewComment(resultSet.getString("review_comment"));
		return review;
	}

}
