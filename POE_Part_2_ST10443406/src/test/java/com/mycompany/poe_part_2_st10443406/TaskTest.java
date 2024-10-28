/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_part_2_st10443406;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    
    public TaskTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        Task instance = null;
        Boolean expResult = null;
        Boolean result = instance.checkTaskDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() {
        System.out.println("createTaskID");
        Task instance = null;
        String expResult = "";
        String result = instance.createTaskID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");
        Task instance = null;
        String expResult = "";
        String result = instance.printTaskDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalHours method, of class Task.
     */
    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        Task instance = null;
        int expResult = 0;
        int result = instance.returnTotalHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    void testTask1Details(){
        //Test data for task 1
        String taskName = "Login feture";
                String taskDescription = "Create login to authenticate users";
        String devFirstName = "Robyn";
        String devLastName = "Harrison";
        double taskDuration = 8;
        int taskNumber = 0; // Assuming task number starts from 0
        String taskStatus = "To Do";

        // Create Task 1
        Task task1 = new Task(taskName, taskDescription, devFirstName, devLastName, taskDuration, taskNumber, taskStatus);

        // Check Task Description
        assertTrue(task1.checkTaskDescription(), "Task 1 description should be valid (less than 50 characters)");

        // Check Task ID
        String expectedTaskID = "LO:0:SON"; // Based on task name "Login feature" and developer "Harrison"
        assertEquals(expectedTaskID, task1.createTaskID(), "Task 1 ID should be correctly generated");

        // Check Total Hours
        assertEquals(8, task1.returnTotalHours(), "Task 1 duration should be 8 hours");

        // Print Task Details
        String expectedTaskDetails = "Task Status: To Do\n"
                + "Developer: Robyn Harrison\n"
                + "Task Number: 0\n"
                + "Task Name: Login feature\n"
                + "Task Description: Create login to authenticate users\n"
                + "Task ID: LO:0:SON\n"
                + "Task Duration: 8.0 hours";
        assertEquals(expectedTaskDetails, task1.printTaskDetails(), "Task 1 details should match expected values");
    }
    @Test
    void testTask2Details() {
        //Test data for Task 2
        String taskName = "Add Task Feature";
        String taskDescription = "Create Add Task Feature to add Task users";
        String devFirstName = "Mike";
        String devLastName = "Smith";
        double taskDuration = 10;
        int taskNumber = 1; // Assuming task number increments to 1 for the second task
        String taskStatus = "Doing";

        // Create Task 2
        Task task2 = new Task(taskName, taskDescription, devFirstName, devLastName, taskDuration, taskNumber, taskStatus);

        // Check Task Description
        assertTrue(task2.checkTaskDescription(), "Task 2 description should be valid (less than 50 characters)");

        // Check Task ID
        String expectedTaskID = "AD:1:ITH"; // Based on task name "Add Task Feature" and developer "Smith"
        assertEquals(expectedTaskID, task2.createTaskID(), "Task 2 ID should be correctly generated");

        // Check Total Hours
        assertEquals(10, task2.returnTotalHours(), "Task 2 duration should be 10 hours");

        // Print Task Details
        String expectedTaskDetails = "Task Status: Doing\n"
                + "Developer: Mike Smith\n"
                + "Task Number: 1\n"
                + "Task Name: Add Task Feature\n"
                + "Task Description: Create Add Task Feature to add Task users\n"
                + "Task ID: AD:1:ITH\n"
                + "Task Duration: 10.0 hours";
        assertEquals(expectedTaskDetails, task2.printTaskDetails(), "Task 2 details should match expected values");
    }
     @Test
    void testTotalCombinedHours() {
        // Test data for Task 1 and Task 2
        Task task1 = new Task("Login feature", "Create login to authenticate users", "Robyn", "Harrison", 8, 0, "To Do");
        Task task2 = new Task("Add Task Feature", "Create Add Task Feature to add Task users", "Mike", "Smith", 10, 1, "Doing");

        // Check Total Combined Hours
        int totalHours = task1.returnTotalHours() + task2.returnTotalHours();
        assertEquals(18, totalHours, "Total hours should be the sum of both tasks: 8 + 10 = 18");
    }
     @Test
    void testTaskDescriptionValidation() {
        // Test for Success (Task description less than 50 characters)
        Task task1 = new Task("Login feature", "Create login to authenticate users", "Robyn", "Harrison", 8, 0, "To Do");
        assertEquals("Task successfully captured", task1.checkTaskDescription(), "Task description should be valid");

        // Test for Failure (Task description more than 50 characters)
        Task task2 = new Task("Add Task Feature", "This description exceeds the character limit by a significant margin", "Mike", "Smith", 10, 1, "Doing");
        assertEquals("Please enter a task description of less than 50 characters", task2.checkTaskDescription(), "Task description should be invalid");
    }

    @Test
    void testTaskIDGeneration() {
        // Test for Task ID based on data from Test Case 1
        Task task1 = new Task("Login feature", "Create login to authenticate users", "Robyn", "Harrison", 8, 1, "To Do");
        assertEquals("LO:1:BYN", task1.createTaskID(), "TaskID should match 'LO:1:BYN'");

        // Test TaskID in a loop for the remaining cases
        String[][] testData = {
            {"Create Report Feature", "Description 1", "Mike", "Ike", "CR:0:IKE"},
            {"Create Dashboard", "Description 2", "Edward", "Lard", "CR:1:ARD"},
            {"Create Analytics Feature", "Description 3", "Jonathan", "Matha", "CR:2:THA"},
            {"Create Notification System", "Description 4", "Arnold", "Bond", "CR:3:ND"}
        };

        for (int i = 0; i < testData.length; i++) {
            Task task = new Task(testData[i][0], testData[i][1], testData[i][2], testData[i][3], 10, i, "Doing");
            assertEquals(testData[i][4], task.createTaskID(), "TaskID should match " + testData[i][4]);
        }
    }

    @Test
    void testTotalHoursAccumulation() {
        // Test for total hours for Task 1 and Task 2
        Task task1 = new Task("Login feature", "Create login to authenticate users", "Robyn", "Harrison", 8, 0, "To Do");
        Task task2 = new Task("Add Task Feature", "Create Add Task Feature to add tasks", "Mike", "Smith", 10, 1, "Doing");

        int totalHours = task1.getTaskDuration() + task2.getTaskDuration();
        assertEquals(18, totalHours, "Total hours should be 18 for task1 and task2");

        // Test for additional data (5 tasks with durations: 10, 12, 55, 11, 1)
        Task[] tasks = {
            new Task("Task 1", "Description 1", "Dev1", "Last1", 10, 0, "Doing"),
            new Task("Task 2", "Description 2", "Dev2", "Last2", 12, 1, "To Do"),
            new Task("Task 3", "Description 3", "Dev3", "Last3", 55, 2, "Done"),
            new Task("Task 4", "Description 4", "Dev4", "Last4", 11, 3, "Doing"),
            new Task("Task 5", "Description 5", "Dev5", "Last5", 1, 4, "To Do")
        };

        int total = 0;
        for (Task task : tasks) {
            total += task.getTaskDuration();
        }

        assertEquals(89, total, "Total hours should be 89 for the given task durations");
    }
    
}
