/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part_2_st10443406;

/**
 *
 * @author RC_Student_lab
 */
public class Task {

  
    final private String taskName;
    final private String taskDescription;
    final private String devFirstName;
    final private String devLastName;
    final private double taskDuration;
    final private int taskNumber;
    final private String taskStatus;
    final private String taskID;
    
    // Constructor to initialize task details
    public Task(String taskName, String taskDescription, String devFirstName, String devLastName, double taskDuration, int taskNumber, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.devFirstName = devFirstName;
        this.devLastName = devLastName;
        this.taskDuration = taskDuration;
        this.taskNumber = taskNumber;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }

    // Method to check if task description is valid
    public Boolean checkTaskDescription() {
        if (taskDescription.length() > 50) {
            return false; // Task description exceeds 50 characters
        }
        return true; // Task description is valid
    }

    // Method to create task ID
    final public String createTaskID() {
        String taskNamePrefix = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String devLastNameSuffix = devLastName.length() >= 3 ? devLastName.substring(devLastName.length() - 3).toUpperCase() : devLastName.toUpperCase();
        return taskNamePrefix + ":" + taskNumber + ":" + devLastNameSuffix;
    }

    // Method to print full task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n"
                + "Developer: " + devFirstName + " " + devLastName + "\n"
                + "Task Number: " + taskNumber + "\n"
                + "Task Name: " + taskName + "\n"
                + "Task Description: " + taskDescription + "\n"
                + "Task ID: " + taskID + "\n"
                + "Task Duration: " + taskDuration + " hours";
    }

    // Method to return task duration
    public int returnTotalHours() {
        return (int) taskDuration;
    }

    int getTaskDuration() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
