package com.masai.model;

import java.time.LocalDate;




import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedBackId;
	
	@NotNull(message = "can't set as null")
	private Integer driverRating;
	
	@NotNull(message = "can't set as null")
	private Integer serviceRating;
	
	@NotNull(message = "can't set as null")
	private Integer overallRating;
	
	private String comments;

	private LocalDate feedBackDate;
	
	
	@OneToOne
	@JoinColumn (name = "customerLoginId")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "reservationId")
	private Reservation reserc;
	

	
}
