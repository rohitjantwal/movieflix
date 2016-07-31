package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.rest.entity.Comment;

@Repository
public class CommentRepositoryImp implements CommentRepository{

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Comment> findAll() {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findAll", Comment.class);
		return query.getResultList();
	}

	@Override
	public Comment findOne(String id) {
		return em.find(Comment.class, id);
	}
	
	@Override
	public Comment findCommentByMovieandUser(String movieId, String userId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findCommentByMovieAndUser",Comment.class);
		query.setParameter("pMovieId", movieId).setParameter("pUserId", userId);
		List<Comment> comment = query.getResultList();
		if (comment != null && comment.size() == 1) {
			return comment.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Comment addComment(Comment comment) {
		em.persist(comment);
		return comment;
	}
	
	@Override
	public Comment updateComment(Comment comment) {
		em.merge(comment);
		return comment;
	}

	@Override
	public List<Comment> findCommentsOnMovie(String movieId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findCommentsOnMovie", Comment.class);
		query.setParameter("pMovieId", movieId);
		List<Comment> comment = query.getResultList();
		if (comment != null) {
			return comment;
		} else {
			return null;
		}
	}


	@Override
	public void deleteComment(Comment com) {
		em.remove(com);
	}

}
