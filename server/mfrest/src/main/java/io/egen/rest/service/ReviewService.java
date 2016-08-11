package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.Review;

public interface ReviewService {

	public Review addReview (Review review);
	
	//public List<Review> findReviewsOnMovie(String movieId);
	
	public List<Review> findAll();
	
	public Review findOne(String reviewId);
	
	public List<Review> findMovieReviewList(String movieId);
	
	public List<Review> findUserReviewList(String userid);
	
	public Review updateReview(String reviewid, Review review);
	
	public void deleteReview(String id);
	
	public int findAvgMovieReviewList(String movieId);

}
