package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Movie;
import io.egen.rest.entity.Review;
import io.egen.rest.entity.User;

public interface ReviewRepository {

	public Review addReview (Review review);
	
	//public List<Review> findReviewsOnMovie(Movie movie);
	
	public List<Review> findAll();
	
	public Review findOne(String reviewId);
	
	public List<Review> findMovieReviewList(Movie movie);
	
	public List<Review> findUserReviewList(User user);
	
	public Review updateReview(Review review);
	
	public void deleteReview(Review review);
	
	public Review findReviewByMovieandUser(Movie movie,User user);
}
