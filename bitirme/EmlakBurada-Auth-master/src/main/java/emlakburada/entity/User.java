package emlakburada.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import emlakburada.entity.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Table(name="users")
@Entity
@Getter
@Setter
public class User {

	@Id
	private int id;
	private String email;
	private String password;

}
