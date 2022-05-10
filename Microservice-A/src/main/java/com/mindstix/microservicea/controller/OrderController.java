package com.mindstix.microservicea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindstix.microservicea.config.RabbitMQSender;
import com.mindstix.microservicea.entity.Order;
import com.mindstix.microservicea.model.Product;
import com.mindstix.microservicea.repository.OrderRepository;

@RestController
@RequestMapping(path = "/mindstix/v1")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductServiceProxy productServiceProxy;
	
	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	@PostMapping(path = "/orders")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		Order savedOrder = orderRepository.save(order);
		rabbitMQSender.send(savedOrder);
		return new ResponseEntity<Order>(savedOrder, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/products")
	public ResponseEntity<List<Product>> getProducts() {
		return ResponseEntity.ok(productServiceProxy.getProducts());
	}

}
