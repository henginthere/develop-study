package com.tophoon.dao;

import org.springframework.stereotype.Repository;

import com.tophoon.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Override
	public Product findProduct() {
		return new Product("공기밥", 1000);
	}

}
