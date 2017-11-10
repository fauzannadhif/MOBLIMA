package com.moblima.Application;

import java.util.Scanner;
import com.moblima.users.User;

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
				MovieList.getMovie()
				break;
				
			case 3: //select movie, list the details
				System.out.println("Here are the movies available: ");
				MovieList.getMovie();
				System.out.println("Please choose the movie you want to view");
				int movieInput = sc.next();
					
				System.out.println("Here is the details of the movie: ");
				System.out.print("Title: ");
				Movie.getTitle();
				System.out.print("Showing status: ");
				Movie.getStatus();
				System.out.print("Synopsis: ");
				Movie.getSynopsis();
				System.out.print("Director: ");
				Movie.getDirector();
				System.out.print("Casts: ");
				Movie.getCast();
				System.out.print("Overall reviewer rating: ");
				Movie.getOverallRating();
				System.out.print("Reviews: ");
				Movie.getReview();
					
				break;
				
			case 4: //choose cineplex; choose movie; choose time; show: array list of seats
				break;
				
			case 5: //choose cineplex; choose movie; choose time; choose seat; show: tickets, seats, amount to be paid; approve? (if yes, add to booking history)
				break;
				
			case 6: //list all movies booked, show: transaction id, movie, cinema, cineplex, date/time, tickets, seats, total amount
				User.getBookingHistory();
				break;
				
			case 7: 
				System.out.println("Sort by ticket sales or ratings? 1 for ticket sales, 2 for ratings");
				int inputTop5 = sc.nextInt();
				MovieList.sortMovie(inputTop5);	
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
