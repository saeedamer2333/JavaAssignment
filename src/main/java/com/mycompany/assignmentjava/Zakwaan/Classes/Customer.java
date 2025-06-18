/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.Utilites.FileManager;
import com.mycompany.assignmentjava.Utilites.ObjectToFileUpdater;
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
    public CustomerCart customerCart;
    
    //Brand new Customer
    public Customer(String name, String email, String phone, String password, String address){
        super(name, email, phone, password, "Customer");
        
        this.address = address;
        this.balance = 0;
        
        FileManager.addCustomer(this.name, this.email, this.phone, this.password, 
                                this.role, this.address, this.balance);
        
        CustomerCart newCustomerCart = new CustomerCart(this);
        this.customerCart = newCustomerCart;
    }
    //new customer object from record that already exists
    public Customer(String customerID, String name, String email, String phone, String password, String address){
        super(customerID, name, email, phone, password, "Customer");
        
        this.address = address;
        this.balance = 0;
        
        CustomerCart newCustomerCart = new CustomerCart(this);
        this.customerCart = newCustomerCart;
    }
    
    //-------Getters and setteres-------
    //customerID
    public String getCustomerID(){
        return this.userID;
    }
    
    public void setCustomerID(String userID){
        this.userID = userID;
        ObjectToFileUpdater.updateCustomerInUsersTxt(this, "userID", userID);
    }
    
    //Address
    public String getAddress(){
        return this.address;
    }
    
    public void setAddress(String address){
        this.address = address;
        ObjectToFileUpdater.updateCustomerInUsersTxt(this, "address", address);
    }
    
    //Balance
      public double getBalance(){
        return this.balance;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
        ObjectToFileUpdater.updateCustomerInUsersTxt(this, "balance", Double.toString(balance));
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
        //improve with loadAll method from ObjectWriter
    }
    
    // for getting the customer review history
    public Review[] getReviewHistory(){
        List<String> customerReviews = FileManager.searchRecords(FileManager.FileType.REVIEWS, "customerID", this.userID);
        return customerReviews.toArray(new Review[customerReviews.size()]);
        //improve with loadAll method from ObjectWriter
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
