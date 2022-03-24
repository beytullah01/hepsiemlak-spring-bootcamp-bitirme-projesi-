package com.example.emlakburadaadverts.dto.response;

import java.math.BigDecimal;

import com.example.emlakburadaadverts.model.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertResponse {


	private int advertId;
	private int advertNo;
	//private RealEstate gayrimenkul;
	private String baslik;
	
	//private String[] resimList = new String[5];
	private BigDecimal fiyat;
	private int suresi;
	//private Status status;
	private int userId;
	private Status status;
	
	
	//private boolean oneCikarilsinMi = false;
	//private boolean incelendiMi = false;
	//private Date olusturulmaTarihi;
	//private boolean aktifMi;
	//private Address address;
}