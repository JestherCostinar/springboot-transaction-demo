package com.jesthercostinar.springboot.dto;

import com.jesthercostinar.springboot.entity.Order;
import com.jesthercostinar.springboot.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
