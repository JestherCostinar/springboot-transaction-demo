package com.jesthercostinar.springboot.repository;

import com.jesthercostinar.springboot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
