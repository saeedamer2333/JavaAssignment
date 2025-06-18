/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Shariq.Classes;

import com.mycompany.assignmentjava.Shariq.UI.ManagerComplaintsJFrame;
import com.mycompany.assignmentjava.Utilites.FileManager;
import static com.mycompany.assignmentjava.Utilites.FileManager.updateSingleField;
import com.mycompany.assignmentjava.Zakwaan.Classes.Ticket;
//import static com.mycompany.assignmentjava.Utilites.ObjectWriter.getAllTickets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author ysssh
 */
public class ManageCustomerComplaints {
    Manager manager;
    private Ticket selectedTicket;
    private List<Ticket> ticketList;
    
    public ManageCustomerComplaints(Manager manager){
        this.manager = manager;   
    }
    
    public List<Ticket> getTicketList(){
        return this.ticketList;
    }
        
    
// ==============================================
// =   METHODS                                  =
// ==============================================
    public void launchJFrame(){
        ManagerComplaintsJFrame customerComplaintsForm = new ManagerComplaintsJFrame(this.manager);
        customerComplaintsForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        customerComplaintsForm.setVisible(true);
    }
    
    //returns list of  all Vendor names
    public List<String> listAllTicketIDs(){
        List<String> ticketIDs = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            ticketIDs.add(ticket.getTicketID()); // Extract and add name to list
        }
        return ticketIDs;
    }
    
    public void loadAllTickets(){
//        this.ticketList = getAllTickets(); 
    }
    
    //view complaint
    public String viewComment(){
        return selectedTicket.getCustomerComment();
    }
    
    //reply to complaint
    public boolean replyTicket(String reply){
        try {
            return updateSingleField(FileManager.FileType.TICKETS, selectedTicket.getTicketID(), "managerReply", reply, 4);
        } catch (Exception e) {  
            return false;         // Indicate failure
        }
    }

    public void selectTicket(int index) {
        this.selectedTicket = ticketList.get(index);
    }
    
}


