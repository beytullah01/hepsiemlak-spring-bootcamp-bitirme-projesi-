package emlakburada.queue;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import emlakburada.dto.PaymentRequest;
import emlakburada.service.OrderService;
import emlakburada.service.UserService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class RabbitMqListenerService {
	

	@Autowired
	UserService userService;
	
	@RabbitListener(queues = "emlakburada.payment-queue")
    public void consume(PaymentRequest paymentRequest) {
        System.out.println("Received Message: " + paymentRequest);
        
        if(paymentRequest!=null) {
        	
         userService.addProductToUser(paymentRequest.getUserId(),paymentRequest.getProductId());
         log.info("rabbit calıstı");
        }
        
    }

}
