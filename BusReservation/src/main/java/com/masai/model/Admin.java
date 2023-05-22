package com.masai.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin  extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;

}
