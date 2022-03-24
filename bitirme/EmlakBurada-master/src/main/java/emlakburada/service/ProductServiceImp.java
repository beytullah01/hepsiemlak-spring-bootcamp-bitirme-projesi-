package emlakburada.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.dto.ProductRequest;
import emlakburada.dto.UserRequest;
import emlakburada.dto.response.ProductResponse;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.Order;
import emlakburada.model.Product;
import emlakburada.model.User;
import emlakburada.repository.OrderRepository;
import emlakburada.repository.ProductRepository;
import emlakburada.repository.UserRepository;

@Service
public class ProductServiceImp  implements ProductService{

	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderService orderService;
	
	@Override
	public ProductResponse saveProduct(ProductRequest request) {
		
		Product product=convertToProduct(request);
		productRepository.save(product);
		
		
		return convertToProductResponse(product);
	}

	@Override
	public ProductResponse updateProduct(int id, ProductRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductResponse getByProductId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	public Product convertToProduct(ProductRequest productRequest) {
		
		long oneDayLongValue = 1000 * 60 * 60 * 24;

		Date now=new Date();
		Date afterThirtyDays = new Date(now.getTime() + (30 * oneDayLongValue));
		
		Product product = new Product();
	
		
		product.setName(productRequest.getName());
		product.setCreatedDate(now);
		product.setExpiredDate(afterThirtyDays);
		product.setQuantity(10);
		
		return product;
	}

	public  ProductResponse convertToProductResponse(Product product) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setProductId(product.getProductId());
		productResponse.setName(product.getName());
		productResponse.setExpiredDate(product.getExpiredDate());
		productResponse.setCreatedDate(product.getCreatedDate());
		productResponse.setQuantity(product.getQuantity());
		//productResponse.setUsers(product.getEnrolledUsers());
		return productResponse;
	}
	
	public ProductResponse enrolledUserToProduct(int userId,int productId) {
		
		Product product=productRepository.getById(productId);
		User user=userRepository.getById(userId);
		//product.enrolledUser(user);
		productRepository.save(product);
		return  convertToProductResponse(product);
	} 
	
	
	

	
	
	
	
	
}
