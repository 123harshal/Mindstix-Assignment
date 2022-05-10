package com.mindstix.microserviceb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindstix.microserviceb.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
