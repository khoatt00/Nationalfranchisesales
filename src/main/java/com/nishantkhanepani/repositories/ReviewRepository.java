package com.nishantkhanepani.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nishantkhanepani.entities.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}
