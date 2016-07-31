package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


import io.egen.rest.entity.Rating;


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
	public Rating findRatingByMovieandUser(String movieId, String userId) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findRatingByMovieAndUser",Rating.class);
		query.setParameter("pMovieId", movieId).setParameter("pUserId", userId);
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
	public List<Rating> findMovieRatingList(String movieid) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findMovieRatingList", Rating.class);
		query.setParameter("pMovieid", movieid);
		List<Rating> ratings = query.getResultList();
		
		if (ratings.size() > 0) {
			return ratings;
		}
		return null;
	}

	@Override
	public List<Rating> findUserRatingList(String userid) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findUserRatingList", Rating.class);
		query.setParameter("pUserid", userid);
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
