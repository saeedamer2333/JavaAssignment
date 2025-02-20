/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.Utilites.FileManager;
import java.util.ArrayList;

/**
 *
 * @author zechn
 */
public class Order {
    private String orderID;
    private Customer customer;
    private Vendor vendor;
    private Deliveryrunner runner = null;
    private Product[] products; //products cannot be changed once order is placed
    private String orderType;
    private String status = "";
    private double totalAmount;
    //order statuses:
    /*
    - In the kitchen
    - On the way!
    - Delivered
    - Served to Table
    - Completed
    */
    
    
    //Constructors
    public Order(Customer customer, Vendor vendor, Product[] products, double totalAmount, String orderType){
        this.orderID = "OID" + FileManager.generateID();
        this.customer = customer;
        this.vendor = vendor;
        this.products = products;
        this.orderType = orderType;
    }
    
    //----Methods
    
    
    
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
    
    public List<Product> getProducts() {
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
    
    public void setProducts(List<Product> products) {
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

