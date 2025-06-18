/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.Utilites.ObjectWriter;
import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Utilites.FileManager;
import com.mycompany.assignmentjava.Utilites.ObjectToFileUpdater;

/**
 *
 * @author zechn
 */
public class Product {
    private String productID;
    private String vendorID;
    private Vendor vendor;
    private String productName;
    private double price;
    
    //Constructor
    //Brand new product so new productID is generated
    public Product(String vendorID, String productName, double price){
        this.productID = "PID" + FileManager.generateID();
        this.vendorID = vendorID;
        this.vendor = ObjectWriter.getVendorByID(this.vendorID);
        this.productName = productName;
        this.price = price;
        
        FileManager.addProduct(productID, vendorID, productName, price);
    }
    //Constructor for constructing an existing entry in the text file
    public Product(String productID, String vendorID, String productName, double price){
        this.productID = productID;
        this.vendorID = vendorID;
        this.vendor = ObjectWriter.getVendorByID(this.vendorID);
        this.productName = productName;
        this.price = price;
    }
    
    // Getters
    public String getProductID() {
        return productID;
    }
    
    public String getVendorID() {
        return vendorID;
    }
    
    public Vendor getVendor(){
        return vendor;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Setters
    
    //Put the ObjectToFileUpdater stuff in here to update the file when these details are changed with setters
    public void setProductID(String productID) {
        this.productID = productID;
        ObjectToFileUpdater.updateProductInProductsTxt(this, "productID", productID);
    }
    
    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
        ObjectToFileUpdater.updateProductInProductsTxt(this, "vendorID", vendorID);
        this.vendor = ObjectWriter.getVendorByID(vendorID);
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
        ObjectToFileUpdater.updateProductInProductsTxt(this, "productName", productName);
    }
    
    public void setPrice(double price) {
        this.price = price;
        ObjectToFileUpdater.updateProductInProductsTxt(this, "price", Double.toString(price));
    }
}
