/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Utilites;

import com.mycompany.assignmentjava.Zakwaan.Classes.Customer;
import com.mycompany.assignmentjava.Zakwaan.Classes.Order;
import com.mycompany.assignmentjava.Zakwaan.Classes.Review;
import com.mycompany.assignmentjava.Zakwaan.Classes.Ticket;
import com.mycompany.assignmentjava.Zakwaan.Classes.Transaction;

/**
 *
 * @author zechn
 */
public class ObjectToFileUpdater {
    //Needed a class that speeds up updating files
    
    //Need to update files corresponding to these classes:
    //Customer - users.txt
    public static void updateCustomerInUsersTxt(Customer customer, String txtFileHeaderName, String newValue){
        FileManager.updateSingleFieldWithoutIndex(FileManager.FileType.USERS, customer.getCustomerID(), 
                                                    txtFileHeaderName, newValue);
    }
    //Order - orders.txt
    public static void updateOrderInOrdersTxt(Order order, String txtFileHeaderName, String newValue){
        FileManager.updateSingleFieldWithoutIndex(FileManager.FileType.ORDERS, order.getOrderID(), 
                                                    txtFileHeaderName, newValue);
    }
    //Review - reviews.txt
    public static void updateReviewInReviewsTxt(Review review, String txtFileHeaderName, String newValue){
        FileManager.updateSingleFieldWithoutIndex(FileManager.FileType.REVIEWS, review.getReviewID(), 
                                                    txtFileHeaderName, newValue);
    }
    //Transaction - transactions.txt
    public static void updateTransactionInTransactionsTxt(Transaction transaction, String txtFileHeaderName, String newValue){
        FileManager.updateSingleFieldWithoutIndex(FileManager.FileType.TRANSACTIONS, transaction.getTransactionID(),
                                                    txtFileHeaderName, newValue);
    }
    //Ticket - tickets.
    public static void updateTicketInTicketsTxt(Ticket ticket, String txtFileHeaderName, String newValue){
        FileManager.updateSingleFieldWithoutIndex(FileManager.FileType.TICKETS, ticket.getTicketID(),
                                                    txtFileHeaderName, newValue);
    }
}
