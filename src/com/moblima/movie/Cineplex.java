package com.moblima.movie;

import java.util.ArrayList;

/**
 * Represents a cineplex.
 */
public class Cineplex{

    /**
     * The name of this cineplex.
     */
    private String Name;

    /**
     * The list of cinemas in this cineplex.
     */
    private ArrayList<Cinema> CinemaList;

    /**
     * The location of this cineplex.
     */
    private String Location;

    /**
     * Creates new cineplex with the
     * given name, cinema list, and location.
     */
    public Cineplex(String name, ArrayList<Cinema> cinemaList,String location){
        this.Name = name;
        this.CinemaList = cinemaList;
        this.Location = location;
    }

    /**
     * Gets the name of this cineplex.
     */
    public String getName(){
        return this.Name;
    }

    /**
     * Gets the list of cinemas in this cineplex.
     */
    public ArrayList<Cinema> getCinemaList(){
        return this.CinemaList;
    }

    /**
     * Gets the location of this cineplex.
     */
    public String getLocation(){
        return this.Location;
    }

    /**
     * Changes the name of this cineplex.
     */
    public void setName(String name){
        this.Name = name;
    }

    /**
     * Changes the list of cinemas in this cineplex.
     */
    public void setCinemaList(ArrayList<Cinema> CinemaList){
        this.CinemaList = CinemaList;
    }

    /**
     * Changes the location of this cineplex.
     */
    public void setLocation(String location){
        this.Location = location;
    }
}
