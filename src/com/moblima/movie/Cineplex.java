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
     * @return this cineplex's name.
     */
    public String getName(){
        return this.Name;
    }

    /**
     * Gets the list of cinemas in this cineplex.
     * @return this cineplex's cinema list.
     */
    public ArrayList<Cinema> getCinemaList(){
        return this.CinemaList;
    }

    /**
     * Gets the location of this cineplex.
     * @return this cineplex's location.
     */
    public String getLocation(){
        return this.Location;
    }

    /**
     * Changes the name of this cineplex.
     * @param name the new name.
     */
    public void setName(String name){
        this.Name = name;
    }

    /**
     * Changes the list of cinemas in this cineplex.
     * @param CinemaList the new cinema list.
     */
    public void setCinemaList(ArrayList<Cinema> CinemaList){
        this.CinemaList = CinemaList;
    }

    /**
     * Changes the location of this cineplex.
     * @param location the new location.
     */
    public void setLocation(String location){
        this.Location = location;
    }
}
