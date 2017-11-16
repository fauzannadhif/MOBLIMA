package com.moblima.Application;

import java.util.Scanner;
import com.moblima.users.User;
import com.moblima.Manager.UserManager;
import com.moblima.movie.*;
import java.util.ArrayList;

public class UserApplication {
	private static Scanner sc = new Scanner(System.in);
	private static User user;
	private static UserManager usermgr = UserManager.getInstance();
	
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
		Movie ChosenMovie;
		ShowTime ChosenShowTime;
		ArrayList<String> MovieTitles;
		ArrayList<String> MovieDetails;
		ArrayList<String> seatStructure;
		

		int choice = 0;
		
		while (choice != 8) {
			System.out.println("Press enter to continue");
			sc.nextLine();
			sc.nextLine();
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
				System.out.println("\n----------------\n");
				System.out.println("Please input the movie that you want to search");
				String inputMovie = sc.next();
				System.out.println("\n----------------\n");
				System.out.println("Ok, here are the results of your search");
				Movies.searchMovie(inputMovie);
				break;
				
			case 2: //list movie
				System.out.println("\n----------------\n");
				System.out.println("Here are the list of the movies");
				MovieTitles = usermgr.listMovie(Movies);
				for (int i=0; i<Movies.getMovie().size(); i++) {
					System.out.println((i+1) + ". " + (MovieTitles.get(i)));
				}
				break;
				
			case 3: //select movie, list the details
				System.out.println("\n----------------\n");
				System.out.println("Here are the movies available: ");
				// list the movie first
				System.out.println("\n----------------\n");
				MovieTitles = usermgr.listMovie(Movies);
				for (int i=0; i<Movies.getMovie().size(); i++) {
					System.out.println((i+1) + ". " + (MovieTitles.get(i)));
				}
				System.out.println("\n----------------\n");
				System.out.println("Please choose the movie you want to view: ");
				int movieInput = sc.nextInt();
				ChosenMovie = Movies.getMovie().get(movieInput-1);

				MovieDetails = usermgr.detailMovie(ChosenMovie);
				System.out.println("\n----------------\n");
				System.out.println("Here is the details of the movie: ");
				System.out.println("Title: " + MovieDetails.get(0));
				System.out.println("Showing status: " + MovieDetails.get(1));
				System.out.println("Synopsis: " + MovieDetails.get(2));
				System.out.println("Director: " + MovieDetails.get(3));
				System.out.println("Casts: " + MovieDetails.get(4));
				System.out.println("Overall reviewer rating: " + MovieDetails.get(5));
				System.out.println("Reviews: " + MovieDetails.get(6));
				break;
				
			case 4: //choose movie; choose show time; show: array list of seats
				//Choose movie
				System.out.println("\n----------------\n");
				System.out.println("Which movie do you want to check");
				int count=0;
				System.out.println("\n----------------\n");
				ArrayList<Integer> usedindex = new ArrayList<Integer>();
				for(int i=0;i<Movies.getMovie().size(); i++){
					if(Movies.getMovie().get(i).getStatus().equals("Now Showing") || Movies.getMovie().get(i).getStatus().equals("Preview")){
						count++;
						usedindex.add(i);
						System.out.println(count+". "+Movies.getMovie().get(i).getTitle());
					}
				}
				ChosenMovie = Movies.getMovie().get(usedindex.get(sc.nextInt()-1));
				//Choose show time
				System.out.println("\n----------------\n");
				System.out.println("The available time slots for " + ChosenMovie.getTitle() + " are: ");
				count=0;
				usedindex.clear();
				for (int i=0; i<ShowTimes.getShowTimes().size(); i++){
					if(ShowTimes.getShowTimes().get(i).getMovieShown().getTitle().equals(ChosenMovie.getTitle())){
						count++;
						usedindex.add(i);
						System.out.println(count+". "+ShowTimes.getShowTimes().get(i).getCineplex().getName()+", "+ShowTimes.getShowTimes().get(i).getCinema().getCinemaCode()+", "+ShowTimes.getShowTimes().get(i).getDate().toString());
					}
				}
				System.out.println("\n----------------\n");
				System.out.println("Which time slot do you want to check?");
				ChosenShowTime = ShowTimes.getShowTimes().get(usedindex.get(sc.nextInt()-1));
				// Show seats from show time
				System.out.println("\n----------------\n");
				System.out.println("Here is the seat layout of the cinema: ");
				System.out.println("");
				seatStructure = usermgr.seatStructure(ChosenShowTime);
				for (int i=0; i<seatStructure.size(); i++)
					System.out.println(seatStructure.get(i));
				break;
				
			case 5: //choose cineplex; choose movie; choose time; choose seat; show: tickets, seats, amount to be paid; approve? (if yes, add to booking history)
				System.out.println("\n----------------\n");
				System.out.println("Which movie do you want to watch");
				int count2=0;
				ArrayList<Integer> usedindex2 = new ArrayList<Integer>();
				for(int i=0;i<Movies.getMovie().size(); i++){
					if(Movies.getMovie().get(i).getStatus().equals("Now Showing") || Movies.getMovie().get(i).getStatus().equals("Preview")){
						count2++;
						usedindex2.add(i);
						System.out.println((count2)+". "+Movies.getMovie().get(i).getTitle());
					}
				}
				ChosenMovie = Movies.getMovie().get(usedindex2.get(sc.nextInt()-1));
				//Choose show time
				System.out.println("\n----------------\n");
				System.out.println("The available time slots for " + ChosenMovie.getTitle() + " are: ");
				count2=0;
				usedindex2.clear();
				for (int i=0; i<ShowTimes.getShowTimes().size(); i++){
					if(ShowTimes.getShowTimes().get(i).getMovieShown().getTitle().equals(ChosenMovie.getTitle())){
						count2++;
						usedindex2.add(i);
						System.out.println((count2)+". "+ShowTimes.getShowTimes().get(i).getCineplex().getName()+", "+ShowTimes.getShowTimes().get(i).getCinema().getCinemaCode()+", "+ShowTimes.getShowTimes().get(i).getDate().toString());
					}
				}
				System.out.println("Which time slot do you want to watch in?");
				ChosenShowTime = ShowTimes.getShowTimes().get(usedindex2.get(sc.nextInt()-1));
				// TODO: show seats from show time(?)
				System.out.println("\n----------------\n");
				System.out.println("Here is the seat layout of the cinema: ");
				System.out.println("");
				seatStructure = usermgr.seatStructure(ChosenShowTime);
				for (int i=0; i<seatStructure.size(); i++)
					System.out.println(seatStructure.get(i));
				System.out.println("\n----------------\n");
				System.out.println("Which seat would you like to choose?");
				System.out.println("Row (Please input the letter in capital) :");
				Integer selectedrow = (int) Character.toUpperCase(sc.next().charAt(0)) -64;
				System.out.println("Column (Please input the number) : ");
				Integer selectedcolumn = sc.nextInt();
				if (selectedcolumn>16 || selectedrow>10 || selectedcolumn<1 || selectedrow<1){
					System.out.println("Wrong Input");
					break;
				}
				ChosenShowTime.getSeat().assignSeat(selectedrow-1, selectedcolumn-1);
				System.out.println("Please enter your name: ");
				System.out.println("Please enter your email address: ");
				System.out.println("Please enter your mobile number: ");
				//The Process should be on UserManager
				//print no of tickets, the seats chosen, total amount
				//proceed? if yes, add to booking history. if no, go back
				
				break;
				
			case 6: //list all movies booked, show: transaction id, movie, cinema, cineplex, date/time, tickets, seats, total amount
				//TODO: Change booking history into showtime type, move to usermanager
				System.out.println("\n----------------\n");
				System.out.println(user.getBookingHistory());
				break;
				
			case 7: 
				System.out.println("\n----------------\n");
				System.out.println("Sort by ticket sales or ratings? 1 for ticket sales, 2 for ratings");
				int inputTop5 = sc.nextInt();
				ArrayList<String> sortedMovies = usermgr.sortMovie(Movies, inputTop5);
				for(int i=0; i<sortedMovies.size(); i++){
					System.out.println((i+1) + ". " + sortedMovies.get(i));
				}
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
