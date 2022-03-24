package com.example.emlakburadaadverts.dto.request;

import java.math.BigDecimal;
import java.util.List;

import com.example.emlakburadaadverts.model.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdvertRequest {


	private int advertNo;
	private String baslik;
	private BigDecimal fiyat;
	private int suresi;
	//private List<Image> image ;
	
	private int userId;
}
