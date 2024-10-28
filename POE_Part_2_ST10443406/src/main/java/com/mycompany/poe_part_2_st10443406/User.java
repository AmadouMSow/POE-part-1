/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part_2_st10443406;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
class User {
      //Variable declaration
     private String firstName;
     private String lastName;
    private String username;
    private String password;

    // Constructor
    public  void Users(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to validate username
    public boolean validateUsername(String username) {
        //This checks if the username is 5 letters or less and if it has an underscore
        if (username.length() <= 5 && username.contains("_")) {
            this.username = username;
            return true;
        }
        return false;
    }

    // Method to validate password
    public boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        Pattern capitalLetter = Pattern.compile("[A-Z]"); //to check for upper case letters
        Pattern smallLetter = Pattern.compile("[a-z]"); //to check for lower case letters
        Pattern number = Pattern.compile("[0-9]"); //to check for numbers
        Pattern specialChar = Pattern.compile("[^a-zA-Z0-9]"); // To check for special characters
        //This looks for letters, numbers, special characters etc within the password to see if the password passes the requirements
        Matcher hasCapitalLetter = capitalLetter.matcher(password);
        Matcher hasSmallLetter = smallLetter.matcher(password);
        Matcher hasNumber = number.matcher(password);
        Matcher hasSpecialChar = specialChar.matcher(password);
        //if statement if the password has all the required characters
        if (hasCapitalLetter.find() && hasSmallLetter.find() && hasNumber.find() && hasSpecialChar.find()) {
            this.password = password;
            return true;
        }
        return false;
    }

    // Method to check if login details match
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    // Getters
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getUsername() {
        return username;
    }
}
