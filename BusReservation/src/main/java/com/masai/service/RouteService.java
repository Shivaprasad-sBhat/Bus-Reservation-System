package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.RouteException;
import com.masai.model.Bus;
import com.masai.model.Route;

public interface RouteService {

	public Route addRoute(Route route) throws RouteException, CustomerException;

	public Route updateRoute(Route route) throws RouteException, CustomerException;

	public Route deleteRoute(Integer routeId) throws RouteException, CustomerException;

	public Route viewRoute(Integer routeId) throws RouteException, CustomerException;
	
	public List<Route> viewAllRoute() throws RouteException, CustomerException;
	
	public List<Bus> viewBusByRoute(String soure, String destination , LocalDate date) throws RouteException;

}
