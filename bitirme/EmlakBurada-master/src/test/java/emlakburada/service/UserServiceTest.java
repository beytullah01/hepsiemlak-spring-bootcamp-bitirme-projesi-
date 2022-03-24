package emlakburada.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import emlakburada.dto.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;
import emlakburada.model.enums.UserType;
import emlakburada.repository.UserRepository;
import emlakburada.utilities.Result;

public class UserServiceTest {
	
	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@BeforeEach
	void init() {

		Mockito.when(userRepository.findAll()).thenReturn(prepare());
		Mockito.when(userRepository.save(any())).thenReturn(prepareUser());
		Mockito.when(userRepository.getById(1)).thenReturn(prepareUser());
		Mockito.when(userRepository.saveAndFlush(any())).thenReturn(prepareUser());
		
		
	
	}
	

	private List<User> prepare() {
		List<User> userList = new ArrayList<User>();

		userList.add(new User(0, UserType.INDIVIDUAL, "AHMET", "AHMET@GMAİL.COM", null, null, null, null));
		userList.add(new User(1, UserType.INDIVIDUAL, "AHMET", "AHMET@GMAİL.COM", null, null, null, null));
		return userList;
	}
	
	@Test
	void getAllUsers() {
		
		List<UserResponse> allUser=userService.getAllUsers();
		
		assertNotNull(allUser);
		assertThat(allUser.size()).isNotZero();
	}
	
	@Test
	void saveUserTest() {
		
		   UserRequest request=userRequestPrepare();
		       
		   Result response=userService.saveUser(request);
		     assertEquals("adam@gmail.com", response.getEmail());  	
		       
		       
	}
	
	


	private User prepareUser() {
	
		return new User(1, UserType.INDIVIDUAL,"adam", "adam@gmail.com");
	}

	private UserRequest userRequestPrepare() {
		
		return new UserRequest(1,"adam", "adam@gmail.com", "bio");
		
	}
	
	
	@Test
	void findUser() {
		
	
		
		UserResponse response=userService.findByIdUser(1);
		
		assertEquals("adam@gmail.com", response.getEmail());  
	}
	
	
	
	@Test 
	void updateUser() {
		
		
		
		UserResponse response=userService.updateUser(userUpdateRequestPrepare());
		
		assertEquals("adam@gmail.com",  response.getEmail());
		
		
		
	}
	private UserRequest userUpdateRequestPrepare() {
		
		return new UserRequest(1,"kadam", "adam@gmail.com", "bio");
		
	}
	
	@Test
	void deleteUser() {
		
		
		boolean  result=userService.deleteUser(1);
		
		assertEquals(true, result);
		
	}
	

}
