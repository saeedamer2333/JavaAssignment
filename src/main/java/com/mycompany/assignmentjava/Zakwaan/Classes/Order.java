/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Saeed.Deliveryrunner;
import com.mycompany.assignmentjava.Utilites.FileManager;
import com.mycompany.assignmentjava.Utilites.Notification;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zechn
 */
public class Order {
    private String orderID;
    private Customer customer;
    private Vendor vendor;
    private Deliveryrunner runner;
    private Product[] products; //products cannot be changed once order is placed
    private String orderType;
    private String status;
    private double totalAmount;
    //order statuses:
    /*
    - In the kitchen
    - On the way
    - Delivered
    - Served to table
    - Cancelled
    */
    
    
    //Constructors
    public Order(Customer customer, Vendor vendor, Product[] products, String orderType, double totalAmount){
        this.orderID = "OID" + FileManager.generateID();
        this.customer = customer;
        this.vendor = vendor;
        this.runner = null;
        this.products = products;
        this.orderType = orderType;
        this.status = "In the kitchen";
        this.totalAmount = totalAmount;
        
        List<String> productIDList = arrayToStringListProducts(this.products);
        String runnerID = "";
        
        FileManager.addOrder(this.orderID, this.customer.getCustomerID(), this.vendor.getVendorID(), 
                                runnerID, productIDList, this.orderType, this.status, this.totalAmount);
    }
    
    //----Methods
    //For Deliveryrunner
    public void acceptOrder(){
        
    }
    
    //calculating deliveryfees, we should have communicated about this saeeeeeeddddd
    //so maybe can have a fixed value
//    public double calculateDeliveryFees(){
//        
//    }
    
    //allocating a runner
    public void allocateRunner(Deliveryrunner runner){
        this.runner = runner;
    }
    
    //the transaction object will cancel the order
    public void cancelOrder(){
        notifyCustomer("Order was cancelled");
        this.status = "Cancelled";
    }
    
    public void updateOnTheWay(){
        notifyCustomer("Order is on the way!");
        this.status = "On the way";
    }
    
    public void updateDelivered(String customerID){
        notifyCustomer("Order was delivered");
        this.status = "Delivered";
    }
    
    //Helper methods
    public List<String> arrayToStringListProducts(Product[] products){
        List<String> productIDList = new ArrayList<String>();
        
        for (Product product : products){
            String productID = product.getProductID();
            productIDList.add(productID);
        }
        return productIDList;
    }
    
    //notifying customer
    public void notifyCustomer(String message){
        Notification notification = new Notification(this.customer.getCustomerID(), message);
    }
    
    
    //----Getters and setters
    // Getters
    public String getOrderID() {
        return orderID;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public Vendor getVendor() {
        return vendor;
    }
    
    public Deliveryrunner getRunner() {
        return runner;
    }
    
    public Product[] getProducts() {
        return products;
    }
    
    public String getOrderType() {
        return orderType;
    }
    
    public String getStatus() {
        return status;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    // Setters
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    
    public void setRunner(Deliveryrunner runner) {
        this.runner = runner;
    }
    
    public void setProducts(Product[] products) {
        this.products = products;
    }
    
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

