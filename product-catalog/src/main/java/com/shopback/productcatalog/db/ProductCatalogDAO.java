package com.shopback.productcatalog.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.shopback.productcatalog.core.domain.ProductCatalog;
import com.shopback.productcatalog.db.mapper.ProductCatalogMapper;

/**
 * @author Karthik Jayaraman
 *
 */
@RegisterMapper(ProductCatalogMapper.class)
public interface ProductCatalogDAO {

	@SqlQuery("select * from product_catalog")
	List<ProductCatalog> findAll();

	@SqlQuery("select * from product_catalog where ID = :id")
	public ProductCatalog findById(@Bind("id") String id);

	// TODO: we can declare other necessary methods here for the product catalog
	// DAO like create, update etc(CRUD)

}
