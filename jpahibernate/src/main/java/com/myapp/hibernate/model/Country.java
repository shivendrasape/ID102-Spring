package com.myapp.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Country")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	
	private String capital;
	
	private String continent;
	
	private int GNP;
	
	private int lifeExpectancy;
	
	private String localname;
	
	private int popualtion;
	
	private String region;
	
	public Country() {
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	private void setCode(int code) {
		this.code = code;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public int getGNP() {
		return GNP;
	}

	public void setGNP(int gNP) {
		GNP = gNP;
	}

	public int getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(int lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

	public int getPopualtion() {
		return popualtion;
	}

	public void setPopualtion(int popualtion) {
		this.popualtion = popualtion;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="country")
//	@JoinColumn(name="country_id")
	private Set<City> city = new HashSet<>(); 
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="country")
	//@JoinColumn(name="country_id")
	private Set<CountryLanguage> CountryLanguage = new HashSet<>(); 
	
	
	public Set<City> getCity() {
		return city;
	}

	public void setCity(Set<City> city) {
		this.city = city;
	}

	public Set<CountryLanguage> getCountryLanguage() {
		return CountryLanguage;
	}

	public void setCountryLanguage(Set<CountryLanguage> countryLanguage) {
		CountryLanguage = countryLanguage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + code;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Country))
			return false;
		Country other = (Country) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (code != other.code)
			return false;
		return true;
	}

	public Country(String capital, String continent, int gNP, int lifeExpectancy, String localname, int popualtion,
			String region) {
		super();
		this.capital = capital;
		this.continent = continent;
		GNP = gNP;
		this.lifeExpectancy = lifeExpectancy;
		this.localname = localname;
		this.popualtion = popualtion;
		this.region = region;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Country [code=");
		builder.append(code);
		builder.append(", capital=");
		builder.append(capital);
		builder.append(", continent=");
		builder.append(continent);
		builder.append(", GNP=");
		builder.append(GNP);
		builder.append(", lifeExpectancy=");
		builder.append(lifeExpectancy);
		builder.append(", localname=");
		builder.append(localname);
		builder.append(", popualtion=");
		builder.append(popualtion);
		builder.append(", region=");
		builder.append(region);
		builder.append("]");
		return builder.toString();
	}
	
	

	
	
}