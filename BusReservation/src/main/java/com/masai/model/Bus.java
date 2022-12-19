package com.masai.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.tomcat.jni.Time;
import org.springframework.data.jpa.repository.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	
	
	
	@javax.persistence.Temporal(TemporalType.TIME)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private java.util.Date arrivalTime;
	
	

	@javax.persistence.Temporal(TemporalType.TIME)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private java.util.Date departureTime;
	
	
	@Min(value = 30 , message = "seat min 30")
	@Max(value = 60 , message = "seat max 60")
	private Integer seats;

	@Min( value = 0 , message = "not availabel seat")
	private Integer availableSeats;
	

	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "routeId")
	private Route routes;
}
