package emlakburada.service;

import org.springframework.stereotype.Service;

import emlakburada.dto.AuthRequest;
import emlakburada.dto.AuthResponse;
import emlakburada.entity.User;
import emlakburada.repository.AuthRepository;
import emlakburada.util.JwtUtil;
import emlakburada.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthService {

	private final AuthRepository authRepository;

	private final JwtUtil jwtUtil;

	public AuthResponse getToken(AuthRequest request) throws Exception {
		User user = authRepository.findByEmail(request.getEmail());

		if (user == null) {
			log.error("User not found with email " + request.getEmail());
			throw new Exception("User not found");
		}

		if (!UserUtil.isValidPassword(user.getPassword(), request.getPassword())) {
			log.error("User's password not valid " + request.getEmail());
			throw new Exception("User's password not valid");
		}

		return new AuthResponse(jwtUtil.generateToken(user));//token
	}

}
