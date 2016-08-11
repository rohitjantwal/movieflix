package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.rest.entity.Movie;
import io.egen.rest.entity.Rating;
import io.egen.rest.entity.User;


@Repository
public class RatingRepositoryImp implements RatingRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Rating addRating(Rating rating) {
		em.persist(rating);
		return rating;
	}

//	@Override
//	public List<Rating> findMovieRating(String movieId) {
//		TypedQuery<Rating> query = em.createNamedQuery("Rating.findMovieRating", Rating.class);
//				query.setParameter("pMovie",movieId);
//		List<Rating> rating = query.getResultList();
//		if (rating != null) {
//			return rating;
//		} else {
//			return null;
//		}
//	}
	@Override
	public List<Rating> findAll() {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findAll", Rating.class);
		return query.getResultList();
	}
	
	@Override
	public Rating findOne(String id) {
		return em.find(Rating.class, id);
	}

	@Override
	public Rating findRatingByMovieandUser(Movie movie, User user) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findRatingByMovieAndUser",Rating.class);
		query.setParameter("pMovie", movie).setParameter("pUser", user);
		List<Rating> rating = query.getResultList();
		if (rating != null && rating.size() == 1) {
			return rating.get(0);
		} else {
			return null;
		}
	}
	
//	@Override
//	public Rating findRating(Movie movie, User user) {
//		TypedQuery<Rating> query = em.createQuery("SELECT r FROM Rating r WHERE r.movie = :pMovie and r.user= :pUser",Rating.class).setParameter("pMovie", movie).setParameter("pUser", user);
//		List<Rating> rating = query.getResultList();
//		if (rating != null && rating.size() == 1) {
//			return rating.get(0);
//		} else {
//			return null;
//		}
//	}

	@Override
	public List<Rating> findMovieRatingList(Movie movie) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findMovieRatingList", Rating.class);
		query.setParameter("pMovie", movie);
		List<Rating> ratings = query.getResultList();
		
		if (ratings.size() > 0) {
			return ratings;
		}
		return null;
	}

	@Override
	public List<Rating> findUserRatingList(User user) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findUserRatingList", Rating.class);
		query.setParameter("pUser", user);
		List<Rating> ratings = query.getResultList();
		
		if (ratings.size() > 0) {
			return ratings;
		}
		return null;
	}

	@Override
	public Rating updateRating(Rating rating) {
		em.merge(rating);
		return rating;
	}

}
