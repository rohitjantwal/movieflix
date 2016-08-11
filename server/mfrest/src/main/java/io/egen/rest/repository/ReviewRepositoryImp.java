package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.rest.entity.Movie;
import io.egen.rest.entity.Review;
import io.egen.rest.entity.User;

@Repository
public class ReviewRepositoryImp implements ReviewRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Review addReview(Review review) {
		em.persist(review);
		return review;
	}

	@Override
	public List<Review> findAll() {
		TypedQuery<Review> query = em.createNamedQuery("Review.findAll", Review.class);
		return query.getResultList();
	}

	@Override
	public Review findOne(String reviewId) {
		return em.find(Review.class, reviewId);
	}

	@Override
	public List<Review> findMovieReviewList(Movie movie) {
		TypedQuery<Review> query = em.createNamedQuery("Review.findMovieReviewList", Review.class);
		query.setParameter("pMovie", movie);
		List<Review> reviews = query.getResultList();
		if (reviews != null) {
			return reviews;
		} else {
			return null;
		}
	}
	//from rating
	@Override
	public List<Review> findUserReviewList(User user) {
		TypedQuery<Review> query = em.createNamedQuery("Review.findUserReviewList", Review.class);
		query.setParameter("pUser", user);
		List<Review> reviews = query.getResultList();
		
		if (reviews.size() > 0) {
			return reviews;
		}
		return null;
	}
	//from rating
	@Override
	public Review updateReview(Review review) {
		em.merge(review);
		return review;
	}

	@Override
	public void deleteReview(Review review) {
		em.remove(review);
	}

	@Override
	public Review findReviewByMovieandUser(Movie movie, User user) {
		TypedQuery<Review> query = em.createNamedQuery("Review.findReviewByMovieAndUser",Review.class);
		query.setParameter("pMovie", movie);
		query.setParameter("pUser", user);
		List<Review> reviews = query.getResultList();
		if (reviews != null && reviews.size() == 1) {
			return reviews.get(0);
		} else {
			return null;
		}
	}

	
}
