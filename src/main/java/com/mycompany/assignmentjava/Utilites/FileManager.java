package com.mycompany.assignmentjava.Utilites;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class FileManager {
    private static final String BASE_PATH = "data/";
    public static final String DELIMITER = ";;";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final Random RANDOM = new Random();

    // File names
    public enum FileType {
        LOGIN("login.txt"),
        USERS("users.txt"),
        TRANSACTIONS("transactions.txt"),
        ORDERS("orders.txt"),
        REVIEWS("reviews.txt"),
        PRODUCTS("products.txt"),
        TICKETS("tickets.txt");

        private final String filename;

        FileType(String filename) {
            this.filename = filename;
        }

        public String getPath() {
            return BASE_PATH + filename;
        }
    }

    // Initialize files with headers
    static {
        initializeFile(FileType.LOGIN, "email,password,role");
        initializeFile(FileType.USERS, "userID,name,email,phone,password,role,status");
        initializeFile(FileType.TRANSACTIONS, "transactionID,orderID,customerID,amount,paymentDate,paymentStatus");
        initializeFile(FileType.ORDERS, "orderID,customerID,vendorID,runnerID,products,orderType,status,runnerStatus,deliveryfees,totalAmount,OrderDate");
        initializeFile(FileType.REVIEWS, "reviewID,customerID,runnerID,orderID,vendorID,reviewText,rating,date");
        initializeFile(FileType.PRODUCTS, "productID,vendorID,productName,price");
        initializeFile(FileType.TICKETS, "ticketID,managerID,customerID,customerComment,managerReply,status");
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

    // Generate 8-digit ID
    private static String generateID() {
        return String.format("%08d", RANDOM.nextInt(100000000));
    }

    // Display error in a dialog
    private static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    // User management methods
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

        String userID = "ID" + generateID();
        String record = String.join(DELIMITER, userID, name, email, phone, password, role);

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
    private static boolean validateEmail(String email) {
        return email.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$");
    }

    private static boolean validatePassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$");
    }

    private static boolean validatePhone(String phone) {
        return phone.matches("^\\+?[0-9]{10,15}$");
    }

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

    public static void main(String[] args) {
        // Example usage
        boolean userAdded = addUser("John Doe", "invalid-email", "+1234567890", "Passw0rd", "customer");
        System.out.println("User added: " + userAdded);

        List<String> users = searchRecords(FileType.USERS, "email", "john@example.com");
        System.out.println("Found users: " + users);
    }
}
