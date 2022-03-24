package com.example.emlakburadapayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.emlakburadapayment.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	
	@Query(
			  value = "SELECT * FROM payments u WHERE u.order_id= ?", 
			  nativeQuery = true)
	Payment findPaymentByOrderId(int orderId);

}
