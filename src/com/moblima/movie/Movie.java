package com.moblima.movie;

import java.util.ArrayList;



public class Movie {

	private String Title;
	private String Status;
	private String Synopsis;
	private String Director;
	private String Type;
	private ArrayList<String> Cast;
	private Double OverallRating;
	private ArrayList<Integer> Rating;
	private ArrayList<String> Review;
	private String AgeRating;
	private int TicketSales;
	
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
	
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getSynopsis() {
		return Synopsis;
	}

	public void setSynopsis(String synopsis) {
		Synopsis = synopsis;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public ArrayList<String> getCast() {
		return Cast;
	}

	public void setCast(ArrayList<String> cast) {
		Cast = cast;
	}

	public Double getOverallRating() {
		return OverallRating;
	}

	public ArrayList<Integer> getRating() {
		return Rating;
	}

	public void addRating(Integer newRating) {
		this.Rating.add(newRating);
		this.OverallRating = (OverallRating*(Rating.size()-1)+newRating)/Rating.size();
	}

	public ArrayList<String> getReview() {
		return Review;
	}

	public void addReview(String review) {
		this.Review.add(review);
	}

	public String getAgeRating() {
		return AgeRating;
	}

	public void setAgeRating(String ageRating) {
		AgeRating = ageRating;
	}

	public int getTicketSales() {
		return TicketSales;
	}

	public void setTicketSales(int ticketsales) {
		TicketSales = ticketsales;
	}

	public void addTicketSales() {
		TicketSales --;
	}

}
