package com.moblima.Manager;

import com.moblima.users.User;
import com.moblima.movie.*;
import java.util.GregorianCalendar;
import java.util.ArrayList;


public final class UserManager{
    private static final UserManager INSTANCE = new UserManager();
    
    private UserManager(){}
    
    public static UserManager getInstance() {
        return INSTANCE;
    }

    public String bookMovie(User user, ShowTime showtime){
        GregorianCalendar date = showtime.getDate();
        String bookingID = showtime.getCinema().getCinemaCode() + date;
        user.addBookingHistory(bookingID);
        TicketPrice ticketprice = new TicketPrice(date,user.getAge(),showtime.getMovieShown().getType(),showtime.getCinema().getType());
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
    
    public ArrayList<String> detailMovie(Movie movie){
        ArrayList<String> details= new ArrayList<String>();
		details.add(movie.getTitle());
        details.add(movie.getStatus());
        details.add(movie.getSynopsis());
        details.add(movie.getDirector());
        details.add(movie.getCast().toString());
        details.add(movie.getOverallRating().toString());
        details.add(movie.getReview().toString());
        return details;
    }

    public ArrayList<String> seatStructure(ShowTime showTime){
        ArrayList<String> seatArrayList = new ArrayList<String>();
        seatArrayList.add("  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16");
        String[] Alphabets = {"A","B","C","D","E","F","G","H","I","J"};
        for(int i=0;i<10; i++){
            seatArrayList.add(Alphabets[i] + " ");
            for (int j=0;j<9;j++){
                if (showTime.getSeat().getSeats()[i][j])
                    seatArrayList.set(2*i, seatArrayList.get(i+1) + "0 ");
                else
                    seatArrayList.set(2*i, seatArrayList.get(i+1) + "_ ");
                seatArrayList.add("\n");
            }
            for (int j=10;j<16;j++){
                if (showTime.getSeat().getSeats()[i][j])
                    seatArrayList.set(2*i, seatArrayList.get(i+1) + "0  ");
                else
                    seatArrayList.set(2*i, seatArrayList.get(i+1) + "_  ");
                seatArrayList.add("\n");
            }
        }
        seatArrayList.add("                 SCREEN                 ");
        return seatArrayList;
    }
    
    public ArrayList<String> sortMovie(MovieList movies, int choice){
        return movies.sortMovie(choice);
    }
}
