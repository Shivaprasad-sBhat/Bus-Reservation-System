package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer feedBackId;
	
	@Min(value = 0 , message = "Can't set as 0")
	@Max(value = 10 , message = "Can't set as greater than 10")
	private Integer driverRating;
	
	@Min(value = 0 , message = "Can't set as 0")
	@Max(value = 10 , message = "Can't set as greater than 10")
	private Integer serviceRating;
	
	@Min(value = 0 , message = "Can't set as less tahn 0")
	@Max(value = 10 , message = "Can't set as greater than 10")
	private Integer overallRating;
	private String comments;

	private LocalDate feedBackDate;
	
	
	
	//private Integer userId;
	
}
