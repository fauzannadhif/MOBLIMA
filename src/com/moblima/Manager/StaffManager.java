package com.moblima.Manager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.IOException;

import com.moblima.movie.Cinema;
import com.moblima.movie.Cineplex;
import com.moblima.movie.Movie;
import com.moblima.movie.MovieList;
import com.moblima.movie.ShowTime;
import com.moblima.movie.ShowTimeList;
import com.moblima.movie.TicketPrice;

/**
 * Represents a manager for staff.
 */
public final class StaffManager{
    private ServerInterface DBInterface = ServerInterface.getINSTANCE();
    private SimpleDateFormat fmt = new SimpleDateFormat("yyyy;MM;dd;HH;mm;ss");
    private static final StaffManager INSTANCE = new StaffManager();
    
    /**
     * Default constructor.
     */
    private StaffManager(){};

    /**
     * @return the instance
     */
    public static StaffManager getInstance() {
        return INSTANCE;
    }

    /**
     * Adds a movie to a movie list.
     * @param newMovie the movie to be added.
     * @param Movies the movie list.
     */
    public void addMovie(Movie newMovie, MovieList Movies){
        Movies.addMovie(newMovie);
        File DatabaseFile = new File("data\\MovieList.txt");
        ArrayList<String> LineDataList = new ArrayList<String>();
        LineDataList.add(newMovie.getTitle());
        LineDataList.add(newMovie.getStatus());
        LineDataList.add(newMovie.getSynopsis());
        LineDataList.add(newMovie.getDirector());
        LineDataList.add(newMovie.getType());
        String CastString = "";
        for (String s: newMovie.getCast())
            CastString = CastString + s + ";";
        CastString.substring(0, CastString.length()-1);
        LineDataList.add(CastString);
        LineDataList.add(" ");
        LineDataList.add(" ");        
        LineDataList.add(newMovie.getAgeRating());
        LineDataList.add("0");
        String LineData = "";
        for (String s: LineDataList)
            LineData += s + " | ";
        LineData = LineData.substring(0, LineData.length()-3);
        try {
            DBInterface.NewLine(DatabaseFile, LineData);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
        return;
    }

    /**
     * Updates the details of a movie.
     * @param chosenMovie the movie to be updated.
     */
    public void updateDetails(Movie chosenMovie){
        File DatabaseFile = new File("data\\MovieList.txt");
        String OldString = "";
        String NewString = "";
        ArrayList<String> LineDataList = new ArrayList<String>();
        LineDataList.add(chosenMovie.getTitle());
        LineDataList.add(chosenMovie.getStatus());
        LineDataList.add(chosenMovie.getSynopsis());
        LineDataList.add(chosenMovie.getDirector());
        LineDataList.add(chosenMovie.getType());
        for (String s: chosenMovie.getCast())
            LineDataList.add(s);
        for (Integer i: chosenMovie.getRating())
            LineDataList.add(i.toString());
        for (String s: chosenMovie.getCast())
            LineDataList.add(s);
        LineDataList.add(chosenMovie.getAgeRating());
        LineDataList.add(String.valueOf(chosenMovie.getTicketSales()));
        for (String s: LineDataList)
            NewString+= s + " | ";
        NewString = NewString.substring(0, NewString.length()-3);
        try {
            ArrayList<String> st = DBInterface.ReadFile(DatabaseFile);
            for (String s: st){
                if (s.startsWith(chosenMovie.getTitle())){
                    OldString = s;
                    break;
                }
            }
            DBInterface.RewriteLine(DatabaseFile, OldString, NewString);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

    /**
     * Removes a movie from a movie list.
     * @param removedMovie the movie to be removed from the list.
     * @param Movies the movie list.
     */
    public void removeMovie(Movie removedMovie, MovieList Movies){
        Movies.removeMovie(removedMovie);
        File DatabaseFile = new File("data\\MovieList.txt");
        try {
            ArrayList<String> st = DBInterface.ReadFile(DatabaseFile);
            String DeletedLine = "";
            // Remove movie from MovieList.txt
            for (int i=0; i<st.size(); i++){
               if (st.get(i).startsWith(removedMovie.getTitle())){
                    DeletedLine = st.get(i);
                    break;
                }
            }
            DBInterface.DeleteLine(DatabaseFile, DeletedLine);

            DatabaseFile = new File("data\\ShowTimeList.txt");
            st = DBInterface.ReadFile(DatabaseFile);
            ArrayList<String> DeletedLineList = new ArrayList<String>();
            for (int i=0; i<st.size(); i++){
                if (st.get(i).startsWith(removedMovie.getTitle()))
                    DeletedLineList.add(st.get(i));
            }
            for (String DeletedLine2: DeletedLineList)
                DBInterface.DeleteLine(DatabaseFile, DeletedLine2);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
        
    }

    /**
     * Adds a showtime to a showtime list.
     * @param newShowTime the showtime to be added.
     * @param ShowTimes the showtime list.
     */
    public void createShowtime(ShowTime newShowTime, ShowTimeList ShowTimes){
        ShowTimes.addShowTimes(newShowTime);
        File DatabaseFile = new File("data\\ShowTimeList.txt");
        String LineData = newShowTime.getMovieShown().getTitle()+" | "+newShowTime.getCineplex().getName()+" | "+newShowTime.getCinema().getCinemaCode()+" | "+fmt.format(newShowTime.getDate().getTime());
        try {
            DBInterface.NewLine(DatabaseFile, LineData);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

    /**
     * Updates a showtime.
     * @param updatedShowTime the showtime to be updated.
     * @param newCineplex the new cineplex.
     * @param newCinema the new cinema.
     * @param newDate the new date.
     */
    public void updateShowTime(ShowTime updatedShowTime, Cineplex newCineplex, Cinema newCinema, GregorianCalendar newDate){
        updatedShowTime.setCinema(newCinema);
        updatedShowTime.setCineplex(newCineplex);
        updatedShowTime.setDate(newDate);
        File DatabaseFile = new File("data\\ShowTimeList.txt");
        String OldString = "";
        String NewString;
        try {
            ArrayList<String> st = DBInterface.ReadFile(DatabaseFile);
            for (String s: st){
                if (s.startsWith(updatedShowTime.getMovieShown().getTitle())){
                    OldString = s;
                    break;
                }
            }
            NewString = OldString.substring(0, OldString.indexOf("|") +1) + newCineplex.getName() + " | " + newCinema.getCinemaCode() + " | " + fmt.format(newDate.getTime());
            DBInterface.RewriteLine(DatabaseFile, OldString, NewString);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

    /**
     * Removes a showtime from a showtime list.
     * @param removedShowTime the showtime to be removed.
     * @param ShowTimes the showtime list.
     */
    public void removeShowTime(ShowTime removedShowTime, ShowTimeList ShowTimes){
        ShowTimes.removeShowTimes(removedShowTime);
        File DatabaseFile = new File("data\\ShowTimeList.txt");
        String DeletedLine = "";
        try {
            ArrayList<String> st = DBInterface.ReadFile(DatabaseFile);
            for (String s: st){
                if (s.startsWith(removedShowTime.getMovieShown().getTitle()))
                    DeletedLine = s;
            }
            DBInterface.DeleteLine(DatabaseFile, DeletedLine);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

    /**
     * Configures the modifiers of ticket price.
     * @param newModifier the new ticket price modifier.
     */
    public void ConfigurePrice(Double[] newModifier){
        File DatabaseFile = new File("data\\Modifiers.txt");
        String NewString = "";
        for (Double d: newModifier)
            NewString += String.valueOf(d) + " | ";
        NewString = NewString.substring(0, NewString.length()-3);
        try {
            String OldString = DBInterface.ReadFile(DatabaseFile).get(0);
            DBInterface.RewriteLine(DatabaseFile, OldString, NewString);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

    /**
     * Adds a holiday date to the list in ticket price.
     * @param newDate the new holiday date.
     * @param ticketPrice the ticket price.
     */
    public void addHoliday(String newDate, TicketPrice ticketPrice){
        ticketPrice.addHolidayDate(newDate);
        File DatabaseFile = new File("data\\HolidayDate.txt");
        try {
            DBInterface.NewLine(DatabaseFile, newDate);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }

    }

    /**
     * Removes a holiday date from the list.
     * @param removedDate the date to be removed.
     * @param ticketPrice the ticket price
     */
    public void removeHoliday(String removedDate, TicketPrice ticketPrice){
        ticketPrice.removeHolidayDate(removedDate);
        File DatabaseFile = new File("data\\HolidayDate.txt");
        try {
            DBInterface.DeleteLine(DatabaseFile, removedDate);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
