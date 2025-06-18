/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Shariq.Classes;

import com.mycompany.assignmentjava.Saeed.Deliveryrunner;
import com.mycompany.assignmentjava.Shariq.UI.ManagerRunnerFeedbackJFrame;
import com.mycompany.assignmentjava.Utilites.FileManager;
import static com.mycompany.assignmentjava.Utilites.ObjectWriter.getAllRunners;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author ysssh
 */
public class MonitorRunnerPerformance {
    Manager manager;
    private Deliveryrunner selectedRunner;
    private List<Deliveryrunner> runnerList;

    public MonitorRunnerPerformance(Manager manager){
        this.manager = manager;
    }
    
    public List<Deliveryrunner> getRunnerList() {
        return this.runnerList;
    }
    
    public Deliveryrunner getSelectedVendor(){
        return this.selectedRunner;
    }    
    
// ==============================================
// =   METHODS                                  =
// ==============================================
    // launches JFrame
    public void launchJFrame(){
        ManagerRunnerFeedbackJFrame runnerFeedbackForm = new ManagerRunnerFeedbackJFrame(manager);
        runnerFeedbackForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        runnerFeedbackForm.setVisible(true);
    }
        
    //returns list of  all Vendor names
    public List<String> listAllRunnerNames(){
        List<String> runnerNames = new ArrayList<>();
        for (Deliveryrunner runner : runnerList) {
            runnerNames.add(runner.getName()); // Extract and add name to list
        }
        return runnerNames;
    }
    
    //loads list of all Vendor objects from file
    public void loadAllRunners(){
       this.runnerList = getAllRunners(); 
    }
    
    //sets selected Vendor object
    public void selectRunner(int index){
        this.selectedRunner = runnerList.get(index);
    }
    
    //load Runner info
    public List<String> getDeliveries(){
        List<String> runnerOrders = new ArrayList<>();
        List<String> allOrders = FileManager.searchRecords(FileManager.FileType.ORDERS, "runnerID", this.selectedRunner.getRunnerID());
        for (String order : allOrders) {
            String[] details = order.split(FileManager.DELIMITER);
            runnerOrders.add(details[0]);
        } 
        return runnerOrders;
    }

    
}
