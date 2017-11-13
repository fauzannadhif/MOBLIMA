package com.moblima.users;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.IOException;

public class User{
    private String name;
    private int age;
    private ArrayList<String> bookingHistory;

    public User(String name){
        this.name = name;
        try{
            this.age = readAge("DatabaseUserAge.txt");
            this.bookingHistory = read("DatabaseUserHistory.txt");
        }catch(IOException e){
            System.out.println("IOException > " + e.getMessage());
        }
    }

    // Read Age from DB
    public int readAge(String filename) throws IOException{
        ArrayList<String> StringArray = read(filename);
        int AgeDB = 0;
        for (int i=0; i<StringArray.size(); i++){
            String st = StringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, "|");
            String Name = star.nextToken().trim();
            if (Name == name)
                AgeDB = Integer.valueOf(star.nextToken().trim());
        }
        return AgeDB;
    }

    public ArrayList<String> bookingHistory(String filename) throws IOException{
        ArrayList<String> StringArray = read(filename);
        ArrayList<String> BookingHistories = new ArrayList<String>();
        int NumOfBookHistory;
        for (int i=0; i<StringArray.size(); i++){
            String st = StringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, "|");
            String Name = star.nextToken().trim();
            if (Name == name){
                NumOfBookHistory = star.countTokens();
                for (int j = 0; j<NumOfBookHistory; j++){
                    BookingHistories.add(star.nextToken());
                }
            }
        }
        return BookingHistories;
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
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }

    public ArrayList<String> getBookingHistory(){
        return this.bookingHistory;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void addBookingHistory(String newBooking){
        this.bookingHistory.add(newBooking);
    }

}
