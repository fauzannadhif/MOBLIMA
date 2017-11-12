package com.moblima.Manager;
import com.moblima.users.User;
import com.moblima.movie.*;

import java.util.Date;


public class UserManager{
    private String bookingID;
    private User user;
    public UserManager(User user){
        this.user = user;
    }
    
    public String bookMovie(Movie movie,Date date,Cinema cinema,Cineplex cineplex){
        this.bookingID = cinema.getCinemaCode() + "date/time"; // TODO: Do Date/Time
        user.addBookingHistory(bookingID);
        TicketPrice ticketprice = new TicketPrice(false,user.getAge(),movie.getType(),cinema.getType());
        Double price = ticketprice.getPrice();
        System.out.println("Your price = " + price);
        return bookingID;
    }
    
}
