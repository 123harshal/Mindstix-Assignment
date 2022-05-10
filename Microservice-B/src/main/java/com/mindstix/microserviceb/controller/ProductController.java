package com.mindstix.microserviceb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindstix.microserviceb.entity.Product;
import com.mindstix.microserviceb.service.ProductService;

@RestController
@RequestMapping(path = "/mindstix/v1")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
    @GetMapping(path = "/products")
    public List<Product> getProducts(){
    	List<Product> products = productService.getProducts();
    	return products;
    }

}
