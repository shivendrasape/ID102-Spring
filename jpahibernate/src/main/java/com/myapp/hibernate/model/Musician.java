package com.myapp.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OTM_MUSICIAN1")
public class Musician {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String preferedInstrument;
	
	@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="CD_ID",nullable=false,insertable=true,updatable=false)
	private CD cd;
	//join colum will create cd_id column in musicians & it will link id in cd with cd_id in musuicians with pk in cd.
	
	public Musician() {
		// TODO Auto-generated constructor stub
	}

	public Musician(String firstName, String lastName, String preferedInstrument) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.preferedInstrument = preferedInstrument;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((preferedInstrument == null) ? 0 : preferedInstrument.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Musician))
			return false;
		Musician other = (Musician) obj;
		if (id != other.id)
			return false;
		if (preferedInstrument == null) {
			if (other.preferedInstrument != null)
				return false;
		} else if (!preferedInstrument.equals(other.preferedInstrument))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Musician [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", preferedInstrument=");
		builder.append(preferedInstrument);
		builder.append("]");
		return builder.toString();
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPreferedInstrument() {
		return preferedInstrument;
	}

	public void setPreferedInstrument(String preferedInstrument) {
		this.preferedInstrument = preferedInstrument;
	}

	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}
		
}
