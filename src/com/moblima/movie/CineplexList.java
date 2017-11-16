package com.moblima.movie;

import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.StringTokenizer;
import com.moblima.Manager.ServerInterface;

public final class CineplexList{
    private static final CineplexList INSTANCE = new CineplexList();
    private ArrayList<Cineplex> Cineplexes;
    private static final String separator = "|";
    private ServerInterface DBInterface = ServerInterface.getINSTANCE();

    private CineplexList(){
        File file = new File("data\\CineplexList.txt");
        try {
            this.Cineplexes = readCineplex(file);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

    public static CineplexList getInstance() {
        return INSTANCE;
    }

    public ArrayList<Cineplex> readCineplex(File DatabaseFile) throws IOException{
        ArrayList<String> StringArray = DBInterface.ReadFile(DatabaseFile);
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

    public ArrayList<Cineplex> getCineplex(){
        return Cineplexes;
    }
}

