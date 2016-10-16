package com.shopback.productreview.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.shopback.productreview.core.domain.ProductReview;
import com.shopback.productreview.db.mapper.ProductReviewMapper;

/**
 * @author Karthik Jayaraman
 *
 */
@RegisterMapper(ProductReviewMapper.class)
public interface ProductReviewDAO {

	@SqlQuery("select * from product_review where sku_id = :skuId")
	public List<ProductReview> getReviews(@Bind("skuId") String skuId);

}
