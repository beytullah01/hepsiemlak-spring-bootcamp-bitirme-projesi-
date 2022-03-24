package com.example.emlakburadapayment.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emlakburadapayment.dto.request.PaymentRequest;
import com.example.emlakburadapayment.dto.response.PaymentResponse;
import com.example.emlakburadapayment.model.Payment;
import com.example.emlakburadapayment.queue.RabbitMqService;
import com.example.emlakburadapayment.repository.PaymentRepository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentService {

	int orderNo=1000;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private RabbitMqService rabbitMqService;
	
	
	public PaymentResponse savePayment(PaymentRequest request) {
		
		Payment payment=paymentRepository.save(convertToPayment(request));
		
		rabbitMqService.sendMessage(request);
		log.info("kuyruga yazıldı");
		
		return convertToPaymentResponse(payment);
	}
	
	public PaymentResponse paymentExist(int id) {
		
		Payment payment=paymentRepository.findPaymentByOrderId(id);
		
		return convertToPaymentResponse(payment);
	}
	
	public PaymentResponse convertToPaymentResponse(Payment payment) {
		
		PaymentResponse response = new PaymentResponse();
		response.setPaymentId(payment.getPaymentId());
		response.setOrderId(payment.getOrderId());
		response.setAmount(payment.getAmount());
		response.setCreditCard(payment.getCreditCard());
		response.setIsPay(payment.getIsPay());

		return response;
	}

	public Payment convertToPayment(PaymentRequest request) {
		Payment payment = new Payment();
		
		payment.setOrderId(orderNo++);
		payment.setAmount(request.getAmount());
		payment.setCreditCard(request.getCreditCard());
		payment.setIsPay(request.getIsPay());
		payment.setUserId(request.getUserId());
		payment.setProductId(request.getProductId());
		return payment;
	}
	
	public PaymentRequest PaymentPrepare() {
		PaymentRequest paymentRequest=new PaymentRequest();//bu metot userserviceimp icerisinde request atmamızı saglar feignle haberlesmede hazır olarak halledılır
		paymentRequest.setAmount(new BigDecimal(1000));
		paymentRequest.setIsPay(false);
		paymentRequest.setCreditCard(paymentRequest.getCreditCard());
		return paymentRequest;
	}

}
