package com.masai.service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BusException;
import com.masai.exception.ReservationException;
import com.masai.exception.UserException;
import com.masai.model.Bus;
import com.masai.model.CurrentSession;
import com.masai.model.Reservation;
import com.masai.model.User;
import com.masai.repository.BusDao;
import com.masai.repository.ReservationDao;
import com.masai.repository.SessionDao;
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

	
	
	@Autowired
	private SessionDao sDao;
	

	// Seat reservation
	@Override
	public Reservation addReservation(Reservation reservation,Integer busId,String uuid) throws ReservationException{
	
		
		
	Bus bus =	bDao.findById(busId).orElseThrow(() -> new ReservationException("Bus not found."));
	CurrentSession user1 = sDao.findByUuid(uuid);
	User user = uDao.findById(user1.getId()).orElseThrow(()-> new UserException("User not found"));
	
	if(reservation.getReservationDateAndTime().isBefore(LocalDateTime.now()))
		throw new ReservationException("Plese enter future date");
	
	if(bus.getAvailableSeats()<=0) 
		throw new ReservationException("All seats are booked.");
		
	
			bus.setAvailableSeats(bus.getAvailableSeats()-1);
			Bus updatedBus = bDao.save(bus);
			
			reservation.setBus(bus);
			reservation.setReservationStatus("Reservation Confirmed");
			reservation.setReservationDateAndTime(LocalDateTime.now());
			reservation.setSource(bus.getRoutes().getRouteFrom());
			reservation.setDestination(bus.getRoutes().getRouteTo());
			
			
			List<Reservation> reservationList = user.getReservationList();
			reservationList.add(reservation);
			
			user.setReservationList(reservationList);
			
			reservation.setUser(user);
		
			return	rDao.save(reservation);
			
		
	
	}
	
	


//	@Override
//	public Reservation updateReservation(Reservation reservation,String uuid) throws ReservationException {
//		
//	return null;
//		
//		
//	}

	@Override
	public Reservation deleteReservation(Integer reservationId,String uuid) throws ReservationException {
		
		Reservation reservations = rDao.findById(reservationId).orElseThrow(() -> new ReservationException("Reservation details not found."));

		
		CurrentSession user1 = sDao.findByUuid(uuid);
		User user = uDao.findById(user1.getId()).orElseThrow(()-> new UserException("User not found"));
		
		List<Reservation> reservationList =user.getReservationList();
		
		boolean flag = false;
		for(int i=0;i<reservationList.size();i++) {
			
			if(reservationList.get(i).getReservationId()==reservationId) {
				
				flag = true ;
				reservationList.remove(i);
				
				//update seats in the bus
				Bus bus = reservations.getBus();
				
				bus.setAvailableSeats(bus.getAvailableSeats()+1);
				bDao.save(bus);
				
				//update status and adding to list again
				reservations.setReservationStatus("Reservation Canceled.");
				user.setReservationList(reservationList);
				
				uDao.save(user);
			}
			
		}
		
		if(flag==false)
			throw new ReservationException("Reservation details is incorrect.");
				
		
		
		return rDao.save(reservations);
		
	
		
	}

	@Override
	public Reservation viewReservationDetail(Integer reservationId,String uuid) throws ReservationException {
		CurrentSession user1 = sDao.findByUuid(uuid);
		User user = uDao.findById(user1.getId()).orElseThrow(()-> new UserException("User not found"));
		
		List<Reservation> rList = user.getReservationList();
		
		Reservation resrvation=null;
		boolean flag=true;
		for(int i=0;i<rList.size();i++) {
			
			if(rList.get(i).getReservationId()==reservationId) {
				flag=false;
				resrvation = rList.get(i);
				break;
			}
		}
		
		if(flag)
			throw new ReservationException("Reservation details not found.");
		else
			return resrvation;
		
	}

	@Override
	public List<Reservation> viewReservations(Integer userID,String uuid) throws ReservationException {
		
		CurrentSession user1 = sDao.findByUuid(uuid);
		User user = uDao.findById(user1.getId()).orElseThrow(()-> new UserException("User not found"));
	
		List<Reservation> reservationsList = user.getReservationList();
		
		if(reservationsList.isEmpty()) {
			throw new ReservationException("Reservation details not found.");
		}
		else
		{
			return reservationsList;
		}
		
	}
	
	

	@Override
	public List<Reservation> viewReservationsByDate(String uuid,String date) throws ReservationException {

		CurrentSession user1 = sDao.findByUuid(uuid);
		User user = uDao.findById(user1.getId()).orElseThrow(()-> new UserException("User not found"));
		
	
		List<Reservation> reservationsList = user.getReservationList();
		
		if(reservationsList.isEmpty()) {
			throw new ReservationException("Reservation details not found.");
		}
		else
		{
			List<Reservation> reservationList = new ArrayList<>();
			
			for(Reservation r: 	reservationsList ) {
				
	
				LocalDate dt1 = LocalDate.parse(date);
				
				
				if(r.getTravelDate().equals(dt1)) {
					reservationList.add(r);
				}
				
			}
			
			if(reservationList.isEmpty()) 
				throw new ReservationException("Reservation details not found.");
				
			return reservationsList;
		}
	}

}
