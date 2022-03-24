package com.example.emlakburadaadverts.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.example.emlakburadaadverts.service.AdvertService;

@Component
public class RabbitMqListenerService {
	
	@Autowired
	private AdvertService advertService;
	
	@RabbitListener(queues = "emlakburada.queue")
    public void consume(int advertId) {
        System.out.println("Received Message: " + advertId);
        
      advertService.changeStatus(advertId);
        
    }

}
