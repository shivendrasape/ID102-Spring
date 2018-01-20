package com.myapp.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.hibernate.model.Flight;




@Repository        // all crud operations are defined in the jpaRepo
public interface FlightRepository extends JpaRepository<Flight, Long>{

	
	List<Flight> findAll();

	
	List<Flight> SourceCityAndDestinationCityOrderByFareAscDuarationAsc(String source,String destination);
	
	
}
