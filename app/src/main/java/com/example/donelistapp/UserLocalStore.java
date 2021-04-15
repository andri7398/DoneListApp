package com.example.donelistapp;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);

    }

    public void storeUserData(User user){
        SharedPreferences.Editor editor = userLocalDatabase.edit();
        editor.putString("name", user.name);
        editor.putString("email", user.email);
        editor.putString("password", user.password);
        editor.commit();
    }

    public User getLoggedInUser(){
        String name = userLocalDatabase.getString("name","");
        String email = userLocalDatabase.getString("email","");
        String password = userLocalDatabase.getString("password","");

        User storedUser = new User(name, email, password);

        return storedUser;
    }

    public boolean getUserLoggedIn(){
        if(userLocalDatabase.getBoolean("loggedIn",false) == true){
            return true;

        }
        else{
            return false;
        }

    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor editor = userLocalDatabase.edit();
        editor.putBoolean("loggedIn",loggedIn);
        editor.commit();
    }

    public void clearUserData(){
        SharedPreferences.Editor editor = userLocalDatabase.edit();
        editor.clear();
        editor.commit();
    }
}
