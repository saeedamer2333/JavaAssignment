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
        initializeFile(FileType.USERS, "userID,name,email,phone,password,role,status,address,balance");
        initializeFile(FileType.TRANSACTIONS, "transactionID,orderID,customerID,amount,paymentDate,paymentStatus");
        initializeFile(FileType.ORDERS, "orderID,customerID,customerName,vendorID,"
                + "vendorName,runnerID,products,orderType,status,address,deliveryfees,totalAmount,OrderDate");
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

    // ----------Adding records methods----------
    // Add a regular user (without status)
    public static boolean addUser(String name, String email, String phone, String password) {
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
        String record = String.join(DELIMITER, userID, name, email, phone, password);
        return appendToFile(FileType.USERS, record);
    }

    // Add a delivery runner (user with status property)
    
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
        String record = String.join(DELIMITER, userID, name, email, phone, password, role, "Available");
        return appendToFile(FileType.USERS, record);
    }
    
    //Add user with address and balance (For customer)
    public static boolean addCustomer(String name, String email, String phone, String password, String role, 
            String address, double balance) {
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
        String record = String.join(DELIMITER, userID, name, email, phone, password, 
                                       role, "status", address, Double.toString(balance));
        return appendToFile(FileType.USERS, record);
    }

    // Transaction methods (using java.util.Date)
    public static boolean addTransaction(String orderID, String customerID,
                                         double amount, Date paymentDate, String paymentStatus,
                                         String receiptGenerated) {
        if (amount <= 0) {
            showErrorDialog("Transaction amount must be greater than 0.");
            return false;
        }
        String transactionID = "ID" + generateID();
        String dateStr = DATE_FORMAT.format(paymentDate);
        String record = String.join(DELIMITER, transactionID, orderID, customerID,
                String.valueOf(amount), dateStr, paymentStatus, receiptGenerated);
        return appendToFile(FileType.TRANSACTIONS, record);
    }

    // Order management methods
    //
    public static boolean addOrder(String orderID, String customerID, String customerName,
                                    String vendorID, String vendorName, String runnerID,
                                    List<String> products, String orderType, String status,
                                  String address,double deliveryfees, double totalAmount, Date orderDate) {
        if (products.isEmpty()) {
            showErrorDialog("Order must contain at least one product.");
            return false;
        }
        if (totalAmount <= 0) {
            showErrorDialog("Total amount must be greater than 0.");
            return false;
        }
        String dateStrOrder = DATE_FORMAT.format(orderDate);
        String productsStr = String.join(",", products);
        
        String record = String.join(DELIMITER, orderID, customerID, customerName,
                vendorID, vendorName, runnerID, productsStr, orderType, status, 
                address,String.valueOf(deliveryfees),
                String.valueOf(totalAmount), dateStrOrder);
        
        return appendToFile(FileType.ORDERS, record);
    }

    // Other append methods (using LocalDateTime in some cases)
    //transaction append method with Date
    public static boolean addTransaction(String transactionID, String orderID, String customerID,
                                         double amount, Date paymentDate, String paymentStatus, 
                                         String receiptGenerated) {
        if (amount <= 0) {
            showErrorDialog("Transaction amount must be greater than 0.");
            return false;
        }
        String dateStr = DateConverter.dateToString(paymentDate);
        String record = String.join(DELIMITER, transactionID, orderID, customerID,
                String.valueOf(amount), dateStr, paymentStatus, receiptGenerated);
        return appendToFile(FileType.TRANSACTIONS, record);
    }
    
    //Add review to reviews.txt. Would be more ideal to just pass the Review object but this remains more flexible
    public static boolean addReview(String reviewID, String customerID, String runnerID, String orderID, 
                                    String vendorID, String reviewText, int rating, Date date) {
        String dateStr = DateConverter.dateToString(date);
        String record = String.join(DELIMITER, reviewID, customerID, runnerID, orderID,
                                    vendorID, reviewText, Integer.toString(rating), dateStr);
        return appendToFile(FileType.REVIEWS, record);
    }

    public static boolean addProduct(String productID, String vendorID, String productName, double price) {
        if (price <= 0) {
            showErrorDialog("Price must be greater than 0.");
            return false;
        }
        String record = String.join(DELIMITER, productID, vendorID, productName, Double.toString(price));
        return appendToFile(FileType.PRODUCTS, record);
    }

    public static boolean addTicket(String ticketID, String managerID, String customerID, String customerComment, 
                                    String managerReply, String status) {
        String record = String.join(DELIMITER, ticketID, managerID, customerID, 
                                    customerComment, managerReply, status);
        return appendToFile(FileType.TICKETS, record);
    }

    public static boolean addNotification(String notificationID, String userID, String message, 
                                            LocalDateTime timestamp, boolean isRead) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestampStr = timestamp.format(formatter);
        String record = String.join(DELIMITER, notificationID, userID, message, 
                                        timestampStr, Boolean.toString(isRead));
        return appendToFile(FileType.NOTIFICATIONS, record);
    }

    // ----------Generic File Append Method----------
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

    // ----------Search Method----------
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
    
    
    // method to search records with dynamic columns and filters
    public static List<String[]> searchRecords(FileType fileType, String searchKey, String searchValue, 
                                               String[] filterColumns, String[] filterValues, 
                                               String[] columnsToExtract) {
        List<String[]> results = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileType.getPath()))) {
            String header = reader.readLine();  // Read the header
            String[] headers = header.split(",");

            // Identifying indices for the searchKey and the columnsToExtract
            int searchKeyIndex = -1;
            List<Integer> extractIndices = new ArrayList<>();
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase(searchKey)) {
                    searchKeyIndex = i;
                }
                // Search for the indices of the columns to extract
                for (String col : columnsToExtract) {
                    if (headers[i].equalsIgnoreCase(col)) {
                        extractIndices.add(i);
                    }
                }
            }

            // Ensure the search key and required columns are found
            if (searchKeyIndex == -1 || extractIndices.isEmpty()) {
                showErrorDialog("Missing required column(s) in the file.");
                return results;
            }

            // Reading the records and applying filters
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                if (parts.length > searchKeyIndex) {
                    // Check if the search value matches
                    if (parts[searchKeyIndex].equalsIgnoreCase(searchValue)) {
                        boolean matchesAllFilters = true;
                        // Apply each filter
                        for (int i = 0; i < filterColumns.length; i++) {
                            int filterColumnIndex = -1;
                            for (int j = 0; j < headers.length; j++) {
                                if (headers[j].equalsIgnoreCase(filterColumns[i])) {
                                    filterColumnIndex = j;
                                    break;
                                }
                            }
                            if (filterColumnIndex != -1 && !parts[filterColumnIndex].equalsIgnoreCase(filterValues[i])) {
                                matchesAllFilters = false;
                                break;
                            }
                        }

                        // If the row matches the search and all filters, extract the required columns
                        if (matchesAllFilters) {
                            // Create an array to store the values of the extracted columns
                            String[] extractedData = new String[extractIndices.size()];
                            for (int i = 0; i < extractIndices.size(); i++) {
                                extractedData[i] = parts[extractIndices.get(i)];
                            }
                            results.add(extractedData);
                        }
                    }
                }
            }
        } catch (IOException e) {
            showErrorDialog("Error searching records: " + e.getMessage());
        }
        return results;
    }
    

    // ----------Update a Single Field----------
   public static boolean updateSingleField(FileType fileType, String id, String fieldName, String newValue, int fieldIndex) {
    List<String> updatedLines = new ArrayList<>();
    boolean recordFound = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(fileType.getPath()))) {
        String header = reader.readLine();
        updatedLines.add(header);

        String[] headers = header.split(","); // Assuming the header uses commas, update if needed
        if (fieldIndex < 0 || fieldIndex >= headers.length) {
            showErrorDialog("Invalid field index: " + fieldIndex);
            return false;
        }

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(DELIMITER, -1); // Preserve empty fields

            if (parts.length < headers.length) {
                showErrorDialog("Malformed line detected: " + line);
                return false;
            }

            if (parts[0].equals(id)) {
                recordFound = true;
                parts[fieldIndex] = newValue;
                line = String.join(DELIMITER, parts);
            }

            updatedLines.add(line);
        }
    } catch (IOException e) {
        showErrorDialog("Error reading file: " + e.getMessage());
        return false;
    }

    if (!recordFound) {
        showErrorDialog("Record with ID " + id + " not found.");
        return false;
    }

    return writeLinesToFile(fileType, updatedLines);
}
   //update single field but without the need for field index
   public static boolean updateSingleFieldWithoutIndex(FileType fileType, String id, String fieldName, String newValue) {
    List<String> updatedLines = new ArrayList<>();
    boolean recordFound = false;
    try (BufferedReader reader = new BufferedReader(new FileReader(fileType.getPath()))) {
        String header = reader.readLine();
        updatedLines.add(header);
        String[] headers = header.split(DELIMITER);
        
        // Find the field index based on the field name
        int fieldIndex = -1;
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].trim().equalsIgnoreCase(fieldName)) {
                fieldIndex = i;
                break;
            }
        }
        
        if (fieldIndex < 0) {
            showErrorDialog("Field not found: " + fieldName);
            return false;
        }
        
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(DELIMITER, -1); // Preserve empty fields
            if (parts.length < headers.length) {
                showErrorDialog("Malformed line detected: " + line);
                return false;
            }
            if (parts[0].equals(id)) {
                recordFound = true;
                parts[fieldIndex] = newValue;
                line = String.join(DELIMITER, parts);
            }
            updatedLines.add(line);
        }
    } catch (IOException e) {
        showErrorDialog("Error reading file: " + e.getMessage());
        return false;
    }
    
    if (!recordFound) {
        showErrorDialog("Record with ID " + id + " not found.");
        return false;
    }
    
    return writeLinesToFile(fileType, updatedLines);
}

    // ----------Rewrite the Entire File with the Given Lines----------
    public static boolean writeLinesToFile(FileType fileType, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileType.getPath()))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            showErrorDialog("Error writing to file: " + e.getMessage());
            return false;
        }
    }
    
    // ----------Delete Record Method----------
    /**
     * Deletes the record with the specified id from the given file.
     * @param fileType the file from which the record should be deleted.
     * @param id the ID (first field in the record) to delete.
     * @return true if the deletion was successful; false otherwise.
     */    
    public static boolean deleteRecord(FileType fileType, String id) {
        List<String> updatedLines = new ArrayList<>();
        boolean recordFound = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileType.getPath()))) {
            // Read header and add it.
            String header = reader.readLine();
            updatedLines.add(header);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                // Assume the ID is in the first column.
                if (parts[0].equals(id)) {
                    recordFound = true;
                    // Skip adding this line to updatedLines (i.e. delete it).
                    continue;
                }
                updatedLines.add(line);
            }
        } catch (IOException e) {
            showErrorDialog("Error reading file: " + e.getMessage());
            return false;
        }
        if (!recordFound) {
            showErrorDialog("Record with ID " + id + " not found.");
            return false;
        }
        // The helper method writeLinesToFile is called here to overwrite the file with the updated content.
        return writeLinesToFile(fileType, updatedLines);
        
    }
        /**
     * Gets all records within a specified file
     * @param fileType the file from which the record should be deleted.
     * @return a list of records.
     */
    
    public static List<String> getAllRecords(FileType fileType) {
    List<String> records = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileType.getPath()))) {
        // Read and ignore the header line
        String header = reader.readLine();
        String line;
        while ((line = reader.readLine()) != null) {
            records.add(line);
        }
    } catch (IOException e) {
        showErrorDialog("Error reading records: " + e.getMessage());
    }
    return records;
    }


    // ----------Main Method with Examples----------
    public static void main(String[] args) {
        // -------------------------------------------------------------------
//         Example: Using updateSingleField (which calls writeLinesToFile internally)
//         (Assuming the first field is the record's ID)
//         For USERS: update the 'name' property (which is at index 1 based on the header order)
         updateSingleField(FileType.USERS, "ID12345678", "name", "Alice Smith", 1);
         
//         For TRANSACTIONS: update the 'paymentStatus' property (index 5)
         updateSingleField(FileType.TRANSACTIONS, "ID87654321", "paymentStatus", "Completed", 5);
        
//         For ORDERS: update the 'status' property (index 5) or 'runnerStatus' (index 7)
         updateSingleField(FileType.ORDERS, "ID11111111", "status", "Shipped", 5);
         updateSingleField(FileType.ORDERS, "ID11111111", "runnerStatus", "Assigned", 7);
        
        // For REVIEWS: update the 'rating' property (index 6)
         updateSingleField(FileType.REVIEWS, "ID22222222", "rating", "5", 6);
        //
        // For PRODUCTS: update the 'price' property (index 3)
         updateSingleField(FileType.PRODUCTS, "ID33333333", "price", "19.99", 3);
        //
        // For TICKETS: update the 'managerReply' property (index 4)
         updateSingleField(FileType.TICKETS, "ID44444444", "managerReply", "We are looking into it", 4);
        //
        // For NOTIFICATIONS: update the 'isRead' property (index 4)
         updateSingleField(FileType.NOTIFICATIONS, "ID55555555", "isRead", "true", 4);
        // 
        // In each of the above examples, the updateSingleField method calls writeLinesToFile
        // after modifying the appropriate record.
        // -------------------------------------------------------------------

        // -------------------------------------------------------------------
        // Example: Using deleteRecord
        // To delete a user record with a given ID from the USERS file:
         boolean deleted = deleteRecord(FileType.USERS, "ID12345678");
        // System.out.println("User deletion successful: " + deleted);
        //
        // Similarly, you can delete a transaction, order, review, product, ticket, or notification record:
         deleteRecord(FileType.TRANSACTIONS, "ID87654321");
         deleteRecord(FileType.ORDERS, "ID11111111");
         deleteRecord(FileType.REVIEWS, "ID22222222");
         deleteRecord(FileType.PRODUCTS, "ID33333333");
         deleteRecord(FileType.TICKETS, "ID44444444");
         deleteRecord(FileType.NOTIFICATIONS, "ID55555555");
         
         List<String> userRecords = FileManager.getAllRecords(FileManager.FileType.USERS);
        // -------------------------------------------------------------------
    }

    // ----------Validation Methods----------
    private static boolean validateEmail(String email) {
        if (email.contains(";;")) {
    JOptionPane.showMessageDialog(
        null,
        "Password cannot contain consecutive semicolons.",
        "You trying to hack us?",
        JOptionPane.QUESTION_MESSAGE
    );
    return false;
    }
        return email.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$");
    }

    private static boolean validatePassword(String password) {
        if (password.contains(";;")) {
    JOptionPane.showMessageDialog(
        null,
        "Password cannot contain consecutive semicolons.",
        "You trying to hack us?",
        JOptionPane.QUESTION_MESSAGE
    );
    return false;
    }
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$");
    }

    private static boolean validatePhone(String phone) {
        if (phone.contains(";;")) {
    JOptionPane.showMessageDialog(
        null,
        "Password cannot contain consecutive semicolons.",
        "You trying to hack us?",
        JOptionPane.QUESTION_MESSAGE
    );
    return false;
    }
        return phone.matches("^\\+?[0-9]{10,15}$");
    }
    
    public static SimpleDateFormat getDATE_FORMAT(){
        return DATE_FORMAT;
    }
}


