package com.moblima.Application;

import java.util.Scanner;
import com.moblima.users.User;
import com.moblima.movie.*;
import java.util.ArrayList;

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
		ShowTimeList ShowTimes = new ShowTimeList();
		CineplexList Cineplexes = new CineplexList();
		Cineplex ChosenCineplex;
		Cinema ChosenCinema;
		Movie ChosenMovie;
		String CineplexName;
		String MovieName;
		String CinemaCode;
		ShowTime ChosenShowTime;
		

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
				for (int i=0; i<Movies.getMovie().size(); i++) {
					System.out.println((i+1) + ". " + (Movies.getMovie().get(i).getTitle()));
				}
				break;
				
			case 3: //select movie, list the details
				System.out.println("Here are the movies available: ");
				// print the list of movies
				for (int i=0; i<Movies.getMovie().size(); i++) {
					System.out.println((i+1) + ". " + (Movies.getMovie().get(i).getTitle()));
				}
				System.out.println("Please choose the movie you want to view: ");
				int movieInput = sc.nextInt();
				ChosenMovie = Movies.getMovie().get(movieInput-1);
					
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
				
			case 4: //choose movie; choose show time; show: array list of seats
				//Choose movie
				System.out.println("Which movie do you want to check");
				int count=0;
				ArrayList<Integer> usedindex = new ArrayList<Integer>();
				for(int i=0;i<Movies.getMovie().size(); i++){
					if(Movies.getMovie().get(i).getStatus() == "Now Showing" || Movies.getMovie().get(i).getStatus() == "Preview"){
						count++;
						usedindex.add(i);
						System.out.println((count+1)+". "+Movies.getMovie().get(i).getTitle());
					}
				}
				ChosenMovie = Movies. getMovie().get(usedindex.get(count-1));
				//Choose show time
				System.out.println("The available time slots for " + ChosenMovie.getTitle() + " are: ");
				int count2=0;
				ArrayList<Integer> usedindex2 = new ArrayList<Integer>();
				for (int i=0; i<ShowTimes.getShowTimes().size(); i++){
					if(ShowTimes.getShowTimes().get(i).getMovieShown() == ChosenMovie){
						count2++;
						usedindex2.add(i);
						System.out.println((count2+1)+". "+ShowTimes.getShowTimes().get(i).getCineplex().getName()+", "+ShowTimes.getShowTimes().get(i).getCinema()+", "+ShowTimes.getShowTimes().get(i).getDate());
					}
				}
				System.out.println("Which time slot do you want to check?");
				ChosenShowTime = ShowTimes.getShowTimes().get(usedindex2.get(count2-1));
				// TODO: show seats from show time(?)
				System.out.println("Here is the seat layout of the cinema: ");
				System.out.println("");
				System.out.println("  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16");
				String Alphabets[] = {"A","B","C","D","E","F","G","H","I","J"};
				for(int i=0;i<10; i++){
					System.out.print(Alphabets[i]+" ");
					for (int j=0;j<16;j++){
						if (ChosenShowTime.getSeat().getSeats()[i][j]){
							System.out.print("0 ");
						}
						else
							System.out.print("_ ");
						System.out.print("\n");
					}
				}

				break;
				
			case 5: //choose cineplex; choose movie; choose time; choose seat; show: tickets, seats, amount to be paid; approve? (if yes, add to booking history)
				System.out.println("Which movie do you want to watch");
				int count3=0;
				ArrayList<Integer> usedindex3 = new ArrayList<Integer>();
				for(int i=0;i<Movies.getMovie().size(); i++){
					if(Movies.getMovie().get(i).getStatus() == "Now Showing" || Movies.getMovie().get(i).getStatus() == "Preview"){
						count3++;
						usedindex3.add(i);
						System.out.println((count3+1)+". "+Movies.getMovie().get(i).getTitle());
					}
				}
				ChosenMovie = Movies. getMovie().get(usedindex3.get(count3-1));
				//Choose show time
				System.out.println("The available time slots for " + ChosenMovie.getTitle() + " are: ");
				int count4=0;
				ArrayList<Integer> usedindex4 = new ArrayList<Integer>();
				for (int i=0; i<ShowTimes.getShowTimes().size(); i++){
					if(ShowTimes.getShowTimes().get(i).getMovieShown() == ChosenMovie){
						count4++;
						usedindex4.add(i);
						System.out.println((count4+1)+". "+ShowTimes.getShowTimes().get(i).getCineplex().getName()+", "+ShowTimes.getShowTimes().get(i).getCinema()+", "+ShowTimes.getShowTimes().get(i).getDate());
					}
				}
				System.out.println("Which time slot do you want to watch in?");
				ChosenShowTime = ShowTimes.getShowTimes().get(usedindex4.get(count4-1));
				// TODO: show seats from show time(?)
				System.out.println("Here is the seat layout of the cinema: ");
				System.out.println("");
				System.out.println("  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16");
				String Alphabets2[] = {"A","B","C","D","E","F","G","H","I","J"};
				for(int i=0;i<10; i++){
					System.out.print(Alphabets2[i]+" ");
					for (int j=0;j<16;j++){
						if (ChosenShowTime.getSeat().getSeats()[i][j]){
							System.out.print("0 ");
						}
						else
							System.out.print("_ ");
						System.out.print("\n");
					}
				}
				//show the time, choose time, show seat, choose seat
				//print no of tickets, the seats chosen, total amount
				//proceed? if yes, add to booking history. if no, go back
				
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
