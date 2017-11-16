package com.moblima.movie;

import java.util.ArrayList;

/**
 * Represents a movie.
 */

public class Movie {

	/**
	 * The title of this movie.
	 */
	private String Title;

	/**
	 * The showing status of this movie.
	 */
	private String Status;

	/**
	 * The synopsis of this movie.
	 */
	private String Synopsis;

	/**
	 * The director of this movie.
	 */
	private String Director;

	/**
	 * The type of this movie. Either 2D, 3D, or blockbuster.
	 */
	private String Type;

	/**
	 * The casts of this movie.
	 */
	private ArrayList<String> Cast;

	/**
	 * The average rating of this movie.
	 */
	private Double OverallRating;

	/**
	 * The rating numbers of this movie.
	 */
	private ArrayList<Integer> Rating;

	/**
	 * The reviews of this movie.
	 */
	private ArrayList<String> Review;

	/**
	 * The age rating of this movie.
	 */
	private String AgeRating;

	/**
	 * The number of ticket sales of this movie.
	 */
	private int TicketSales;

	/**
	 * Creates new movie with the given attributes
	 */
	public Movie(String Title,String Status,String Synopsis,String Director,String Type,ArrayList<String> Cast,ArrayList<Integer> Rating, ArrayList<String> Review, String AgeRating, Integer TicketSales){
		this.Title = Title;
		this.Status = Status;
		this.Synopsis = Synopsis;
		this.Director = Director;
		this.Type = Type;
		this.Cast = Cast;
		this.Rating = Rating;
		this.Review = Review;
		this.AgeRating = AgeRating;
		this.OverallRating = 0.0;
		for(int i=0;i <Rating.size(); i++){
			OverallRating +=Rating.get(i);
		}
		OverallRating = OverallRating/Rating.size();
		this.TicketSales = TicketSales;
	}
	
	/**
	 * Gets the title of this movie.
	 * @return this Movie's Title.
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * Changes the title of this movie.
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * Gets the status of this movie.
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * Changes the status of this movie.
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * Gets the synopsis of this movie.
	 */
	public String getSynopsis() {
		return Synopsis;
	}

	/**
	 * Changes the synopsis of this movie.
	 */
	public void setSynopsis(String synopsis) {
		Synopsis = synopsis;
	}

	/**
	 * Gets the director of this movie.
	 */
	public String getDirector() {
		return Director;
	}

	/**
	 * Changes the director of this movie.
	 */
	public void setDirector(String director) {
		Director = director;
	}

	/**
	 * Gets the type of this movie.
	 */
	public String getType() {
		return Type;
	}

	/**
	 * Changes the type of this movie.
	 */
	public void setType(String type) {
		Type = type;
	}

	/**
	 * Gets the cast of this movie.
	 */
	public ArrayList<String> getCast() {
		return Cast;
	}

	/**
	 * Changes the cast of this movie.
	 */
	public void setCast(ArrayList<String> cast) {
		Cast = cast;
	}

	/**
	 * Gets the average rating of this movie.
	 */
	public Double getOverallRating() {
		return OverallRating;
	}

	/**
	 * Gets the rating numbers of this movie.
	 */
	public ArrayList<Integer> getRating() {
		return Rating;
	}

	/**
	 * Adds a rating to this movie.
	 */
	public void addRating(Integer newRating) {
		this.Rating.add(newRating);
		this.OverallRating = (OverallRating*(Rating.size()-1)+newRating)/Rating.size();
	}

	/**
	 * Gets the review of this movie.
	 */
	public ArrayList<String> getReview() {
		return Review;
	}

	/**
	 * Adds a review to this movie.
	 */
	public void addReview(String review) {
		this.Review.add(review);
	}

	/**
	 * Gets the age rating of this movie.
	 */
	public String getAgeRating() {
		return AgeRating;
	}

	/**
	 * Sets the age rating of this movie.
	 */
	public void setAgeRating(String ageRating) {
		AgeRating = ageRating;
	}

	/**
	 * Gets the ticket sales of this movie.
	 */
	public int getTicketSales() {
		return TicketSales;
	}

	/**
	 * Changes the ticket sales of this movie.
	 */
	public void setTicketSales(int ticketsales) {
		TicketSales = ticketsales;
	}

	/**
	 * Add the ticket sales of this movie by 1.
	 */
	public void addTicketSales() {
		TicketSales ++;
	}

}
