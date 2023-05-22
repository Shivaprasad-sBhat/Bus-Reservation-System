package com.masai.model;

import java.util.ArrayList;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//pending 

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;
	
	@NotNull(message = "can't set as null")
	private String routeFrom;
	
	@NotNull(message = "can't set as null")
	private String routeTo;
	
	@NotNull(message = "can't set as null")
	private Integer distance;
	
//	
//	@JsonIgnore
	@OneToMany(mappedBy = "routes",cascade = CascadeType.ALL)
	private List<Bus> bus = new ArrayList<>();
	
}
