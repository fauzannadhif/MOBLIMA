package com.moblima.movie;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.Scanner;

public class ShowTimeList {
    private ArrayList<ShowTime> showTimes;
    private static String separator1 = "|";
    private static String separator2 = ";";
    public ShowTimeList(){
        try {
            File DatabaseFile = new File("data\\ShowTimeList.txt");
            this.showTimes = readShowTimes(DatabaseFile);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
        try {
            File DatabaseFile = new File("data\\Seat.txt");
            ArrayList<String> StringArray = read(DatabaseFile);
            for (int i=0; i<StringArray.size(); i++){
                String st = StringArray.get(i);
                for(int a=0; a<10; a++){
                    for(int b=0; b<16; b++){
                        if(st.charAt((a*16)+b) == 't')
                            this.showTimes.get(i).getSeat().getSeats()[a][b] = true;
                        else
                            this.showTimes.get(i).getSeat().getSeats()[a][b] = false;
                    }
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }

    public ArrayList<ShowTime> getShowTimes() {
        return showTimes;
    }

    public void addShowTimes(ShowTime newShowTime) {
        this.showTimes.add(newShowTime);
    }

    public void removeShowTimes(ShowTime removedShowTime){
		showTimes.remove(showTimes.indexOf(removedShowTime));
    }
    
    public ArrayList<ShowTime> readShowTimes(File DatabaseFile) throws IOException{
		ArrayList<ShowTime> showtimes = new ArrayList<ShowTime>();
		ArrayList<String> StringArray = read(DatabaseFile);
        ShowTime showtime = null;
        MovieList movies = new MovieList();
        CineplexList cineplexes = CineplexList.getInstance();
		for (int i=0; i<StringArray.size(); i++){
			String st = StringArray.get(i);
			StringTokenizer star = new StringTokenizer(st, separator1);
            String MovieTitle = star.nextToken().trim();
            Movie movieShown = null;
            Cinema cinemaShown = null;
            GregorianCalendar dateshown;
            Cineplex cineplexShown = null;
            for(int j=0; j<movies.getMovie().size(); j++){
                if(MovieTitle.equals(movies.getMovie().get(j).getTitle()))
                    movieShown = movies.getMovie().get(j);
            }
            String CineplexName = star.nextToken().trim();
            for(int j=0; j<cineplexes.getCineplex().size(); j++){
                if(CineplexName.equals(cineplexes.getCineplex().get(j).getName())){
                    cineplexShown = cineplexes.getCineplex().get(j);
                }
            }
            
            String CinemaCode = star.nextToken().trim();
            if (cineplexShown != null){
                for(int j=0; j< cineplexShown.getCinemaList().size(); j++){
                    if(CinemaCode.equals(cineplexShown.getCinemaList().get(j).getCinemaCode())){
                        cinemaShown = cineplexShown.getCinemaList().get(j);
                    }
                }
            }
            String DateInput = star.nextToken().trim();
            StringTokenizer Dater = new StringTokenizer(DateInput, separator2);
            int[] DateList = new int[6];
            for(int j = 0; j<6; j++){
                DateList[j] = Integer.valueOf(Dater.nextToken().trim());
            }
            dateshown = new GregorianCalendar(DateList[0], DateList[1], DateList[2], DateList[3], DateList[4], DateList[5]);

            if (movieShown != null && cinemaShown != null && cineplexShown != null){
			    showtime = new ShowTime(movieShown,cinemaShown, dateshown, cineplexShown);
            }
			showtimes.add(showtime);
		}

		return showtimes;
    }
    
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

}
