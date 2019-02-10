package com.nishantkhanepani.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Resturant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long resturantId;

	@Column(name = "resturantName")
	private String resturantName;

	@OneToMany (mappedBy= "resturant",
			fetch= FetchType.LAZY,
			cascade = CascadeType.ALL)
	List<Review> reviews = new ArrayList<Review>();

	public Resturant() {
	}

	public Resturant(long resturantId, String resturantName) {

		this.resturantId = resturantId;
		this.resturantName = resturantName;
	}

	public long getResturantId() {
		return resturantId;
	}

	public void setResturantId(long resturantId) {
		this.resturantId = resturantId;
	}

	public String getResturantName() {
		return resturantName;
	}

	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
