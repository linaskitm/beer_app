package com;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    // objekto kintamieji (pozymiai, argumentai)
    private String username;
    private String password;
    private String email;

    private SharedPreferences sharedPreferences;
    private static String PREFERENCES_PACKAGE_NAME = "com";
    private  static String USERNAME_KEY = "username";
    private static String PASSWORD_KEY = "password";
    private static String REMEMBERME_KEY = "rememberMe";

    // konstruktorius registracijai
    //right mouse click->generate->constructor
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //konstructorius skirtas vartotojo prisijungimui
    public User(Context context){
        this.sharedPreferences = context.getSharedPreferences(User.PREFERENCES_PACKAGE_NAME,
                Context.MODE_PRIVATE);
    }

    // klases metodai (get and set) registracijai
    //right mouse click->generate->getter and setter
    public String getUsernameForRegistration() {
        return username;
    }

    public void setUsernameForRegistration(String username) {
        this.username = username;
    }

    public String getPasswordForRegistration() {
        return password;
    }

    public void setPasswordForRegistration(String password) {
        this.password = password;
    }

    public String getEmailForRegistration() {
        return email;
    }

    public void setEmailForRegistration(String email) {
        this.email = email;
    }

    //kalases metodai get and set vartototjo prisijungimui
    public String getUsernameKey() {
        return this.sharedPreferences.getString(USERNAME_KEY, "");
    }

    public void setUsernameKey(String username) {
        this.sharedPreferences.edit().putString(USERNAME_KEY, username).apply();
    }

    public String getPasswordKey() {
        return this.sharedPreferences.getString(PASSWORD_KEY, "");
    }

    public void setPasswordKey(String password) {
        this.sharedPreferences.edit().putString(PASSWORD_KEY, password).apply();
    }

    public boolean getRemembermeKey() {
        return this.sharedPreferences.getBoolean(REMEMBERME_KEY, false);
    }

    public void setRemembermeKey(boolean remembermeKey) {
        this.sharedPreferences.edit().putBoolean(REMEMBERME_KEY, remembermeKey);
    }
}
