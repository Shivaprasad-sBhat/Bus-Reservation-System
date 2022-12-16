package com.masai.service;

import com.masai.exception.ReservationException;
import com.masai.model.Reservation;



public interface ReservationService {

	public Reservation addReservation(Reservation reservation,Integer busId) throws ReservationException ;
	
//	public Reservation  updateReservation(Reservation reservation) throws ReservationException ;
	
	public Reservation  deleteReservation(Integer reservationId) throws ReservationException ;
	
	public Reservation  viewReservationDetail(Integer reservationId) throws ReservationException ;
	
//	public List<Reservation>  viewReservations(Integer userID) throws ReservationException ;
//	
//	public List<Reservation>  viewReservationsByDate(Integer userID,LocalDate date) throws ReservationException ;
}
