package com.ssafy.cafe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.ssafy.cafe.model.dto.Product;


class ProductServiceTest extends AbstractServiceTest{
    
    
    @Test
    void listTest() {
        List<Product> list = prodService.getProductList();
        assertEquals(list.size(), 10);
        Product p = list.get(0);
        assertEquals(p.getName(), "name 10");
    }
}
