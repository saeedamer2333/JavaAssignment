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
        
        // Components (specific responsibilites)
        this.monitorVendorPerformance = new MonitorVendorPerformance(Manager.this); 
        this.monitorRunnerPerformance = new MonitorRunnerPerformance(Manager.this);
        this.manageVendorListings = new ManageVendorListings(Manager.this);
        this.manageCustomerComplaints = new ManageCustomerComplaints(Manager.this);
        
    }
    
    //needed this thanks :) - zakwaan
    public Manager (String managerID, String name, String email, String phone, 
                    String password, String role){
        super(managerID, name, email, phone, password, role);
    }
    
// ==============================================
// =   GETTERS                                  =
// ==============================================
    public String getManagerID(){
        return this.userID;
    }
    
}
