package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Movie;
//import io.egen.rest.entity.Movie;
import io.egen.rest.entity.Rating;
import io.egen.rest.entity.User;


public interface RatingRepository {
	
	public List<Rating> findAll();
	
	public Rating findOne(String id);
	
	public Rating addRating(Rating rating);

	public Rating findRatingByMovieandUser(Movie movie, User user);
		
	public Rating updateRating(Rating rating);

	public List<Rating> findMovieRatingList(Movie movie);

	public List<Rating> findUserRatingList(User user);
}
