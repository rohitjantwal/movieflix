package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Comment;
import io.egen.rest.entity.Movie;
import io.egen.rest.entity.User;
import io.egen.rest.exception.CommentNotFoundException;
import io.egen.rest.exception.CommentAlreadyExistsException;
import io.egen.rest.repository.CommentRepository;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentRepository comrepo;
	
	@Autowired
	MovieService movieService;
		
	@Autowired
	UserService userService;
		
	
	@Override
	public List<Comment> findAll() {
		return comrepo.findAll();
	}
	
	@Override
	public Comment findOne(String id) {
		Comment existing = comrepo.findOne(id);
		if (existing == null) {
			throw new CommentNotFoundException("Comment with id:" + id + " not found");
		}
	
		return existing;
	}
	
	@Override
	@Transactional
	public Comment addComment(Comment comment) {
		String movieId = comment.getMovie().getId();
		String userId = comment.getUser().getId();
		//String scomment = comment.getComment();
		
		//check if comment from this user on this movie already exists
		//Comment com = findCommentByMovieandUser(movie, user);
		Comment existing = comrepo.findCommentByMovieandUser(movieId, userId);
		
		//map the comment
		if (existing == null) {
			throw new CommentAlreadyExistsException("Comment for this movie already exists.");
		}
			//existing = new Comment();
		else{
		Movie movie = movieService.findById(movieId);
		User user = userService.findByUserId(userId);
			existing.setMovie(movie);
			existing.setUser(user);	
		//}
		//else{
			comment.setId(existing.getId());
			//return comrepo.updateComment(comment);
		//}
		//when/if mapped set it
		//existing.setComment(scomment);
		return comrepo.addComment(comment);
		}
	}
	
//	@Override
//	public Comment findCommentByMovieandUser(Movie movie, User user) {
//		return comrepo.findCommentByMovieandUser(movie,user);
//	}

	@Override
	public List<Comment> findCommentsOnMovie(String movieId) {
		return comrepo.findCommentsOnMovie(movieId);
	}

//	@Override
//	public Comment findMovieCommentById(String id) {
//		return comrepo.findMovieCommentById(id);
//	}

	@Override
	public void deleteComment(String id) {
		Comment existing = comrepo.findOne(id);
		if(existing==null){
			throw new CommentNotFoundException("Comment with id:" + id + " not found");
		}
		comrepo.deleteComment(existing);
	}

}
