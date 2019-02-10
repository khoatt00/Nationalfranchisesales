package com.nishantkhanepani.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishantkhanepani.entities.Resturant;
import com.nishantkhanepani.entities.Review;
import com.nishantkhanepani.repositories.ResturantRepository;
import com.nishantkhanepani.repositories.ReviewRepository;

@Service
public class ResturantServices {

	@Autowired
	private ResturantRepository resturantRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	public List<Resturant> searchResturant() {
		return (List<Resturant>) resturantRepository.findAll();
	}

	public List<Resturant> getResturants() {
		return (List<Resturant>) resturantRepository.findAll();
	}

	public void addResturant(Resturant resturant) {
		List<Review> reviews = resturant.getReviews();
		// link resurant and review in postman..
		List<Review> emptyReview = new ArrayList<Review>();
		resturant.setReviews(emptyReview);
		// remove all remove and create new review..

		Resturant dataRes = resturantRepository.save(resturant);
		for (Review review : reviews) {
			review.setResturant(dataRes);
			reviewRepository.save(review);
		}
	}

	public void updateResturant(long id, Resturant postManResturant) {
		Resturant dbResturant = resturantRepository.findById(id).get();
		// override db resturant with post man resturant
		dbResturant.setResturantName(postManResturant.getResturantName());
		resturantRepository.save(dbResturant);
	}

	public void deleteResturant(long id) {
		resturantRepository.deleteById(id);

	}

}
