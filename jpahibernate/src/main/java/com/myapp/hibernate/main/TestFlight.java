package com.myapp.hibernate.main;

import java.time.Instant;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.myapp.hibernate.model.Flight;

public class TestFlight {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("JPAHIBERNATE");
		
		EntityManager em=emf.createEntityManager();  // create Entity manager  crate entity manager mobj
		
		Flight flight= new Flight("Blore","Delhi");// transient state -- as not available in db yet
		Flight flight2= new Flight("chennai","hyderbad");
//		
		EntityTransaction trxn = em.getTransaction();
		//persistent state
		
		try {
			trxn.begin();
			em.persist(flight2);
			trxn.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			trxn.rollback();
		
		}
			
			EntityTransaction trxn1 = em.getTransaction();
			try {
				trxn1.begin();
			Flight f=	em.find(Flight.class, 30L);
				f.setFromCity("rgavrggea");
				em.merge(f);
				trxn1.commit();
			} catch (Exception e) {
				trxn1.rollback();
				e.printStackTrace();
			}

	
		//detach state 
		em.close();
		
		emf.close();
		 //otherwise jvm will keep running	
		
		// All the exceptions are unchecked
	
	}

}
