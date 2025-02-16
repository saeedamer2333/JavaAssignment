/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.Utilites.User;

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
    
    
}
