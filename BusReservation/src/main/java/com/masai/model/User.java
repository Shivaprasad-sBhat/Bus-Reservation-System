package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userLoginId;
	
	@NotNull(message = "user name cannot set as null")
	@NotEmpty(message = "user name cannot set as empty")
	@NotBlank(message = "user name cannot set as blank")
	@Column(unique = true)
	private String userName;
	
	@NotNull(message = "password cannot set as null")
	@NotEmpty(message = "password cannot set as empty")
	@NotBlank(message = "password cannot set as blank")

	private String password;
	
	@NotNull(message = "first name  cannot set as null")
	@NotEmpty(message = "first name cannot set as empty")
	@NotBlank(message = "first name cannot set as blank")
	private String firstName;
	
	@NotNull(message = "last name cannot set as null")
	@NotEmpty(message = "last name cannot set as empty")
	@NotBlank(message = "last name cannot set as blank")
	private String lastName;
	
	@NotNull(message = "contact cannot set as null")
	private long contact;
	
	@Column(unique = true)
	@Email(message = "email format is incorrect")
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Reservation> reservationList = new ArrayList();
	
}
