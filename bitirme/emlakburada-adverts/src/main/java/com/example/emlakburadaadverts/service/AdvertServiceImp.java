package com.example.emlakburadaadverts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.emlakburadaadverts.client.UserClientFeign;
import com.example.emlakburadaadverts.dto.request.AdvertRequest;
import com.example.emlakburadaadverts.dto.response.AdvertResponse;
import com.example.emlakburadaadverts.model.Advert;
import com.example.emlakburadaadverts.model.enums.Status;
import com.example.emlakburadaadverts.queue.RabbitMqListenerService;
import com.example.emlakburadaadverts.queue.RabbitMqService;
import com.example.emlakburadaadverts.repository.AdvertRepository;
import com.example.emlakburadaadverts.util.Result;
import com.example.emlakburadaadverts.util.DataResult;
import com.example.emlakburadaadverts.util.ErrorDataResult;
import com.example.emlakburadaadverts.util.SuccessDataResult;
import com.example.emlakburadaadverts.util.SuccessResult;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

import com.example.emlakburadaadverts.util.ErrorResult;

@Slf4j
@Service
public class AdvertServiceImp implements AdvertService {

	@Autowired
	private AdvertRepository advertRepository;

	@Autowired
	private UserClientFeign userFeignClient;
	
	@Autowired
	private RabbitMqService rabbitMqService;
	
	private static int advertNo = 38164784;

	
	public List<AdvertResponse> getAllAdverts() {

		List<AdvertResponse> advertList = new ArrayList<>();
		for (Advert advert : advertRepository.findAll()) {
			advertList.add(convertToAdvertResponse(advert));
		}
		return advertList;
	}

	public Result saveAdvert(AdvertRequest request) {

		if (userFeignClient.getFindQuantity(request.getUserId()) != null){

			Advert advert = advertRepository.save(convertToAdvert(request));

			rabbitMqService.sendMessage(advert.getAdvertId());
		
			return new SuccessDataResult<>(convertToAdvertResponse(advert), HttpStatus.CREATED,
					advert.getUserId() + " id li kisi ilan kaydetti");
		} else {

			return new Result(HttpStatus.NO_CONTENT, "kullanici olmadığı için ilan kaydedilemedi");
		}

	}

	public DataResult<AdvertResponse> updateAdvert(AdvertRequest request, int id) {

		try {
			Advert advert = advertRepository.getById(id);// ACTİVE VE passive getirme sadece tek metota ayarlansın

			advert.setBaslik(request.getBaslik());
			advert.setFiyat(request.getFiyat());
			advert.setSuresi(request.getSuresi());
			

			advertRepository.save(advert);
			log.info("ilan guncelleme gerceklestı");
			return new SuccessDataResult<AdvertResponse>(convertToAdvertResponse(advert), HttpStatus.OK,
					"ilan başarıyla güncellendi");

		} catch (Exception e) {
			log.info("ilan guncelleme gerceklesemedı");
			return new ErrorDataResult<AdvertResponse>(HttpStatus.NO_CONTENT,
					e.getMessage() + "ilan güncellenemedi basarısız");
		
		}

	}

	private AdvertResponse convertToAdvertResponse(Advert advert) {
		AdvertResponse response = new AdvertResponse();
		response.setAdvertId(advert.getAdvertId());
		response.setBaslik(advert.getBaslik());
		response.setFiyat(advert.getFiyat());
		response.setAdvertNo(advert.getAdvertNo());
		response.setUserId(advert.getUserId());
		response.setSuresi(advert.getSuresi());
		response.setStatus(advert.getStatus());

		return response;
	}

	private Advert convertToAdvert(AdvertRequest request) {
		Advert advert = new Advert();
		advertNo++;
		
		advert.setAdvertNo(advertNo);
		advert.setBaslik(request.getBaslik());
		advert.setFiyat(request.getFiyat());
		advert.setUserId(request.getUserId());
		advert.setSuresi(request.getSuresi());
		
		

		return advert;
	}

	public AdvertResponse getAdvertByAdvertId(int advertId) {
		Advert advert = advertRepository.getById(advertId);
		return convertToAdvertResponse(advert);
	}

	@Override
	public DataResult<List<AdvertResponse>> getAdvertByUserId(int userId) {

		List<AdvertResponse> advertResponses = new ArrayList<AdvertResponse>();

		if (userFeignClient.getFindUserById(userId) != null) {

			for (Advert advert : advertRepository.findByUserId(userId)) {
				advertResponses.add(convertToAdvertResponse(advert));
			}

			return new SuccessDataResult<List<AdvertResponse>>(advertResponses, HttpStatus.OK, "basarıyla listelendi");

		} else {

			return new ErrorDataResult<List<AdvertResponse>>(HttpStatus.NO_CONTENT,"getirilemedi");

		}

	}

	@Override
	public Result deleteById(int id) {
		
		try {
			advertRepository.deleteById(id);
			
			return new SuccessResult(HttpStatus.OK, id+"li ilan silindi");
		} catch (Exception e) {
	
			
			return new  ErrorResult(HttpStatus.NO_CONTENT, id+"li ilan bulunamadı");
		}
		
	
	}
	
	public void changeStatus(int id) {

		Advert advert = advertRepository.getById(id);

		advert.setStatus(Status.ACTIVE);

		advertRepository.save(advert);

	}

	@Override
	public List<Advert> passiveAdverts(int id) {

		List<Advert> passiveAdverts=advertRepository.findAllByUserIdAndStatus(id, Status.PASSIVE);
		
		return passiveAdverts;
	}

	@Override
	public List<Advert> activeAdverts(int id) {
		List<Advert> activeAdverts=advertRepository.findAllByUserIdAndStatus(id, Status.ACTIVE);
		
		return activeAdverts;
	}
	
	
	public Result makeActiveStatus(int id) {
		
		Advert advert=advertRepository.getById(id);
		
		advert.setStatus(Status.ACTIVE);
		
		return new  DataResult<Advert>(advertRepository.save(advert), HttpStatus.OK, "İlan aktif hale getirildi");
	}
	

	public Result makePassiveStatus(int id) {
		
		Advert advert=advertRepository.getById(id);
		
		advert.setStatus(Status.PASSIVE);
		
		return new  DataResult<Advert>(advertRepository.save(advert), HttpStatus.OK, "İlan pasif hale getirildi");
	}
	
	
	
	

}
