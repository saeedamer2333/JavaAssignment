/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Saeed;

import com.mycompany.assignmentjava.Utilites.User;
import com.mycompany.assignmentjava.Utilites.FileManager;
import static com.mycompany.assignmentjava.Utilites.FileManager.showErrorDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class Deliveryrunner extends User {
    protected String orderID;
    protected String  runnerid;
    private static ScheduledExecutorService executor;
    private static boolean runnerAssigned = false;
   
    public Deliveryrunner(String runnerid,String name, String email, String phone, String password, String role) {
        
        super(name, email, phone, password, "Runner");
        this.runnerid = runnerid;
        
    }
    //needed this constructor for something thanks :) -zakwaan
    public Deliveryrunner(String runnerid,String name, String email, String phone, String password) {
        
        super(runnerid, name, email, phone, password, "Runner");
        this.runnerid = runnerid;
        
    }
    
    public Deliveryrunner() {
        // Call the parent class constructor with default or empty values
        super("Default Name", "default@email.com", "0000000000", "defaultPassword", "Runner");
        // Initialize the runnerid with a default value or null
}
    
    public String getRunnerID() {
        return this.userID;
    }
    
    
    
    
    
    
  public static List<String[]> getTask(String runnerID) {
    List<String[]> results = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("data/orders.txt"))) { 
        String header = reader.readLine();  // Read the header
        String[] headers = header.split(",");  // Assuming ';;' is your delimiter

        // Identifying indices for the required columns
        List<Integer> extractIndices = new ArrayList<>();
        String[] columnsToExtract = {"orderID","customerName", "vendorName", "products", "status", "address","deliveryfees", "totalAmount", "OrderDate"};

        for (int i = 0; i < headers.length; i++) {
            // Identify columns to extract
            for (String col : columnsToExtract) {
                if (headers[i].equalsIgnoreCase(col)) {
                    extractIndices.add(i);
                }
            }
        }

        // Ensure the necessary columns are found
        if (extractIndices.isEmpty()) {
            showErrorDialog("Missing required column(s) in the file.");
            return results;
        }

        // Reading the records and applying the filters
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";;");

            // Check if the runnerID and status match the conditions
            String status = parts[8]; 
            String runner = parts[5]; 

            // Updated condition: runnerID matches, and status is either "delivered" or "decline" but not "Waiting for Delivery"
            if (runner.equalsIgnoreCase(runnerID) &&
                 ((!status.equalsIgnoreCase("delivered") && !status.equalsIgnoreCase("decline"))
                    && !status.equalsIgnoreCase("Waiting for Delivery"))) {

                // Extract the specified columns
                String[] extractedData = new String[extractIndices.size()];
                for (int i = 0; i < extractIndices.size(); i++) {
                    extractedData[i] = parts[extractIndices.get(i)];
                }
                results.add(extractedData);
            }
        }
    } catch (IOException e) {
        showErrorDialog("Error searching records: " + e.getMessage());
    }
    return results;
}
   
  
  
  
  
  
  
  
  
  
  
  
  // retrive history data from order.txt
  public static List<String[]> getHistory(String runnerID) {
    List<String[]> results = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("data/orders.txt"))) { 
        String header = reader.readLine();  // Read the header
        String[] headers = header.split(",");  // Assuming ';;' is your delimiter

        // Identifying indices for the required columns
        List<Integer> extractIndices = new ArrayList<>();
        String[] columnsToExtract = {"customerName", "vendorName", "products", "status", "address","deliveryfees", "totalAmount", "OrderDate"};

        for (int i = 0; i < headers.length; i++) {
            // Identify columns to extract
            for (String col : columnsToExtract) {
                if (headers[i].equalsIgnoreCase(col)) {
                    extractIndices.add(i);
                }
            }
        }

        // Ensure the necessary columns are found
        if (extractIndices.isEmpty()) {
            showErrorDialog("Missing required column(s) in the file.");
            return results;
        }

        // Reading the records and applying the filters
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";;");

            // Check if the runnerID and status match the conditions
            String status = parts[8]; 
            String runner = parts[5]; 

            // Updated condition: runnerID matches, and status is either "delivered" or "decline" but not "Waiting for Delivery"
            if (runner.equalsIgnoreCase(runnerID) &&
                 ((status.equalsIgnoreCase("delivered") || status.equalsIgnoreCase("decline"))
                    && !status.equalsIgnoreCase("Waiting for Delivery"))) {

                // Extract the specified columns
                String[] extractedData = new String[extractIndices.size()];
                for (int i = 0; i < extractIndices.size(); i++) {
                    extractedData[i] = parts[extractIndices.get(i)];
                }
                results.add(extractedData);
            }
        }
    } catch (IOException e) {
        showErrorDialog("Error searching records: " + e.getMessage());
    }
    return results;
}

  
  public static List<String[]> getOrdersForRunner(String runnerID) {
    List<String[]> ordersForRunner = new ArrayList<>();
   
    try (BufferedReader reader = new BufferedReader(new FileReader("data/orders.txt"))) {
        String line;
        String header = reader.readLine(); // skip the header
     
        // Read through each line of orders
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";;");

            
            String[] assignedRunnerID = parts[5].split(",");  // The runnerID field (index 5) contains the assigned runner ID
           // String runnerStatus = parts[9]; // Assuming runnerStatus is in index 9
           
            for (String runner : assignedRunnerID) {
            if (runner.equals(runnerID) && "Waiting for Delivery".equalsIgnoreCase(parts[8])) {
        // Runner is assigned to this order
         String[] extractedOrder = {
                        parts[1],  // orderid (indx 1)
                        parts[2],  // customerName (index 2)
                        parts[4],  // vendorName (index 4)
                        parts[6],  // products (index 6)
                        parts[8],  // status (index 8)
                        parts[9], // address
                        parts[10], // deliveryfees (index 10)
                        parts[11], // totalAmount (index 11)
                        parts[12]  // OrderDate (index 12)
                    };

                    // Add the extracted order details to the list
                    ordersForRunner.add(extractedOrder);
         }
        }
        }
        // If no orders were found, handle accordingly
       

    } catch (IOException e) {
        showErrorDialog("Error reading orders file: " + e.getMessage());
    }
    return ordersForRunner;
} 
  
  
  
  


    public static void assignRunnerToOrder(String orderID, String customerID) {
        // Create an executor service to manage the timer
        executor = Executors.newSingleThreadScheduledExecutor();
        
        // This will run the task to notify the customer after 60 seconds if no runner accepts the order
        Runnable notifyCustomerTask = new Runnable() {
            @Override
            public void run() {
                // If no runner has been assigned after 60 seconds, notify the customer
                if (!runnerAssigned) {
                    try {
                        // Update order to remove the runnerID and mark the status as 'No Available Runners'
                        FileManager.updateSingleField(FileManager.FileType.ORDERS, orderID, "runnerID", "", 5);  // Clear the runnerID (index 5)
                        FileManager.updateSingleField(FileManager.FileType.ORDERS, orderID, "status", "No Available Runners", 8);  // Update status to "No Available Runners"
                        
                        // Notify the customer
                        String message = "No available runners for your order " + orderID + ". Please choose between Take-away or Dine-in.";
                        LocalDateTime timestamp = LocalDateTime.now();
                        FileManager.addNotification("ID" + FileManager.generateID(), customerID, message, timestamp, false);
                    } catch (Exception e) {
                        showErrorDialog("Error notifying customer or updating order: " + e.getMessage());
                    }
                }
            }
        };

        // Schedule the task to notify the customer after 60 seconds if no runner accepts
        executor.schedule(notifyCustomerTask, 60, TimeUnit.SECONDS);

        try (BufferedReader reader = new BufferedReader(new FileReader("data/users.txt"))) {
            String line;
            String header = reader.readLine(); // skip the header
            List<String> availableRunners = new ArrayList<>();

            // Collect available runners
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";;");

                // Check if the role is "Runner" and the status is "Available"
                if (parts.length >= 7 && "Runner".equalsIgnoreCase(parts[5]) && "Available".equalsIgnoreCase(parts[6])) {
                    availableRunners.add(parts[0]);  // Add the runner's ID to the list
                }else{
                    try {
                        // Update order to remove the runnerID and mark the status as 'No Available Runners'
                        FileManager.updateSingleField(FileManager.FileType.ORDERS, orderID, "runnerID", "", 5);  // Clear the runnerID (index 5)
                        FileManager.updateSingleField(FileManager.FileType.ORDERS, orderID, "status", "No Available Runners", 8);  // Update status to "No Available Runners"
                        
                        // Notify the customer
                        String message = "No available runners for your order " + orderID + ". Please choose between Take-away or Dine-in.";
                        LocalDateTime timestamp = LocalDateTime.now();
                        FileManager.addNotification("ID" + FileManager.generateID(), customerID, message, timestamp, false);
                    } catch (Exception e) {
                        showErrorDialog("Error notifying customer or updating order: " + e.getMessage());
                    }
                }
            }

            // Now, let's read the order data from orders.txt and check if the order status is "Waiting for Delivery"
            String orderLine = null;
            try (BufferedReader orderReader = new BufferedReader(new FileReader("data/orders.txt"))) {
                
                String skipheader = orderReader.readLine(); // skip the header
                
                while ((orderLine = orderReader.readLine()) != null) {
                    String[] orderParts = orderLine.split(";;");

                    // Check if this order's orderID matches the one we're assigning runners to
                    if (orderParts[0].equalsIgnoreCase(orderID)) {
                        // Check if the status is "Waiting for Delivery"
                        if ("Waiting for Delivery".equals(orderParts[8])) {  // Assuming status is in index 8
                            if (!availableRunners.isEmpty()) {
                                // Update the order with available runners' IDs in the runnerID field
                                String availableRunnersString = String.join(",", availableRunners);  // Convert list to comma-separated string
                                boolean updateSuccess = FileManager.updateSingleField(FileManager.FileType.ORDERS, orderID, "runnerID", availableRunnersString, 5);  // 5 is the index of runnerID field

                                if (updateSuccess) {
                                    runnerAssigned = true;  // Set flag to true once a runner is assigned
                                }
                            }
                        }
                    }
                    break;  // We found the order, no need to keep reading
                }
            }
        } catch (IOException e) {
            showErrorDialog("Error reading Users or Orders file: " + e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
      

    public static void acceptOrder(String orderID, String runnerID) {
        // Stop the 60-second timer as the runner has accepted the order
        executor.shutdown();  // Stops the executor (if the timer is running)
        // Now, update the runner status in the order to "Accepted"
        boolean updateSuccess = FileManager.updateSingleField(FileManager.FileType.ORDERS, orderID, "runnerStatus", "Accepted", 8); // Index 9 for `runnerStatus`
        if (updateSuccess) {
            // Update the order with the accepted runner's ID
            boolean updtaterunnid = FileManager.updateSingleField(FileManager.FileType.ORDERS, orderID, "runnerID", runnerID, 5);  // Assign runnerID to the order (index 5)
            if(updtaterunnid){
                // update the runner status to in-deliveried
                FileManager.updateSingleField(FileManager.FileType.USERS, runnerID, "status", "in-delivery", 6);
            
            
            }
            // Notify the customer that the runner has accepted
            String message = "Your order " + orderID + " has been accepted by runner " + runnerID + ". It is on its way!";
            LocalDateTime timestamp = LocalDateTime.now();
            FileManager.addNotification("ID" + FileManager.generateID(), orderID, message, timestamp, false);
            
           
        } else {
            showErrorDialog("Error accepting the order.");
        }
 }
    
    
    
    
    
    
    
    
    public static void rejectOrder(String orderID, String runnerID) {
    
    try {
        // Read the order file and update the runnerStatus to "Rejected"
        List<String> updatedLines = new ArrayList<>();
        boolean orderFound = false;
        boolean allRunnersRejected = true;  // To track if all runners reject
        String customerid = null;
        // Reading the order file and checking for the order
        try (BufferedReader readorder = new BufferedReader(new FileReader("data/orders.txt"))) {
            String line;
            String header = readorder.readLine(); // skipe the header
            while ((line = readorder.readLine()) != null) {
                String[] orderParts = line.split(";;");
                if (orderParts[0].equals(orderID)) {
                   
                   
                    // Remove the rejected runner from the runnerID list (index 5)
                    String updatedRunnerID = removeRunnerFromList(orderParts[5], runnerID);
                    line = line.replace(orderParts[5], updatedRunnerID); // Update runnerID field

                    // If after rejection, there are still other available runners
                    if (!updatedRunnerID.isEmpty()) {
                        allRunnersRejected = false;
                    }

                    orderFound = true;
                }
                updatedLines.add(line);
                customerid = orderParts[1];
            }
        }

        // If the order was found and successfully updated
        if (orderFound) {
            
            // Check if all runners rejected, if so, notify the customer
            if (allRunnersRejected) {
                String message = "Your order " + orderID + " was not accepted. Please choose between Take-away or Dine-in.";
                LocalDateTime timestamp = LocalDateTime.now();
                FileManager.addNotification("ID" + FileManager.generateID(), customerid, message, timestamp, false);

                // Show a rejection message dialog
                JOptionPane.showMessageDialog(null, "All runners have rejected your order.", "Order Rejected", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Order not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (IOException e) {
        // Catching exception and showing dialog in case of errors
        JOptionPane.showMessageDialog(null, "Error rejecting the order: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    
    
    
    
    
    public static void UpdateOrderStatus(String orderID, String selectedStatus,String runnerid){
     // Check if the selected status is valid
    boolean updateSuccess = false;

    if (selectedStatus.equalsIgnoreCase("Pick Up")) {
        // Update the status to "Pick Up"
        updateSuccess = FileManager.updateSingleField(
            FileManager.FileType.ORDERS, orderID, "Status", "Pick Up", 8);
        
    } else if (selectedStatus.equalsIgnoreCase("On the Way")) {
        // Update the status to "On the Way"
        updateSuccess = FileManager.updateSingleField(
            FileManager.FileType.ORDERS, orderID, "Status", "On the Way", 8);
        
    } else if (selectedStatus.equalsIgnoreCase("Delivered")) {
        // Update the status to "Delivered"
        updateSuccess = FileManager.updateSingleField(
            FileManager.FileType.ORDERS, orderID, "status", "Delivered", 8);
        
        updateSuccess = FileManager.updateSingleField(
            FileManager.FileType.USERS, runnerid, "status", "Delivered", 8);
        
        
    } else {
        // If the status is not valid
        JOptionPane.showMessageDialog(null, "Invalid Status selected.", "Error", JOptionPane.ERROR_MESSAGE);
        return;  // Exit the method if the status is invalid
    }

    // Check if the update was successful
    if (updateSuccess) {
        JOptionPane.showMessageDialog(null, "Order " + orderID + " status successfully updated.", "Status Update", JOptionPane.INFORMATION_MESSAGE);
    } 
    
    
    
    }
    
    
    
    
    

// Helper method to remove runnerID from the runnerID list
    private static String removeRunnerFromList(String currentRunners, String runnerIDToRemove) {
        // Split the current runners by comma
        String[] runners = currentRunners.split(",");
        List<String> runnersList = new ArrayList<>(Arrays.asList(runners));

        // Remove the runnerID from the list
        runnersList.remove(runnerIDToRemove);

        // Join the remaining runner IDs into a string and return
        return String.join(",", runnersList);
    }

    
    
    
    
    
    
    
    
    
     // Method to get revenue data based on date range
 public static List<String[]> getRevenueData(String dateRange, String runnerID) {
    List<String[]> orderDetails = new ArrayList<>();  // List to store the orders' details (date, revenue, order count)
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Adjust the date format to match yyyy-MM-dd


    // Variables to keep track of the total revenue and order count for each period
    double totalRevenue = 0.0;
    int orderCount = 0;

    // Track the last processed date or month/year to group the orders
    String lastPeriodKey = "";

    try (BufferedReader reader = new BufferedReader(new FileReader("data/orders.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] orderParts = line.split(";;");

            if (orderParts.length >= 13) {
                String orderDateStr = orderParts[12];  // Order Date
                String orderRunnerID = orderParts[5]; // Runner ID
                double deliveryFee = Double.parseDouble(orderParts[10]); // Delivery Fee
                String orderStatus = orderParts[8];

                // Only process orders that match the current runner and are delivered
                if (orderRunnerID.equals(runnerID) && "delivered".equalsIgnoreCase(orderStatus)) {
                    // Extract only the date part (yyyy-MM-dd)
                    String orderDateOnly = orderDateStr.split(" ")[0];  // Take only the date (yyyy-MM-dd)

                    // Now parse the date string (yyyy-MM-dd)
                    LocalDate orderDate = LocalDate.parse(orderDateOnly, dateFormatter);

                    // Calculate the key for grouping orders
                    String periodKey = "";
                    switch (dateRange) {
                        case "day" -> periodKey = orderDate.toString();  // Use exact date (yyyy-MM-dd)
                        case "month" -> periodKey = orderDate.getMonthValue() + "/" + orderDate.getYear();  // Month/Year (MM/yyyy)
                        case "year" -> periodKey = String.valueOf(orderDate.getYear());  // Year only
                        default -> {
                        }
                    }

                    // Check if we are still processing the same period (avoid repeating the same day, month, or year)
                    if (!periodKey.equals(lastPeriodKey)) {
                        // If this is not the first period, save the data for the last period
                        if (!lastPeriodKey.isEmpty()) {
                            orderDetails.add(new String[]{lastPeriodKey, String.valueOf(totalRevenue), String.valueOf(orderCount)});
                        }

                        // Reset the revenue and order count for the new period
                        totalRevenue = 0.0;
                        orderCount = 0;
                        lastPeriodKey = periodKey;
                    }

                    // Add revenue and increment order count for this period
                    totalRevenue += deliveryFee;
                    orderCount++;
                }
            }
        }

        // Add the last period to the list (after the loop ends)
        if (!lastPeriodKey.isEmpty()) {
            orderDetails.add(new String[]{lastPeriodKey, String.valueOf(totalRevenue), String.valueOf(orderCount)});
        }

    } catch (IOException e) {
        System.err.println("Error reading orders file: " + e.getMessage());
    }

    return orderDetails;  // Return the list of orders with date, revenue, and order count
}

    



    
}
