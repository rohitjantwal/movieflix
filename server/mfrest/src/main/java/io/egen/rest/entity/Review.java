package io.egen.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table
@NamedQueries ({
@NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r "),
@NamedQuery(name = "Review.findMovieReviewList", query = "SELECT r FROM Review r WHERE movie = :pMovie"),
@NamedQuery(name = "Review.findReviewByMovieAndUser", query = "SELECT r FROM Review r WHERE r.movie = :pMovie and r.user= :pUser"),
@NamedQuery(name = "Review.findUserReviewList", query = "SELECT r FROM Review r WHERE user = :pUser"),
})
public class Review {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	
	private String comment;
	
	private int rating;
	
	@ManyToOne(fetch=FetchType.EAGER) 
	private Movie movie;
	
	@OneToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
