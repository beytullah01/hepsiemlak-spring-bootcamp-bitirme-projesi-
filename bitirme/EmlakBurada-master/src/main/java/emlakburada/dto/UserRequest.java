package emlakburada.dto;


import javax.validation.constraints.NotNull;

import emlakburada.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {


	private String name;	
	private String email;
	private String password;
	private String bio;
	private String photo;
	private UserType userType;
	
	private String creditCardNumber;

}
