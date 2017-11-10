package com.moblima.movie;

import java.util.ArrayList;


public class MovieList {
	private ArrayList<Movie> Movies;
	public MovieList(){
		//FILEIO
	}
	public void addMovie(Movie newMovie){
		Movies.add(newMovie);
		// FILEIO
	}
	
	public ArrayList<Movie> getMovie(){
		return this.Movies;
	}
	
	public ArrayList<Movie> sortMovie(int choice){
		ArrayList<Movie> sortedMovies = Movies;
		if (choice == 1){
			System.out.println("Sorting by ticket sales");
		}
		else if (choice == 2){
			System.out.println("Sorting by overall reviewers ratings");
		}
		else {
			System.out.println("Wrong Choice!");
		}
		return sortedMovies;
	}
}
