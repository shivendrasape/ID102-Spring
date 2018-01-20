package com.myapp.hibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.myapp.hibernate.model.Benefit;
import com.myapp.hibernate.model.CD;
import com.myapp.hibernate.model.Employee;
import com.myapp.hibernate.model.Flight;
import com.myapp.hibernate.model.Musician;

public class TestMTM {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHIBERNATE");

		EntityManager em = emf.createEntityManager();

		Employee employee1 = new Employee("shibwv", "Kvennohi", "shevrnooiv@kohli.com");
		employee1.getBenefits().put("MEDICAL", new Benefit("MEDICAL", 683321.543));
		employee1.getBenefits().put("DENTAL", new Benefit("DENTAL", 166446.45));

		EntityTransaction trxn = em.getTransaction();

		Employee f = em.find(Employee.class, 3L);
		System.out.println(f.getBenefits().get("MEDICAL"));
		
		try {
			trxn.begin();
			em.persist(employee1);

//			Employee f = em.find(Employee.class, 3L);
//			System.out.println(f.getBenefits().get("MEDICAL"));
			trxn.commit();
		} catch (Exception e) {

			e.printStackTrace();
			trxn.rollback();

		}

		em.close();

		emf.close();

	}

}
