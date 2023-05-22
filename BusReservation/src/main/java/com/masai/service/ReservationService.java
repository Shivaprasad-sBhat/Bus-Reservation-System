package com.masai.service;


import java.util.List;
import com.masai.exception.ReservationException;
import com.masai.model.Reservation;




public interface ReservationService {

	public Reservation addReservation(Reservation reservation,Integer busId) throws ReservationException ;
	
//	public Reservation  updateReservation(Reservation reservation,String uuid) throws ReservationException ;
	
	public Reservation  deleteReservation(Integer reservationId) throws ReservationException ;
	
	public Reservation  viewReservationDetail(Integer reservationId) throws ReservationException ;
	
	public List<Reservation>  viewReservations() throws ReservationException ;
	
	public List<Reservation>  viewReservationsByDate(String date) throws ReservationException ;
}
