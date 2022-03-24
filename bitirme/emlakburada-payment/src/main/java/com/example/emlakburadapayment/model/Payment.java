package com.example.emlakburadapayment.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private int orderId;
	private BigDecimal amount;
	private String creditCard;
	private Boolean isPay=false;
	private int userId;
	private int  productId;
	
	
	

}
