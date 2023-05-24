package com.masai.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId;
	
	@NotNull(message = "bus name cannot set as null")
	private String busName;
	
	@NotNull(message = "driver name cannot set as null")
	private String driverName;

	@NotNull(message = "driver name cannot set as null")
	private String busType;
	
	
	
	@jakarta.persistence.Temporal(TemporalType.TIME)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private java.util.Date arrivalTime;
	
	

	@jakarta.persistence.Temporal(TemporalType.TIME)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private java.util.Date departureTime;

	@NotNull(message = "Can't set date as null")
	private LocalDate date;
	
	
	@Min(value = 10 , message = "seat min 10")
	@Max(value = 100 , message = "seat max 100")
	@NotNull(message = "Can't Set as null")
	private Integer seats;

	@Min( value = 0 , message = "not availabel seat")
	private Integer availableSeats;

	

	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "routeId")
	private Route routes;
}
