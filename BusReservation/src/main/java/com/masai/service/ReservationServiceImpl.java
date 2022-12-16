package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BusException;
import com.masai.exception.ReservationException;
import com.masai.model.Bus;
import com.masai.model.Reservation;
import com.masai.model.User;
import com.masai.repository.BusDao;
import com.masai.repository.ReservationDao;

import net.bytebuddy.utility.RandomString;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDao rDao;
	
	@Autowired
	private	BusDao bDao;
	
//	@Autowired
//	private UserDao uDao;
	
	
	// Seat reservation
	@Override
	public Reservation addReservation(Reservation reservation) throws ReservationException {
		
		
		
		Bus bus = bDao.findById(reservation.getBusId()).orElseThrow(() ->new BusException("Bus details not available."));
		
		
	
		
		if(bus.getAvailableSeats()<=0) {
			
			throw new ReservationException("All seats are booked.");
			
		}			
		else {
			
			bus.setSeats(bus.getAvailableSeats()-1);
			bDao.save(bus);
			
			reservation.setReservationStatus("Reservation Confirmed.");
			return rDao.save(reservation);
		}
		
		
	}

//	@Override
//	public Reservation updateReservation(Reservation reservation) throws ReservationException {
//		
//	return null;
//		
//		
//	}

	@Override
	public Reservation deleteReservation(Integer reservationId) throws ReservationException {
		
		Reservation reservations = rDao.findById(reservationId).orElseThrow(() -> new ReservationException("Reservation details not found."));
		
		Bus bus  = bDao.findById(reservations.getBusId()).orElseThrow(() -> new BusException("Bus details not found"));
		
		bus.setAvailableSeats(bus.getAvailableSeats()+1);
		
		reservations.setReservationStatus("Reservation Canceled.");
		
		return rDao.save(reservations);
		
	}

	@Override
	public Reservation viewReservationDetail(Integer reservationId) throws ReservationException {
		
		return rDao.findById(reservationId).orElseThrow(() -> new ReservationException("Reservation details not found."));
		
	}

//	@Override
//	public List<Reservation> viewReservations(Integer userID) throws ReservationException {
//		
//		List<Reservation> reservationsList = rDao.finByUserLoginId(userID);
//		
//		if(reservationsList.isEmpty()) {
//			throw new ReservationException("Reservation details not found.");
//		}
//		else
//		{
//			return reservationsList;
//		}
//		
//	}
//
//	@Override
//	public List<Reservation> viewReservationsByDate(Integer userID,LocalDate date) throws ReservationException {
//
//		List<Reservation> reservationsList = rDao.finByUserLoginIdAndTravelDate(userID, date);
//		
//		if(reservationsList.isEmpty()) {
//			throw new ReservationException("Reservation details not found.");
//		}
//		else
//		{
//			return reservationsList;
//		}
//	}

}
