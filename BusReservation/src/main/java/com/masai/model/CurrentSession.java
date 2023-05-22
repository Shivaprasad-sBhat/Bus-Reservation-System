package com.masai.model;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CurrentSession {

	@Id
	@Column(unique = true)
	private Integer id;
	
	private String type;
	
	private String uuid;
	
	private LocalDateTime timeStamp;

	
}
