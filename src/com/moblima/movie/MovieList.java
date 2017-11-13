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

	public void removeMovie(Movie removedMovie){
		Movies.set(Movies.indexOf(removedMovie), Movies.get(Movies.size()-1));
		Movies.remove(Movies.size()-1);
	}
	
	public ArrayList<Movie> sortMovie(int choice){
		ArrayList<Movie> sortedMovies = Movies;
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
			System.out.println("Sorting by ticket sales");
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
		}
		ArrayList<Movie> result = new ArrayList<Movie>(sortedMovies.subList(0,4));
		return result;		
	}
}
