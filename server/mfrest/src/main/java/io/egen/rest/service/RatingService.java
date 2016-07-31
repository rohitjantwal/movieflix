package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.Rating;

public interface RatingService {

	public Rating addRating(Rating rating);

	public Rating findOne(String id);
	
	public Rating updateRating(String ratingId,Rating rating);
	
	public List<Rating> findAll();
	
	public List<Rating> findMovieRatingList(String movieid);
	
	public List<Rating> findUserRatingList(String userid);
	
}
