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
	 * @return this Movie's title.
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * Changes the title of this movie.
	 * @param title the new title.
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * Gets the status of this movie.
	 * @return this Movie's status.
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * Changes the status of this movie.
	 * @param status the new status.
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * Gets the synopsis of this movie.
	 * @return this Movie's synopsis.
	 */
	public String getSynopsis() {
		return Synopsis;
	}

	/**
	 * Changes the synopsis of this movie.
	 * @param synopsis the new synopsis.
	 */
	public void setSynopsis(String synopsis) {
		Synopsis = synopsis;
	}

	/**
	 * Gets the director of this movie.
	 * @return this Movie's director.
	 */
	public String getDirector() {
		return Director;
	}

	/**
	 * Changes the director of this movie.
	 * @param director the new director.
	 */
	public void setDirector(String director) {
		Director = director;
	}

	/**
	 * Gets the type of this movie.
	 * @return this movie's type.
	 */
	public String getType() {
		return Type;
	}

	/**
	 * Changes the type of this movie.
	 * @param type the new type
	 */
	public void setType(String type) {
		Type = type;
	}

	/**
	 * Gets the cast of this movie.
	 * @return this movie's casts
	 */
	public ArrayList<String> getCast() {
		return Cast;
	}

	/**
	 * Changes the cast of this movie.
	 * @param cast the new cast
	 */
	public void setCast(ArrayList<String> cast) {
		Cast = cast;
	}

	/**
	 * Gets the average rating of this movie.
	 * @return this movie's average rating.
	 */
	public Double getOverallRating() {
		return OverallRating;
	}

	/**
	 * Gets the rating numbers of this movie.
	 * @return this movie's ratings.
	 */
	public ArrayList<Integer> getRating() {
		return Rating;
	}

	/**
	 * Adds a rating to this movie.
	 * @param newRating the new rating.
	 */
	public void addRating(Integer newRating) {
		this.Rating.add(newRating);
		this.OverallRating = (OverallRating*(Rating.size()-1)+newRating)/Rating.size();
	}

	/**
	 * Gets the review of this movie.
	 * @return this movie's review.
	 */
	public ArrayList<String> getReview() {
		return Review;
	}

	/**
	 * Adds a review to this movie.
	 * @param review the new review.
	 */
	public void addReview(String review) {
		this.Review.add(review);
	}

	/**
	 * Gets the age rating of this movie.
	 * @return this movie's age rating.
	 */
	public String getAgeRating() {
		return AgeRating;
	}

	/**
	 * Sets the age rating of this movie.
	 * @param ageRating the new age rating.
	 */
	public void setAgeRating(String ageRating) {
		AgeRating = ageRating;
	}

	/**
	 * Gets the ticket sales of this movie.
	 * @return this movie's ticket price.
	 */
	public int getTicketSales() {
		return TicketSales;
	}

	/**
	 * Changes the ticket sales of this movie.
	 * @param ticketsales the new ticket price.
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
