package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.Movie;

public interface MovieService {
	
	public List<Movie> findAll();
	
	public Movie findById(String Id);
	
	public Movie findByTitle(String title);

	public void insertAllMovie(List<Movie> movies);

	public Movie insert(Movie movie);

	public Movie update(String Id, Movie movie);
	
	public void delete(String Id);

	public List<Movie> filterByType(String type) ;
	
	public List<Movie> filterByCountry(String country);
	
	public List<Movie> filterByActors(String actors);

	public List<Movie> sortByRating();

	public List<Movie> sortByYear();

	public List<Movie> sortByPopularity();

	public List<Movie> filterByYear(String year);

	public List<Movie> filterByGenre(String genre);

}
