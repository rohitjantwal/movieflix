package io.egen.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries({
@NamedQuery(name = "Movie.findAll", query="SELECT m FROM Movie m ORDER BY m.title ASC"),
@NamedQuery(name = "Movie.filterByType", query="SELECT m FROM Movie m WHERE m.type = :pType"),
@NamedQuery(name = "Movie.filterByYear", query="SELECT m FROM Movie m WHERE m.year = :pYear"),
@NamedQuery(name = "Movie.filterByGenre", query="SELECT m FROM Movie m WHERE m.genre like :pGenre"),
@NamedQuery(name = "Movie.findByTitle", query="SELECT m FROM Movie m WHERE m.title = :pTitle"),
@NamedQuery(name = "Movie.filterByCountry", query="SELECT m FROM Movie m WHERE m.country like :pCountry"),
@NamedQuery(name = "Movie.filterByActors", query="SELECT m FROM Movie m WHERE m.actors like :pActors")

})

public class Movie {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	
	private String title;
	private String year;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	private String director;
	
	@Column(columnDefinition = "TEXT")
	private String writer;
	
	private String actors;
	
	@Column(columnDefinition = "TEXT")
	private String plot;
	
	private String language;
	private String country;
	private String awards;
	private String metascore;
	private String imdbrating;
	private String imdbvotes;
	
	@Column(unique = true)
	private String imdbID;
	
	private String type;
	private String poster;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@JsonProperty(value="Title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@JsonProperty(value="Year")
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	@JsonProperty(value="Rated")
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	
	@JsonProperty(value="Released")
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	
	@JsonProperty(value="Runtime")
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	
	@JsonProperty(value="Genre")
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@JsonProperty(value="Director")
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	@JsonProperty(value="Writer")
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@JsonProperty(value="Actors")
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	
	@JsonProperty(value="Plot")
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	@JsonProperty(value="Language")
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@JsonProperty(value="Country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@JsonProperty(value="Awards")
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	
	@JsonProperty(value="Metascore")
	public String getMetascore() {
		return metascore;
	}
	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}
	
	@JsonProperty(value="imdbRating")
	public String getImdbrating() {
		return imdbrating;
	}
	public void setImdbrating(String imdbrating) {
		this.imdbrating = imdbrating;
	}
	
	@JsonProperty(value="imdbVotes")
	public String getImdbvotes() {
		return imdbvotes;
	}
	public void setImdbvotes(String imdbvotes) {
		this.imdbvotes = imdbvotes;
	}
	@JsonProperty(value="imdbID")
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	
	@JsonProperty(value="Type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
	
	@JsonProperty(value="Poster")
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}

}

