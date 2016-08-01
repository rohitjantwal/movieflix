package io.egen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.rest.entity.Review;
import io.egen.rest.service.ReviewService;

@RestController
@RequestMapping(path="reviews")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review addReview(@RequestBody Review review) {
		return reviewService.addReview(review);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "reviewsList/movie/{movieid}", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Review> findReviewsOnMovie(@PathVariable("movieid") String movieId) {
		return reviewService.findMovieReviewList(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "reviewsList/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Review> findAll() {
		return reviewService.findAll();	
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review findOne(@PathVariable("id") String reviewId) {
		return reviewService.findOne(reviewId);
	}
	
//	@RequestMapping(method = RequestMethod.GET, path = "/reviewList/{movieid}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<Review> findMovieReviewList(@PathVariable("movieid") String movieid) {
//		return reviewService.findMovieReviewList(movieid);
//	}
	
	//find list of (movie and) ratings a user has given using userid on rating table
	@RequestMapping(method = RequestMethod.GET, value = " reviewsList/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Review> findUserRatingList(@PathVariable("userId") String userid) {
		return reviewService.findUserReviewList(userid);
	}
	
	//find average rating on a movie
	@RequestMapping(method = RequestMethod.GET, path = "movie/{movieid}", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public int findMovieReview(@PathVariable("movieid") String movieId) {
		List<Review> reviews = reviewService.findMovieReviewList(movieId);
		
		int ratingAvg = 0;
		if (reviews != null) {
			for (Review review : reviews) {
				ratingAvg += review.getRating();
			}
			ratingAvg = (ratingAvg / reviews.size());
		}
		return ratingAvg;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review update(@PathVariable("id") String reviewId, @RequestBody Review review) {
		return reviewService.updateReview(reviewId, review);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}" )
	public void delete(@PathVariable("id") String id) {		
		reviewService.deleteReview(id);
	}	
	
}
