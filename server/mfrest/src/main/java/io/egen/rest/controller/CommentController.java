package io.egen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.rest.entity.Comment;
import io.egen.rest.service.CommentService;

@RestController
@RequestMapping(path="comments")

public class CommentController {

	@Autowired
	CommentService commentService;
	
	@RequestMapping(method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comment> findAll() {
		return commentService.findAll();	
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment findOne(@PathVariable("id") String commentId) {
		return commentService.findOne(commentId);
	}
	//create
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment addComment(@RequestBody Comment comment) {
		return commentService.addComment(comment);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{movieid}", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Comment> findCommentsOnMovie(@PathVariable("movieid") String movieId) {
		return commentService.findCommentsOnMovie(movieId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}" )
	public void delete(@PathVariable("id") String id) {		
		commentService.deleteComment(id);
	}	
}
