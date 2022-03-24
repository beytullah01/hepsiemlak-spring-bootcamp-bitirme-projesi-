package emlakburada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.model.Order;
import emlakburada.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	Order saveOrder(Order order) {
		
		
		
		return orderRepository.save(order);
	
	}
	
	
	Order getOrderByUserId(int id) {
		
		
		
		return orderRepository.findOrderByUserId(id);
	
	}
}
