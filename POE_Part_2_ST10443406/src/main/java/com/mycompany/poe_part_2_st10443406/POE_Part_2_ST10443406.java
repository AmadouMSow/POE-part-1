
package com.mycompany.poe_part_2_st10443406;

import javax.swing.JOptionPane;

public class POE_Part_2_ST10443406 {

    
    private static User users = new User();
   
    public static String username="";
    public static String password = "";

    
    public static void main(String[] args) {

        // Ask for first and last name
        String firstName = JOptionPane.showInputDialog("Please enter your first name: ");
        String lastName = JOptionPane.showInputDialog("Please enter your last name: ");
        // Ask for username with the required format
        while (true) {
            username = JOptionPane.showInputDialog("Enter a username (must contain an underscore and be no more than 5 characters long): ");
            if (users.validateUsername(username)) {
                JOptionPane.showMessageDialog(null, "Username successfully captured!");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }

        // Ask for password with the required format
        
        while (true) {
            password = JOptionPane.showInputDialog("Enter a password (at least 8 characters long and containing a capital letter, a number, and a special character): ");
            if (users.validatePassword(password)) {
                JOptionPane.showMessageDialog(null, "Password successfully captured!");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            }
        }

        // Show user details
        JOptionPane.showMessageDialog(null, "Name: " + users.getFullName() + "\nUsername: " + username);

        // Login process
        EasyKanban object = new EasyKanban();
        object.StartingApplication();
     
        
        
    }
    
    
    
    public String usernames () {
        return username;
    }
        public String passwords () {
        return password;
    }
    
    
}
