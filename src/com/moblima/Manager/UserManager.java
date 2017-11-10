package com.moblima.Manager;

public class UserManager{
    private String bookingID;
    private User user;
    public UserManager(User user){
        this.user = user;
    }
    
    public string bookMovie(Movie movie,GregorianCalendar date,Cinema cinema,Cineplex cineplex){
        this.bookingID = cinema.getCinemaCode+(String)date;
        user.addBookingHistory(bookingID);
        TicketPrice ticketprice = new TiketPrice(false,user.getAge(),Movie.getType(),Cinema.getType())
        Double price = ticketprice.getPrice();
        System.out.println("Your price = "+price);
        return bookingID;
    }
    
}
