package emlakburada.util;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import emlakburada.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private static final String SECRET_KEY = "bitirme-projesi-bize-yar-olsun-bitirme-projesi-bize-yar-olsunbitirme-projesi-bize-yar-olsun-";

	private static final long EXPIRATION_TIME = 50_000_000;

	private Key key;

	@PostConstruct
	public void init() {
		this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}

	private Claims getAllClaimsFromToken(String token) {
		//// @formatter:off
		return Jwts
				.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
		// @formatter:on
	}

	public String getUserName(String token) {
		return getAllClaimsFromToken(token).getSubject();
	}

	public Date getExpirationDate(String token) {
		return getAllClaimsFromToken(token).getExpiration();
	}

	public boolean isTokenExpired(String token) {
		return this.getExpirationDate(token).before(new Date());
	}

	public String generateToken(User user) {

		Map<String, Object> claims = new HashMap<>();
	
		claims.put("email", user.getEmail());
		claims.put("id", user.getId());
		claims.put("beytullah", "BOZKURT");
		claims.put("service", "emlakburada-auth");

		long now = System.currentTimeMillis();

		// @formatter:off
 
		return Jwts
				.builder()
				.setClaims(claims)
				.setSubject(user.getEmail())
				.setIssuedAt(new Date())
				.setIssuer("emlakburada")
				.setExpiration( new Date(now + EXPIRATION_TIME))
				.signWith(key, SignatureAlgorithm.HS512)
				.compact();
		
		// @formatter:on
	}

}
