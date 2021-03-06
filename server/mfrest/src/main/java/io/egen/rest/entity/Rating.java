package io.egen.rest.entity;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
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
@NamedQueries({
@NamedQuery(name = "Rating.findMovieRatingList", query = "SELECT r FROM Rating r WHERE movie = :pMovie"),
@NamedQuery(name = "Rating.findUserRatingList", query = "SELECT r FROM Rating r WHERE user = :pUser"),
@NamedQuery(name = "Rating.findRatingByMovieAndUser", query = "SELECT r FROM Rating r WHERE movie = :pMovie and user= :pUser")

})

public class Rating {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	
	private int rating;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	private User user;
	
	@ManyToOne
	private Movie movie;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
}
