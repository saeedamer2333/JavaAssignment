/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.Shariq.Classes.Manager;
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
    public Ticket(String customerID, String customerComment, 
                    String managerReply, String status){
        this.ticketID = "TID" + FileManager.generateID();
        //this.manager = manager;
        //this.customer = customer;
        this.customerComment = customerComment;
        this.managerReply = managerReply;
        this.status = status;
    }
    
    //Constructors for existing ticket
    public Ticket(String ticketID, String managerID, String customerID, String customerComment, 
                    String managerReply, String status){
        this.ticketID = ticketID;
        this.managerID = managerID;
        //this.customer = customer;
        this.customerComment = customerComment;
        this.managerReply = managerReply;
        this.status = status;
    }
    
    //Getters and setters
    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerComment() {
        return customerComment;
    }

    public void setCustomerComment(String customerComment) {
        this.customerComment = customerComment;
    }

    public String getManagerReply() {
        return managerReply;
    }

    public void setManagerReply(String managerReply) {
        this.managerReply = managerReply;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
