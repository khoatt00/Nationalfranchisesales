package com.nishantkhanepani.test.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nishantkhanepani.entities.Resturant;
import com.nishantkhanepani.entities.Review;
import com.nishantkhanepani.repositories.ResturantRepository;
import com.nishantkhanepani.repositories.ReviewRepository;
import com.nishantkhanepani.services.ResturantServices;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ResturantServicesTest {

	@InjectMocks
	private ResturantServices resturantService;

	@Mock
	private ResturantRepository resturantRepository;

	@Mock
	private ReviewRepository reviewRepository;

	@Before
	public void setUp() {
		// ReflectionTestUtils.setField(resturantService, "resturantRepository",
		// resturantRepository);
	}

	@Test
	public void testGetResturantWithNoResturant() {
		List<Resturant> mockedResturants = new ArrayList<Resturant>();
		when(resturantRepository.findAll()).thenReturn(mockedResturants);
		List<Resturant> actualResturants = resturantService.getResturants();
		Assert.assertTrue(actualResturants.isEmpty());
	}

	@Test
	public void testGetResturantWithReturnValue() {
		List<Resturant> mockedResturants = new ArrayList<Resturant>();
		Resturant r1 = new Resturant(1L, "Peak");
		mockedResturants.add(r1);
		when(resturantRepository.findAll()).thenReturn(mockedResturants);
		List<Resturant> actualResturants = resturantService.getResturants();
		Assert.assertTrue(!actualResturants.isEmpty());
		Assert.assertEquals(r1.getResturantName(), actualResturants.get(0).getResturantName());
	}

	@Test
	public void testAddResturantNoReviews() {
		Resturant r = new Resturant();
		r.setResturantName("temptation");
		resturantService.addResturant(r);
		verify(reviewRepository, times(0)).save(Mockito.any());

	}

	@Test
	public void testAddResturantTwoReviews() {
		Resturant temptation = new Resturant();
		temptation.setResturantName("temptation");
		List<Review> temptationReviews = new ArrayList<Review>();
		Review review1 = new Review(1L, "good", 3);
		Review review2 = new Review(1L, "good", 3);
		temptationReviews.add(review1);
		temptationReviews.add(review2);
		temptation.setReviews(temptationReviews);
		
		resturantService.addResturant(temptation);
		verify(reviewRepository, times(2)).save(Mockito.any());

	}

}
