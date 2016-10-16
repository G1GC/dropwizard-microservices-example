package com.shopback.productcatalog.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.shopback.productcatalog.core.domain.ProductCatalog;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductCatalogMapper implements ResultSetMapper<ProductCatalog> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.skife.jdbi.v2.tweak.ResultSetMapper#map(int, java.sql.ResultSet,
	 * org.skife.jdbi.v2.StatementContext)
	 */
	@Override
	public ProductCatalog map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
		ProductCatalog productCatalog = new ProductCatalog();
		productCatalog.setId(resultSet.getString("id"));
		productCatalog.setDesc(resultSet.getString("desc"));
		productCatalog.setName(resultSet.getString("name"));
		productCatalog.setWidth(resultSet.getInt("width"));
		productCatalog.setHeight(resultSet.getInt("height"));
		productCatalog.setDepth(resultSet.getInt("depth"));
		productCatalog.setDimensionUnit(resultSet.getString("dimension_unit"));
		productCatalog.setWeight(resultSet.getDouble("weight"));
		productCatalog.setCategories(resultSet.getString("categories"));
		productCatalog.setPriceUnit(resultSet.getString("price_unit"));
		productCatalog.setListPrice(resultSet.getInt("list_price"));
		productCatalog.setSalePrice(resultSet.getInt("sale_price"));
		return productCatalog;
	}

}
