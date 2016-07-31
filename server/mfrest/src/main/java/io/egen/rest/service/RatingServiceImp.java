package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Movie;
import io.egen.rest.entity.Rating;
import io.egen.rest.entity.User;
import io.egen.rest.repository.RatingRepository;

@Service
public class RatingServiceImp implements RatingService {

	@Autowired
	RatingRepository ratrepo;
	
	@Autowired
	MovieService movieService;
		
	@Autowired
	UserService userService;
		
//	@Override
//	public List<Rating> findMovieRating(Movie movie) {
//		return ratrepo.findMovieRating(movie);
//	}

//	@Override
//	public Rating findRating(Movie movie, User user) {
//		return ratrepo.findRating(movie,user);
//	}
	
	@Override
	@Transactional
	public Rating addRating(Rating rating) {
		String movieId = rating.getMovie().getId();
		String userId = rating.getUser().getId();
		Movie movie = movieService.findById(movieId);
		User user = userService.findByUserId(userId);
		//check if comment from this user on this movie already exists
		//Comment com = findCommentByMovieandUser(movie, user);
		Rating existing = ratrepo.findRatingByMovieandUser(movieId, userId);
		//map the comment
		if (existing == null) {
			existing = new Rating();
			existing.setMovie(movie);
			existing.setUser(user);	
		}
		else{
			return ratrepo.updateRating(rating);
		}
		return ratrepo.addRating(rating);
	}

	@Override
	public List<Rating> findMovieRatingList(String movieid) {
		List<Rating> ratings=ratrepo.findMovieRatingList(movieid);
		if(ratings.size() ==0){
			return null;}
		else{
		return ratings;}
	}

	@Override
	public List<Rating> findUserRatingList(String userid) {
		List<Rating> ratings=ratrepo.findUserRatingList(userid);
		if(ratings.size() ==0){
			return null;}
		else{
		return ratings;}
	}

}
