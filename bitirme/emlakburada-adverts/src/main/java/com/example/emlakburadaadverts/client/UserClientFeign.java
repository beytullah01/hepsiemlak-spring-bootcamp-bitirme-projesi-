package com.example.emlakburadaadverts.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.emlakburadaadverts.client.request.UserRequest;

import com.example.emlakburadaadverts.client.response.UserResponse;





@FeignClient(name="user-client",url="http://localhost:8080")
public interface UserClientFeign {

	@GetMapping(value="/users/{userId}")
	public UserResponse getFindUserById(@PathVariable int userId);
	
	@GetMapping(value = "/users/get-find-quantity/{userId}")
	public Object getFindQuantity(@PathVariable int userId);
	
	
}
