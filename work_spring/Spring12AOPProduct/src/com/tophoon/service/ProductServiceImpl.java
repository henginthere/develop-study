package com.tophoon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tophoon.dao.ProductDao;
import com.tophoon.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public Product findProduct() {
		return productDao.findProduct();
	}

}
