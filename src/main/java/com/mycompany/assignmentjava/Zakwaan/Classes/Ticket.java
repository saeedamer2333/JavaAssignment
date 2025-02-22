/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.Shariq.Classes.Manager;
import com.mycompany.assignmentjava.Utilites.FileManager;
import com.mycompany.assignmentjava.Utilites.ObjectToFileUpdater;
import com.mycompany.assignmentjava.Utilites.ObjectWriter;

/**
 *
 * @author zechn
 */
public class Ticket {
    private String ticketID;
    private String managerID;
    private Manager manager;
    private String customerID;
    private Customer customer;
    private String customerComment;
    private String managerReply;
    private String status;
    /*
    - Submitted
    - Resolved
    */
    
    //Constructors 
    // Constructor for brand new ticket
    public Ticket(String customerID, String customerComment){
        this.ticketID = "TID" + FileManager.generateID();
        this.managerID = "";
        this.manager = null;
        this.customerID = customerID;
        this.customer = ObjectWriter.getCustomerByID(customerID);
        this.customerComment = customerComment;
        this.managerReply = "";
        this.status = "Submitted";
        
        FileManager.addTicket(this.ticketID, this.managerID, this.customerID, 
                                this.customerComment, this.managerReply, this.status);
    }
    
    //Constructor for reading from txt file
    public Ticket(String ticketID, String managerID, String customerID, 
                    String customerComment, String managerReply, String status) {
    this.ticketID = ticketID;
    this.managerID = managerID;
    this.manager = ObjectWriter.getManagerByID(managerID);
    this.customerID = customerID;
    this.customer = ObjectWriter.getCustomerByID(customerID);
    this.customerComment = customerComment;
    this.managerReply = managerReply;
    this.status = status;
}
    
    //Getters and setters
    // Getters
    public String getTicketID() {
        return ticketID;
    }

    public String getManagerID() {
        return managerID;
    }

    public Manager getManager() {
        return manager;
    }

    public String getCustomerID() {
        return customerID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getCustomerComment() {
        return customerComment;
    }

    public String getManagerReply() {
        return managerReply;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
        ObjectToFileUpdater.updateTicketInTicketsTxt(this, "ticketID", ticketID);
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
        ObjectToFileUpdater.updateTicketInTicketsTxt(this, "managerID", managerID);
        
        //set manager agian
        this.manager = ObjectWriter.getManagerByID(managerID);
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
        ObjectToFileUpdater.updateTicketInTicketsTxt(this, "customerID", customerID);
        
        this.customer = ObjectWriter.getCustomerByID(customerID);
    }

    public void setCustomerComment(String customerComment) {
        this.customerComment = customerComment;
        ObjectToFileUpdater.updateTicketInTicketsTxt(this, "customerComment", customerComment);
    }

    public void setManagerReply(String managerReply) {
        this.managerReply = managerReply;
        ObjectToFileUpdater.updateTicketInTicketsTxt(this, "managerReply", managerReply);
    }

    public void setStatus(String status) {
        this.status = status;
        ObjectToFileUpdater.updateTicketInTicketsTxt(this, "status", status);
    }

}
