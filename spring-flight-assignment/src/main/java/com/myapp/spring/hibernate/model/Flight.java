package com.myapp.spring.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Flight")



public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FlightNumber")
	private long id;
	
	@Column(name="SourceCity")
	private String sourceCity;
	
	@Column(name="DestinationCity")
	private String destinationCity;
	
	@Column(name="Fare")
	private int fare;
	
	@Column(name="duaration")
	private int duaration;
	
	@Column(name="airline")
	private String airline;
	
    public Flight() {
	// TODO Auto-generated constructor stub
}

	public Flight(String sourceCity, String destinationCity, int fare, int duaration, String airline) {
		super();
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.fare = fare;
		this.duaration = duaration;
		this.airline = airline;
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public int getDuaration() {
		return duaration;
	}

	public void setDuaration(int duaration) {
		this.duaration = duaration;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fare;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Flight))
			return false;
		Flight other = (Flight) obj;
		if (fare != other.fare)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Flight [id=");
		builder.append(id);
		builder.append(", sourceCity=");
		builder.append(sourceCity);
		builder.append(", destinationCity=");
		builder.append(destinationCity);
		builder.append(", fare=");
		builder.append(fare);
		builder.append(", duaration=");
		builder.append(duaration);
		builder.append(", airline=");
		builder.append(airline);
		builder.append("]");
		return builder.toString();
	}





}
