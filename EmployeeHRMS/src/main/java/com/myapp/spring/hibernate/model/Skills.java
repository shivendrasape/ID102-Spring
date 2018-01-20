package com.myapp.spring.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Skills")
public class Skills{
	
	
	@Id
	@Column(name="skill_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String SkillsName;
	
	public Skills() {
		// TODO Auto-generated constructor stub
	}

	public Skills(String skillsName) {
		super();
		SkillsName = skillsName;
	}

	public long getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getSkillsName() {
		return SkillsName;
	}

	public void setSkillsName(String skillsName) {
		SkillsName = skillsName;
	}
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy = "skills")
//	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
//	@MapKeyColumn(name="Skills_key")
	private List<Employee> employee= new ArrayList<Employee>();


	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SkillsName == null) ? 0 : SkillsName.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Skills))
			return false;
		Skills other = (Skills) obj;
		if (SkillsName == null) {
			if (other.SkillsName != null)
				return false;
		} else if (!SkillsName.equals(other.SkillsName))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Skills [id=");
		builder.append(id);
		builder.append(", SkillsName=");
		builder.append(SkillsName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}