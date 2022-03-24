package com.example.emlakburadaadverts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emlakburadaadverts.dto.request.AdvertRequest;
import com.example.emlakburadaadverts.dto.response.AdvertResponse;
import com.example.emlakburadaadverts.model.Advert;
import com.example.emlakburadaadverts.service.AdvertService;
import com.example.emlakburadaadverts.util.DataResult;
import com.example.emlakburadaadverts.util.Result;

@RestController
public class AdvertController {

	@Autowired
	private AdvertService advertService;

	@PostMapping(value = "/adverts")
	public Result createAdvert(@RequestBody AdvertRequest request) {
		
		return advertService.saveAdvert(request);
	}

	@GetMapping(value = "/adverts/{userId}")
	public DataResult<List<AdvertResponse>> getAllAdvertByUserId(@PathVariable int userId) {

		return advertService.getAdvertByUserId(userId);
	}

	

	@PutMapping(value = "/adverts/{id}")
	public DataResult<AdvertResponse> updateAdvert(@RequestBody AdvertRequest request, @PathVariable int id) {

		return advertService.updateAdvert(request, id);
	}
	
	@DeleteMapping(value="/adverts/{id}")
	public Result deleteAdvertById(@PathVariable int id) {

		return advertService.deleteById(id);
	}
	
	
	@GetMapping(value="/adverts/passive-adverts/{userId}")
	public ResponseEntity<List<Advert>> getPassiveAdverts(@PathVariable Integer userId) {

		return new ResponseEntity<>(advertService.passiveAdverts(userId), HttpStatus.OK);
	}
	
	@GetMapping(value="/adverts/active-adverts/{userId}")
	public ResponseEntity<List<Advert>> getActiveAdverts(@PathVariable Integer userId) {

		return new ResponseEntity<>(advertService.activeAdverts(userId), HttpStatus.OK);
	}
	
	@PutMapping(value="/adverts/make-active-advert/{advertId}")
	public Result updateActiveAdvert(@PathVariable int advertId) {

		return advertService.makeActiveStatus(advertId);
	}
	@PutMapping(value="/adverts/make-passive-advert/{advertId}")
	public Result updatePassiveAdvert(@PathVariable int advertId) {

		return advertService.makePassiveStatus(advertId);
	}

}
