/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Saeed.Deliveryrunner;
import com.mycompany.assignmentjava.Utilites.FileManager;
import java.time.LocalDateTime;

/**
 *
 * @author zechn
 */
public class Review {
    private String reviewID;
    private Customer customer;
    private Deliveryrunner runner;
    private Order order;
    private Vendor vendor;
    private String reviewText;
    private int rating;
    private LocalDateTime date;
    
    //normal constructor
    public Review(Customer customer, Deliveryrunner runner, Order order, Vendor vendor, String reviewText, int rating){
        //implementation
        this.reviewID = FileManager.generateID();
        this.customer = customer;
        this.runner = runner;
        this.order = order;
        this.vendor = vendor;
        this.reviewText = reviewText;
        this.rating = rating;
        this.date = LocalDateTime.now();
        
        FileManager.addReview(this.reviewID, this.customer.getCustomerID(), this.runner.getRunnerID(), this.order.getOrderID(), 
                this.vendor.getVendorID(), this.reviewText, this.rating, this.date);
    }
    
    //Methods
    public Review[] getCustomerReviews(String customerID){
        //Object writer call
        return null;
    }
    
    //Getters and setters
    public String getReviewID() {
        return reviewID;
    }

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Deliveryrunner getRunner() {
        return runner;
    }

    public void setRunner(Deliveryrunner runner) {
        this.runner = runner;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
