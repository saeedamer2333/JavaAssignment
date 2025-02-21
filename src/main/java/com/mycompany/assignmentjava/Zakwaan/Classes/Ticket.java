/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.Utilites.FileManager;

/**
 *
 * @author zechn
 */
public class Ticket {
    private String ticketID;
    private String managerID;
    //private Manager manager;
    private String customerID;
    private Customer customer;
    private String customerComment;
    private String managerReply;
    private String status = "Submitted";
    /*
    
    */
    
    //Constructors for new ticket
    public Ticket(/*Manager manager,*/String customerID, String customerComment, 
                    String managerReply, String status){
        this.ticketID = "TID" + FileManager.generateID();
        //this.manager = manager;
        this.customer = customer;
        this.customerComment = customerComment;
        this.managerReply = managerReply;
        this.status = status;
    }
}
