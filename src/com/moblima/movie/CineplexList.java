package com.moblima.movie;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.StringTokenizer;

public final class CineplexList{
    private static final CineplexList INSTANCE = new CineplexList();
    private ArrayList<Cineplex> Cineplexes;
    private static final String separator = "|";

    private CineplexList(){
        try {
            this.Cineplexes = readCineplex("CineplexCinema.txt");
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

    public static CineplexList getInstance() {
        return INSTANCE;
    }

    public ArrayList<Cineplex> readCineplex(String filename) throws IOException{
        ArrayList<String> StringArray = read(filename);
        ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
        ArrayList<Cinema> CinemaList;
        String CineplexName;
        String CineplexLocation;
        String CinemaCode;
        String CinemaType;
        Cinema CinemaInCineplex;
        Cineplex cineplex;
        int NumOfCinema = 0;
        for (int i=0; i<StringArray.size(); i++){
            String st = StringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, separator);
            CineplexName = star.nextToken().trim();
            CineplexLocation = star.nextToken().trim();
            NumOfCinema = (star.countTokens())/3;
            CinemaList = new ArrayList<Cinema>();
            for(int j=0; j<(NumOfCinema); j++){
                CinemaCode = star.nextToken().trim();
                CinemaType = star.nextToken().trim();
                CinemaInCineplex = new Cinema(CinemaCode, CinemaType);
                CinemaList.add(CinemaInCineplex);
            }
            cineplex = new Cineplex(CineplexName, CinemaList, CineplexLocation);
            cineplexList.add(cineplex);
        }
        return cineplexList;
    }
    
    // Method to read data from text file
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

    public ArrayList<Cineplex> getCineplex(){
        return Cineplexes;
    }
}

