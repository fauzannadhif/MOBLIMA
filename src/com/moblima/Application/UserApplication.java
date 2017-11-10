package com.moblima.Application;

import java.util.Scanner;
import com.moblima.users.User;
import com.moblima.movie.MovieList;
import com.moblima.movie.Movie;

public class UserApplication {
	private static Scanner sc = new Scanner(System.in);
	private static User user;
	
	public static void main() {
		
		System.out.println("Please enter your details below");
		System.out.println("Name: ");
		String name = sc.next();
		System.out.println("Age: ");
		int age = sc.nextInt();
		user = new User(name);
		user.setAge(age);
		MovieList Movies = new MovieList();

		int choice = 0;
		
		while (choice != 8) {
			System.out.println("1. Search movie");
			System.out.println("2. List movie");
			System.out.println("3. View movie details");
			System.out.println("4. Check seat availability");
			System.out.println("5. Book and purchase ticket");
			System.out.println("6. View booking history");
			System.out.println("7. List the Top 5 movies");
			System.out.println("8. Quit");
			System.out.println("Please select one of the choices above: ");
			
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: //search movie
				break;
				
			case 2: //list movie
				Movies.getMovie();
				break;
				
			case 3: //select movie, list the details
				System.out.println("Here are the movies available: ");
				System.out.println(Movies.getMovie());
				System.out.println("Please choose the movie you want to view");
				int movieInput = sc.nextInt();
				Movie ChosenMovie = Movies.getMovie().get(movieInput-1);
					
				System.out.println("Here is the details of the movie: ");
				System.out.print("Title: ");
				ChosenMovie.getTitle();
				System.out.print("Showing status: ");
				ChosenMovie.getStatus();
				System.out.print("Synopsis: ");
				ChosenMovie.getSynopsis();
				System.out.print("Director: ");
				ChosenMovie.getDirector();
				System.out.print("Casts: ");
				ChosenMovie.getCast();
				System.out.print("Overall reviewer rating: ");
				ChosenMovie.getOverallRating();
				System.out.print("Reviews: ");
				ChosenMovie.getReview();
					
				break;
				
			case 4: //choose cineplex; choose movie; choose time; show: array list of seats
				System.out.println("Here are the list of cineplex available: ");
				//show the list of cineplex
				System.out.println("Please choose the cineplex you want");
				int cineplexInput = sc.nextInt(); //the input will be the index of the cineplex array list
				System.out.println("Here are the list of cinema in " + ??? + " cineplex: ");
				Cineplex.getCinemaList();
				System.out.println("Please choose the cinema");
				int cinemaInput = sc.nextInt();
				Cinema chosenCinema = CinemaList.getCinema().get(cinemaInput-1);\
				
				System.out.print("The movie shown is: ");
				Movie chosenMovie = chosenCinema.getMovieShown();
				System.out.println("The available time slot for " + chosenMovie + " are: ");
				
				//show the time and seats
				
				break;
				
			case 5: //choose cineplex; choose movie; choose time; choose seat; show: tickets, seats, amount to be paid; approve? (if yes, add to booking history)
				break;
				
			case 6: //list all movies booked, show: transaction id, movie, cinema, cineplex, date/time, tickets, seats, total amount
				user.getBookingHistory();
				break;
				
			case 7: 
				System.out.println("Sort by ticket sales or ratings? 1 for ticket sales, 2 for ratings");
				int inputTop5 = sc.nextInt();
				Movies.sortMovie(inputTop5);	
				break;
			
			case 8:
				System.out.println("Exiting...");
				break;
				
			default:
				System.out.println("Invalid input. Please enter another input: ");
				break;
			}
		}
		
		sc.close();
	}

}
