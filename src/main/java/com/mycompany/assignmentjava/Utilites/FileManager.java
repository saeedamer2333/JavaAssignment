package com.mycompany.assignmentjava.Utilites;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    private static final String BASE_PATH = "data/";
    public static final String DELIMITER = ";;";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final Random RANDOM = new Random();

    // ----------File names----------
    
    public enum FileType {
        USERS("users.txt"),
        TRANSACTIONS("transactions.txt"),
        ORDERS("orders.txt"),
        REVIEWS("reviews.txt"),
        PRODUCTS("products.txt"),
        TICKETS("tickets.txt"),
        NOTIFICATIONS("notifications.txt");

        private final String filename;

        FileType(String filename) {
            this.filename = filename;
        }

        public String getPath() {
            return BASE_PATH + filename;
        }
    }

    // ----------Initialize files with headers----------
    static {
<<<<<<< HEAD
        initializeFile(FileType.LOGIN, "email,password,role");
        initializeFile(FileType.USERS, "userID,name,email,phone,password,role,status");
=======
        initializeFile(FileType.USERS, "userID,name,email,phone,password,role");
>>>>>>> 4779e2def9c6ed53ef703abde0cd4fe428f29174
        initializeFile(FileType.TRANSACTIONS, "transactionID,orderID,customerID,amount,paymentDate,paymentStatus");
        initializeFile(FileType.ORDERS, "orderID,customerID,vendorID,runnerID,products,orderType,status,runnerStatus,deliveryfees,totalAmount,OrderDate");
        initializeFile(FileType.REVIEWS, "reviewID,customerID,runnerID,orderID,vendorID,reviewText,rating,date");
        initializeFile(FileType.PRODUCTS, "productID,vendorID,productName,price");
        initializeFile(FileType.TICKETS, "ticketID,managerID,customerID,customerComment,managerReply,status");
        initializeFile(FileType.NOTIFICATIONS, "notificationID,userID,message,timestamp,isRead");
    }

    private static void initializeFile(FileType fileType, String header) {
        File file = new File(fileType.getPath());
        if (!file.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(header);
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Error initializing file: " + fileType.getPath());
            }
        }
    }

    //----------More Utility----------
    // Generate 8-digit ID
    public static String generateID() {
        return String.format("%08d", RANDOM.nextInt(100000000));
    }

    // Display error in a dialog
    public static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }



<<<<<<< HEAD
        // Also add to login file
        String loginRecord = String.join(DELIMITER, email, password, role);

        return appendToFile(FileType.USERS, record) && appendToFile(FileType.LOGIN, loginRecord);
    }
    
    // Add user for deliveryrunner adding the status property 

   
     public static boolean addUser(String name, String email, String phone, String password, String role,String status) {
        if (!validateEmail(email)) {
            showErrorDialog("Invalid email format: " + email);
            return false;
        }
        if (!validatePassword(password)) {
            showErrorDialog("Password must be at least 8 characters long, contain uppercase, lowercase, and a number.");
            return false;
        }
        if (!validatePhone(phone)) {
            showErrorDialog("Invalid phone number: " + phone);
            return false;
        }

        String userID = "ID" + generateID();
        String record = String.join(DELIMITER, userID, name, email, phone, password, role,status);

        // Also add to login file
        String loginRecord = String.join(DELIMITER, email, password, role);

        return appendToFile(FileType.USERS, record) && appendToFile(FileType.LOGIN, loginRecord);
    }
    
    // Transaction methods
    public static boolean addTransaction(String orderID, String customerID,
                                         double amount, Date paymentDate, String paymentStatus) {
        if (amount <= 0) {
            showErrorDialog("Transaction amount must be greater than 0.");
            return false;
        }
        String transactionID = "ID" + generateID();
        String dateStr = DATE_FORMAT.format(paymentDate);
        String record = String.join(DELIMITER, transactionID, orderID, customerID,
                String.valueOf(amount), dateStr, paymentStatus);
        return appendToFile(FileType.TRANSACTIONS, record);
    }

    // Order management methods
    public static boolean addOrder(String customerID, String vendorID, String runnerID,
                                   List<String> products, String orderType, String status, double deliveryfees  ,double totalAmount, Date orderDate) {
        if (products.isEmpty()) {
            showErrorDialog("Order must contain at least one product.");
            return false;
        }
        if (totalAmount <= 0) {
            showErrorDialog("Total amount must be greater than 0.");
            return false;
        }
        String dateStrnOrder = DATE_FORMAT.format(orderDate);
        String orderID = "ID" + generateID();
        String productsStr = String.join("|", products);
        String record = String.join(DELIMITER, orderID, customerID, vendorID, runnerID,
                productsStr, orderType, status,String.valueOf(deliveryfees) ,String.valueOf(totalAmount), dateStrnOrder);
        return appendToFile(FileType.ORDERS, record);
    }

    // Validation methods
=======
    // ----------Validation methods----------
