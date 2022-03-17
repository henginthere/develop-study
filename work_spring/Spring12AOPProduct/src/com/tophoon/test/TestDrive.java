package com.tophoon.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tophoon.model.Product;
import com.tophoon.service.ProductService;

public class TestDrive {
	public static void main(String[] args) {
		TestDrive testDrive = new TestDrive();
		testDrive.execute();
	}

	private void execute() {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/tophoon/config/config.xml");
		ProductService productService = context.getBean(ProductService.class);
		Product product = productService.findProduct();
		System.out.println(product);
	}
}
