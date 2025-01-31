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
    private String walletID;
    
    public Customer(String name, String email, String phone, String password, String address){
        super(name, email, phone, password, "Customer");
        
        this.address = address;
        this.walletID = ""; //new Wallet object
        String poo = "poo";
    }
    
}
