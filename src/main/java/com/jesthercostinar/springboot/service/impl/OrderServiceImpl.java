package com.jesthercostinar.springboot.service.impl;

import com.jesthercostinar.springboot.dto.OrderRequest;
import com.jesthercostinar.springboot.dto.OrderResponse;
import com.jesthercostinar.springboot.entity.Order;
import com.jesthercostinar.springboot.entity.Payment;
import com.jesthercostinar.springboot.exception.PaymentException;
import com.jesthercostinar.springboot.repository.OrderRepository;
import com.jesthercostinar.springboot.repository.PaymentRepository;
import com.jesthercostinar.springboot.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }
    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment card type is not supported");
        }
        payment.setOrder_id(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
