package com.moblima.movie;

import java.util.ArrayList;

public class Cineplex{
    private String Name;
    private ArrayList<Cinema> CinemaList;
    private String Location;

    public Cineplex(String name, ArrayList<Cinema> cinemaList,String location){
        this.Name = name;
        this.CinemaList = cinemaList;
        this.Location = location;
    }

    public String getName(){
        return this.Name;
    }
    public ArrayList<Cinema> getCinemaList(){
        return this.CinemaList;
    }
    public String getLocation(){
        return this.Location;
    }
    public void setName(String name){
        this.Name = name;
    }
    public void setCinemaList(ArrayList<Cinema> CinemaList){
        this.CinemaList = CinemaList;
    }
    public void setLocation(String location){
        this.Location = location;
    }
}
