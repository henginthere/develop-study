package com.ssafy.cafe.model.dao;

import java.util.List;
import com.ssafy.cafe.model.dto.Order;

public interface OrderDao {
    int insert(Order order);

    int update(Order order);

    int delete(Integer orderId);

    Order select(Integer orderId);

    List<Order> selectAll();
    
    Order selectWithDetail(int id);
    
    List<Order> selectByUser(String userId);
}
