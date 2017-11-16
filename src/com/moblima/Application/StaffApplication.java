package com.moblima.Application;

import java.util.Scanner;
import com.moblima.users.Staff;
import com.moblima.movie.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
			
			if (Staff.checkvalidity(username, pass)){
				staff = new Staff(username,pass);
				break;
			}
			else
				System.out.println("Invalid username or password. Please try again.");
		}

		MovieList Movies = new MovieList(); 
		Movie ChosenMovie;
		String MovieName;
		ShowTimeList ShowTimes = new ShowTimeList();
		ShowTime ChosenShowTime;
		CineplexList Cineplexes = CineplexList.getInstance();
		Cineplex ChosenCineplex;
		Cinema ChosenCinema;
		GregorianCalendar ChosenDate;
		TicketPrice TicketPrices = new TicketPrice();
		
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
				
				System.out.println("Status:");
				String Status = sc.next();
				System.out.println("Synopsis:");
				String Synopsis = sc.next();
				System.out.println("Director:");
				String Director = sc.next();
				System.out.println("Type:");
				String Type = sc.next();
				System.out.println("Cast(please enter at least 2 casts, press 0 to finish):");
				ArrayList<String> Cast = new ArrayList<String>();
				int i=0;
				while(true){
					String desiredINPUT = sc.next();
					if(desiredINPUT.equals("0") && i>=2)
						break;
					else if(desiredINPUT.equals("0") && i<2)
						System.out.println("Please add more cast");
					else{	
						Cast.add(desiredINPUT);
						i++;
					}					
				}
				System.out.println("AgeRating:");
				String AgeRating = sc.next();
				ArrayList<Integer> Rating = new ArrayList<Integer>();
				ArrayList<String> Review = new ArrayList<String>();
				Movie newMovie = new Movie(MovieName,Status,Synopsis,Director,Type,Cast,Rating,Review,AgeRating);
				Movies.addMovie(newMovie);

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
				if(input == 2){
					System.out.println("Old status: " + ChosenMovie.getStatus());
					System.out.println("Please enter the new status");
					ChosenMovie.setStatus(sc.next());
				}	
				if(input == 3){
					System.out.println("Old synopsis: " + ChosenMovie.getSynopsis());
					System.out.println("Please enter the new synopsis");
					ChosenMovie.setSynopsis(sc.next());
				}
				if(input == 4){
					System.out.println("Old director: " + ChosenMovie.getDirector());
					System.out.println("Please enter the new director");
					ChosenMovie.setDirector(sc.next());
				}			
				if(input == 5){
					System.out.println("Old type: " + ChosenMovie.getType());
					System.out.println("Please enter the new type");
					ChosenMovie.setType(sc.next());
				}
				if(input == 6){
					System.out.println("Old casts: " + ChosenMovie.getCast());
					System.out.println("Please enter the new casts(Please enter at least 2 casts, press 0 to finish");
					ArrayList<String> newcasts = new ArrayList<String>();
					int j=0;
					while(true){
						String desiredINPUT = sc.next();
						if(desiredINPUT.equals("0") && j>=2)
							break;
						else if(desiredINPUT.equals("0") && j<2)
							System.out.println("Please add more cast");
						else{	
							newcasts.add(desiredINPUT);
							j++;
						}					
					}
					ChosenMovie.setCast(newcasts);
				}
				if(input == 7){
					System.out.println("Old age rating: " + ChosenMovie.getAgeRating());
					System.out.println("Please enter the new age rating");
					ChosenMovie.setAgeRating(sc.next());
				}
				break;
				
			case 3: //remove a movie from the list
					System.out.println("Which movie would you like to remove? (please input the no.)");
					for (int index=0; index<Movies.getMovie().size(); index++){
						System.out.println((index+1) + ". " + Movies.getMovie().get(index+1).getTitle());
					}
					ChosenMovie = Movies.getMovie().get(sc.nextInt()-1);
					Movies.removeMovie(ChosenMovie);
				break;
				
			case 4: //create new showtime for a movie
					// Movie
					System.out.println("Here is the list of movies: ");
					for(int index=0; index<Movies.getMovie().size(); index++){
						System.out.println((index+1)+". "+Movies.getMovie().get(index).getTitle());
					}
					System.out.println("Which movie would you like to add to showtime? (please input the no.)");
					ChosenMovie = Movies.getMovie().get(sc.nextInt()-1);
					// Cineplex
					System.out.println("On which cineplex?");
					System.out.println("Cineplex List: ");
					for(int n=0; n<Cineplexes.getCineplex().size(); n++){
						System.out.println((n+1)+". "+Cineplexes.getCineplex().get(n).getName());	
					}
					ChosenCineplex = Cineplexes.getCineplex().get(sc.nextInt()-1);
					System.out.println("On which cinema?");
					System.out.println("Cinema list: ");
					for(int m=0; m<ChosenCineplex.getCinemaList().size(); m++){
						System.out.println((m+1)+". "+ChosenCineplex.getCinemaList().get(m));
					}
					ChosenCinema = ChosenCineplex.getCinemaList().get(sc.nextInt()-1);
					ChosenDate = new GregorianCalendar(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
					ShowTime newshowtime = new ShowTime(ChosenMovie, ChosenCinema, ChosenDate, ChosenCineplex);
					ShowTimes.addShowTimes(newshowtime);
					ChosenMovie.setStatus("Now Showing");
				break;
				
			case 5: //update the showtime of a movie
					System.out.println("Which showtime would you like to update?");
					for(int index=0; index<ShowTimes.getShowTimes().size(); index++){
						System.out.println((index+1)+". "+ShowTimes.getShowTimes().get(index).getMovieShown().getTitle()+", "+ShowTimes.getShowTimes().get(index).getCinema()+", "+ShowTimes.getShowTimes().get(index).getCineplex()+", "+ShowTimes.getShowTimes().get(index).getDate());
					}
					ChosenShowTime=ShowTimes.getShowTimes().get(sc.nextInt()-1);
					System.out.println("What would you like to change?");
					System.out.println("1. The Cineplex and Cinema");
					System.out.println("2. The Date and Time");
					int select = sc.nextInt();
					if(select == 1){
						System.out.println("Select the new Cineplex: ");
						for(int x=0; x<Cineplexes.getCineplex().size(); x++){
							System.out.println((x+1)+". "+Cineplexes.getCineplex().get(x).getName());
						}
						ChosenCineplex = Cineplexes.getCineplex().get(sc.nextInt()-1);
						System.out.println("Select the new Cinema");
						for(int y=0; y<ChosenCineplex.getCinemaList().size(); y++){
							System.out.println((y+1)+". "+ChosenCineplex.getCinemaList().get(y));
						}
						ChosenCinema = ChosenCineplex.getCinemaList().get(sc.nextInt()-1);
						ChosenShowTime.setCineplex(ChosenCineplex);
						ChosenShowTime.setCinema(ChosenCinema) ;
					}
					if(select == 2){
						System.out.println("Please input the new date: ");
						ChosenDate = new GregorianCalendar(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
						ChosenShowTime.setDate(ChosenDate);
					}
				break;
				
			case 6: //remove a showtime of a movie
					System.out.println("Which showtime would you like to remove?");
					for(int index=0; index<ShowTimes.getShowTimes().size(); index++){
						System.out.println((index+1)+". "+ShowTimes.getShowTimes().get(index).getMovieShown().getTitle()+", "+ShowTimes.getShowTimes().get(index).getCinema()+", "+ShowTimes.getShowTimes().get(index).getCineplex()+", "+ShowTimes.getShowTimes().get(index).getDate());
					}
					ChosenShowTime=ShowTimes.getShowTimes().get(sc.nextInt()-1);
					ShowTimes.removeShowTimes(ChosenShowTime);
					break;
				
			case 7: //configure system settings: ticket price, holidays, etc.
					System.out.println("What would you like to configure?");
					System.out.println("1. Ticket Price");
					System.out.println("2. Configure Holiday Dates");
					int pick = sc.nextInt();
					if(pick==1){
						System.out.println("What would you like to change?");
						System.out.println("1. Base price");
						System.out.println("2. Additional price for holiday");
						System.out.println("3. Substractive price for children");
						System.out.println("4. Substractive price for senior citizen");
						System.out.println("5. Additional price for premium cinema");
						System.out.println("6. Additional price for 3D movie");
						System.out.println("7. Additional Price for blockbuster movie");
						int option = sc.nextInt();
						if(option==1){
							System.out.println("The old base price is: " + TicketPrices.getModifier()[0]);
							System.out.println("Please input your new base price: ");
							TicketPrices.getModifier()[0] = sc.nextDouble();
						}
						if(option==2){
							System.out.println("The old additional price for holiday is: " + TicketPrices.getModifier()[1]);
							System.out.println("Please input your new additional price: ");
							TicketPrices.getModifier()[1] = sc.nextDouble();
						}
						if(option==3){
							System.out.println("The old substractive price for children is: " + TicketPrices.getModifier()[2]);
							System.out.println("Please input your new substractive price: ");
							TicketPrices.getModifier()[2] = sc.nextDouble();
						}
						if(option==4){
							System.out.println("The old substractive price for senior citizen is: " + TicketPrices.getModifier()[3]);
							System.out.println("Please input your new substractive price: ");
							TicketPrices.getModifier()[3] = sc.nextDouble();
						}
						if(option==5){
							System.out.println("The old additional price for premium cinema is: " + TicketPrices.getModifier()[4]);
							System.out.println("Please input your new additional price: ");
							TicketPrices.getModifier()[4] = sc.nextDouble();
						}
						if(option==6){
							System.out.println("The old additional price for 3D movie is: " + TicketPrices.getModifier()[5]);
							System.out.println("Please input your new additional price: ");
							TicketPrices.getModifier()[5] = sc.nextDouble();
						}
						if(option==7){
							System.out.println("The old additional price for blockbuster movie is: " + TicketPrices.getModifier()[6]);
							System.out.println("Please input your new additional price: ");
							TicketPrices.getModifier()[6] = sc.nextDouble();
						}
					}

					if(pick==2){
						System.out.println("Here is the list of holidays: ");
						for(int indexholiday=0;indexholiday<TicketPrices.getHolidayDate().size();indexholiday++){
							System.out.println((indexholiday+1)+". "+TicketPrices.getHolidayDate().get(indexholiday));
						}
						System.out.println("What would you like to do?");
						System.out.println("1. Add a holiday date");
						System.out.println("2. Remove a holiday date");
						int choose = sc.nextInt();
						if(choose == 1){
							System.out.println("Please enter the date in numbers");
							System.out.println("Year: ");
							int yearchosen = sc.nextInt();
							System.out.println("Month: ");
							int monthchosen = sc.nextInt(); 
							System.out.println("Day: ");
							int daychosen = sc.nextInt();
							GregorianCalendar chosendate = new GregorianCalendar(yearchosen, monthchosen, daychosen);
							TicketPrices.addHolidayDate(chosendate.toString());
						}
						if(choose == 2){
							System.out.println("Which date would you like to remove(please input the no.)");
							String removeddate = TicketPrices.getHolidayDate().get(sc.nextInt()-1);
							TicketPrices.removeHolidayDate(removeddate);
						}
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
