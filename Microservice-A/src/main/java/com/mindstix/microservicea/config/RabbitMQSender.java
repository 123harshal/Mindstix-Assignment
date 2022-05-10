package com.mindstix.microservicea.config;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mindstix.microservicea.entity.Order;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.routingkey}")
	private String routingkey;

	public void send(Order order) {
		amqpTemplate.convertAndSend(exchange, routingkey, order);
		System.out.println("Send order = " + order);
	}
}