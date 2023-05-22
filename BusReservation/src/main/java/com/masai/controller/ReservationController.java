package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ReservationException;
import com.masai.model.Reservation;
import com.masai.service.ReservationService;



@RestController
public class ReservationController {

	@Autowired
	private ReservationService rService;
	
	
	
	@PostMapping("/seatReservation/{busid}")
	public ResponseEntity<Reservation> addReservation( @RequestBody Reservation reservation, @PathVariable("busid") Integer busId) throws ReservationException {
		
		Reservation bookedReservation = rService.addReservation(reservation,busId);
		
		return new ResponseEntity<Reservation>(bookedReservation, HttpStatus.CREATED);
		
	}
	
	
	
//	@PutMapping("updateReservation")
//	public ResponseEntity<Reservation> updateReservation( Reservation reservation) throws ReservationException {
//		
//		Reservation updatedReservation = rService.updateReservation(reservation);
//		
//		return new ResponseEntity<Reservation>(updatedReservation, HttpStatus.ACCEPTED);
//		
//	}
	
	
	
	@DeleteMapping ("/deleteReservations/{reservationId}")
	public ResponseEntity<Reservation>  deleteReservation(@PathVariable("reservationId") Integer reservationId) throws ReservationException {
		
		Reservation deleteReservation = rService.deleteReservation(reservationId);
		
		return new ResponseEntity<Reservation>(deleteReservation, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@GetMapping("/viewReservationsDetails/{reservationId}}")
	public ResponseEntity<Reservation>  viewReservationDetail(@PathVariable("reservationId") Integer reservationId) {
		
			Reservation viewReservation = rService.viewReservationDetail(reservationId);
		
		return new ResponseEntity<Reservation>(viewReservation, HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@GetMapping("/viewAllReservations")
	public ResponseEntity<List<Reservation>>  viewReservations() {
		
		List<Reservation> viewReservations = rService.viewReservations();
		
		return new ResponseEntity<List<Reservation>>(viewReservations, HttpStatus.ACCEPTED);
	}
	
	
	
	
	@GetMapping("/viewReservationsbyDate/{date}")
	public ResponseEntity<List<Reservation>>  viewReservationsByDate(@PathVariable("date") String date) {
		
		List<Reservation> viewReservations = rService.viewReservationsByDate(date);
		
		return new ResponseEntity<List<Reservation>>(viewReservations, HttpStatus.ACCEPTED);
		
	}
	
	
}
