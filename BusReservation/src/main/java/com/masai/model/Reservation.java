package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reservationId;
	
	@NotNull
	private Integer seatQuantity;
	
	private String reservationStatus;
	
	@NotNull(message = "Can't set as Null")
	private String reservationType;
	
	@NotNull(message = "Can't set as Null")
	private LocalDate travelDate;
	
//	@NotNull(message = "Can't set as Null")
	private LocalDateTime reservationDateAndTime;
	
	@NotNull(message = "Can't set as Null")
	private String source;
	
	@NotNull (message = "Can't set as Null")
	private String destination;
	
	
	@ManyToOne
	private Bus bus;
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerLoginId")
	private Customer customer;
	
}
