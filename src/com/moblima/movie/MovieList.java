package com.moblima.movie;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.lang.String;

public class MovieList {
	private ArrayList<Movie> Movies;
	private static String separator1 = "|";
	private static String separator2 = ";";
	public MovieList(){
		try {
			File DatabaseFile = new File("data\\MovieList.txt");
			this.Movies = readMovies(DatabaseFile);
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}


	public ArrayList<Movie> readMovies(File DatabaseFile) throws IOException{
		ArrayList<Movie> movies = new ArrayList<Movie>();
		ArrayList<String> StringArray = read(DatabaseFile);
		Movie movie;
		for (int i=0; i<StringArray.size(); i++){
			String st = StringArray.get(i);
			StringTokenizer star = new StringTokenizer(st, separator1);
			String Title = star.nextToken().trim();
			String Status = star.nextToken().trim();
			String Synopsis = star.nextToken().trim();
			String Director = star.nextToken().trim();
			String Type = star.nextToken().trim();
			ArrayList<String> Cast = new ArrayList<String>();
			String LongCast = star.nextToken().trim();
			if (!LongCast.equals("")){
				StringTokenizer Caster = new StringTokenizer(LongCast, separator2);
				int NumOfCaster = Caster.countTokens();
				for (int j=0; j<NumOfCaster; j++){
					Cast.add(Caster.nextToken().trim());
				}
			}
			String LongRating = star.nextToken().trim();			
			ArrayList<Integer> Rating = new ArrayList<Integer>();
			if (!LongRating.equals("")){
				StringTokenizer Rater = new StringTokenizer(LongRating, separator2);
				int NumOfRating = Rater.countTokens();
				for (int j=0; j<NumOfRating; j++){
					Rating.add(Integer.valueOf(Rater.nextToken().trim()));
				}
			}
			ArrayList<String> Review = new ArrayList<String>();
			String LongReview = star.nextToken().trim();
			if (!LongReview.equals("")){
				StringTokenizer Reviewer = new StringTokenizer(LongReview, separator2);
				int NumOfReview = Reviewer.countTokens();
				for (int j=0; j<NumOfReview; j++){
					Review.add(Reviewer.nextToken().trim());
				}
			}
			String AgeRating = star.nextToken().trim();
			movie = new Movie(Title, Status, Synopsis, Director, Type, Cast, Rating, Review, AgeRating);
			movies.add(movie);
		}

		return movies;
	}

	// Method to read data from text file
	public static ArrayList<String> read(File DatabaseFile) throws IOException{
        	ArrayList<String> data = new ArrayList<String>();
        	Scanner sc = new Scanner(new FileInputStream(DatabaseFile));
        	try {
        	    while (sc.hasNextLine()){
        	        data.add(sc.nextLine());
        	    }
        	}
        	finally {
        	    sc.close();
        	}
        	return data;
	}

	public void addMovie(Movie newMovie){
		Movies.add(newMovie);
		// FILEIO
	}
	
	public ArrayList<Movie> getMovie(){
		return this.Movies;
	}

	public void removeMovie(Movie removedMovie){
		Movies.set(Movies.indexOf(removedMovie), Movies.get(Movies.size()-1));
		Movies.remove(Movies.size()-1);
	}
	
	public ArrayList<String> sortMovie(int choice){
		ArrayList<Movie> sortedMovies = Movies;
		ArrayList<String> result = new ArrayList<String>();
		if (choice == 1){
			System.out.println("Sorting by ticket sales");
			int i;
			int j;
			for(i=0;i<this.Movies.size();i++){
				for(j=i;j<this.Movies.size();j++){
					if(sortedMovies.get(i).getTicketSales() < sortedMovies.get(j).getTicketSales()){
						Movie dummy = sortedMovies.get(i);
						sortedMovies.set(i,sortedMovies.get(j));
						sortedMovies.set(j,dummy);
					}
				}
			}			
		}
		else if (choice == 2){
			System.out.println("Sorting by overall reviewers ratings");
			int i;
			int j;
			for(i=0;i<this.Movies.size();i++){
				for(j=i;j<this.Movies.size();j++){
					if(sortedMovies.get(i).getOverallRating() < sortedMovies.get(j).getOverallRating()){
						Movie dummy = sortedMovies.get(i);
						sortedMovies.set(i,sortedMovies.get(j));
						sortedMovies.set(j,dummy);
					}
				}
			}
		}
		else {
			System.out.println("Wrong Choice!");
			result.add("Wrong Input");
			return result;
		}
		for(int i=0; i<5; i++){
			result.add(i, sortedMovies.get(i).getTitle());
		}
		return result;		
	}
	
	public void searchMovie(String searchInput) {
		int count = 0;
		for (int i=0; i<this.getMovie().size(); i++) {
			if (this.getMovie().get(i).getTitle().contains(searchInput)) {
				count++;
				System.out.println(count + ". " + this.getMovie().get(i).getTitle());
			}
		}
	}
}
