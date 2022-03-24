package com.example.emlakburadapayment.dto.response;

import java.math.BigDecimal;

import com.example.emlakburadapayment.dto.request.PaymentRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
	
	private int paymentId;
	private int orderId;
	private BigDecimal amount;
	private String creditCard;
	private Boolean isPay;
	
}
