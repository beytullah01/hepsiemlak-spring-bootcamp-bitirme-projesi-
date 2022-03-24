package com.example.emlakburadapayment.queue;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emlakburadapayment.config.RabbitMqConfig;
import com.example.emlakburadapayment.dto.request.PaymentRequest;
import com.example.emlakburadapayment.model.Payment;




@Service
public class RabbitMqService implements QueueService {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Autowired
	private RabbitMqConfig config;

	

	@Override
	public void sendMessage(PaymentRequest payment) {
		
		rabbitTemplate.convertAndSend(config.getExchange(), config.getRoutingkey(), payment);
		
	}

}