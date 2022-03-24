package com.example.emlakburadapayment.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

	

	private BigDecimal amount;
	private String creditCard;
	private Boolean isPay;
	private int userId;
	private int  productId;
	
}
