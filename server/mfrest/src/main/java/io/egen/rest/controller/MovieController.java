package io.egen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.rest.entity.Movie;
import io.egen.rest.service.MovieService;


@RestController
@RequestMapping(path = "movies")

public class MovieController {

	@Autowired
	MovieService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie findById(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie findByTitle(@PathVariable("title") String title) {
		return service.findByTitle(title);
	}
	
	@RequestMapping(method = RequestMethod.POST, path="insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie insert(@RequestBody Movie movie){
		return service.insert(movie);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String id, @RequestBody Movie movie) {
		return service.update(id, movie);
	}
	
	@RequestMapping(method=RequestMethod.POST, path = "insert_all", consumes=MediaType.APPLICATION_JSON_VALUE )
	public void insertAllMovie(@RequestBody List<Movie> Movies){
		service.insertAllMovie(Movies);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	@RequestMapping( method = RequestMethod.GET, path = "filter/country/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> filterByCountry(@PathVariable("country") String country){
		return service.filterByCountry(country);
	}
	
	@RequestMapping( method = RequestMethod.GET, path = "filter/type/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> filterByType(@PathVariable("type") String type){
		return service.filterByType(type);
	}
	
	@RequestMapping( method = RequestMethod.GET, path = "filter/actors/{actors}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> filterByActors(@PathVariable("actors") String actors){
		return service.filterByActors(actors);
	}
	
	@RequestMapping( method = RequestMethod.GET, path = "filter/year/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> filterByYear(@PathVariable("year") String year){
		return service.filterByYear(year);
	}
	
	@RequestMapping( method = RequestMethod.GET, path = "filter/genre/{genre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> filterByGenre(@PathVariable("genre") String genre){
		return service.filterByGenre(genre);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "sort/rating", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> sortByRating() {
		return service.sortByRating();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "sort/year", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> sortByYear() {
		return service.sortByYear();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "sort/popularity", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> sortByPopularity() {
		return service.sortByPopularity();
	}
}
