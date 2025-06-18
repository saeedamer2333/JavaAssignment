/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.Utilites.FileManager;
import com.mycompany.assignmentjava.Utilites.ObjectToFileUpdater;
import com.mycompany.assignmentjava.Utilites.ObjectWriter;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author zechn
 */
public class Transaction {
    //---------Attributes---------
    private String transactionID;
    private String orderID;
    private Order order;
    private String customerID;
    private Customer customer;
    private double amount;
    private Date paymentDate;
    private String paymentStatus;
    private boolean receiptGenerated;
    //Payment status options
//    Pending
//    Completed
//    Failed
//    Cancelled
    
    //brand new transaction constructor for general usage
    public Transaction(String orderID, String customerID, double amount){
        this.transactionID = "TRID" + FileManager.generateID();
        this.orderID = orderID;
        this.order = ObjectWriter.getOrderByID(orderID);
        this.customerID = customerID;
        this.customer = ObjectWriter.getCustomerByID(customerID);
        this.amount = amount;
        this.paymentDate = new Date();
        this.paymentStatus = "Pending";
        this.receiptGenerated = false;
        
        FileManager.addTransaction(this.transactionID, this.orderID, this.customerID, 
                                    this.amount, this.paymentDate, this.paymentStatus, 
                                    Boolean.toString(this.receiptGenerated));
    }
    
    // Transaction constructor with all attributes
    public Transaction(String transactionID, String orderID,String customerID, double amount, 
                        Date paymentDate, String paymentStatus, boolean receiptGenerated) {
        this.transactionID = transactionID;
        this.orderID = orderID;
        this.order = ObjectWriter.getOrderByID(orderID);
        this.customerID = customerID;
        this.customer = ObjectWriter.getCustomerByID(customerID);
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.receiptGenerated = receiptGenerated;
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
    // Getters
    public String getTransactionID() {
        return transactionID;
    }

    public String getOrderID() {
        return orderID;
    }

    public Order getOrder() {
        return order;
    }

    public String getCustomerID() {
        return customerID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public boolean isReceiptGenerated() {
        return receiptGenerated;
    }

    // Setters
    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
        ObjectToFileUpdater.updateTransactionInTransactionsTxt(this, "transactionID", transactionID);
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
        ObjectToFileUpdater.updateTransactionInTransactionsTxt(this, "orderID", orderID);
        
        this.order = ObjectWriter.getOrderByID(orderID);
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
        ObjectToFileUpdater.updateTransactionInTransactionsTxt(this, "customerID", customerID);
        
        this.customer = ObjectWriter.getCustomerByID(customerID);
    }

    public void setAmount(double amount) {
        this.amount = amount;
        ObjectToFileUpdater.updateTransactionInTransactionsTxt(this, "amount", String.valueOf(amount));
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
        ObjectToFileUpdater.updateTransactionInTransactionsTxt(this, "paymentDate", paymentDate.toString());
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
        ObjectToFileUpdater.updateTransactionInTransactionsTxt(this, "paymentStatus", paymentStatus);
    }

    public void setReceiptGenerated(boolean receiptGenerated) {
        this.receiptGenerated = receiptGenerated;
        ObjectToFileUpdater.updateTransactionInTransactionsTxt(this, "receiptGenerated", String.valueOf(receiptGenerated));
    }


}
