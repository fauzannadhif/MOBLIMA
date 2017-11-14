package com.moblima.Manager;

import com.moblima.users.User;
import com.moblima.movie.*;
import java.util.GregorianCalendar;
import java.util.ArrayList;


public final class UserManager{
    private static final UserManager INSTANCE = new UserManager();
    public UserManager(){}
    
    /**
     * @return the instance
     */
    public static UserManager getInstance() {
        return INSTANCE;
    }

    public String bookMovie(User user, ShowTime showtime){
        GregorianCalendar date = new GregorianCalendar();
        String bookingID = showtime.getCinema().getCinemaCode() + date;
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
