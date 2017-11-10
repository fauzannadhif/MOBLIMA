package com.moblima.users;

import java.util.ArrayList;
public class User{
    private String name;
    private int age;
    private ArrayList<Integer> bookingHistory;

    public User(String name){
        this.name = name;
        //FILEIO
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }

    public ArrayList<Integer> getBookingHistory(){
        return this.bookingHistory;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void addBookingHistory(int newBooking){
        this.bookingHistory.add(newBooking);
    }

}
