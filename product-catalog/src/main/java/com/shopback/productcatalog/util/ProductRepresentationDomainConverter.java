package com.shopback.productcatalog.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import com.shopback.productcatalog.api.Dimension;
import com.shopback.productcatalog.api.DimensionUnit;
import com.shopback.productcatalog.api.Price;
import com.shopback.productcatalog.api.PriceUnit;
import com.shopback.productcatalog.api.ProductDescription;
import com.shopback.productcatalog.api.ProductCatalogRepresentation;
import com.shopback.productcatalog.api.ShippingInfo;
import com.shopback.productcatalog.core.domain.ProductCatalog;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductRepresentationDomainConverter {

	public static ProductCatalogRepresentation toRepresentation(ProductCatalog productDetails) {
		ProductCatalogRepresentation representation = new ProductCatalogRepresentation();
		representation.setSkuId(productDetails.getId());
		representation.setName(productDetails.getName());
		List<ProductDescription> descriptions = new ArrayList<>();
		ProductDescription description = new ProductDescription();
		description.setDesc(productDetails.getDesc());
		description.setLanguage("en");
		descriptions.add(description);
		representation.setDescriptions(descriptions);
		List<String> categories = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(productDetails.getCategories(), ",");
		while (tokenizer.hasMoreTokens()) {
			categories.add(tokenizer.nextToken());
		}
		representation.setCategories(categories);
		ShippingInfo info = new ShippingInfo();
		Dimension dimension = new Dimension();
		dimension.setDepth(productDetails.getDepth());
		dimension.setHeight(productDetails.getHeight());
		dimension.setWidth(productDetails.getWidth());
		dimension.setDimensionUnit(DimensionUnit.getDimensionUnit(productDetails.getDimensionUnit()));
		info.setDimension(dimension);
		info.setWeight(productDetails.getWeight());
		representation.setShippingInfo(info);
		Price price = new Price();
		price.setListPrice(productDetails.getListPrice());
		price.setSalePrice(productDetails.getSalePrice());
		price.setUnit(PriceUnit.getPriceUnit(productDetails.getPriceUnit()));
		representation.setPrice(price);
		representation.setAdditionalAttr(new HashMap<String, Object>());
		return representation;
	}

}
