package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exception.ReservationException;
import com.masai.model.Reservation;



public interface ReservationService {

	public Reservation addReservation(Reservation reservation,Integer busId,String uuid) throws ReservationException ;
	
//	public Reservation  updateReservation(Reservation reservation,String uuid) throws ReservationException ;
	
	public Reservation  deleteReservation(Integer reservationId,String uuid) throws ReservationException ;
	
	public Reservation  viewReservationDetail(Integer reservationId,String uuid) throws ReservationException ;
	
	public List<Reservation>  viewReservations(Integer userID,String uuid) throws ReservationException ;
	
	public List<Reservation>  viewReservationsByDate(String uuid,String date) throws ReservationException ;
}
