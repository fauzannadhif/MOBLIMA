package com.moblima.users;

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
}
