package com.moblima.movie;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.FileInputStream;

public class Cineplex{
    private String Name;
    private ArrayList<Cinema> CinemaList;
    private String Location;
    private static final String separator = "|";

    public Cineplex(String name){
        this.Name = name;
        //TODO: Change filename
        try{
            this.CinemaList = readCinemaList("CineplexCinemaList.txt");
        }catch(IOException e){
            System.out.println("IOException > " + e.getMessage());
        }
        try{
            this.Location = readLocation("CineplexLocation.txt");
        }catch (IOException e){
            System.out.println("IOException > " + e.getMessage());
        }
    }

    // Parse String Array into CinemaList
    public ArrayList<Cinema> readCinemaList(String filename) throws IOException{
        ArrayList<Cinema> resultCinemaList = new ArrayList<Cinema>();
        ArrayList<String> StringArray = read(filename);
        Cinema cinema;
        for (int i=0; i < StringArray.size(); i++){
            String st = StringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, separator);
            String name = star.nextToken().trim();
            if (name == Name){
                int NumberOfToken = star.countTokens();
                for (int j = 0; j<NumberOfToken; j++){
                    cinema = new Cinema(star.nextToken(), Name);
                    resultCinemaList.add(cinema);
                }
            }
        }
        return resultCinemaList;
    }


    // Parse String Array into Location
    public String readLocation(String filename) throws IOException{
        ArrayList<String> StringArray = read(filename);
        for (int i=0; i < StringArray.size(); i++){
            String st = StringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, separator);
            String name = star.nextToken().trim();
            String location = star.nextToken().trim();
            if (name == Name){
                return location;
            }
        }
        return "";
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


    public String getName(){
        return this.Name;
    }
    public ArrayList<Cinema> getCinemaList(){
        return this.CinemaList;
    }
    public String getLocation(){
        return this.Location;
    }
    public void setName(String name){
        this.Name = name;
    }
    public void setCinemaList(ArrayList<Cinema> CinemaList){
        this.CinemaList = CinemaList;
    }
    public void setLocation(String location){
        this.Location = location;
    }
}
