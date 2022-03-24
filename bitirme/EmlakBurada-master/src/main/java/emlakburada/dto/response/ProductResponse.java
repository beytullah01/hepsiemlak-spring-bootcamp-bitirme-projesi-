package emlakburada.dto.response;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import emlakburada.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
	
	private int productId;
	private String name;
	private int quantity;
	private Date createdDate;
	private Date expiredDate;
	private Set<User> users;
	

	

}
