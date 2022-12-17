package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
