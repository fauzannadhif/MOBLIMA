package com.moblima.movie;

import java.util.Date;

public class ShowTime{
    private Movie MovieShown;
    private Cinema cinema;
    private Date date;
    private Cineplex cineplex;

    public ShowTime(Movie MovieShown){
        this.MovieShown = MovieShown;
        //File IO
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
