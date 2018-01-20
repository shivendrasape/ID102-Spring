package com.myapp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.hibernate.model.Flight;
import com.myapp.spring.repository.FlightRepository;

@RestController // for jSON data
public class OrderController {

	@Autowired
	private FlightRepository flightRepo;

	@RequestMapping("/flights")
	public ResponseEntity<List<Flight>> getAllOrders() {
		return new ResponseEntity<List<Flight>>(flightRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/flights", method = RequestMethod.POST)
	public ResponseEntity<String> saveAFlight(@RequestBody Flight flight) {
		flightRepo.save(flight);
		return new ResponseEntity<String>("Flight Save", HttpStatus.CREATED);
	}

	// Searching flight on the basis of source and destination city
	@RequestMapping(value = "/flights/find/{source}/{destination}", method = RequestMethod.GET)
	public ResponseEntity<List<Flight>> findAnOrder(@PathVariable("source") String source,
			@PathVariable("destination") String destination) {

		return new ResponseEntity<List<Flight>>(flightRepo.SourceCityAndDestinationCityOrderByFareAscDuarationAsc(source, destination),
				HttpStatus.OK);
	}

}
