package com.myapp.hibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.myapp.hibernate.model.CD;
import com.myapp.hibernate.model.Musician;

public class TestCD {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("JPAHIBERNATE");
		
		EntityManager em=emf.createEntityManager();  // create Entity manager  crate entity manager mobj
		
		CD Cd1= new CD("Ram","Classic",175,"Classical",3.5);// transient state -- as not available in db yet
		
		Musician musician1=new Musician("sanjay","afwsf","vvf");
		musician1.setCd(Cd1);
		Cd1.getMusicians().add(musician1);
		
		Musician musician2=new Musician("sanjaydbe","afwegrsf","vergvf");
		musician2.setCd(Cd1);
		Cd1.getMusicians().add(musician2);
		
		// bcoz of cascading changing cd will update musicians
		
		EntityTransaction trxn = em.getTransaction();
		//persistent state
		
		try {
			trxn.begin();
			em.persist(Cd1);
			trxn.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			trxn.rollback();
		
		}
			

	
		//detach state 
		em.close();
		
		emf.close();
		 //otherwise jvm will keep running	
		
		// All the exceptions are unchecked
	
	}

}
