package com.nishantkhanepani.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nishantkhanepani.entities.Resturant;
import com.nishantkhanepani.entities.Review;

@Component
public class DummyDatabase {
	List<Resturant> resturants = new ArrayList<Resturant>();

	public DummyDatabase() {
		Resturant mcDonals = new Resturant(101L, "Mcdonals");
		Review review1 = new Review(1L, "good", 3);
		Review review2 = new Review(1L, "good", 3);
		List<Review> mcDonaldsReview = new ArrayList<Review>();
		mcDonaldsReview.add(review1);
		mcDonaldsReview.add(review2);
		mcDonals.setReviews(mcDonaldsReview);

		Resturant kfc = new Resturant(102L, "kfc");
		Review kfcReview1 = new Review(1L, "good", 3);
		Review kfcReview2 = new Review(1L, "good", 3);
		List<Review> kfcReviews = new ArrayList<Review>();
		kfcReviews.add(kfcReview1);
		kfcReviews.add(kfcReview2);
		kfc.setReviews(mcDonaldsReview);

		Resturant buffalowings = new Resturant(103L, "buffalowings");
		Review bfReview1 = new Review(1L, "good", 3);
		Review bfReview2 = new Review(1L, "good", 3);
		List<Review> bfReviews = new ArrayList<Review>();
		bfReviews.add(bfReview1);
		bfReviews.add(bfReview2);
		buffalowings.setReviews(mcDonaldsReview);

		resturants.add(kfc);
		resturants.add(mcDonals);
		resturants.add(buffalowings);
	}

	public List<Resturant> getResturants() {
		return resturants;
	}

	public void addResturant(Resturant resturant) {
		resturants.add(resturant);

	}

	public void updateResturant(long id, Resturant resturant) {
		//for(Resturant r: resturants) {
			
	
		
		for(int i=0;i<resturants.size();i++) {
			Resturant r = resturants.get(i);
			if(r.getResturantId() == id) {
				r.setResturantName(resturant.getResturantName());
				r.setReviews(resturant.getReviews());
				break;
			}
		}
		
	}

	public void deletResturant(long id) {
		List<Resturant> tmpResturant = new ArrayList<Resturant>();
		for(Resturant r: resturants) {
			if(r.getResturantId() != id) {
				tmpResturant.add(r);
			}
		}
		resturants = tmpResturant;
	}

}
