package emlakburada.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import emlakburada.dto.UserRequest;
import emlakburada.dto.response.ProductResponse;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.Order;
import emlakburada.model.User;
import emlakburada.service.UserService;
import emlakburada.utilities.DataResult;
import emlakburada.utilities.Result;
import emlakburada.utilities.SuccessDataResult;
import emlakburada.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/users")
	public DataResult<List<UserResponse>> getAllUsers() {

		return userService.getAllUsers();

	}

	@PostMapping(value = "/users")
	public Result saveUser(@RequestBody UserRequest request) {

		return userService.saveUser(request);

	}

	@DeleteMapping(value = "/users/{id}")
	public Result deleteUserById(@PathVariable int id) {

		return userService.deleteUserById(id);

	}

	@GetMapping(value = "/users/{id}")
	public UserResponse findUserById(@PathVariable int id) {

		return userService.findUserById(id);

	}
	
	@GetMapping(value = "/users/get-find-quantity/{userId}")
	public Object getFindQuantity(@PathVariable int userId) {// Kullanıcıya ait yayınlama hakkınız getirmek icin object donduruldu
		
		return userService.getFindQuantity(userId);

	}
	

	@PutMapping(value = "/users/{userId}")
	public Result updateUser(@RequestBody UserRequest userRequest,@PathVariable int userId) {
	  
	  return userService.updateUser(userRequest, userId);
	  
	  }
	

	@PutMapping(value="/users/{userId}/products/{productId}")
	public Result addProductToUser(@PathVariable int userId,@PathVariable int productId) {
		return userService.addProductToUser(userId, productId);
	}
	

	@GetMapping(value = "/users/packages-of-users/{userId}")
	public ResponseEntity<Order> getPackagesOfUsers(@PathVariable int userId) {

		return new ResponseEntity<Order>(userService.packagesOfUsers(userId),HttpStatus.OK);

	}
	
	
	
}
