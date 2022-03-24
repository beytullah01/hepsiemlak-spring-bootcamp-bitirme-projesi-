package emlakburada.dto.response;

import java.util.Set;

import emlakburada.model.Product;
import emlakburada.model.enums.Status;
import emlakburada.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	
	
	private int id;
	private String name;
	private String email;
	private String bio;
	private UserType userType;
	private Set<Product> productsToUsers;

}
