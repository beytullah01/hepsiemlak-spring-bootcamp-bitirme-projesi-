package emlakburada.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//import emlakburada.client.request.PaymentRequest;
import emlakburada.client.response.PaymentResponse;



@FeignClient(name="feing-client",url="http://localhost:8097")
public interface PaymentClient {
	
	/*
	 * @PostMapping(value="/payments") PaymentResponse savePayment(@RequestBody
	 * PaymentRequest paymentRequest);
	 * 
	 * @GetMapping(value="/payments/{orderId}") PaymentResponse
	 * findPaymentByOrderId(@PathVariable int orderId);
	 * 
	 * @GetMapping(value="/payments/prepare") public PaymentRequest
	 * paymentRequest();
	 */
}
