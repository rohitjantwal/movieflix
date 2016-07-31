package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Comment;

public interface CommentRepository {
	
	public Comment findCommentByMovieandUser(String movieId,String userId);
	
	public List<Comment> findAll();
	
	public Comment findOne(String id);
	
	public Comment addComment(Comment com);
	
	public Comment updateComment(Comment com);
	
	public void deleteComment(Comment com);

	public List<Comment> findCommentsOnMovie(String movieId);
}
