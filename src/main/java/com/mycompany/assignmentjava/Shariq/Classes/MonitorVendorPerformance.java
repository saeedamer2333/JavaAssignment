/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Shariq.Classes;

import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Shariq.UI.ManagerRevenueDashboardJFrame;
import com.mycompany.assignmentjava.Utilites.FileManager;
import static com.mycompany.assignmentjava.Utilites.FileManager.showErrorDialog;
import static com.mycompany.assignmentjava.Utilites.ObjectWriter.getAllVendors;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author ysssh
 */
public class MonitorVendorPerformance{
    Manager manager;
    private Vendor selectedVendor;
    private List<Vendor> vendorList;
     
    
    public MonitorVendorPerformance(Manager manager){
        this.manager = manager;   
    }
    
    public List<Vendor> getVendorList() {
        return this.vendorList;
    }
    
    public Vendor getSelectedVendor(){
        return this.selectedVendor;
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
        
    //returns list of  all Vendor names
    public List<String> listAllVendorNames(){
        List<String> vendorNames = new ArrayList<>();
        for (Vendor vendor : vendorList) {
            vendorNames.add(vendor.getName()); // Extract and add name to list
        }
        return vendorNames;
    }
    
    //loads list of all Vendor objects from file
    public void loadAllVendors(){
       this.vendorList = getAllVendors(); 
    }
    
    //sets selected Vendor object
    public void selectVendor(int index){
        this.selectedVendor = vendorList.get(index);
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
    
    //returns total orders
    public int calcTotalOrders(){
        List<String> records = FileManager.getAllRecords(FileManager.FileType.ORDERS); // Get all orders
       return records.size(); // Return the total number of orders

    }
    
    //returns average order value
    public float calcAvgOrderValue(){
        float totalRevenue = calcTotalRevenue();
        int totalOrders = calcTotalOrders();
        return totalRevenue/totalOrders;
    }
    
    
    //returns total orders of vendor
    public int calcTotalOrdersOfVendor(){
        if (this.selectedVendor == null) {
            return 0;
        }
        List<String> allOrders = FileManager.searchRecords(FileManager.FileType.ORDERS, "vendorID", this.selectedVendor.getVendorID());
        return allOrders.size(); 
    }
    
    public float calcTotalRevenueOfVendor(){
        if (this.selectedVendor == null) {
            return 0f;
        }
        //get all orders
        List<String> allOrders = FileManager.searchRecords(FileManager.FileType.ORDERS, "vendorID", this.selectedVendor.getVendorID());
        //add their total values!
        float totalAmount = 0.0f;
        for (String order : allOrders){
            String[] details = order.split(FileManager.DELIMITER);
            if (details.length > 10) { // Ensure amount column exists
                try {
                    totalAmount += Double.parseDouble(details[11]); // Extract amount
                } catch (NumberFormatException e) {
                    showErrorDialog("Invalid number format in amount column: " + details[11]);
                }
            }
        }
        return totalAmount;
        
    }
    
    public float calcAvgOrderValueOfVendor(){
        float totalRevenue = calcTotalRevenueOfVendor();
        float totalOrders = calcTotalOrdersOfVendor();
        return totalRevenue/totalOrders;
    }

    
}

