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
        return "None";
    }

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

    public Cineplex(String name){
        this.Name = name;
        try{
            this.Location = readLocation("Database");            
        }catch (IOException e){
            System.out.println("IOException > " + e.getMessage());
        }
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
