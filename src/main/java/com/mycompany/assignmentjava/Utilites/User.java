/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Utilites;
import static com.mycompany.assignmentjava.Utilites.FileManager.generateID;
import java.time.LocalDateTime;
import java.util.List;
import javax.security.auth.login.LoginException;

import javax.swing.JOptionPane;

/**
 *
 * @author zechn
 */
public abstract class User {
    protected String userID;
    private String name; 
    private String email;
    private String password;
    private String role;
    private String phone;

    
    // Constructor
    public User(String name, String email, String phone, String password, String role) {    
        this.userID = "UID" + generateID();
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;

        
    }
    
    // --------Getters and Setters--------
    
    // Getter and Setter for name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter and Setter for email
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Getter and Setter for password
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    // Getter and Setter for role
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    // --------Static Methods--------
    public static String[] login(String email, String password) throws LoginException {
        // Search for the user in the LOGIN file
        List<String> loginRecords = FileManager.searchRecords(FileManager.FileType.USERS, "email", email);

        if (loginRecords.isEmpty()) {
            throw new LoginException("Invalid email or password."); // Throw exception if email is not found
        }
        
        // Grab user details from USERS file using email
        List<String> userRecords = FileManager.searchRecords(FileManager.FileType.USERS, "email", email);

        // Parse the result and validate the password
        String loginRecord = loginRecords.get(0); // Assuming there's only one record per email
        String userRecord = userRecords.get(0);
        
        String[] loginDetails = loginRecord.split(FileManager.DELIMITER);
//
        System.out.println(loginDetails[4]);
        if (loginDetails.length < 3 || !loginDetails[4].equals(password)) {
            
            throw new LoginException("Invalid email or password."); // Throw exception if password is incorrect
        }
//        
        //construct userDetails from USERS file
        String[] userDetails = userRecord.split(FileManager.DELIMITER);

        // Upon successful login return userDetails
        return userDetails; // Return the details
    }
    
//    public static Notification sendNotification(String userID, String message){
//        
//    }


}

