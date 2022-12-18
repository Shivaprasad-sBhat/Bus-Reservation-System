package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exception.ReservationException;
import com.masai.model.Reservation;
import com.masai.model.User;



public interface ReservationService {

	public Reservation addReservation(Reservation reservation,Integer busId, Integer Userid) throws ReservationException ;
	
//	public Reservation  updateReservation(Reservation reservation,String uuid) throws ReservationException ;
	
	public Reservation  deleteReservation(Integer reservationId, Integer userid) throws ReservationException ;
	
	public Reservation  viewReservationDetail(Integer reservationId,Integer userid) throws ReservationException ;
	
	public List<Reservation>  viewReservations(Integer userID) throws ReservationException ;
	
	public List<Reservation>  viewReservationsByDate(Integer userId,String date) throws ReservationException ;
}
