package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Movie;

public interface MovieRepository {
	
	public List<Movie> sortByRating();
	
	public List<Movie> findAll();
	
	public Movie findById(String Id);
	
	public Movie insert(Movie movie);
	
	public Movie update(Movie movie);
	
	public void delete(Movie movie);
	
	public void insertAllMovie(List<Movie> movies);
	
	public List<Movie> filterByType(String type);
	
	public List<Movie> sortByYear();
	
	public List<Movie> sortByPopularity();
	
	public Movie findByTitle(String title);
	
	public List<Movie> filterByYear(String year);
	
	public List<Movie> filterByGenre(String genre);
	
	public List<Movie> filterByCountry(String country);
	
	public List<Movie> filterByActors(String actors);
}
