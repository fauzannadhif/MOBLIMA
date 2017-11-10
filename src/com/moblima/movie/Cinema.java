package com.moblima.movie;

import java.util.ArrayList;

public class Cinema{
    private ArrayList<Boolean> Seat;
    private Movie MovieShown;
    private String Type;
    private String CinemaCode;

    public Cinema(String CinemaCode){
        this.CinemaCode = CinemaCode;
    }
    public ArrayList<Boolean> getSeat(){
        return this.Seat;
    }
    public Movie getMovieShown(){
        return this.MovieShown;
    }
    public String getType(){
        return this.Type;
    }
    public String getCinemaCode(){
        return this.CinemaCode;
    }
    public void setSeat(ArrayList<Boolean> seat){
        this.Seat = seat;
    }
    public void setMovieShown(Movie movieShown){
        this.MovieShown = movieShown;
    }
    public void setType(String type){
        this.Type = type;
    }
    public void setCinemaCode(String cinemaCode){
        this.CinemaCode = cinemaCode;
    }
}