>>>>>>> 4779e2def9c6ed53ef703abde0cd4fe428f29174
    private static boolean validateEmail(String email) {
        return email.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$");
    }

    private static boolean validatePassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$");
    }

    private static boolean validatePhone(String phone) {
        return phone.matches("^\\+?[0-9]{10,15}$");
    }

    
    //----------Generic File Append & Remove & Search----------
    // Generic file append method
    private static boolean appendToFile(FileType fileType, String record) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileType.getPath(), true))) {
            writer.write(record);
            writer.newLine();
            return true;
        } catch (IOException e) {
            showErrorDialog("Error writing to file: " + e.getMessage());
            return false;
        }
    }
    
    //searchKey = any header from the txt file
    // Search method
    public static List<String> searchRecords(FileType fileType, String searchKey, String searchValue) {
        List<String> results = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileType.getPath()))) {
            String header = reader.readLine();
            String[] headers = header.split(",");
            int index = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase(searchKey)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                showErrorDialog("Invalid search key: " + searchKey);
                return results;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                if (parts.length > index && parts[index].equalsIgnoreCase(searchValue)) {
                    results.add(line);
                }
            }
        } catch (IOException e) {
            showErrorDialog("Error searching records: " + e.getMessage());
        }
        return results;
    }

    //----------Appending .txt files----------
        // append users.txt and login.txt
    public static boolean addUser(String name, String email, String phone, String password, String role) {
        if (!validateEmail(email)) {
            showErrorDialog("Invalid email format: " + email);
            return false;
        }
        if (!validatePassword(password)) {
            showErrorDialog("Password must be at least 8 characters long, contain uppercase, lowercase, and a number.");
            return false;
        }
        if (!validatePhone(phone)) {
            showErrorDialog("Invalid phone number: " + phone);
            return false;
        }
           String userID= generateID();

        
        String record = String.join(DELIMITER, userID, name, email, phone, password, role);


        return appendToFile(FileType.USERS, record);
    }

    // Append transactions.txt
    public static boolean addTransaction(String transactionID, String orderID, String customerID,
                                         double amount, LocalDateTime paymentDate, String paymentStatus) {
        if (amount <= 0) {
            showErrorDialog("Transaction amount must be greater than 0.");
            return false;
        }

        // Convert LocalDateTime to String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateStr = paymentDate.format(formatter);
        
        String record = String.join(DELIMITER, transactionID, orderID, customerID,
                String.valueOf(amount), dateStr, paymentStatus);
        return appendToFile(FileType.TRANSACTIONS, record);
    }

    // Append orders.txt
    public static boolean addOrder(String orderID, String customerID, String vendorID, String runnerID,
                                   List<String> products, String orderType, String status, double totalAmount) {
        if (products.isEmpty()) {
            showErrorDialog("Order must contain at least one product.");
            return false;
        }
        if (totalAmount <= 0) {
            showErrorDialog("Total amount must be greater than 0.");
            return false;
        }
        
        String productsStr = String.join("|", products);
        String record = String.join(DELIMITER, orderID, customerID, vendorID, runnerID,
                productsStr, orderType, status, String.valueOf(totalAmount));
        return appendToFile(FileType.ORDERS, record);
    }
    
    //Appending reviews to reviews.txt
    public static boolean addReview(String reviewID, String customerID, String runnerID, String orderID, 
                                    String vendorID, String reviewText, int rating, LocalDateTime date){
        
        // Convert LocalDateTime to String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateStr = date.format(formatter);
        
        String record = String.join(DELIMITER, reviewID, customerID, runnerID, orderID,
                                    vendorID, reviewText, Integer.toString(rating), dateStr);
        
        return appendToFile(FileType.REVIEWS, record);
    }
    
    //Appending products to products.txt
    public static boolean addProduct(String productID, String vendorID, String productName, double price) {
        if (price <= 0) {
            showErrorDialog("Transaction amount must be greater than 0.");
            return false;
        }
        
        String record = String.join(DELIMITER, productID, vendorID, productName, Double.toString(price));
        
        return appendToFile(FileType.PRODUCTS, record);
    }
    
    //Appending tickets to tickets.txt
    public static boolean addTicket(String ticketID, String managerID, String customerID, String customerComment, 
                                    String managerReply, String status){

        String record = String.join(DELIMITER, ticketID, managerID, customerID, 
                                    customerComment, managerReply, status);
        
        return appendToFile(FileType.TICKETS, record);
    }
    
    //Appending to notifications.txt
    public static boolean addNotification(String notificationID, String userID, String message, 
                                            LocalDateTime timestamp, boolean isRead){
        // Convert LocalDateTime to String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestampStr = timestamp.format(formatter);
        
        String record = String.join(DELIMITER, notificationID, userID, message, 
                                        timestampStr, Boolean.toString(isRead));
        
        return appendToFile(FileType.NOTIFICATIONS, record);
    }
    
    
    //----------Main----------
    public static void main(String[] args) {
        // Example usage
        //boolean userAdded = addUser("John Doe", "invalid-email", "+1234567890", "Passw0rd", "customer");
        //System.out.println("User added: " + userAdded);

        //List<String> users = searchRecords(FileType.USERS, "email", "john@example.com");
        //System.out.println("Found users: " + users);
    }
}
