package com.myapp.hibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.myapp.hibernate.model.City;
import com.myapp.hibernate.model.Country;
import com.myapp.hibernate.model.CountryLanguage;

public class TestCountry {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHIBERNATE");

		EntityManager em = emf.createEntityManager();

		Country country = new Country("delhi", "asia", 175, 60, "delhi", 1810000, "Saket");

		City city = new City("district", "name", 1026);
		city.setCountry(country);

		CountryLanguage countryLanguage = new CountryLanguage("yes", 75.2);
		countryLanguage.setCountry(country);

		country.getCountryLanguage().add(countryLanguage);
		country.getCity().add(city);

		EntityTransaction trxn = em.getTransaction();

		try {
			trxn.begin();
			em.persist(country);
			trxn.commit();
		} catch (Exception e) {

			e.printStackTrace();
			trxn.rollback();

		}

		em.close();

		emf.close();

	}

}
