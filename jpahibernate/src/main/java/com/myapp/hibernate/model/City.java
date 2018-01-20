package com.myapp.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="City")
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String district;
	private String name;
	private int population;
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}

	public City() {
		// TODO Auto-generated constructor stub
	}
	public City(String district, String name, int population) {
		super();
		this.district = district;
		this.name = name;
		this.population = population;
	}
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Country country;
	
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof City))
			return false;
		City other = (City) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("City [id=");
		builder.append(id);
		builder.append(", district=");
		builder.append(district);
		builder.append(", name=");
		builder.append(name);
		builder.append(", population=");
		builder.append(population);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
