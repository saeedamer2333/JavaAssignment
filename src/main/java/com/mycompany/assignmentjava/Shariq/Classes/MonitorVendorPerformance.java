/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Shariq.Classes;

import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Shariq.UI.ManagerRevenueDashboardJFrame;
import com.mycompany.assignmentjava.Utilites.FileManager;
import static com.mycompany.assignmentjava.Utilites.FileManager.showErrorDialog;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author ysssh
 */
public class MonitorVendorPerformance{
    Manager manager;
    
    // TODO: private VendorList;    
    
    public MonitorVendorPerformance(Manager manager){
        this.manager = manager;
    }
    
    
// ==============================================
// =   METHODS                                  =
// ==============================================
    // launches JFrame
    //TODO i can make this into a interface or something called Jobs
    public void launchJFrame(){
        ManagerRevenueDashboardJFrame revenueDashboardForm = new ManagerRevenueDashboardJFrame(manager);
        revenueDashboardForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        revenueDashboardForm.setVisible(true);
    }
    
    // finds total revenue
    public float calcTotalRevenue(){
        
        List<String> records = FileManager.searchRecords(FileManager.FileType.TRANSACTIONS, "paymentStatus", "Completed"); // Only count completed payments
        double totalRevenue = 0.0;

        if (records.isEmpty()) {
            showErrorDialog("No completed transactions found.");
            return (float) totalRevenue;
        }

        for (String record : records) {
            String[] parts = record.split(FileManager.DELIMITER);
            if (parts.length > 3) { // Ensure amount column exists
                try {
                    totalRevenue += Double.parseDouble(parts[3]); // Extract amount
                } catch (NumberFormatException e) {
                    showErrorDialog("Invalid number format in amount column: " + parts[3]);
                }
            }
    }
    return (float) totalRevenue;
}    
    
    //finds total orders
    public int calcTotalOrders(){
        List<String> records = FileManager.getAllRecords(FileManager.FileType.ORDERS); // Get all orders
       return records.size(); // Return the total number of orders

    }
    
    //finds average order value
    public float calcAvgOrderValue(){
        float totalRevenue = calcTotalRevenue();
        int totalOrders = calcTotalOrders();
        return totalRevenue/totalOrders;
    }
    
    //selects Vendor
    
    
    //finds total orders of vendor
    public int calcTotalOrdersOfVendor(Vendor vendor){
        
    }
}

