package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Feedback;
import com.masai.service.FeedBackService;



@RestController
public class FeedBackController {

	@Autowired
	private FeedBackService fService;
	
	
	
	@PostMapping("/setfeedback/{rid}")
	public ResponseEntity<Feedback> setFeedBack(@PathVariable("rid") int reservid, @RequestBody Feedback fb ) {

   		Feedback res = fService.addFeedBack(fb, reservid);
   		
   		return new ResponseEntity<Feedback>(res, HttpStatus.ACCEPTED);
		
	}
	
	
	@PutMapping("/updatefeedback")
	public ResponseEntity<Feedback> updateFeedBack(@RequestBody Feedback fb){
		
		
		Feedback res = fService.updateFeedBack(fb);

		return new ResponseEntity<Feedback>(res, HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/getfeedback/{id}")
	public ResponseEntity<Feedback> getFeedBack(@PathVariable("id") int id){
		
		Feedback fb = 	fService.viewFeedBack(id);
		
		return new ResponseEntity<Feedback>(fb, HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/getAllFeedbackOfUser")
	public ResponseEntity<List<Feedback>> getAllFeedBackOfUser(){
		
		
	  List<Feedback> fb = 	fService.viewAllFeedBackOfUser();
		
	  
	  return new ResponseEntity<List<Feedback>>(fb, HttpStatus.ACCEPTED);
	  
	}
	
	
	@GetMapping("/getAllFeedbacks")
	public ResponseEntity<List<Feedback>> getAllFeedBacks(){
		
		
	  List<Feedback> fb = 	fService.viewAllFeedBacks();
		
	  
	  return new ResponseEntity<List<Feedback>>(fb, HttpStatus.ACCEPTED);
	  
	}
	
	
	
}
