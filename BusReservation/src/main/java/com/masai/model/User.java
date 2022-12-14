package com.masai.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	@NotNull(message = "bus name cannot set as null")
	@NotEmpty(message = "bus name cannot set as empty")
	@NotBlank(message = "bus name cannot set as blank")
	@Column(unique = true)
	private String userName;
	
	@NotNull(message = "bus name cannot set as null")
	@NotEmpty(message = "bus name cannot set as empty")
	@NotBlank(message = "bus name cannot set as blank")
    @Size(min =  8 , message = "Minimum 8 charcters")
	private String password;
	
	@NotNull(message = "bus name cannot set as null")
	@NotEmpty(message = "bus name cannot set as empty")
	@NotBlank(message = "bus name cannot set as blank")
	private String firstName;
	
	@NotNull(message = "bus name cannot set as null")
	@NotEmpty(message = "bus name cannot set as empty")
	@NotBlank(message = "bus name cannot set as blank")
	private String lastName;
	
	@NotNull(message = "bus name cannot set as null")
	@NotEmpty(message = "bus name cannot set as empty")
	@NotBlank(message = "bus name cannot set as blank")
	private long contact;
	
	@Column(unique = true)
	@Email(message = "not in mail format")
	private String email;
	
	private Reservation reservation;
	
}
