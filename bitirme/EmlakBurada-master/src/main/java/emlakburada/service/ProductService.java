package emlakburada.service;

import org.springframework.stereotype.Service;

import emlakburada.dto.ProductRequest;
import emlakburada.dto.response.ProductResponse;


public interface ProductService {
	
		ProductResponse	saveProduct(ProductRequest request);
		ProductResponse	updateProduct(int id,ProductRequest request);
		ProductResponse getByProductId(int id);
		

}
