package io.egen.rest.repository;

import java.util.List;

//import io.egen.rest.entity.Movie;
import io.egen.rest.entity.Rating;


public interface RatingRepository {
	
	public List<Rating> findAll();
	
	public Rating findOne(String id);
	
	public Rating addRating(Rating rating);

	public Rating findRatingByMovieandUser(String movieId, String userId);
		
	public Rating updateRating(Rating rating);

	public List<Rating> findMovieRatingList(String movieid);

	public List<Rating> findUserRatingList(String userid);
}
