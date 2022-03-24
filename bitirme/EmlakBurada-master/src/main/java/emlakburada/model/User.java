package emlakburada.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import emlakburada.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

public  class User implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private UserType userType; 
	private String name;
	
	@NotNull(message = "email bos bırakma")
	@Size(min = 1, max = 255)
	@Column(name="email")
	private String email;
	private String password;
	private String photo;
	private String bio;
	
	private String creditCardNumber;
	
	/*
	 * @JsonIgnore
	 * 
	 * @EqualsAndHashCode.Exclude
	 * 
	 * @ToString.Exclude
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy =
	 * "enrolledUsers") private Set<Product> products=new HashSet<Product>();
	 * 
	 * public void addUsetToProduct(Product product) {
	 * 
	 * products.add(product);
	 * 
	 * }
	 */
	
	
	public User(int id, String name, String email) {
		
		this.id = id;
		
		this.name = name;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
