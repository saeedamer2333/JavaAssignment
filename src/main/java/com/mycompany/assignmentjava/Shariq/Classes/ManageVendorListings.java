/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Shariq.Classes;

import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Shariq.UI.ManagerVendorListingsJFrame;
import com.mycompany.assignmentjava.Utilites.FileManager;
import static com.mycompany.assignmentjava.Utilites.ObjectWriter.getAllVendors;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author ysssh
 */
class ManageVendorListings {
    Manager manager;
    private Vendor selectedVendor;
    private List<Vendor> vendorList;
    
    public ManageVendorListings(){
        
    }
    
    public ManageVendorListings(Manager manager){
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
    public void launchJFrame(){
        // launches the Jframe
        ManagerVendorListingsJFrame vendorListingsForm = new ManagerVendorListingsJFrame();
        vendorListingsForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        vendorListingsForm.setVisible(true);
    }
    
    public void loadAllVendors(){
       this.vendorList = getAllVendors(); 
    }
    
    //returns list of  all Vendor names
    public List<String> listAllVendorNames(){
        List<String> vendorNames = new ArrayList<>();
        for (Vendor vendor : vendorList) {
            vendorNames.add(vendor.getName()); // Extract and add name to list
        }
        return vendorNames;
    }
    
    //sets selected Vendor object
    public void selectVendor(int index){
        this.selectedVendor = vendorList.get(index);
    }
    
    //view items of vendor
    public List<String> viewVendorItems(){
        List<String> vendorItems = new ArrayList<>();
        List<String> allItems = FileManager.searchRecords(FileManager.FileType.PRODUCTS, "vendor", this.selectedVendor.getVendorID());
        for (String order : allItems) {
            String[] details = order.split(FileManager.DELIMITER);
            vendorItems.add(details[0]);
        } 
        return vendorItems;
    }
    
    //remove items of vendor
    public void removeVendorItems(){
        
    }
}
