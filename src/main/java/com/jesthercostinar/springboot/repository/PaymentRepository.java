package com.jesthercostinar.springboot.repository;

import com.jesthercostinar.springboot.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
