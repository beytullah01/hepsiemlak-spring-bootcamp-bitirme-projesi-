package emlakburada.service;

import java.util.List;

import emlakburada.dto.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.Order;
import emlakburada.model.User;
import emlakburada.utilities.DataResult;
import emlakburada.utilities.Result;

public interface UserService {
	
	Result saveUser(UserRequest request);
	DataResult<List<UserResponse>> getAllUsers();
	UserResponse findUserById(int id);
	Result deleteUserById(int id);
	User findByEmail(String email);
	Result updateUser(UserRequest userRequest,int id);
	Result addProductToUser(int userId,int productId);
	Order packagesOfUsers(int userId);
	Order getFindQuantity(int userId);

	
	
	

}
