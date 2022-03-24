package com.example.emlakburadaadverts.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emlakburadaadverts.config.RabbitMqConfig;


@Service
public class RabbitMqService implements QueueService {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Autowired
	private RabbitMqConfig config;

	

	@Override
	public void sendMessage(int advertId) {
		
		rabbitTemplate.convertAndSend(config.getExchange(), config.getRoutingkey(), advertId);
		
	}

}