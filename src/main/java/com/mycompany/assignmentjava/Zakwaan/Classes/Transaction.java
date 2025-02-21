/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.Utilites.FileManager;
import java.time.LocalDateTime;

/**
 *
 * @author zechn
 */
public class Transaction {
    //---------Attributes---------
    String transactionID;
    Order order;
    Customer customer;
    double amount;
    LocalDateTime paymentDate;
    String paymentStatus;
    boolean receiptGenerated = false;
    //Payment status options
//    Pending
//    Completed
//    Failed
//    Cancelled
    
    //transaction constructor for general usage
    public Transaction(Order order, Customer customer, double amount){
        this.transactionID = "TRID" + FileManager.generateID();
        this.order = order;
        this.customer = customer;
        this.amount = amount;
        this.paymentDate = LocalDateTime.now();
        this.paymentStatus = "Pending";
        
//        FileManager.addTransaction(this.transactionID, this.order.getOrderID(), 
//                this.customer.getCustomerID(), this.amount, this.paymentDate, this.paymentStatus, this.receiptGenerated);
    }
    
    // Transaction constructor with all attributes
    public Transaction(String transactionID, Order order, Customer customer, double amount, LocalDateTime paymentDate, String paymentStatus) {
        this.transactionID = transactionID;
        this.order = order;
        this.customer = customer;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        
//        FileManager.addTransaction(this.transactionID, this.order.getOrderID(), 
//            this.customer.getCustomerID(), this.amount, this.paymentDate, this.paymentStatus);
    }
    
    //---------Methods---------
    public void makePayment() throws InsufficientFundsException {
        //deduct the payment from customer wallet
        double paymentDeductable = this.customer.getBalance() - this.amount;
        //if not enough balance then throw an insufficient funds exception
        if (paymentDeductable < 0){
            throw new InsufficientFundsException("Insufficient Balance");
        }
        //update order status to completed
        //update transaction status to completed
    }
    
    public void refundPayment(){
        //get the order amount from the order object
        //add that amount to customer balance
        //set transaction status to Cancelled
        //set order status as cancelled
    }
    
    public String generateReceipt(){
        //better to just use getters for each attribute and link each attribute to a label or something
        //will have a separate design for receipt, constructor will accept a transaction object
        return null;
    }
    
    
    
    //---------Setters and Getters---------
    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomerID(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


}
