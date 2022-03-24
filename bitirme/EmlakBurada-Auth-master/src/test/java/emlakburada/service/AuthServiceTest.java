package emlakburada.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import emlakburada.dto.AuthRequest;
import emlakburada.dto.AuthResponse;
import emlakburada.entity.User;
import emlakburada.entity.enums.UserType;
import emlakburada.repository.AuthRepository;
import emlakburada.util.JwtUtil;

@SpringBootTest
public class AuthServiceTest {

		@InjectMocks
		private AuthService authService;
	
		@Mock
		private AuthRepository authRepository;
		
		@Mock
		private JwtUtil jwtUtil;
		

			@BeforeEach
			void init() {
				
				Mockito.when(authRepository.findByEmail("beytullahbozkurt@gmail.com")).thenReturn(prepareUser());
				
		
			}
	
	
			private User  prepareUser() {
				User user=new User();
				user.setEmail("beytullahbozkurt@gmail.com");
			
				user.setPassword("selaminko");
				return user;
			}
			
			
			private AuthRequest  prepareAuthRequest() {
				
				
				return new AuthRequest("beytullahbozkurt@gmail.com","selaminko");
			}
			
			private String jwtToken() {
				
				
				return jwtUtil.generateToken(prepareUser());
			}
		
			@Test
			void auth() throws Exception{
				
				AuthResponse response=authService.getToken(prepareAuthRequest());
			
				
				
				assertEquals(jwtToken(),response.getToken() );
				
				
			}
		
}
