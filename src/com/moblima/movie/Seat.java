package com.moblima.movie;

/**
 * Represents the seat layout.
 */

public class Seat{

    /**
     * Arrays of seats represented
     * as boolean
     */
    private Boolean[][] Seats;

    /**
     * Default constructor.
     */
    public Seat(){
        Boolean t=true;
        Boolean f=false;
        this.Seats = new Boolean[][]{{t,t,f,f,f,f,f,f,f,f,f,f,f,f,f,f},
                                     {t,t,f,f,f,f,f,f,f,f,f,f,f,f,f,f},
                                     {t,t,f,f,f,f,f,f,f,f,f,f,f,f,f,f},
                                     {t,t,f,f,f,f,f,f,f,f,f,f,f,f,f,f},
                                     {f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f},
                                     {f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f},
                                     {f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f},
                                     {f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f},
                                     {f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f},
                                     {f,f,f,f,f,f,f,f,t,t,f,f,f,f,f,f}};
    }

    /**
     * Gets the arrays of seats.
     */
    public Boolean[][] getSeats(){
        return Seats;
    }

    /**
     * Changes the arrays of seats.
     */
    public void setSeats(Boolean[][] Seats){
        this.Seats = Seats;
    }

    /**
     * Assigns a seat to a person.
     */
    public void assignSeat(int row,int column){
        if(row>9 || column>15 || row<0 || column<0){
            return;
        }
        Seats[row][column] = true;
    }
}

