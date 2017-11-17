package com.moblima.users;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
import com.moblima.Manager.ServerInterface;

/**
 * Represents a staff.
 */
public class Staff{

    /**
     * The username of this staff.
     */
    private String Username;

    /**
     * The password of this staff.
     */
    private String Password;
    private static ServerInterface DBInterface = ServerInterface.getINSTANCE();

    /**
     * Creates a staff with the given
     * username and password.
     * @param username the username.
     * @param password the password.
     */
    public Staff(String username, String password){
        this.Username = username;
        this.Password = password;
    }

    /**
     * Gets the username of this staff.
     * @return this staff's username.
     */
    public String getUsername(){
        return this.Username;
    }

    /**
     * Gets the password of this staff.
     * @return this staff's password.
     */
    public String getPassword(){
        return this.Password;
    }

    /**
     * Changes the username of this staff.
     * @param username the new username.
     */
    public void setUsername(String username){
        this.Username = username;
    }

    /**
     * Changes the password of this staff.
     * @param password the new password.
     */
    public void setPassword(String password){
        this.Password = password;
    }
    private static String separator1 = "|";

    /**
     * Checks the validity of the given
     * username and password.
     * @param username the input username.
     * @param password the input password.
     * @return true if valid, else false. 
     */
    public static Boolean checkvalidity(String username, String password){
        try {
            File DatabaseFile = new File("data\\UsernamePassword.txt");
            ArrayList<String> StringArray = DBInterface.ReadFile(DatabaseFile);
            for(int i=0; i<StringArray.size();i++){
                String st = StringArray.get(i);
                StringTokenizer star = new StringTokenizer(st, separator1);
                String usernamedb = star.nextToken().trim();
                String passworddb = star.nextToken().trim();
                if(username.equals(usernamedb) && password.equals(passworddb)){
                    return true;
                }
            }
            System.out.println("The username and password combination you entered is not correct!");
            return false;
            } 
        catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
            return false;
        }
    }
}
