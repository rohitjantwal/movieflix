package io.egen.rest.repository;

import java.util.List;

//import io.egen.rest.entity.Movie;
import io.egen.rest.entity.Rating;


public interface RatingRepository {
	
	public Rating addRating(Rating rating);

	public Rating findRatingByMovieandUser(String movieId, String userId);
		
	public Rating updateRating(Rating rating);

	public List<Rating> findMovieRatingList(String movieid);
	
//	public Rating findRating(Movie movie, User user);

	public List<Rating> findUserRatingList(String userid);
}
