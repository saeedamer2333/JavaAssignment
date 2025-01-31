/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Utilites;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author zechn
 */
public class Notification {
    private String notificationID;
    private String userID;
    private String message;
    private LocalDateTime timestamp;
    private boolean isRead;
    
    //--------Constructor--------
    Notification(String userID, String message){
        //get current date and time
        LocalDateTime rTimestamp = LocalDateTime.now();
        
        this.notificationID = "NID" + FileManager.generateID();
        this.userID = userID;
        this.message = message;
        this.timestamp = rTimestamp;
        this.isRead = false;
        
        FileManager.addNotification(this.notificationID, this.userID, this.message, this.timestamp, this.isRead);
    }
    
    //notificationRecord = one line from notifications.txt
    //constructor to directly read lines
    Notification(String notificationRecord){
        //Split notificationRecord into headers
        String[] splitNotificationRecord = notificationRecord.split(FileManager.DELIMITER);
        //Headers
        var rNotificationID = splitNotificationRecord[0];
        var rUserID = splitNotificationRecord[1];
        var rMessage = splitNotificationRecord[2];
        var rTimestamp = splitNotificationRecord[3];
        var rIsRead = splitNotificationRecord[4];
        
        //Convert timestamp from String to LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime convertedTimestamp = LocalDateTime.parse(rTimestamp, formatter);
        
        //Convert isRead from String to boolean
        boolean convertedIsRead = Boolean.parseBoolean(rIsRead);
        
        this.notificationID = rNotificationID;
        this.userID = rUserID;
        this.message = rMessage;
        this.timestamp = convertedTimestamp;
        this.isRead = convertedIsRead;
    }
    
    //--------Getters and Setters--------
    
    // Getter and Setter for notificationID
    public String getNotificationID() {
        return notificationID;
    }
    public void setNotificationID(String notificationID) {
        this.notificationID = notificationID;
    }
    
    // Getter and Setter for userID
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    // Getter and Setter for message
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter and Setter for isRead
    public boolean isRead() {
        return isRead;
    }
    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }
    
    //--------Methods--------
    
    public void markAsRead(){
        this.isRead = true;
    }
    
    public static Notification sendNewNotification(String userID, String message){
        if (userID == null || userID.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty.");
        }
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty.");
        }

        try {
            // Initialize the notification object
            Notification notification = new Notification(userID, message);

            return notification;
        } catch (Exception e) {
            // Handle unexpected exceptions
            System.err.println("Error while sending notification: " + e.getMessage());
            throw new RuntimeException("Failed to send notification. Please try again.");
        }
    }
    
    public static List<Notification> listUserNotifications(String userID){
        List<Notification> userNotifications = new ArrayList<>();
        
        //get list of all notifications belonging to userID in notifications.txt
        List<String> notificationRecords =  FileManager.searchRecords(FileManager.FileType.NOTIFICATIONS, "userID", userID);
        
        //for each notification record create a notification object
        for (String notificationRecord : notificationRecords){
            Notification notification = new Notification(notificationRecord);
            userNotifications.add(notification);
        }
        
        return userNotifications;
    }
    
    public static boolean hasNewNotification(String userID) {
        // Get the list of all notifications belonging to the userID
        List<String> notificationRecords = FileManager.searchRecords(FileManager.FileType.NOTIFICATIONS, "userID", userID);

        // Check each record to see if it has an unread notification
        for (String record : notificationRecords) {
            String[] parts = record.split(FileManager.DELIMITER);
            if (parts.length >= 5) { // Ensure the record has all fields
                String isRead = parts[4]; // The "isRead" field
                if (isRead.equalsIgnoreCase("false")) {
                    return true; // Found at least one unread notification
                }
            }
        }
    
        return false; // No unread notifications
    }

    
}

