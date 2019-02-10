package com.nishantkhanepani.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nishantkhanepani.entities.Resturant;
import com.nishantkhanepani.services.ResturantServices;

@RestController
@RequestMapping(path = "/api")
public class ResturantController {

	@Autowired
	private ResturantServices resturantServices;
	
	@GetMapping("/resturant/search")
	public List<Resturant> searchResturant() {
	//	return resturantServices,searchResturant();
		return null;
	}
	


	@RequestMapping(path = "/resturants", method = RequestMethod.GET)
	public List<Resturant> resturants() {
		return resturantServices.getResturants();
	}

	@RequestMapping(path = "/resturant", method = RequestMethod.POST)
	public void addResturant(@RequestBody Resturant resturant) {
		resturantServices.addResturant(resturant);
	}
	
	@RequestMapping(path = "/resturant/{id}", method = RequestMethod.PUT)
	public void updateResturant(@RequestBody Resturant resturant,@PathVariable("id") long id) {
		resturantServices.updateResturant(id,resturant);
	}
	@RequestMapping(path = "/resturant/{id}", method = RequestMethod.DELETE)
	public void deleteResturant(@PathVariable("id") long id) {
		resturantServices.deleteResturant(id);
	}		
}
























