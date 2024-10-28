package com.mycompany.poe_part_2_st10443406;

import javax.swing.JOptionPane;

public class EasyKanban {
    private static boolean loggedIn = false;
    private static int taskNumber = 0; // Auto-increment task number
    private static double totalTaskHours = 0; // Accumulate total hours

    public void StartingApplication(){
        login();
        if (loggedIn) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban.", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            int option;
            do {
                String[] options = {"Add Tasks", "Show Report", "Quit"};
                option = JOptionPane.showOptionDialog(null, "Choose an option:", "Menu",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                switch (option) {
                    case 0:
                        addTasks();
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Coming soon.", "Report", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Quitting the application.", "Quit", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please choose again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (option != 2);
        }
    }
    

    private static void login() {
        POE_Part_2_ST10443406 m= new POE_Part_2_ST10443406();
               
        String loginUsername = JOptionPane.showInputDialog(null, "Enter your username:"+ m.usernames(), "Login", JOptionPane.QUESTION_MESSAGE);
        String loginPassword = JOptionPane.showInputDialog(null, "Enter your password:"+ m.passwords()
                , "Login", JOptionPane.QUESTION_MESSAGE);

        if (loginUsername.equals(m.usernames()) && loginPassword.equals(m.passwords())) {
            loggedIn = true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credentials. Exiting.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    //addTasks method to allow the user to enter the necessary details about their tasks, such as their details, task duration, etc.
    private static void addTasks() {
        String input = JOptionPane.showInputDialog(null, "How many tasks would you like to enter?", "Task Input", JOptionPane.QUESTION_MESSAGE);
        int numberOfTasks = Integer.parseInt(input);

        for (int i = 1; i <= numberOfTasks; i++) {
            String taskName = JOptionPane.showInputDialog(null, "Enter the Task Name for Task " + i, "Task Input", JOptionPane.QUESTION_MESSAGE);

            String taskDescription;
            do {
                taskDescription = JOptionPane.showInputDialog(null, "Enter Task Description (less than 50 characters):", "Task Input", JOptionPane.QUESTION_MESSAGE);
                if (taskDescription.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (taskDescription.length() > 50);

            String devFirstName = JOptionPane.showInputDialog(null, "Enter Developer First Name:", "Task Input", JOptionPane.QUESTION_MESSAGE);
            String devLastName = JOptionPane.showInputDialog(null, "Enter Developer Last Name:", "Task Input", JOptionPane.QUESTION_MESSAGE);

            String durationInput = JOptionPane.showInputDialog(null, "Enter Task Duration (hours):", "Task Input", JOptionPane.QUESTION_MESSAGE);
            double taskDuration = Double.parseDouble(durationInput);

            totalTaskHours += taskDuration; // Accumulate total task hours

            String taskStatus = chooseTaskStatus();

            String taskId = generateTaskId(taskName, devLastName, taskNumber);

            // Display task details using JOptionPane
            displayTaskDetails(taskStatus, devFirstName, devLastName, taskNumber, taskName, taskDescription, taskId, taskDuration);

            taskNumber++; // Increment task number for the next task
        }

        // Display the total number of hours across all tasks
        JOptionPane.showMessageDialog(null, "Total Task Hours: " + totalTaskHours, "Task Summary", JOptionPane.INFORMATION_MESSAGE);
    }
    //method for the user to decide the state of the task: Doing, done, to do
    private static  String chooseTaskStatus() {
        String[] statuses = {"To Do", "Doing", "Done"};
        int statusChoice = JOptionPane.showOptionDialog(null, "Choose task status:", "Task Status",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);

        switch (statusChoice) {
            case 0:
                return "To Do";
            case 1:
                return "Doing";
            case 2:
                return "Done";
            default:
                JOptionPane.showMessageDialog(null, "Invalid option, defaulting to 'To Do'.", "Error", JOptionPane.ERROR_MESSAGE);
                return "To Do";
        }
    }
    //method to auto generate a taskID 
    private static String generateTaskId(String taskName, String devLastName, int taskNumber) {
        String taskNamePrefix = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String devLastNameSuffix = devLastName.length() >= 3 ? devLastName.substring(devLastName.length() - 3).toUpperCase() : devLastName.toUpperCase();
        //hard code teh ID to return in the desired format
        return taskNamePrefix + ":" + taskNumber + ":" + devLastNameSuffix;
    }
    //display the tasks and their details to the user
    private static void displayTaskDetails(String taskStatus, String devFirstName, String devLastName, int taskNumber, String taskName, String taskDescription, String taskId, double taskDuration) {
        String taskDetails = "Task Status: " + taskStatus + "\n"
                + "Developer: " + devFirstName + " " + devLastName + "\n"
                + "Task Number: " + taskNumber + "\n"
                + "Task Name: " + taskName + "\n"
                + "Task Description: " + taskDescription + "\n"
                + "Task ID: " + taskId + "\n"
                + "Task Duration: " + taskDuration + " hours";
        JOptionPane.showMessageDialog(null, taskDetails, "Task Details", JOptionPane.INFORMATION_MESSAGE);
    }

  
    
}
