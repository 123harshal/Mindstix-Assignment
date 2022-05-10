package com.mindstix.microserviceb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindstix.microserviceb.entity.Order;
import com.mindstix.microserviceb.repository.OrderRepository;

@Component
public class Receiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	
	@Autowired
	private OrderRepository orderRepository;

	@RabbitListener(queues = "${rabbitmq.queue}")	
	public void getMsg(final Order order) {
		LOGGER.info("Getting messages.....");
		LOGGER.info("Finally Receiver received the message and the message  is..\n" + order);
		orderRepository.save(order);
	}
}
