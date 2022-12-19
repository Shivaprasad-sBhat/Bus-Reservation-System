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
	
	
	
	@PostMapping("/setfeddback/{uid}/{rid}")
	@CrossOrigin
	public ResponseEntity<Feedback> setFeedBack( @PathVariable("uid") int userid ,@PathVariable("rid") int reservid, @RequestBody Feedback fb ) {
		
		System.out.println(fb);
   		Feedback res = fService.addFeedBack(fb, userid , reservid);
   		
   		return new ResponseEntity<Feedback>(res, HttpStatus.ACCEPTED);
		
	}
	
	
	@PutMapping("/updatefeedback")
	@CrossOrigin
	public ResponseEntity<Feedback> updateFeedBack(@RequestBody Feedback fb){
		
		
		Feedback res = fService.updateFeedBack(fb);

		return new ResponseEntity<Feedback>(res, HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/getfeedback/{id}")
	@CrossOrigin
	public ResponseEntity<Feedback> getFeedBack(@PathVariable("id") int id){
		
		Feedback fb = 	fService.viewFeedBack(id);
		
		return new ResponseEntity<Feedback>(fb, HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/getAllFedback{uid}")
	@CrossOrigin
	public ResponseEntity<List<Feedback>> getAllFeedBack(@PathVariable("uid") int uid){
		
		
	  List<Feedback> fb = 	fService.viewAllFeedBack(uid);
		
	  
	  return new ResponseEntity<List<Feedback>>(fb, HttpStatus.ACCEPTED);
	  
	}
	
	
	@GetMapping("/getAllFedbacks")
	@CrossOrigin
	public ResponseEntity<List<Feedback>> getAllFeedBacks(){
		
		
	  List<Feedback> fb = 	fService.viewAllFeedBacks();
		
	  
	  return new ResponseEntity<List<Feedback>>(fb, HttpStatus.ACCEPTED);
	  
	}
	
	
	
}
