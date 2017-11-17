package com.moblima.users;

import java.util.ArrayList;
import java.util.StringTokenizer;
import com.moblima.Manager.ServerInterface;
import java.io.File;
import java.io.IOException;

/**
 * Represents a user.
 */
public class User{

    /**
     * The name of this user.
     */
    private String name;

    /**
     * The age of this user.
     */
    private int age;

    /**
     * The booking history of this user.
     */
    private ArrayList<String> bookingHistory;
    private ServerInterface DBInterface = ServerInterface.getINSTANCE();

    /**
     * Creates a user with the given name
     * and age.
     * @param name name.
     * @param age age.
     */
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

    /**
     * Reads the booking history from database file.
     * @param DatabaseFile the database file.
     * @return the list of booking histories.
     * @throws IOException throw error in case of error.
     */
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

    /**
     * Gets the name of this user.
     * @return this user's name.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the age of this user.
     * @return this user's age.
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Gets the booking history 
     * of this user.
     * @return this user's booking history. 
     */
    public ArrayList<String> getBookingHistory(){
        return this.bookingHistory;
    }

    /**
     * Changes the name of this user.
     * @param name the new name.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Changes the age of this user.
     * @param age the new age.
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * Adds a booking history for
     * this user.
     * @param newBooking the booking history to add.
     */
    public void addBookingHistory(String newBooking){
        this.bookingHistory.add(newBooking);
    }

}
