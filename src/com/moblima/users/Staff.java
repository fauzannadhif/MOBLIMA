package com.moblima.users;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Staff{
    private String Username;
    private String Password;
    public Staff(String username, String password){
        this.Username = username;
        this.Password = password;
    }

    public String getUsername(){
        return this.Username;
    }
    public String getPassword(){
        return this.Password;
    }
    public void setUsername(String username){
        this.Username = username;
    }
    public void setPassword(String password){
        this.Password = password;
    }
    private static String separator1 = "|";
    public static Boolean checkvalidity(String username, String password){
        try {
            File DatabaseFile = new File("data\\UsernamePassword.txt");
            ArrayList<String> StringArray = read(DatabaseFile);
            for(int i=0; i<StringArray.size();i++){
                String st = StringArray.get(i);
                StringTokenizer star = new StringTokenizer(st, separator1);
                String usernamedb = star.nextToken().trim();
                String passworddb = star.nextToken().trim();
                if(username==usernamedb && password==passworddb){
                    return true;
                }
            }
            System.out.println("The username and password combination you entered is not correct!");
            return false;
            } 
        catch (Exception e) {
            System.out.println("IOException > " + e.getMessage());
            return false;
        }
    }
    public static ArrayList<String> read(File DatabaseFile) throws IOException{
        ArrayList<String> data = new ArrayList<String>();
        Scanner sc = new Scanner(new FileInputStream(DatabaseFile));
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
}
