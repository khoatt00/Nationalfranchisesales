package com.nishantkhanepani.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reviewId;

	@Column(name = "text")
	private String reviewtext;

	@Column(name = "stars")
	private int stars;

	@ManyToOne
	@JoinColumn(name = "rest_id", nullable = false)
	@JsonIgnore
	private Resturant resturant;

	public Review() {
	}

	public Review(long reviewId, String reviewtext, int stars) {

		this.reviewId = reviewId;
		this.reviewtext = reviewtext;
		this.stars = stars;
	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewtext() {
		return reviewtext;
	}

	public void setReviewtext(String reviewtext) {
		this.reviewtext = reviewtext;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Resturant getResturant() {
		return resturant;
	}

	public void setResturant(Resturant resturant) {
		this.resturant = resturant;
	}

}
