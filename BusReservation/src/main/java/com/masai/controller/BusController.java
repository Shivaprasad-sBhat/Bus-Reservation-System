package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BusException;
import com.masai.exception.RouteException;
import com.masai.model.Bus;
import com.masai.service.BusServiceImpl;

@RestController
public class BusController {

	@Autowired
	BusServiceImpl busServices;
	
	
	@PostMapping("/savebus")
	public ResponseEntity<Bus> saveBus(@Valid @RequestBody Bus bus, @RequestParam("rid") int rid) throws BusException, RouteException{
		
		Bus savedBus = busServices.addBus(bus , rid);
		
		return new ResponseEntity<Bus>(savedBus,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/updatebus")
	public ResponseEntity<Bus> updateBus(@Valid @RequestBody Bus bus){
		
		Bus savedBus = busServices.updateBus(bus);
		
		return new ResponseEntity<Bus>(savedBus,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deletebus/{id}")
	public ResponseEntity<Bus> deletBus(@PathVariable("id") Integer busId){
		
		Bus deletedBus = busServices.deleteBus(busId);
		
		return new ResponseEntity<Bus>(deletedBus,HttpStatus.OK);
	}
	
	@GetMapping("/viewbus/{id}")
	public ResponseEntity<Bus> viewBus(@PathVariable("id") Integer busId){
		
		Bus foundBus = busServices.viewBus(busId);
		
		return new ResponseEntity<Bus>(foundBus,HttpStatus.OK);
	}
	
	@GetMapping("/viewbytype/{type}")
	public ResponseEntity<List<Bus>> viewAllBusByType(@PathVariable("type") String type){
		
		List<Bus> allBus = busServices.viewBusByType(type);
		
		
		return new ResponseEntity<List<Bus>>(allBus,HttpStatus.OK);		
	}
	
	@GetMapping("/viewallbus")
	public ResponseEntity<List<Bus>> viewAllBus(){
		
		List<Bus> allBus = busServices.viewAllBus();
		
		
		return new ResponseEntity<List<Bus>>(allBus,HttpStatus.OK);		
	}
	
	
	
}