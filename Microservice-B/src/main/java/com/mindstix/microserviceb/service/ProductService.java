package com.mindstix.microserviceb.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mindstix.microserviceb.entity.Product;
import com.mindstix.microserviceb.repository.ProductRepository;

@Service
public class ProductService implements Serializable{
	
	private static final long serialVersionUID = 7156526077883281623L;
	
	@Autowired
	ProductRepository productRepository;
	
    @Cacheable(value = "Products")
	public List<Product> getProducts(){
    	List<Product> products = productRepository.findAll();
    		return products;
    	}

}
