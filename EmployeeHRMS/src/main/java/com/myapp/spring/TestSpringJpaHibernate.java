package com.myapp.spring;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.config.AppConfig;
import com.myapp.spring.dao.EmployeeDAO;
import com.myapp.spring.hibernate.model.Employee;
import com.myapp.spring.hibernate.model.Projects;
import com.myapp.spring.hibernate.model.Skills;

public class TestSpringJpaHibernate {

	public static void main(String[] args) {

		AbstractApplicationContext springContainer = new AnnotationConfigApplicationContext(AppConfig.class);

		EmployeeDAO employeeDao = springContainer.getBean(EmployeeDAO.class);

		

		Employee employee1 = new Employee("Shivendra", "23");
		Employee employee2 = new Employee("Shivendu", "24");
		Employee employee3 = new Employee("Ranjan", "24");

		Skills skills1 = new Skills("java");
		Skills skills2 = new Skills("DotNet");
		Skills skills3 = new Skills("python");
		Skills skills4 = new Skills("spring");

		Projects projects1 = new Projects("HRMS");
		Projects projects2 = new Projects("Spring");
		Projects projects3 = new Projects("AI");
		Projects projects4 = new Projects("Microcontroller");
		Projects projects5 = new Projects("MachineLearning");
		Projects projects6 = new Projects("Microwave");

		
		Set<Employee> employeelist = new HashSet<Employee>();
		employeelist.add(employee1);
		employeelist.add(employee2);
		employeelist.add(employee3);
		
		Set<Projects> projectlist = new HashSet<Projects>();
		projectlist.add(projects1);
		projectlist.add(projects2);
		projectlist.add(projects3);
		projectlist.add(projects4);
		projectlist.add(projects5);
		projectlist.add(projects6);
		
		Set<Skills> SkillList= new HashSet<Skills>();
		
		SkillList.add(skills1);
		SkillList.add(skills2);
		SkillList.add(skills3);
		SkillList.add(skills4);


		employee1.getProjects().add(projects1);
		employee1.getProjects().add(projects2);
		employee1.getProjects().add(projects4);

		employee1.getSkills().add(skills1);
		employee1.getSkills().add(skills4);

		employee2.getProjects().add(projects1);
		employee2.getProjects().add(projects2);
		employee2.getProjects().add(projects5);

		employee2.getSkills().add(skills1);
		employee2.getSkills().add(skills4);

		employee3.getProjects().add(projects1);
		employee3.getProjects().add(projects4);
		employee3.getProjects().add(projects6);

		employee3.getSkills().add(skills1);
		employee3.getSkills().add(skills2);
		employee3.getSkills().add(skills3);
		
		skills1.getEmployee().add(employee1);
		skills2.getEmployee().add(employee1);
		skills2.getEmployee().add(employee2);
		skills2.getEmployee().add(employee3);	
		skills3.getEmployee().add(employee3);
		skills3.getEmployee().add(employee3);
		skills4.getEmployee().add(employee2);
		skills4.getEmployee().add(employee1);
		
		projects1.getEmployee().add(employee1);
		projects2.getEmployee().add(employee1);
		projects2.getEmployee().add(employee2);
		projects2.getEmployee().add(employee3);	
		projects3.getEmployee().add(employee3);
		projects3.getEmployee().add(employee3);
		projects4.getEmployee().add(employee2);
		projects4.getEmployee().add(employee1);

	    employeeDao.save(employee1);
//		employeeDao.save(employee2);
//		employeeDao.save(employee3);
		
		employeeDao.findBySkill(61L).forEach(System.out::println);
//		employeeDao.findByProject(4L).forEach(System.out::println);
//		employeeDao.findAll().forEach(System.out::println);

		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");

		springContainer.close();

	}

}
