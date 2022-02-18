package com.ssafy.cafe.model.dao;

import java.util.List;
import com.ssafy.cafe.model.dto.Product;

public interface ProductDao {
    int insert(Product product);

    int update(Product product);

    int delete(Integer productId);

    Product select(Integer productId);

    List<Product> selectAll();
}
