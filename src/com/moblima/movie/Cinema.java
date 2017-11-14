package com.moblima.movie;

public class Cinema{
    private String Type;
    private String CinemaCode;
    
    public Cinema(String CinemaCode, String Type){
        this.CinemaCode = CinemaCode;
        this.Type = Type;
    }   

    public String getType(){
        return this.Type;
    }
    public String getCinemaCode(){
        return this.CinemaCode;
    }
    public void setType(String type){
        this.Type = type;
    }
    public void setCinemaCode(String cinemaCode){
        this.CinemaCode = cinemaCode;
    }
}
