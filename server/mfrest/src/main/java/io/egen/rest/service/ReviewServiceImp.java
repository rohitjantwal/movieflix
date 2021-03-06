package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Movie;
import io.egen.rest.entity.Review;
import io.egen.rest.entity.User;
import io.egen.rest.exception.ReviewNotFoundException;
import io.egen.rest.repository.ReviewRepository;

@Service
public class ReviewServiceImp implements ReviewService{

	@Autowired
	ReviewRepository repo;
	
	@Autowired
	MovieService movieService;
		
	@Autowired
	UserService userService;
		
	@Transactional
	@Override
	public Review addReview(Review review) {
		String movieId = review.getMovie().getId();
		String userId = review.getUser().getId();
		Movie movie = movieService.findById(movieId);
		User user = userService.findByUserId(userId);
		Review existing = repo.findReviewByMovieandUser(movie, user);
		if (existing!=null)
		{	
			String reviewId=review.getId();
			updateReview(reviewId,review);
			//throw new CommentAlreadyExistsException("Comment for this movie already exists.");
		}
		else {
			review.setMovie(movie);
			review.setUser(user);	
			}
		return repo.addReview(review);
	}

//	@Override
//	public List<Review> findMovieReviewList(String movieId) {
//		Movie movie = movieService.findById(movieId);
//		return repo.findMovieReviewList(movie);
//	}

	@Override
	public List<Review> findAll() {
		return repo.findAll();
	}

	@Override
	public Review findOne(String reviewId) {
		Review existing = repo.findOne(reviewId);
		if (existing == null) {
			throw new ReviewNotFoundException("Review with id:" + reviewId + " not found");
		}
		return existing;
	}

	@Override
	public List<Review> findMovieReviewList(String movieId) {
		Movie movie = movieService.findById(movieId);
		List<Review> reviews=repo.findMovieReviewList(movie);
		if(reviews.size() ==0){
			throw new ReviewNotFoundException("No reviews found for movieId" + movieId);}
		else{
		return repo.findMovieReviewList(movie);
		}
	}

	@Override
	public List<Review> findUserReviewList(String userid) {
		User user = userService.findByUserId(userid);
		List<Review> reviews = repo.findUserReviewList(user);
		if(reviews.size() ==0){
			throw new ReviewNotFoundException("No reviews found for user id " + userid);}
		else{
		return repo.findUserReviewList(user);
		}
	}

	@Transactional
	@Override
	public Review updateReview(String reviewId, Review review) {
		String movieId = review.getMovie().getId();
		String userId = review.getUser().getId();
		Review existing = repo.findOne(reviewId);
		//Review existing = repo.findReviewByMovieandUser(movie, user);
		if (existing ==null)
		{	
			throw new ReviewNotFoundException("Review with id:" + reviewId + " not found");
		}
		else {
			Movie movie = movieService.findById(movieId);
			User user = userService.findByUserId(userId);
			//review.setMovie(movie);
			//review.setUser(user);	
			movieService.update(movieId, movie);
			userService.update(userId, user);
			}
		return repo.updateReview(review);
	}
	
	@Transactional
	@Override
	public void deleteReview(String id) {
		Review existing = repo.findOne(id);
		if(existing==null){
			throw new ReviewNotFoundException("Review with id:" + id + " not found");
		}
		repo.deleteReview(existing);
	}

	@Override
	public int findAvgMovieReviewList(String movieId) {
	List<Review> reviews = findMovieReviewList(movieId);
		int ratingAvg = 0;
		if (reviews != null) {
			for (Review review : reviews) {
				ratingAvg += review.getRating();
			}
			ratingAvg = (ratingAvg / reviews.size());
		}
		return ratingAvg;
	}

}
