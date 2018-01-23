package com.myapp.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product {

	@Id
	private int id;

	private String name;

	private String type;

	private String expiry;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, String type, String expiry) {
		super();

		this.name = name;
		this.type = type;
		this.expiry = expiry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Product newProduct(Product s2) {
		if (this.name == "")
			this.name = s2.getName();
		if (this.type == "")
			this.type = s2.getType();
		if (this.type == "")
			this.expiry = s2.getExpiry();
		return this;
	}

	

}
