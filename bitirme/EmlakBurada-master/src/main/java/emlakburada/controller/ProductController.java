
package emlakburada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import emlakburada.dto.ProductRequest;
import emlakburada.dto.response.ProductResponse;
import emlakburada.service.ProductService;
import emlakburada.utilities.Result;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	
	@PostMapping(value = "/products")
	public ResponseEntity<ProductResponse> createAdvert(@RequestBody ProductRequest request) {
		return new ResponseEntity<>(productService.saveProduct(request), HttpStatus.CREATED);
	}
	
	

	
}
