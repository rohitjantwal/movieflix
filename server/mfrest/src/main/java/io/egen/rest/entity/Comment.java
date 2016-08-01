package io.egen.rest.entity;

import javax.persistence.CascadeType;
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
@NamedQueries ({
@NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c "),
@NamedQuery(name = "Comment.findCommentsOnMovie", query = "SELECT c FROM Comment c WHERE movie = :pMovie"),
@NamedQuery(name = "Comment.findCommentByMovieAndUser", query = "SELECT c FROM Comment c WHERE c.movie = :pMovie and c.user= :pUser")
})

public class Comment {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	
	private String comment;
	
	@ManyToOne
	private Movie movie;
	
	@OneToOne(cascade=CascadeType.REMOVE)
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
	
	
}
