package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Bus;
import com.masai.model.Reservation;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer>{
	
	public List<Reservation> findByBus(Bus bus);
	
	
	
	
}