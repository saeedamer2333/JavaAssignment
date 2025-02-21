/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Saeed.Deliveryrunner;
import com.mycompany.assignmentjava.Utilites.FileManager;
import com.mycompany.assignmentjava.Utilites.Notification;
import com.mycompany.assignmentjava.Utilites.ObjectToFileUpdater;
import com.mycompany.assignmentjava.Utilites.ObjectWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zechn
 */
public class Order {
    private String orderID;
    private String customerID;
    private String customerName;
    private Customer customer;
    private String vendorID;
    private String vendorName;
    private Vendor vendor;
    private String runnerID;
    private Deliveryrunner runner;
    private List<String> productIDList;
    private List<Product> productList;
    private String orderType;
    private String status;
    private String address;
    private double deliveryfees;
    private double totalAmount;
    private Date orderDate;
    //order statuses:
    /*
    - In the kitchen
    - On the way
    - Delivered
    - Served to table
    - Cancelled
    */
    
    
    //Constructors
    
    //Brand new order with ID generation
    public Order(String customerID, String vendorID,
                    List<String> productIDList, String orderType, double totalAmount){
        this.orderID = "OID" + FileManager.generateID();
        this.customerID = customerID;
        this.customer = ObjectWriter.getCustomerByID(customerID); //customerName would be here but need customer object to be assigned first
        this.customerName = this.customer.getName();
        this.vendorID = vendorID;
        this.vendor = ObjectWriter.getVendorByID(vendorID); //same as customerName these will be reordered properly when writing back into the file
        this.runnerID = ""; //runner is not allocated yet 
        this.runner = null; //runner not allocated yet
        this.productIDList = productIDList;
        this.productList = ObjectWriter.getProductListByIDList(productIDList);
        this.orderType = orderType;
        this.status = "In the kitchen";
        this.address = customer.getAddress();
        this.deliveryfees = 0;
        this.totalAmount = totalAmount;
        this.orderDate = new Date();
        
        FileManager.addOrder(this.orderID, this.customerID, this.customerName, this.vendor.getVendorID(),
                                this.vendorName, this.runnerID, this.productIDList,
                                this.orderType, this.status, this.address, this.deliveryfees, 
                                this.totalAmount, this.orderDate);
    }
    
    //----Methods
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
    //notifying customer
    public void notifyCustomer(String message){
        Notification notification = new Notification(this.customer.getCustomerID(), message);
    }
    
    
    //----Getters and setters
    //getters
    // Getters
    public String getOrderID() {
        return orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getVendorID() {
        return vendorID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public String getRunnerID() {
        return runnerID;
    }

    public Deliveryrunner getRunner() {
        return runner;
    }

    public List<String> getProductIDList() {
        return productIDList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public double getDeliveryfees() {
        return deliveryfees;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }
    
    // Setters
    public void setOrderID(String orderID) {
        this.orderID = orderID;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "orderID", orderID);
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "customerID", customerID);
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "customerName", customerName);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        // No ObjectToFileUpdater line for this one
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "vendorID", vendorID);
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "vendorName", vendorName);
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
        // No ObjectToFileUpdater line for this one
    }

    public void setRunnerID(String runnerID) {
        this.runnerID = runnerID;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "runnerID", runnerID);
    }

    public void setRunner(Deliveryrunner runner) {
        this.runner = runner;
        // No ObjectToFileUpdater line for this one
    }

    public void setProductIDList(List<String> productIDList) {
        this.productIDList = productIDList;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "products", String.join(",", productIDList));
        //productID's joined together by commas 
        //eg: product1,product2,product3,product4.....
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
        // No ObjectToFileUpdater line for this one
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "orderType", orderType);
    }

    public void setStatus(String status) {
        this.status = status;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "status", status);
    }

    public void setAddress(String address) {
        this.address = address;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "address", address);
    }

    public void setDeliveryfees(double deliveryfees) {
        this.deliveryfees = deliveryfees;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "deliveryfees", Double.toString(deliveryfees));
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "totalAmount", Double.toString(totalAmount));
    }

    public void setOrderDate(Date OrderDate) {
        this.orderDate = OrderDate;
        ObjectToFileUpdater.updateOrderInOrdersTxt(this, "OrderDate", FileManager.getDATE_FORMAT().format(orderDate));
    }

    
    
}

