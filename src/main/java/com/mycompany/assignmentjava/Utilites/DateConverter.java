/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Utilites;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author zechn
 */
public class DateConverter {

    // Method to convert String to Date
    public static Date stringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format");
            return null;
        }
    }

    // Method to convert Date to String
    public static String dateToString(Date date) {
        SimpleDateFormat formatter = FileManager.getDATE_FORMAT();
        return formatter.format(date);
    }
}
