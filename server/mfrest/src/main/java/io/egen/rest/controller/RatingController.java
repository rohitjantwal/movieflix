package io.egen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.rest.entity.Rating;
import io.egen.rest.service.RatingService;



@RestController
@RequestMapping(path = "ratings")
public class RatingController {

	
	@Autowired
	RatingService ratingService;
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating findOne(@PathVariable("id") String ratingId) {
		return ratingService.findOne(ratingId);
	}
	
	@RequestMapping(method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Rating> findAll() {
		return ratingService.findAll();
		
	}
	
	//user adds rating using userid and movieid
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating addRating(@RequestBody Rating rating) {
		return ratingService.addRating(rating);
	}
	
	//to find rating list for a movie using movieid
	@RequestMapping(method = RequestMethod.GET, path = "/ratinglist/{movieid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Rating> findMovieRatingList(@PathVariable("movieid") String movieid) {
		return ratingService.findMovieRatingList(movieid);
	}
	//find list of (movie and) ratings a user has given using userid on rating table
	@RequestMapping(method = RequestMethod.GET, value = " {userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Rating> findUserRatingList(@PathVariable("userId") String userid) {
		return ratingService.findUserRatingList(userid);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating update(@PathVariable("id") String ratingId, @RequestBody Rating rating) {
		return ratingService.updateRating(ratingId, rating);
	}
	//find average rating on a movie
	@RequestMapping(method = RequestMethod.GET, path = "{movieid}", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public int findMovieRating(@PathVariable("movieid") String movieId) {
		List<Rating> ratings = ratingService.findMovieRatingList(movieId);
		int ratingAvg = 0;
		if (ratings != null) {
			for (Rating rating : ratings) {
				ratingAvg += rating.getRating();
			}
			ratingAvg = (ratingAvg / ratings.size());
		}
		return ratingAvg;
	}
}
