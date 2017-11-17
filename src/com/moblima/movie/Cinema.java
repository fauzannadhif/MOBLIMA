package com.moblima.movie;

/**
 * Represents a cinema.
 */
public class Cinema{

    /**
     * The type of this cinema
     */
    private String Type;

    /**
     * The code of this cinema
     */
    private String CinemaCode;
 
    /**
     * Creates new cinema with the
     * given code and type.
     */
    public Cinema(String CinemaCode, String Type){
        this.CinemaCode = CinemaCode;
        this.Type = Type;
    }   

    /**
     * Gets the type of this cinema.
     * @return this cinema's type.
     */
    public String getType(){
        return this.Type;
    }

    /**
     * Gets the type of this cinema.
     * @return this cinema's code.
     */
    public String getCinemaCode(){
        return this.CinemaCode;
    }

    /**
     * Changes the type of this cinema.
     * @param type the new type
     */
    public void setType(String type){
        this.Type = type;
    }

    /**
     * Changes the code of this cinema.
     * @param cinemaCode the new cinema code.
     */
    public void setCinemaCode(String cinemaCode){
        this.CinemaCode = cinemaCode;
    }
}
