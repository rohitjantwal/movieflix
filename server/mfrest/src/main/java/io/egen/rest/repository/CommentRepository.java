package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Comment;
import io.egen.rest.entity.Movie;
import io.egen.rest.entity.User;

public interface CommentRepository {
	
	public Comment findCommentByMovieandUser(Movie movie, User user);
	
	public List<Comment> findAll();
	
	public Comment findOne(String id);
	
	public Comment addComment(Comment com);
	
	public Comment updateComment(Comment com);
	
	public void deleteComment(Comment com);

	public List<Comment> findCommentsOnMovie(Movie movie);
}
