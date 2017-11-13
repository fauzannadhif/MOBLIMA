package com.moblima.Application;

import java.util.Scanner;
import com.moblima.users.Staff;
import com.moblima.movie.*;
import java.util.ArrayList;

public class StaffApplication {
	private static Scanner sc = new Scanner(System.in);
	private static Staff staff;
	
	
	public static void main() {
		
		System.out.println("Please login to continue");
		
		while (true) {
			System.out.println("Username: ");
			String username = sc.next();
			System.out.println("Password: ");
			String pass = sc.next();
			
			if ((username == "username") && (pass == "password")){
				//change the username and password to match with the database
				staff = new Staff(username,pass);
				break;
			}
			else
				System.out.println("Invalid username or password. Please try again.");
		}

		MovieList Movies = new MovieList();
		Cineplex ChosenCineplex;
		Cinema ChosenCinema;
		Movie ChosenMovie;
		String CineplexName;
		String CinemaName;
		String MovieName;
		
		int choice = 0;
		
		while (choice != 8) {
			System.out.println("1. Create movie listing");
			System.out.println("2. Update movie listing");
			System.out.println("3. Remove movie listing");
			System.out.println("4. Create cinema showtimes and movie to be shown");
			System.out.println("5. Update cinema showtimes and movie to be shown");
			System.out.println("6. Remove cinema showtimes and movie to be shown");
			System.out.println("7. Configure system settings");
			System.out.println("8. Quit");
			System.out.println("Please select one of the choices above: ");
			
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: //add new movie with its details
				System.out.println("Please enter the movie title:");
				MovieName = sc.next();
				Movie newMovie = new Movie(MovieName);
				Movies.addMovie(newMovie);
				System.out.println("Status:");
				newMovie.setStatus(sc.next());
				System.out.println("Synopsis:");
				newMovie.setSynopsis(sc.next());
				System.out.println("Director:");
				newMovie.setDirector(sc.next());
				System.out.println("Type:");
				newMovie.setType(sc.next());
				System.out.println("Cast(please enter at least 2,0 to finish):");
				ArrayList<String> casts = new ArrayList<String>();
				int i=0;
				while(true){
					String desiredINPUT = sc.next();
					if(desiredINPUT=="0" && i>=2)
						break;
					else if(desiredINPUT=="0" && i<2)
						System.out.println("Please add more cast");
					else{	
						casts.add(desiredINPUT);
						i++;
					}					
				}
				newMovie.setCast(casts);
				System.out.println("AgeRating:");

				break;
				
			case 2: //update the details of existing movies
				break;
				
			case 3: //remove a movie from the list
				break;
				
			case 4: //create new showtime for a movie
				break;
				
			case 5: //update the showtime of a movie
				break;
				
			case 6: //remove a showtime of a movie
				break;
				
			case 7: //configure system settings: ticket price, holidays, etc.
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
