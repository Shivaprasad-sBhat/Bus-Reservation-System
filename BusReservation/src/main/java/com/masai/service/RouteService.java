package com.masai.service;

import java.util.List;

import com.masai.exception.RouteException;
import com.masai.exception.UserException;
import com.masai.model.Bus;
import com.masai.model.Route;

public interface RouteService {

	public Route addRoute(Route route) throws RouteException, UserException;

	public Route updateRoute(Route route) throws RouteException, UserException;

	public Route deleteRoute(Integer routeId) throws RouteException, UserException;

	public Route viewRoute(Integer routeId) throws RouteException, UserException;
	
	public List<Route> viewAllRoute() throws RouteException, UserException;
	
	public List<Bus> viewBusByRoute(String soure,String destination) throws RouteException;

}
