package com.moblima.Manager;

import com.moblima.users.User;
import com.moblima.movie.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public final class UserManager{
    private ServerInterface DBInterface = ServerInterface.getINSTANCE();
    private static final UserManager INSTANCE = new UserManager();
    
    /**
     * Default constructor.
     */
    private UserManager(){}

    /**
     * Gets an instance of this class.
     */
    public static UserManager getInstance() {
        return INSTANCE;
    }

    /**
     * Books a movie with the given showtime
     * and seat number.
     */
    public String bookMovie(User user, ShowTime showtime, int SeatRow, int SeatColumn){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmm");
        String bookingID = showtime.getCinema().getCinemaCode() + showtime.getDate().toString() + fmt.format(showtime.getDate().getTime());
        showtime.getSeat().assignSeat(SeatRow, SeatColumn);
        user.addBookingHistory(bookingID);
        BookMovieToDB(user.getName(), showtime);
        return bookingID;
    }

    /**
     * Checks the ticket price of the given
     * showtime for the given user.
     */
    public Double CheckPrice(User user, ShowTime showtime){
        TicketPrice ticketprice = new TicketPrice();
        Double price = ticketprice.getPrice(showtime.getDate(), user.getAge(), showtime.getCinema().getType(),showtime.getMovieShown().getType());
        return price;
    }

    /**
     * Creates booking history in database.
     */
    public void BookMovieToDB(String UserName, ShowTime newShowTime){
        File DatabaseFile = new File("data\\BookingHistory.txt");
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        String LineData = UserName + " | " + newShowTime.getMovieShown().getTitle()+" | "+newShowTime.getCineplex().getName()+" | "+newShowTime.getCinema().getCinemaCode()+" | "+fmt.format(newShowTime.getDate().getTime());
        try {
            DBInterface.NewLine(DatabaseFile, LineData);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

    /**
     * Lists all available movies.
     */
    public ArrayList<String> listMovie(MovieList movies){
        ArrayList<String> result=new ArrayList<String>();
        for (int i=0; i<movies.getMovie().size(); i++) {
			result.add(movies.getMovie().get(i).getTitle());
        }
        return result;
    }

    /**
     * Lists the details of a movie.
     */
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

    /**
     * Gets the seat structure of the
     * given showtime.
     */
    public ArrayList<String> seatStructure(ShowTime showTime){
        ArrayList<String> seatArrayList = new ArrayList<String>();
        seatArrayList.add("  01 02 03 04 05 06 07 08    09 10 11 12 13 14 15 16");
        String[] Alphabets = {"A","B","C","D","E","F","G","H","I","J"};
        for(int i=0;i<10; i++){
            seatArrayList.add(Alphabets[i] + "  ");
            for (int j=0;j<7;j++){
                if (showTime.getSeat().getSeats()[i][j])
                    seatArrayList.set(i+1, seatArrayList.get(i+1) + "0  ");
                else
                    seatArrayList.set(i+1, seatArrayList.get(i+1) + "_  ");
            }
            if (showTime.getSeat().getSeats()[i][7])
                seatArrayList.set(i+1, seatArrayList.get(i+1) + "0     ");
            else
                seatArrayList.set(i+1, seatArrayList.get(i+1) + "_     ");
            for (int j=8;j<16;j++){
                if (showTime.getSeat().getSeats()[i][j])
                    seatArrayList.set(i+1, seatArrayList.get(i+1) + "0  ");
                else
                    seatArrayList.set(i+1, seatArrayList.get(i+1) + "_  ");
            }
        }  
        seatArrayList.add("  ----------------------SCREEN-----------------------");   
        seatArrayList.add("\n\n");
        return seatArrayList;
    }

    /**
     * Sorts the movies in the list.
     */
    public ArrayList<String> sortMovie(MovieList movies, int choice){
        return movies.sortMovie(choice);
    }
}
