/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Utilites;

import java.time.LocalDateTime;

/**
 *
 * @author zechn
 */
public interface Notifiable {
    Notification sendNotification(String userID, String message, LocalDateTime timestamp);
    void showPopupNotification(String message);
}
