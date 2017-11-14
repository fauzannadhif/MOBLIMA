package com.moblima.movie;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.FileInputStream;

public class Cinema{
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

    public String getType(){
        return this.Type;
    }
    public String getCinemaCode(){
        return this.CinemaCode;
    }
    public void setType(String type){
        this.Type = type;
    }
    public void setCinemaCode(String cinemaCode){
        this.CinemaCode = cinemaCode;
    }
}
