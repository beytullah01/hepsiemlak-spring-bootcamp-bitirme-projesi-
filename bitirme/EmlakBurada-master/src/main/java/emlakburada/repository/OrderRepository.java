package emlakburada.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import emlakburada.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	@Query(
			  value = "SELECT * FROM orders u WHERE u.package_user_id = ?", 
			  nativeQuery = true)
	Order findOrderByUserId(int id);

}
