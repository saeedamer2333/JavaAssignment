/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Utilites;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author zechn
 */
public class Notification {
    private String notificationID;
    private String userID;
    private String message;
    private boolean isRead;

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
    
    
    //These two functions depends on Notification file/static storage attribute decision
    //public List<Notification> listUserNotifications(String userID){}
    
    //public void deleteNotification(String notificationID){}
    
    
}

