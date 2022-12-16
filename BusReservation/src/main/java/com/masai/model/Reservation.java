package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

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
	
	@Value("Not Booked.")
	private String reservationStatus;
	
	@NotNull(message = "Can't set as Null")
	private String reservationType;
	
	@NotNull(message = "Can't set as Null")
	private LocalDate travelDate;
	
	@NotNull(message = "Can't set as Null")
	private LocalDateTime reservationDateAndTime;
	
	@NotNull(message = "Can't set as Null")
	private String source;
	
	@NotNull(message = "Can't set as Null")
	private String destination;
	
	@NotNull(message = "Can't set as Null")
	private Integer busId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userLoginId")
	@NotNull(message = "Can't set as Null")
	private User user;
	
}
