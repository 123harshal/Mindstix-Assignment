package com.mindstix.microservicea.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mindstix.microservicea.model.Product;

@FeignClient(name="ProductService", url = "http://localhost:8082" )
public interface ProductServiceProxy {
	
    @GetMapping(path = "/mindstix/v1/products")
    public List<Product> getProducts();

}
