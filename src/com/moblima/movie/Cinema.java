package com.moblima.movie;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.FileInputStream;

public class Cinema{
    private ArrayList<ArrayList<Boolean>> Seat;
    private Movie MovieShown;
    private String Type;
    private String CinemaCode;
    
    public Cinema(String CinemaCode, String CineplexName){
        this.CinemaCode = CinemaCode;
        //TODO: Change Filename
        try{
            this.Type = readCinemaType("CinemaType.txt");
        }catch(IOException e){
            System.out.println("IOException > " + e.getMessage());
        }
        try{
            this.Seat = readSeat("CinemaSeats.txt");
        }catch(IOException e){
            System.out.println("IOException > " + e.getMessage());
        }

    }


    // Parse MovieShown from the String array
    public String readCinemaType(String filename) throws IOException{
        ArrayList<String> StringArray = read(filename);
        for (int i=0; i<StringArray.size(); i++){
            String st = StringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, "|");
            String cinemaCode = star.nextToken().trim();
            if (cinemaCode == CinemaCode){
                return star.nextToken().trim();
            }
        }
        return "";
    }

    public ArrayList<ArrayList<Boolean>> readSeat(String filename) throws IOException{
        ArrayList<ArrayList<Boolean>> Result = new ArrayList<ArrayList<Boolean>>();
        ArrayList<String> StringArray = read(filename);
        ArrayList<Boolean> RowBoolean = new ArrayList<Boolean>();
        for (int i=0; i<StringArray.size(); i++){
            String st = StringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, "|");
            String cinemaCode = star.nextToken().trim();
            String rowSeat;
            if (cinemaCode == CinemaCode){
                int NumberOfToken = star.countTokens();
                for (int j=0; j<NumberOfToken; j++){
                    rowSeat = star.nextToken();
                    for (int k=0; k<rowSeat.length(); k++){
                        if (rowSeat.charAt(k) == '0'){
                            RowBoolean.add(false);
                        }
                        else if (rowSeat.charAt(k) == '1'){
                            RowBoolean.add(true);
                        }
                    }
                    Result.add(RowBoolean);
                }
            }
        }
        return Result;
    }

    // Text Parser from the file
    public static ArrayList<String> read(String filename) throws IOException{
        ArrayList<String> data = new ArrayList<String>();
        Scanner sc = new Scanner(new FileInputStream(filename));
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

    public ArrayList<ArrayList<Boolean>> getSeat(){
        return this.Seat;
    }
    public Movie getMovieShown(){
        return this.MovieShown;
    }
    public String getType(){
        return this.Type;
    }
    public String getCinemaCode(){
        return this.CinemaCode;
    }
    public void setSeat(ArrayList<ArrayList<Boolean>> seat){
        this.Seat = seat;
    }
    public void setMovieShown(Movie movieShown){
        this.MovieShown = movieShown;
    }
    public void setType(String type){
        this.Type = type;
    }
    public void setCinemaCode(String cinemaCode){
        this.CinemaCode = cinemaCode;
    }
}
