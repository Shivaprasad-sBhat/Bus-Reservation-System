package com.masai.controller;

import java.time.LocalDate;
import java.util.List;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.RouteException;
import com.masai.model.Bus;
import com.masai.model.Route;
import com.masai.service.RouteServiceImpl;

@RestController
public class RouteController {

	@Autowired
	private RouteServiceImpl rService;

	@PostMapping("/addRoute")
	public ResponseEntity<Route> addRouteHandler(@Valid @RequestBody Route route) {

		Route rot = rService.addRoute(route);

		return new ResponseEntity<Route>(rot, HttpStatus.CREATED);
	}

	@PutMapping("/updateRoute")
	public ResponseEntity<Route> updateRouteHandler(@Valid @RequestBody Route route) {

		Route rot = rService.updateRoute(route);

		return new ResponseEntity<Route>(rot, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteRoute/{routeId}")
	public ResponseEntity<Route> deleteRouteHandler(@PathVariable("routeId") Integer routeId) {

		Route rot = rService.deleteRoute(routeId);

		return new ResponseEntity<Route>(rot, HttpStatus.OK);

	}
	

	@GetMapping("/viewRoute/{routeId}")
	public ResponseEntity<Route> viewRouteHandler(@PathVariable("routeId") Integer routeId) {

		Route rot = rService.viewRoute(routeId);

		return new ResponseEntity<Route>(rot, HttpStatus.OK);
	}

	
	@GetMapping("/viewAllRoute")
	public ResponseEntity<List<Route>> viewAllRouteHandler() {

		List<Route> rot = rService.viewAllRoute();

		return new ResponseEntity<List<Route>>(rot, HttpStatus.OK);

	}

	
	@GetMapping("/viewBusByRoute/{source}/{destination}/{date}")
	public ResponseEntity<List<Bus>> viewBusByRoute(@PathVariable("source") String soure,@PathVariable("destination") String destination , @PathVariable("date") String date) {

		System.out.println(date);

		LocalDate localDate = LocalDate.parse(date);

		List<Bus> busList =	rService.viewBusByRoute(soure, destination , localDate);
	
		return new ResponseEntity<List<Bus>>(busList,HttpStatus.OK);
	}

}
