package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Movie;
import io.egen.rest.exception.MovieAlreadyExistsException;
import io.egen.rest.exception.MovieNotFoundException;
import io.egen.rest.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService{

	@Autowired
	MovieRepository repo;
	
	@Override
	public List<Movie> findAll() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public void delete(String Id) {
		Movie existing =  repo.findById(Id);
		if(existing == null) {
			throw new MovieNotFoundException("Movie with id " + Id + " not found ");
		}
		else {
			repo.delete(existing);
		}
	}

	@Override
	@Transactional
	public void insertAllMovie(List<Movie> movies) {
		repo.insertAllMovie(movies);
	}

	@Override
	public Movie findById(String Id) {
		Movie movie=repo.findById(Id);
		if(movie==null){
			throw new MovieNotFoundException("Movie with id " + Id + " not found");
		}
		else{
		return movie;
		}		
	}

	@Override
	@Transactional
	public Movie insert(Movie movie) {
		Movie existing =  repo.findById(movie.getImdbID());
		if(existing == null) {
			return repo.insert(movie);
		}
		else {
			throw new MovieAlreadyExistsException ("The inserted movie already exist");
		}
	}

	@Override
	@Transactional
	public Movie update(String Id, Movie movie) {
		Movie existing =  repo.findById(Id);
		if(existing == null) {
			throw new MovieNotFoundException("Movie with id " + Id + " not found");
		}
		else {
			return repo.update(movie);
		}
	}

	@Override
	public Movie findByTitle(String title) {
		Movie movie=repo.findByTitle(title);
		if(movie==null){
			throw new MovieNotFoundException("Movie with given title not found") ;
		}else{
		return movie;
		}
	}

	@Override
	public List<Movie> filterByType(String type) {
		List<Movie> movie=repo.filterByType(type);
		if(movie.size()==0){
			return null;
		}
		else{
		return movie;	
		}
	}

	@Override
	public List<Movie> sortByRating() {
		return repo.sortByRating();
	}

	@Override
	public List<Movie> sortByYear() {
		return repo.sortByYear();
	}

	@Override
	public List<Movie> sortByPopularity() {
		return repo.sortByPopularity();
	}

	@Override
	public List<Movie> filterByYear(String year) {
		List<Movie> movie=repo.filterByYear(year);
		if(movie.size()==0){
			return null;
		}
		else{
		return movie;
		}
	}

	@Override
	public List<Movie> filterByGenre(String genre) {
		List<Movie> movie=repo.filterByGenre(genre);
		if(movie.size()==0){
			return null;
		}
		else{
		return movie;
		}
	}

	@Override
	public List<Movie> filterByCountry(String country) {
		List<Movie> movie=repo.filterByCountry(country);
		if(movie.size()==0){
			return null;
		}
		else{
		return movie;	
		}
	}

	@Override
	public List<Movie> filterByActors(String actors) {
		List<Movie> movie=repo.filterByActors(actors);
		if(movie.size()==0){
			return null;
		}
		else{
		return movie;
		}
	}
}