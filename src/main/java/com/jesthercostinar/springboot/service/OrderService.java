package com.jesthercostinar.springboot.service;

import com.jesthercostinar.springboot.dto.OrderRequest;
import com.jesthercostinar.springboot.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
