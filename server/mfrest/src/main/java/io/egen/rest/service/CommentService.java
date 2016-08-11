package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.Comment;


public interface CommentService {
	
//	public Comment findCommentByMovieandUser(Movie movie,User user);

	//public Comment findMovieCommentById(String id);
	
	public Comment findOne(String id);
	
	public List<Comment> findAll();
	
	public Comment addComment(Comment comment);
	
	public void deleteComment(String id);

	public List<Comment> findCommentsOnMovie(String movieId);
}
