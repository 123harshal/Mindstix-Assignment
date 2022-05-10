package com.mindstix.microserviceb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindstix.microserviceb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
