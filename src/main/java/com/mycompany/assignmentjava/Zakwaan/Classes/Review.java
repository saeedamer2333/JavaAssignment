/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Saeed.Deliveryrunner;
import com.mycompany.assignmentjava.Utilites.DateConverter;
import com.mycompany.assignmentjava.Utilites.FileManager;
import com.mycompany.assignmentjava.Utilites.ObjectToFileUpdater;
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
    public Review(String reviewID, String customerID, String runnerID, 
              String orderID, String vendorID, String reviewText, int rating, Date date) {
        this.reviewID = reviewID;
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
        this.date = date;
    }

    
    //Methods
    public Review[] getCustomerReviews(String customerID){
        //Object writer call
        return null;
    }
    
    //Getters and setters
    // Getters
    public String getReviewID() {
        return reviewID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getRunnerID() {
        return runnerID;
    }

    public Deliveryrunner getRunner() {
        return runner;
    }

    public String getOrderID() {
        return orderID;
    }

    public Order getOrder() {
        return order;
    }

    public String getVendorID() {
        return vendorID;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getRating() {
        return rating;
    }

    public Date getDate() {
        return date;
    }

    // Setters
    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
        ObjectToFileUpdater.updateReviewInReviewsTxt(this, "reviewID", reviewID);
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
        ObjectToFileUpdater.updateReviewInReviewsTxt(this, "customerID", customerID);
        
        //update customer object
        this.customer = ObjectWriter.getCustomerByID(customerID);
    }

    public void setRunnerID(String runnerID) {
        this.runnerID = runnerID;
        ObjectToFileUpdater.updateReviewInReviewsTxt(this, "runnerID", runnerID);
        
        //update Deliveryrunner object
        this.runner = ObjectWriter.getDeliveryrunnerByID(runnerID);
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
        ObjectToFileUpdater.updateReviewInReviewsTxt(this, "orderID", orderID);
        
        //update order object
        this.order = ObjectWriter.getOrderByID(orderID);
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
        ObjectToFileUpdater.updateReviewInReviewsTxt(this, "vendorID", vendorID);
        
        //update vendor object
        this.vendor = ObjectWriter.getVendorByID(vendorID);
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
        ObjectToFileUpdater.updateReviewInReviewsTxt(this, "reviewText", reviewText);
    }

    public void setRating(int rating) {
        this.rating = rating;
        ObjectToFileUpdater.updateReviewInReviewsTxt(this, "rating", Integer.toString(rating));
    }

    public void setDate(Date date) {
        this.date = date;
        ObjectToFileUpdater.updateReviewInReviewsTxt(this, "date", DateConverter.dateToString(date));
    }
    
}
