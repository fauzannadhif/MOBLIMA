package com.moblima.movie;



public class Seat{
    private Boolean[][] Seats;

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

    public Boolean[][] getSeats(){
        return Seats;
    }

    public void setSeats(Boolean[][] Seats){
        this.Seats = Seats;
    }

    public void assignSeat(int row,int column){
        if(row>9 || column>15 || row<0 || column<0){
            return;
        }
        Seats[row][column] = true;
    }
}

