package com.example.emlakburadapayment.queue;

import com.example.emlakburadapayment.dto.request.PaymentRequest;
import com.example.emlakburadapayment.model.Payment;

public interface QueueService {
	


	

	void sendMessage(PaymentRequest payment);

}
