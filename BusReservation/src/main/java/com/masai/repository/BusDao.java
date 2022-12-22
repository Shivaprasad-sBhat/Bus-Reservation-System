package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Bus;

public interface BusDao extends JpaRepository<Bus, Integer> {

	public List<Bus> findByBusType(String busType);
	
	
	
}
