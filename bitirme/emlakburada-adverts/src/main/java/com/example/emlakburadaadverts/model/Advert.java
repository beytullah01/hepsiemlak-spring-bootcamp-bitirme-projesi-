package com.example.emlakburadaadverts.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import com.example.emlakburadaadverts.model.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="adverts")

public class Advert {
	
	@Id
	@Column(name="advert_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int advertId;
	private int advertNo;
	private String baslik;
	private BigDecimal fiyat;
	private int suresi;
	private int userId;
	@Enumerated(value =EnumType.STRING)
	private Status status=Status.IN_REVIEW;




}