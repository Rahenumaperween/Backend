package com.portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfolio.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long>{

}
