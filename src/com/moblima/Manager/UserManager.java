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
    
    public ArrayList<String> listMovie(MovieLists movies){
        ArrayList<String> result=ArrayList<String>();
        for (int i=0; i<Movies.getMovie().size(); i++) {
			result.add(Movies.getMovie().get(i).getTitle());
        }
        return result
    }
    
    public ArrayList<String> detailMovie(MovieDetails movies){
        ArrayList<String> details=ArrayList<String>();
        for (int i=0; i<Movies.getMovie().size(); i++) {
				details.add (Movies.getMovie().get(i).getTitle());
                details.add (Movies.getMovie().get(i).getStatus());
                details.add (Movies.getMovie().get(i).getSynopsis());
                details.add (Movies.getMovie().get(i).getDirector());
                details.add (Movies.getMovie().get(i).getCast());
                details.add (Movies.getMovie().get(i).getOverallRating());
                details.add (Movies.getMovie().get(i).getReview();
		}
        return details
    }
        
    
    
}
