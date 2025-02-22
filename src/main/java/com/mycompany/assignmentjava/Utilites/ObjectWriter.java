/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Utilites;

import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Saeed.Deliveryrunner;
import com.mycompany.assignmentjava.Shariq.Classes.Manager;
import com.mycompany.assignmentjava.Zakwaan.Classes.Customer;
import com.mycompany.assignmentjava.Zakwaan.Classes.Order;
import com.mycompany.assignmentjava.Zakwaan.Classes.Product;
import com.mycompany.assignmentjava.Zakwaan.Classes.Review;
import com.mycompany.assignmentjava.Zakwaan.Classes.Ticket;
import com.mycompany.assignmentjava.Zakwaan.Classes.Transaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author zechn
 */
public class ObjectWriter {
    
    //-------GET BY ID'S
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
    
    public static Manager getManagerByID(String managerID){
        List<String> record = FileManager.searchRecords(FileManager.FileType.USERS, "userID", managerID);
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
        
        Manager manager = new Manager(rID, rName, rEmail, rPhone, rPassword, rRole);
        return manager;
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
    
    public static List<Product> getProductListByIDList(List<String> productIDList){
        List<Product> productList = new ArrayList<>();
        for (String productID : productIDList){
            Product product = getProductByID(productID);
            productList.add(product);
        }
        return productList;
    }
    
    public static List<String> getIDListByProductList(List<Product> productList){
        List<String> productIDList = new ArrayList<>();
        for (Product product : productList){
            productIDList.add(product.getProductID());
        }
        return productIDList;
    }
    
    public static Order getOrderByID(String orderID){
        List<String> record = FileManager.searchRecords(FileManager.FileType.ORDERS, "orderID", orderID);
        String line = record.get(0);
        //headers from txt file
        String[] attributes = line.split(FileManager.DELIMITER);
        String rOrderID = attributes[0];
        String rCustomerID = attributes[1];
        String rCustomerName = attributes[2];
        String rVendorID = attributes[3];
        String rVendorName = attributes[4];
        String rRunnerID = attributes[5];
        //convert products comma into a List<String>
        String rProductsComma = attributes[6];
        List<String> rProductIDList = Arrays.asList(rProductsComma.split(","));
        String rOrderType = attributes[7];
        String rStatus = attributes[8];
        String rAddress = attributes[9];
        String rDeliveryfees = attributes[10];
        String rTotalAmount = attributes[11];
        String rOrderDate = attributes[12];
        
        //objects
        Customer rCustomer = getCustomerByID(rCustomerID);
        Vendor rVendor = getVendorByID(rVendorID);
        Deliveryrunner rRunner = getDeliveryrunnerByID(rRunnerID);
        List<Product> rProductList = getProductListByIDList(rProductIDList);
        
        Order order = new Order(rOrderID, rCustomerID, rCustomerName, rCustomer,
                                rVendorID, rVendorName, rVendor, rRunnerID, rRunner,
                                rProductIDList, rProductList, rOrderType, rStatus,
                                rAddress, Double.parseDouble(rDeliveryfees), 
                                Double.parseDouble(rTotalAmount), 
                                DateConverter.stringToDate(rOrderDate));
        return order;
    }
    
    
    //-----GET HISTORY
    //Get the review history using CustomerID
    public List<Review> getReviewHistoryByCustomerID(String customerID){
        List<Review> reviewObjects = new ArrayList<>();
        List<String> records = FileManager.searchRecords(FileManager.FileType.REVIEWS, "customerID", customerID);
        
        for (String record : records){
            String[] attributes = record.split(FileManager.DELIMITER);
            String rReviewID = attributes[0];
            String rCustomerID = attributes[1];
            String rRunnerID = attributes[2];
            String rOrderID = attributes[3];
            String rVendorID = attributes[4];
            String rReviewText = attributes[5];
            String rRating = attributes[6];
            String rDate = attributes[7];
            
            Review review = new Review(rReviewID, rCustomerID, rRunnerID, rOrderID,
                                        rVendorID, rReviewText, Integer.parseInt(rRating),
                                        DateConverter.stringToDate(rDate));
            reviewObjects.add(review);
        }  
        return reviewObjects;
    }
    
    //get Ticket history using customerID
    public List<Ticket> getTicketHistoryByCustomerID(String customerID){
        List<Ticket> ticketObjects = new ArrayList<>();
        List<String> records = FileManager.searchRecords(FileManager.FileType.TICKETS, "customerID", customerID);
        
        for (String record : records){
            String[] attributes = record.split(FileManager.DELIMITER);
            String rTicketID = attributes[0];
            String rManagerID = attributes[1];
            String rCustomerID = attributes[2];
            String rCustomerComment = attributes[3];
            String rManagerReply = attributes[4];
            String rStatus = attributes[5];
            
            Ticket ticket = new Ticket(rTicketID, rManagerID, rCustomerID, 
                                        rCustomerComment, rManagerReply, rStatus);
            ticketObjects.add(ticket);
        }  
        return ticketObjects;
    }
    //get transaction history using customerID
    public List<Transaction> getTransactionHistoryByCustomerID(String customerID){
        List<Transaction> transactionObjects = new ArrayList<>();
        List<String> records = FileManager.searchRecords(FileManager.FileType.TRANSACTIONS, "customerID", customerID);
        
        for (String record : records){
            String[] attributes = record.split(FileManager.DELIMITER);
            String rTransactionID = attributes[0];
            String rOrderID = attributes[1];
            String rCustomerID = attributes[2];
            String rAmount = attributes[3];
            String rPaymentDate = attributes[4];
            String rPaymentStatus = attributes[5];
            String rReceiptGenerated = attributes[6];
            
            Transaction transaction = new Transaction(rTransactionID, rOrderID, 
                    rCustomerID, Double.parseDouble(rAmount), DateConverter.stringToDate(rPaymentDate), 
                    rPaymentStatus, Boolean.parseBoolean(rReceiptGenerated));
            transactionObjects.add(transaction);
        }  
        return transactionObjects;
    }
    
    
    
    //-----GET ALL
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
    }
}

