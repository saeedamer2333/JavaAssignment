/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Saeed.Deliveryrunner;
import com.mycompany.assignmentjava.Utilites.FileManager;
import com.mycompany.assignmentjava.Utilites.ObjectWriter;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author zechn
 */
public class Review {
    private String reviewID;
    private String customerID;
    private Customer customer;
    private String runnerID;
    private Deliveryrunner runner;
    private String orderID;
    private Order order;
    private String vendorID;
    private Vendor vendor;
    private String reviewText;
    private int rating;
    private Date date;
    
    //Constructors
    //Brand new review with ID generation
    public Review(String customerID, String runnerID, String orderID, 
                    String vendorID, String reviewText, int rating){
        //implementation
        this.reviewID = "RID" + FileManager.generateID();
        this.customerID = customerID;
        this.customer = ObjectWriter.getCustomerByID(customerID);
        this.runnerID = runnerID;
        this.runner = ObjectWriter.getDeliveryrunnerByID(runnerID);
        this.orderID = orderID;
        this.order = ObjectWriter.getOrderByID(orderID);
        this.vendorID = vendorID;
        this.vendor = ObjectWriter.getVendorByID(vendorID);
        this.reviewText = reviewText;
        this.rating = rating;
        this.date = new Date();
        
        FileManager.addReview(this.reviewID, this.customerID, this.runnerID,
                                this.orderID, this.vendorID, this.reviewText,
                                this.rating, this.date);
    }
    
    //Constructor for reading all the details from the text file, can only work paired with ObjectWriter class
    //+since that handles the object assignment there
    public Review(String reviewID, String customerID, Customer customer, String runnerID, Deliveryrunner runner, 
              String orderID, Order order, String vendorID, Vendor vendor, String reviewText, int rating, Date date) {
        this.reviewID = reviewID;
        this.customerID = customerID;
        this.customer = customer;
        this.runnerID = runnerID;
        this.runner = runner;
        this.orderID = orderID;
        this.order = order;
        this.vendorID = vendorID;
        this.vendor = vendor;
        this.reviewText = reviewText;
        this.rating = rating;
        this.date = date;
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
       // return runner;
        return null;
       // return runner;
    }

    public void setRunner(Deliveryrunner runner) {
        //this.runner = runner;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Vendor getVendor() {
        //return vendor;
        return null;
        //return vendor;
    }

    public void setVendor(Vendor vendor) {
        //this.vendor = vendor;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
