package com.myapp.spring;

import java.util.List;

import com.myapp.spring.model.Flight;



public interface FlightDAO {

	
	List<Flight> findAll();
	
	
}
