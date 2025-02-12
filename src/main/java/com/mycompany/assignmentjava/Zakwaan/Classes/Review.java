/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import java.time.LocalDateTime;

/**
 *
 * @author zechn
 */
public class Review {
    private String reviewID;
    private Customer customer;
    private Runner runner;
    private Order order;
    private Vendor vendor;
    private String reviewText;
    private int rating;
    private LocalDateTime date;
    
    //normal constructor
    public Review(Customer customer, Runner runner, Order order, Vendor vendor, String reviewText, int rating){
        //implementation
    }
    
    //constructor because I dont know how runner and vendor is going to be implemented
    public Review(Order order, String reviewText, int rating){
        //implementation
    }
    
    //constructor just in case 
    public Review(String orderID, String reviewText, int rating){
        //implementation
    }
}
