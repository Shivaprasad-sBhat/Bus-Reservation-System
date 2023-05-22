package com.masai.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.masai.model.Bus;

@ControllerAdvice
public class GlobalExceptionHandlerClass {

	
//	Exception Handler for Exception class
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionClassHandler(Exception pe, WebRequest req){
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), pe.getMessage(), req.getDescription(false));
		
		
				
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
//	Data validation exception handler
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> dataValidationExceptionHandler(MethodArgumentNotValidException ne){
		
		ErrorDetails err = new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Validaton error");
		err.setDetails(ne.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
//	Exception Handler for No URI found or wrong uri
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noUriHandlerFoundException(NoHandlerFoundException nfe,WebRequest req){
		
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(),nfe.getMessage(),req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.OK);
	}
	
//	Exception handler for Reservation  Exception
	@ExceptionHandler(ReservationException.class)
	public ResponseEntity<ErrorDetails> reservationExceptionHandler(ReservationException re, WebRequest req){
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), re.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
//	Exception handler for Bus  Exception
	@ExceptionHandler(BusException.class)
	public ResponseEntity<ErrorDetails> bustExceptionHandler(BusException be, WebRequest req){
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), be.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
//	Exception handler for CustomerException  Exception
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> userException(CustomerException us, WebRequest req){
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), us.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
//	Exception handler for Admin  Exception
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<ErrorDetails> adminException(AdminException ad, WebRequest req){
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ad.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
//	Exception handler for Route  Exception
	@ExceptionHandler(RouteException.class)
	public ResponseEntity<ErrorDetails> adminException(RouteException re, WebRequest req){
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), re.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
//	Exception handler for FeedBack  Exception
	@ExceptionHandler(FeedBackException.class)
	public ResponseEntity<ErrorDetails> feedBackException(FeedBackException re, WebRequest req){
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), re.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	

}
