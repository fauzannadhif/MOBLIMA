package com.moblima.users;

import java.util.ArrayList;
import java.util.StringTokenizer;
import com.moblima.Manager.ServerInterface;
import java.io.File;
import java.io.IOException;

public class User{
    private String name;
    private int age;
    private ArrayList<String> bookingHistory;
    private ServerInterface DBInterface = ServerInterface.getINSTANCE();

    public User(String name, int age){
        this.name = name;
        this.age = age;
        this.bookingHistory = new ArrayList<String>();
        try{
            File DatabaseFile = new File("data\\BookingHistory.txt");
            this.bookingHistory = readBookingHistory(DatabaseFile);
        }catch(IOException e){
            System.out.println("IOException > " + e.getMessage());
        }
    }

    public ArrayList<String> readBookingHistory(File DatabaseFile) throws IOException{
        ArrayList<String> StringArray = DBInterface.ReadFile(DatabaseFile);
        ArrayList<String> BookingHistories = new ArrayList<String>();
        int NumOfBookHistory;
        for (int i=0; i<StringArray.size(); i++){
            String st = StringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, "|");
            String Name = star.nextToken().trim();
            if (Name.equals(name)){
                NumOfBookHistory = star.countTokens();
                for (int j = 0; j<NumOfBookHistory; j++){
                    BookingHistories.add(star.nextToken());
                }
            }
        }
        return BookingHistories;
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
