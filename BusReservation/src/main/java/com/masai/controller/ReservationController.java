package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("reservationservice")
public class ReservationController {

	@Autowired
	private ReservationService rService;
	
	@PostMapping("seatReservation/{busid}/{uuid}")
	public ResponseEntity<Reservation> addReservation( @RequestBody Reservation reservation, @PathVariable("busid") Integer busId,@PathVariable("uuid") String uuid) throws ReservationException {
		
		Reservation bookedReservation = rService.addReservation(reservation,busId,uuid);
		
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
	
	
	
	@DeleteMapping ("deleteReservations/{reservationId}/{uuid}")
	public ResponseEntity<Reservation>  deleteReservation(@PathVariable("reservationId") Integer reservationId,@PathVariable("uuid") String uuid) throws ReservationException {
		
		Reservation deleteReservation = rService.deleteReservation(reservationId,uuid);
		
		return new ResponseEntity<Reservation>(deleteReservation, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@GetMapping("viewReservationsDetails/{reservationId}/{uuid}")
	public ResponseEntity<Reservation>  viewReservationDetail(@PathVariable("reservationId") Integer reservationId,@PathVariable("uuid") String uuid) {
		
			Reservation viewReservation = rService.viewReservationDetail(reservationId,uuid);
		
		return new ResponseEntity<Reservation>(viewReservation, HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@GetMapping("viewReservations/{userId}/{uuid}")
	public ResponseEntity<List<Reservation>>  viewReservations(@PathVariable("userId")Integer userId,@PathVariable("uuid") String uuid) {
		
		List<Reservation> viewReservations = rService.viewReservations(userId,uuid);
		
		return new ResponseEntity<List<Reservation>>(viewReservations, HttpStatus.ACCEPTED);
	}
	
	
	
	
	@GetMapping("viewReservationsbyDate/{uuid}/{date}")
	public ResponseEntity<List<Reservation>>  viewReservationsByDate(@PathVariable("uuid") String uuid,@PathVariable("date") String date) {
		
		List<Reservation> viewReservations = rService.viewReservationsByDate(uuid,date);
		
		return new ResponseEntity<List<Reservation>>(viewReservations, HttpStatus.ACCEPTED);
		
	}
	
	
}
