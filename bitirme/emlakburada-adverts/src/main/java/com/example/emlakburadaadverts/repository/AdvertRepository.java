package com.example.emlakburadaadverts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.emlakburadaadverts.dto.response.AdvertResponse;
import com.example.emlakburadaadverts.model.Advert;
import com.example.emlakburadaadverts.model.enums.Status;



@Repository
public interface AdvertRepository extends JpaRepository<Advert, Integer> {

	List<Advert> findByUserId(int id);
	

	
	List<Advert> findAllByUserIdAndStatus(int userId,Status status);
	

}
