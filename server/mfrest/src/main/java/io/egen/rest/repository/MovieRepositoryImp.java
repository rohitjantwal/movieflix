package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Movie;

@Repository
public class MovieRepositoryImp implements MovieRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> sortByRating() {
		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m ORDER BY m.imdbrating ASC", Movie.class);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query =em.createNamedQuery("Movie.findAll",Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findById(String Id) {
		Movie movie= em.find(Movie.class, Id);
		return movie;
	}

	@Override
	public Movie insert(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);		
	}

	@Override
	public void insertAllMovie(List<Movie> movies) {
		for(Movie m:movies){
			em.persist(m);
		}		
	}

	@Override
	public List<Movie> filterByType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterByType", Movie.class);
		query.setParameter("pType",type);
		List<Movie> movie = query.getResultList();
		if (movie.size() >0) {
			return movie;
		} else {
			return null;
		}
	}

	@Override
	public List<Movie> sortByYear() {
		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m ORDER BY m.year ASC", Movie.class);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> sortByPopularity() {
		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m ORDER BY m.imdbvotes ASC", Movie.class);
		List<Movie> movies = query.getResultList();
		return movies;
	}
	
	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies = query.getResultList();
		
		if (movies!=null && movies.size()==1) {
				return movies.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Movie> filterByYear(String year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterByYear", Movie.class);
		query.setParameter("pYear", year);
		List<Movie> movies = query.getResultList();
		if (movies.size() >0) {
			return movies;
		} else {
			return null;
		}
	}

	@Override
	public List<Movie> filterByGenre(String genre) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterByGenre", Movie.class);
		query.setParameter("pGenre","%"+ genre +"%");
		List<Movie> movies = query.getResultList();
		if (movies.size() >0) {
			return movies;
		} else {
			return null;
		}
	}

	@Override
	public List<Movie> filterByCountry(String country) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterByCountry", Movie.class);
		query.setParameter("pCountry","%"+ country +"%");
		List<Movie> movies = query.getResultList();
		if (movies.size() >0) {
			return movies;
		} else {
			return null;
		}
	}

	@Override
	public List<Movie> filterByActors(String actors) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterByActors", Movie.class);
		query.setParameter("pActors","%"+ actors +"%");
		List<Movie> movies = query.getResultList();
		if (movies.size() >0) {
			return movies;
		} else {
			return null;
		}
	}

}
