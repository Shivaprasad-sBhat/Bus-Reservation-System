package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Feedback {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer feedBackId;
	
	@Min(0)
	private Integer driverRating;
	
	@Min(0)
	private Integer serviceRating;
	
	@Min(0)
	private Integer overallRating;
	
	@NotNull
	private String comments;
	
	private LocalDate feedBackDate;
	
/**	private User users;  **/
	
/**	private Bus bus **/
	
}
