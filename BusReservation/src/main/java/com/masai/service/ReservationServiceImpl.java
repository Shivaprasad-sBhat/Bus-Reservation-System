package com.masai.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import com.masai.repository.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDao rDao;
	
	@Autowired
	private	BusDao bDao;
	
	@Autowired
	private UserDao uDao;
	
	
	// Seat reservation
	@Override
	public Reservation addReservation(Reservation reservation,Integer busId) throws ReservationException, UserException {
		
		
	Bus bus =	bDao.findById(busId).orElseThrow(() -> new ReservationException("Bus not found."));
	
	User user = uDao.findById(11).orElseThrow(() ->new UserException("User details not found."));
	
	if(reservation.getReservationDateAndTime().isBefore(LocalDateTime.now()))
		throw new ReservationException("Plese enter future date");
	
	if(bus.getAvailableSeats()<=0) 
		throw new ReservationException("All seats are booked.");
		
	
			bus.setAvailableSeats(bus.getAvailableSeats()-1);
			reservation.setBus(bus);
			reservation.setReservationStatus("Success");
			reservation.setReservationDateAndTime(LocalDateTime.now());
			reservation.setSource(bus.getRoutes().getRouteFrom());
			reservation.setDestination(bus.getRoutes().getRouteTo());
			
			
//			List<Reservation> reservationList = rDao.get
			
			
//			user.setReservationList(reservation);
//			
			
			
			
	
			return	rDao.save(reservation);
			
			
			
	
	}
	
	
		
//		Bus bus = bDao.findById(reservation.getBus().getBusId()).orElseThrow(() ->new BusException("Bus details not available."));
//		
//		
//		
//		
//	
//			
//			
////			reservation.setReservationStatus("Reservation Confirmed.");
////			bus.getReservations().add(reservation);
////			
//			
//			//bDao.save(bus);
//			
//			Reservation reservation2 = new Reservation();
//			
//			
//			reservation2.setDestination(reservation.getDestination());
//			reservation2.setReservationDateAndTime(reservation.getReservationDateAndTime());
//			reservation2.setReservationStatus(reservation.getReservationStatus());
//			reservation2.setReservationType(reservation.getReservationStatus());
//			reservation2.setSource(reservation.getSource());
//			reservation2.setTravelDate(reservation.getTravelDate());
//			
//			
//			
//			return rDao.save(reservation2);
//		}
		
		
//	}

//	@Override
//	public Reservation updateReservation(Reservation reservation) throws ReservationException {
//		
//	return null;
//		
//		
//	}

	@Override
	public Reservation deleteReservation(Integer reservationId) throws ReservationException {
		
//		Reservation reservations = rDao.findById(reservationId).orElseThrow(() -> new ReservationException("Reservation details not found."));
//		
//		Bus bus  = bDao.findById(reservations.getBusId()).orElseThrow(() -> new BusException("Bus details not found"));
//		
//		bus.setAvailableSeats(bus.getAvailableSeats()+1);
//		
//		reservations.setReservationStatus("Reservation Canceled.");
//		
//		return rDao.save(reservations);
		
		return null;
		
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
