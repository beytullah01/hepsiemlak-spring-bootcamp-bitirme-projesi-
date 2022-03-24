package com.example.emlakburadapayment.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emlakburadapayment.dto.request.PaymentRequest;
import com.example.emlakburadapayment.dto.response.PaymentResponse;
import com.example.emlakburadapayment.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping(value="/payments")
	public PaymentResponse savePayment(@RequestBody PaymentRequest paymentRequest){
		
		
		return paymentService.savePayment(paymentRequest);
	}
	
	
	@GetMapping(value="/payments/{id}")
	public PaymentResponse findPayment(@PathVariable int  id){
		
		return paymentService.paymentExist(id);
	}
	
	
	

}
