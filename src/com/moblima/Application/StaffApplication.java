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
				System.out.println("Cast(please enter at least 2 casts, press 0 to finish):");
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
				newMovie.setAgeRating("sc.next()");

				break;
				
			case 2: //update the details of existing movies
				System.out.println("Please select the movie you want to update(please input the no.)");
				for (int index=0; index<Movies.getMovie().size(); index++){
					System.out.println((index+1) + ". " + Movies.getMovie().get(index+1).getTitle());
				}
				ChosenMovie = Movies.getMovie().get(sc.nextInt()-1);
				System.out.println("What would you like to edit from this movie?");
				System.out.println("1. Title");
				System.out.println("2. Status");
				System.out.println("3. Synopsis");
				System.out.println("4. Director");
				System.out.println("5. Type");
				System.out.println("6. Cast");
				System.out.println("7. Age Rating");
				int input = sc.nextInt();
				if(input == 1){
					System.out.println("Old title: " + ChosenMovie.getTitle());
					System.out.println("Please enter the new title");
					ChosenMovie.setTitle(sc.next());
				}
				if(input == 2)
					System.out.println("Old status: " + ChosenMovie.getStatus());
					System.out.println("Please enter the new status");
					ChosenMovie.setStatus(sc.next());	
				if(input == 3)
					System.out.println("Old synopsis: " + ChosenMovie.getSynopsis());
					System.out.println("Please enter the new synopsis");
					ChosenMovie.setSynopsis(sc.next());
				if(input == 4)
					System.out.println("Old director: " + ChosenMovie.getDirector());
					System.out.println("Please enter the new director");
					ChosenMovie.setDirector(sc.next());				
				if(input == 5)
					System.out.println("Old type: " + ChosenMovie.getType());
					System.out.println("Please enter the new type");
					ChosenMovie.setType(sc.next());
				if(input == 6)
					System.out.println("Old casts: " + ChosenMovie.getCast());
					System.out.println("Please enter the new casts(Please enter at least 2 casts, press 0 to finish");
					ArrayList<String> newcasts = new ArrayList<String>();
					int j=0;
					while(true){
						String desiredINPUT = sc.next();
						if(desiredINPUT=="0" && j>=2)
							break;
						else if(desiredINPUT=="0" && j<2)
							System.out.println("Please add more cast");
						else{	
							newcasts.add(desiredINPUT);
							j++;
						}					
					}
					ChosenMovie.setCast(newcasts);
				if(input == 7)
					System.out.println("Old age rating: " + ChosenMovie.getAgeRating());
					System.out.println("Please enter the new age rating");
					ChosenMovie.setAgeRating(sc.next());

				break;
				
			case 3: //remove a movie from the list
					System.out.println("Which movie would you like to remove? (please input the no.)");
					for (int index=0; index<Movies.getMovie().size(); index++){
						System.out.println((index+1) + ". " + Movies.getMovie().get(index+1).getTitle());
					}
					ChosenMovie = Movies.getMovie().get(sc.nextInt());
					Movies.removeMovie(ChosenMovie);
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
