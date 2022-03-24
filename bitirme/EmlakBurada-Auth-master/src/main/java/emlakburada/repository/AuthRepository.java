package emlakburada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import emlakburada.entity.User;


public interface AuthRepository extends JpaRepository<User, Integer> {
	
	
	User findByEmail(String email);

}
