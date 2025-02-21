/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Utilites;

import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Saeed.Deliveryrunner;
import com.mycompany.assignmentjava.Zakwaan.Classes.Customer;
import com.mycompany.assignmentjava.Zakwaan.Classes.Order;
import com.mycompany.assignmentjava.Zakwaan.Classes.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zechn
 */
public class ObjectWriter {
    
    //get customer by id
    public static Customer getCustomerByID(String customerID){
        List<String> record = FileManager.searchRecords(FileManager.FileType.USERS, "userID", customerID);
        String line = record.get(0);
        String[] attributes = line.split(FileManager.DELIMITER);
        String rID = attributes[0];
        String rName = attributes[1];
        String rEmail = attributes[2];
        String rPhone = attributes[3];
        String rPassword = attributes[4];
        String rRole = attributes[5];
        String rStatus = attributes[6];
        String rAddress = attributes[7];
        String rBalance = attributes[8];
        Customer customer = new Customer(rID, rName, rEmail, rPhone, rPassword, rAddress);
        
        return customer;
    }
    
    public static Deliveryrunner getDeliveryrunnerByID(String runnerID){
        List<String> record = FileManager.searchRecords(FileManager.FileType.USERS, "userID", runnerID);
        String line = record.get(0);
        String[] attributes = line.split(FileManager.DELIMITER);
        String rID = attributes[0];
        String rName = attributes[1];
        String rEmail = attributes[2];
        String rPhone = attributes[3];
        String rPassword = attributes[4];
        String rRole = attributes[5];
        String rStatus = attributes[6];
        String rAddress = attributes[7];
        String rBalance = attributes[8];
        
        Deliveryrunner runner = new Deliveryrunner(rID, rName, rEmail,rPhone, rPassword);
        return runner;
    }
    
    public static Vendor getVendorByID(String vendorID){
        List<String> record = FileManager.searchRecords(FileManager.FileType.USERS, "userID", vendorID);
        String line = record.get(0);
        String[] attributes = line.split(FileManager.DELIMITER);
        String rID = attributes[0];
        String rName = attributes[1];
        String rEmail = attributes[2];
        String rPhone = attributes[3];
        String rPassword = attributes[4];
        String rRole = attributes[5];
        String rStatus = attributes[6];
        String rAddress = attributes[7];
        String rBalance = attributes[8];
        
        Vendor vendor = new Vendor(rID, rName, rEmail,rPhone, rPassword, rRole);
        return vendor;
    }
    
    public static Product getProductByID(String productID){
        List<String> record = FileManager.searchRecords(FileManager.FileType.PRODUCTS, "productID", productID);
        String line = record.get(0);
        String[] attributes = line.split(FileManager.DELIMITER);
        String rProductID = attributes[0];
        String rVendorID = attributes[1];
        String rProductName = attributes[2];
        String rPrice = attributes[3];
        
        Product product = new Product(rProductID, rVendorID, rProductName, Double.parseDouble(rPrice));
        return product;
    }
    
//    public static Order getOrderByID(String orderID){
//        
//    }
    
    public static List<Vendor> getAllVendors(){
        List<Vendor> vendorObjects = new ArrayList<>();
        List<String> records = FileManager.searchRecords(FileManager.FileType.USERS, "role", "Vendor");
        
        for (String record : records){
            String[] attributes = record.split(FileManager.DELIMITER);
            String rID = attributes[0];
            String rName = attributes[1];
            String rEmail = attributes[2];
            String rPhone = attributes[3];
            String rPassword = attributes[4];
            String rRole = attributes[5];
            
            Vendor vendor = new Vendor(rID, rName, rEmail,rPhone, rPassword, rRole);
            vendorObjects.add(vendor);
        }  
        return vendorObjects;
    }
    
    public static List<Deliveryrunner> getAllRunners(){
        List<Deliveryrunner> runnerObjects = new ArrayList<>();
        List<String> records = FileManager.searchRecords(FileManager.FileType.USERS, "role", "Runner");
        
        for (String record : records){
            String[] attributes = record.split(FileManager.DELIMITER);
            String rID = attributes[0];
            String rName = attributes[1];
            String rEmail = attributes[2];
            String rPhone = attributes[3];
            String rPassword = attributes[4];
            String rRole = attributes[5];
            
            Deliveryrunner runner = new Deliveryrunner(rID, rName, rEmail,rPhone, rPassword, rRole);
            runnerObjects.add(runner);
        }  
        return runnerObjects;
    public static Order getOrderByID(String orderID){
        
        return null;
        
    }
}

