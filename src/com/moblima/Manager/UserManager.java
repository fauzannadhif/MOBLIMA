package com.moblima.Manager;
import com.moblima.users.User;
import com.moblima.movie.*;

import java.util.Date;
import java.util.ArrayList;


public class UserManager{
    private String bookingID;
    private User user;
    public UserManager(User user){
        this.user = user;
    }
    
    public String bookMovie(ShowTime showtime){
        this.bookingID = showtime.getCinema().getCinemaCode() + "date/time"; // TODO: Do Date/Time
        user.addBookingHistory(bookingID);
        TicketPrice ticketprice = new TicketPrice(false,user.getAge(),showtime.getMovieShown().getType(),showtime.getCinema().getType());
        Double price = ticketprice.getPrice();
        System.out.println("Your price = " + price);
        return bookingID;
    }
    
    public ArrayList<String> listMovie(MovieList movies){
        ArrayList<String> result=new ArrayList<String>();
        for (int i=0; i<movies.getMovie().size(); i++) {
			result.add(movies.getMovie().get(i).getTitle());
        }
        return result;
    }
    
    public ArrayList<String> detailMovie(MovieList movies){
        ArrayList<String> details= new ArrayList<String>();
        for (int i=0; i<movies.getMovie().size(); i++) {
				details.add(movies.getMovie().get(i).getTitle());
                details.add(movies.getMovie().get(i).getStatus());
                details.add(movies.getMovie().get(i).getSynopsis());
                details.add(movies.getMovie().get(i).getDirector());
                details.add(movies.getMovie().get(i).getCast().toString());
                details.add(movies.getMovie().get(i).getOverallRating().toString());
                details.add(movies.getMovie().get(i).getReview().toString());
		}
        return details;
    }
            
}
