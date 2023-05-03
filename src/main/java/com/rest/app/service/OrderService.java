package com.rest.app.service;

import com.rest.app.entity.User;

public interface OrderService {
    Integer addToCart(Integer itemId);
    String confirmOrder(User user, double totalPrice);
}
