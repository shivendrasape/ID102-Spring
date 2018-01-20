package com.myapp.spring.dao;

import java.util.List;

import com.myapp.spring.hibernate.model.Employee;
import com.myapp.spring.hibernate.model.Projects;
import com.myapp.spring.hibernate.model.Skills;

public interface EmployeeDAO {

	void save(Employee employee);
	
	void save(Projects projects);

	void save(Skills skills);
	
	List<Employee> findAll();

	List<Employee> findByProject(long id);
	
	List<Employee> findBySkill(long id);
	
	
	
}
