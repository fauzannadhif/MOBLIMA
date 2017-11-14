package com.moblima.movie;

import java.util.Date;

public class ShowTime{
    private Movie MovieShown;
    private Cinema cinema;
    private Date date;
    private Cineplex cineplex;
    private Seat Seats;

    public ShowTime(Movie MovieShown,Cinema cinema,Date date,Cineplex cineplex){
        this.MovieShown = MovieShown;
        this.cinema = cinema;
        this.date = date;
        this.cineplex = cineplex;
    }

    public Movie getMovieShown() {
        return MovieShown;
    }
    public Cinema getCinema() {
        return cinema;
    }
    public Cineplex getCineplex() {
        return cineplex;
    }
    public Date getDate() {
        return date;
    }
    public Seat getSeat() {
        return Seats;
    }
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setMovieShown(Movie movieShown) {
        this.MovieShown = movieShown;
    }
}
