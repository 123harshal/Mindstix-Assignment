package com.mindstix.microservicea.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mindstix.microservicea.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Long>{

}
