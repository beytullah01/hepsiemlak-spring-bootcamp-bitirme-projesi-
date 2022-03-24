package com.example.emlakburadaadverts.service;

import java.util.List;

import com.example.emlakburadaadverts.dto.request.AdvertRequest;
import com.example.emlakburadaadverts.dto.response.AdvertResponse;
import com.example.emlakburadaadverts.model.Advert;
import com.example.emlakburadaadverts.util.DataResult;
import com.example.emlakburadaadverts.util.Result;



public interface AdvertService {
	
	List<AdvertResponse> getAllAdverts();
	Result saveAdvert(AdvertRequest request);
	DataResult<AdvertResponse> updateAdvert(AdvertRequest request,int id);
	AdvertResponse getAdvertByAdvertId(int advertId);
	DataResult<List<AdvertResponse>> getAdvertByUserId(int id);
	Result deleteById(int id);
	void  changeStatus(int id);
	 List<Advert>  passiveAdverts(int id);
	 List<Advert>  activeAdverts(int id);
	 Result makePassiveStatus(int id);
	 Result makeActiveStatus(int id);
}