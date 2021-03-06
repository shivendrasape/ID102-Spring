package com.myapp.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="OTM_CD1")
public class CD {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String title;
	
	private String description;
	
	private double cost;
	
	private String genre;
	
	private double totalDuration;
	
	public CD() {
		
	}
	
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="cd")// mapped by means here musician is owner//
	//@JoinColumn(name="cd_id") // fk column is created in musician table to link cd table, if u write nullable = false then fk cannot be null // join column is says who is responsible ( i.e ) cd to manage musicians
	private Set<Musician> musicians= new  HashSet<Musician>();
	
	

	public CD(String title, String description, double cost, String genre, double totalDuration) {
		super();
		this.title = title;
		this.description = description;
		this.cost = cost;
		this.genre = genre;
		this.totalDuration = totalDuration;
	}



	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(double totalDuration) {
		this.totalDuration = totalDuration;
	}



	public Set<Musician> getMusicians() {
		return musicians;
	}



	public void setMusicians(Set<Musician> musicians) {
		this.musicians = musicians;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CD))
			return false;
		CD other = (CD) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CD [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", cost=");
		builder.append(cost);
		builder.append(", genre=");
		builder.append(genre);
		builder.append(", totalDuration=");
		builder.append(totalDuration);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
