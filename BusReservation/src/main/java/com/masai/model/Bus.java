package com.masai.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId;
	
	@NotNull(message = "bus name cannot set as null")
	@NotEmpty(message = "bus name cannot set as empty")
	@NotBlank(message = "bus name cannot set as blank")
	private String busName;
	
	@NotNull(message = "bus name cannot set as null")
	@NotEmpty(message = "bus name cannot set as empty")
	@NotBlank(message = "bus name cannot set as blank")
	private String driverName;

	@NotNull(message = "bus name cannot set as null")
	@NotEmpty(message = "bus name cannot set as empty")
	@NotBlank(message = "bus name cannot set as blank")
	private String busType;
	
	@NotNull(message = "routeTFrom cannot set as null")
	@NotEmpty(message = "routeFrom cannot set as empty")
	@NotBlank(message = "routeFrom cannot set as blank")
	private String routeFrom;
	
	@NotNull(message = "routeTo cannot set as null")
	@NotEmpty(message = "routeTo cannot set as empty")
	@NotBlank(message = "routeTo cannot set as blank")
	private String routeTo;
	
	@Future(message = "Only future date is allowed")
	@NotNull(message = "can't set as null")
	private LocalTime arrivalTime;
	
	@Future(message = "Only future date is allowed")
	@NotNull(message = "can't set as null")
	private LocalTime departureTime;
	
	
	@NotNull(message = "can't set as null")
	@Min(value = 30 , message = "seat min 30")
	@Max(value = 60 , message = "seat max 60")
	private Integer seats;
	
	@NotNull(message = "cannt set as null")
	@Min( value = 0 , message = "not availabel seat")
	private Integer availableSeats;
}
