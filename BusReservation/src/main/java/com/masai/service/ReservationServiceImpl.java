package com.masai.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.masai.exception.ReservationException;
import com.masai.model.Bus;
import com.masai.model.Reservation;
import com.masai.repository.BusDao;
import com.masai.repository.ReservationDao;
import com.masai.repository.SessionDao;



@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDao rDao;
	
	@Autowired
	private	BusDao bDao;
	
	@Autowired
	private CustomerDao cDao;

	
	
	@Autowired
	private SessionDao sDao;
	

	// Seat reservation
	@Override
	public Reservation addReservation(Reservation reservation,Integer busId) throws ReservationException{


		Authentication auth = SecurityContextHolder.getContext().getAuthentication();


		Customer customer = cDao.findByName(auth.getName()).orElseThrow(()-> new CustomerException("customer not found"));
		
		Bus bus =	bDao.findById(busId).orElseThrow(() -> new ReservationException("Bus not found."));

	    if(bus.getAvailableSeats()<=0 || bus.getAvailableSeats()- reservation.getSeatQuantity() < 0) throw new ReservationException("All seats are booked.");
		
	
			bus.setAvailableSeats(bus.getAvailableSeats()-reservation.getSeatQuantity());
			
			
			Bus updatedBus = bDao.save(bus);
			
			reservation.setBus(bus);
			reservation.setReservationStatus("Reservation Confirmed");
			reservation.setReservationDateAndTime(LocalDateTime.now());
			reservation.setSource(bus.getRoutes().getRouteFrom());
			reservation.setDestination(bus.getRoutes().getRouteTo());
			
			
			List<Reservation> reservationList = customer.getReservationList();
			reservationList.add(reservation);

			customer.setReservationList(reservationList);
			
			reservation.setCustomer(customer);
		
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
	public Reservation deleteReservation(Integer reservationId) throws ReservationException {

		Authentication auth  = SecurityContextHolder.getContext().getAuthentication();

		Customer customer = cDao.findByName(auth.getName()).orElseThrow(()-> new CustomerException("Customer not found"));
		
		Reservation reservations = rDao.findById(reservationId).orElseThrow(() -> new ReservationException("Reservation details not found."));

//		CurrentSession user1 = sDao.findByUuid(uuid);
		
		List<Reservation> reservationList = customer.getReservationList();
		
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
				reservations.setReservationStatus("Reservation cancelled");
				customer.setReservationList(reservationList);
				
				cDao.save(customer);
			}
			
		}
		
		if(flag==false)
			throw new ReservationException("Reservation details is incorrect.");
				
		
		
		return rDao.save(reservations);
		
	
		
	}

	@Override
	public Reservation viewReservationDetail(Integer reservationId) throws ReservationException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
		
		Customer customer = cDao.findByName(auth.getName()).orElseThrow(()-> new CustomerException("Customer not found"));

		List<Reservation> rList = customer.getReservationList();
		
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
	public List<Reservation> viewReservations() throws ReservationException {
		
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Customer customer = cDao.findByName(auth.getName()).orElseThrow(()-> new CustomerException("Customer not found"));
	
		List<Reservation> reservationsList = customer.getReservationList();
		
		if(reservationsList.isEmpty()) {

			throw new ReservationException("Reservation details not found.");
		}
		else
		{
			return reservationsList;
		}
		
	}
	
	

	@Override
	public List<Reservation> viewReservationsByDate(String date) throws ReservationException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

//		CurrentSession user1 = sDao.findByUuid(uuid);
		Customer customer = cDao.findByName(auth.getName()).orElseThrow(()-> new CustomerException("Customer not found"));

		List<Reservation> reservationsList = customer.getReservationList();
		
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
