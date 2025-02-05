/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.Utilites.FileManager;
import com.mycompany.assignmentjava.Utilites.User;
import java.util.List;

/**
 *
 * @author zechn
 */
public class Customer extends User{
    //Attributes
    private String address;
    private double balance;
    
    public Customer(String name, String email, String phone, String password, String address){
        super(name, email, phone, password, "Customer");
        
        this.address = address;
        this.balance = 0;
    }
    
    //-------Getters and setteres-------
    //Address
    public String getAddress(){
        return this.address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    //Balance
      public double getBalance(){
        return this.balance;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    //-------Methods-------
    // will implement this once Order is implemented
//    public Order[] getOrderHistory(){
//        List<String> customerOrders = FileManager.searchRecords(FileManager.FileType.ORDERS, "customerID", this.userID);
//        return customerOrders.toArray(new Order[customerOrders.size()]);
//    }
    
    //for getting the customer transaction history
    public Transaction[] getTransactionHistory(){
        List<String> customerTransactions = FileManager.searchRecords(FileManager.FileType.TRANSACTIONS, "customerID", this.userID);
        return customerTransactions.toArray(new Transaction[customerTransactions.size()]);
    }
    
    // for getting the customer review history
    public Review[] getReviewHistory(){
        List<String> customerReviews = FileManager.searchRecords(FileManager.FileType.REVIEWS, "customerID", this.userID);
        return customerReviews.toArray(new Review[customerReviews.size()]);
    }
    
    //for add credit to the customer wallet
    public void addCredit(double amount){
        setBalance(this.balance+amount);
    }
    
    //deducting credit from the customer wallet
    public void deductCredit(double amount){
        setBalance(this.balance-amount);
    }
    
    //just another getter for the balance but under a more conventional name
    public double checkBalance(){
        return this.balance;
    }
}
