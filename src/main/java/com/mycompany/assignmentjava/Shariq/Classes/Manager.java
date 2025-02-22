/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Shariq.Classes;

import com.mycompany.assignmentjava.Shariq.UI.ManagerHomeJFrame;
import com.mycompany.assignmentjava.Utilites.FileManager;
import com.mycompany.assignmentjava.Utilites.User;

/**
 *
 * @author ysssh
 */
public class Manager extends User{
    
    public MonitorVendorPerformance monitorVendorPerformance;
    public MonitorRunnerPerformance monitorRunnerPerformance;
    public ManageVendorListings manageVendorListings;
    public ManageCustomerComplaints manageCustomerComplaints;
    
    
    public Manager (String id, String name, String email, String phone, String password) {
        super(id, name, email, phone, password, "Manager");
        
        
//        ManagerHomeJFrame piss = new ManagerHomeJFrame(Manager.this);
//        piss.setVisible(true);
        
        this.monitorVendorPerformance = new MonitorVendorPerformance(Manager.this); 
        this.monitorRunnerPerformance = new MonitorRunnerPerformance(Manager.this);
        this.manageVendorListings = new ManageVendorListings(Manager.this);
        this.manageCustomerComplaints = new ManageCustomerComplaints(Manager.this);
        
    }
    
    
// ==============================================
// =   GETTERS                                  =
// ==============================================
    public String getManagerID(){
        return this.userID;
    }

    
// ==============================================
// =   METHODS                                  =
// ==============================================
    
//    //initializes the vendor performance code 
//    public void monitorVendorPerformance() {
//        this.monitorVendorPerformance = new MonitorVendorPerformance(Manager.this);   
//        System.out.println("weird constructor: " + this.monitorRunnerPerformance);
//
//    }
//    //initializes runner feedback code
//    public void monitorRunnerPerformance() {
//        this.monitorRunnerPerformance = new MonitorRunnerPerformance();
//    }
//    //initializes vendor listings code
//    public void manageVendorListings(){
//        this.manageVendorListings = new ManageVendorListings();
//    }
//    //initializes customer complaints code
//    public void manageCustomerComplaints(){
//        this.manageCustomerComplaints = new ManageCustomerComplaints();
//    }
}
