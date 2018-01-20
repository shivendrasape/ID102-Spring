package com.myapp.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.hibernate.model.Employee;
import com.myapp.spring.hibernate.model.Projects;
import com.myapp.spring.hibernate.model.Skills;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = HibernateException.class)
	@Override
	public void save(Projects projects) {
		em.persist(projects);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = HibernateException.class)
	@Override
	public void save(Skills skills) {

		em.persist(skills);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = HibernateException.class)
	@Override
	public void save(Employee employee) {
		em.persist(employee);
	}

	@Override
	public List<Employee> findAll() {
		return em.createNamedQuery("EmployeeFindAll").getResultList();
	}

	@Override
	public List<Employee> findByProject(long id) {
		return em.find(Projects.class, id).getEmployee();
		
//		return em.createNamedQuery("EmployeeFindByProject").getResultList();
	}

	@Override
	public List<Employee> findBySkill(long id) {
		return  em.find(Skills.class, id).getEmployee();
		
//		return em.createNamedQuery("EmployeeFindBySkill").getResultList();
	}
	
	

}
