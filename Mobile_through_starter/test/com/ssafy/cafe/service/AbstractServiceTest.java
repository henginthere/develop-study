package com.ssafy.cafe.service;

import com.ssafy.cafe.model.dao.OrderDao;
import com.ssafy.cafe.model.dao.OrderDetailDao;
import com.ssafy.cafe.model.dto.User;
import com.ssafy.cafe.model.service.CommentService;
import com.ssafy.cafe.model.service.OrderService;
import com.ssafy.cafe.model.service.ProductService;
import com.ssafy.cafe.model.service.StampService;
import com.ssafy.cafe.model.service.UserService;



public abstract class AbstractServiceTest {

    public static User user = new User("id 01", "name 01", "pass 01", 0);

    public UserService userService;

    public ProductService prodService;

    public OrderService orderService;

    public CommentService cService;

    public StampService sService;
    
    OrderDao oDao;

    OrderDetailDao dDao;


}
