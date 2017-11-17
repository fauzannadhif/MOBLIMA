package com.moblima.movie;

import java.util.GregorianCalendar;

/**
 * Represents a showtime.
 * Shows what movie is being screened
 * in what cineplex and cinema at what time.
 */
public class ShowTime{

    /**
     * The movie shown in this showtime.
     */
    private Movie MovieShown;

    /**
     * The cinema of this showtime.
     */
    private Cinema cinema;

    /**
     * The date of this showtime.
     */
    private GregorianCalendar date;

    /**
     * The cineplex of this showtime.
     */
    private Cineplex cineplex;

    /**
     * The seats of this show time.
     */
    private Seat Seats;

    /**
     * Creates new showtime with the given
     * movie, cinema, date, and cineplex.
     */
    public ShowTime(Movie MovieShown,Cinema cinema,GregorianCalendar date,Cineplex cineplex){
        this.MovieShown = MovieShown;
        this.cinema = cinema;
        this.date = date;
        this.cineplex = cineplex;
        this.Seats = new Seat();
    }

    /**
     * Gets the movie of this showtime.
     */
    public Movie getMovieShown() {
        return MovieShown;
    }

    /**
     * Gets the cinema of this showtime.
     */
    public Cinema getCinema() {
        return cinema;
    }

    /**
     * Gets the cineplex of this showtime.
     */
    public Cineplex getCineplex() {
        return cineplex;
    }

    /**
     * Gets the date of this show time.
     */
    public GregorianCalendar getDate() {
        return date;
    }

    /**
     * Gets the seats of this showtime.
     */
    public Seat getSeat() {
        return Seats;
    }

    /**
     * Changes the cinema of this showtime.
     */
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    /**
     * Changes the cineplex of this showtime.
     */
    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    /**
     * Changes the date of this showtime.
     */
    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    /**
     * Changes the movie of this showtime.
     */
    public void setMovieShown(Movie movieShown) {
        this.MovieShown = movieShown;
    }
}
