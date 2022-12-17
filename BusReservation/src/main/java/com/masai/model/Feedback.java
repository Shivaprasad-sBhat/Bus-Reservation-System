package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	private Integer driverRating;
	
	private Integer serviceRating;
	
	private Integer overallRating;
	private String comments;

	private LocalDate feedBackDate;
	
	
	@OneToOne
	@JoinColumn(name = "userLoginId")
	private User user ;
	

	
}
