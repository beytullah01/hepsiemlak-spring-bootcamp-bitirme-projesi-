package emlakburada.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import emlakburada.client.PaymentClient;

import emlakburada.dto.UserRequest;

import emlakburada.dto.response.UserResponse;
import emlakburada.model.Order;
import emlakburada.model.Product;
import emlakburada.model.User;

import emlakburada.repository.ProductRepository;
import emlakburada.repository.UserRepository;
import emlakburada.utilities.DataResult;
import emlakburada.utilities.ErrorDataResult;
import emlakburada.utilities.ErrorResult;
import emlakburada.utilities.Result;
import emlakburada.utilities.SuccessDataResult;
import emlakburada.utilities.SuccessResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderService orderService;

	@Override
	public Result saveUser(UserRequest request) { // save işlemi gerceklesir

		if (request.getEmail() == null) {

			return new ErrorResult("mail bos olmamalı");

		} else if (userRepository.findByEmail(request.getEmail()) == null) {

			User user = userRepository.save(convertToUserEntity(request));

			return new SuccessDataResult<>(convertToUserResponse(user), HttpStatus.CREATED, "kullanici eklendi");
		}

		return new ErrorResult(HttpStatus.NO_CONTENT, "Bu e-posta adresine ait bir hesabınız olduğunu fark ettik.");

	}

	@Override
	public DataResult<List<UserResponse>> getAllUsers() {
		List<UserResponse> userResponses = new ArrayList<>();
		try {

			for (User user : userRepository.findAll()) {
				userResponses.add(convertToUserResponse(user));
			}

			return new SuccessDataResult<List<UserResponse>>(userResponses, HttpStatus.OK,
					"sonuclar basarılı bir sekilde getirildi");

		} catch (Exception e) {

			return new ErrorDataResult<List<UserResponse>>(userResponses, e.getMessage() + " hata");

		}
	}

	@Override
	public UserResponse findUserById(int id) {

		try {
			User user = userRepository.getById(id);

			return convertToUserResponse(user);

		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public Result deleteUserById(int id) {

		try {
			userRepository.deleteById(userRepository.getById(id).getId());
			return new SuccessResult(HttpStatus.OK, id + "numaralı kisi silindi");

		} catch (Exception e) {

			return new ErrorResult(HttpStatus.NO_CONTENT, id + "numaralı kisi olmadıgı icin islem yapılmadı");
		}

	}

	protected User convertToUserEntity(UserRequest userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setBio(userRequest.getBio());
		user.setPassword(userRequest.getPassword());

		return user;
	}

	protected UserResponse convertToUserResponse(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setName(user.getName());
		userResponse.setEmail(user.getEmail());
		userResponse.setBio(user.getBio());
		userResponse.setUserType(user.getUserType());
		// userResponse.setProductsToUsers(user.getProducts());
		return userResponse;
	}

	@Override
	public User findByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	@Override
	public Result updateUser(UserRequest userRequest, int id) {

		try {
			User user = userRepository.getById(id);

			user.setBio(userRequest.getBio());
			user.setName(userRequest.getName());
			user.setPhoto(userRequest.getPhoto());
			user.setPassword(userRequest.getPassword());

			userRepository.save(user);

			return new SuccessDataResult<UserResponse>(convertToUserResponse(user), HttpStatus.OK,
					"Kullanici başarıyla güncellendi");

		} catch (Exception e) {
			return new ErrorDataResult<UserResponse>(HttpStatus.NO_CONTENT,
					e.getMessage() + "ilan güncellenemedi basarısız");
		}

	}

	public Result addProductToUser(int userId, int productId) {
		try {
			Order order = null;
			User user = userRepository.getById(userId);
			Product product = productRepository.getById(productId);
			Date createdDate = new Date();
			Date expiredDate;

			if (orderService.getOrderByUserId(userId) == null) {
																

				order = new Order();
				expiredDate = new Date(createdDate.getTime() + (1000L * 60 * 60 * 24 * 30));
				order.setUserId(user);
				order.setUserProduct(product);
				order.setCreatedDate(createdDate);
				order.setExpiredDate(expiredDate);
				order.setQuantity(product.getQuantity());

			} else { 
						

				order = orderService.getOrderByUserId(userId);
				expiredDate = new Date(order.getExpiredDate().getTime() + (1000L * 60 * 60 * 24 * 30));
				order.setUserId(user);
				order.setUserProduct(product);
				order.setQuantity(product.getQuantity() + order.getQuantity());
				order.setCreatedDate(createdDate);
				order.setExpiredDate(expiredDate);

				orderService.saveOrder(order);
			}

			log.info("kullanıcıya urun ekleme metodu calıstı");

			return new DataResult<Order>(order, HttpStatus.OK, "kullanıcıya 10 hak eklendi");

		} catch (Exception e) {

			log.info("kullanıcıya urun ekleme metodu calısmadı");

			return new ErrorResult(HttpStatus.NO_CONTENT,
					"kullanıcıya ürün eklenemedi. Hata mesajı-->" + e.getMessage());
		}

	}

	@Override
	public Order getFindQuantity(int userId) {

		try {
			Order order = orderService.getOrderByUserId(userId);
			if (order != null) {

				order.setQuantity(order.getQuantity() - 1);
				orderService.saveOrder(order);
				return order;

			} else {

				return null;
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return null;
		}

	}

	public Order packagesOfUsers(int userId) {

		Order order = orderService.getOrderByUserId(userId);

		return order;
	}

}
