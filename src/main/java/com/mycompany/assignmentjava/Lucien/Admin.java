package com.mycompany.assignmentjava.Lucien;

import com.mycompany.assignmentjava.Utilites.User;
import com.mycompany.assignmentjava.Utilites.FileManager;
import com.mycompany.assignmentjava.Utilites.FileManager.FileType;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.util.List;

public class Admin extends User {

    // Constructor
    public Admin(String name, String email, String phone, String password) {
        super(name, email, phone, password, "Admin");

        // Validate the inputs after calling the superclass constructor
        if (!validate(name, "name")) {
            throw new IllegalArgumentException("Invalid name format");
        }
        if (!validate(email, "email")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (!validate(password, "password")) {
            throw new IllegalArgumentException("Invalid password format");
        }
    }

    // ---------------- Methods ----------------

    // Create user with basic info
    public static boolean createUser(String name, String phone, String role, String email, String password) {
        // You could add extra validations here if needed.
        // For now, we delegate to FileManager.addUser which already performs validations.
        boolean success = FileManager.addUser(name, email, phone, password, role);
        if(success) {
            JOptionPane.showMessageDialog(null, "Customer created successfully!");
        } 
        return success;
    }

    public String readUserDetails(String userId) {
        if (!validate(userId, "userID")) {
            throw new IllegalArgumentException("Invalid userID");
        }
        // Implementation logic here
        return "User details for: " + userId;
    }

    public void updateUserDetails(String userId, String newDetails) {
        if (!validate(userId, "userID") || !validate(newDetails, "details")) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        // Implementation logic here
    }

    public static boolean deleteUser(String customerID) {
        return FileManager.deleteRecord(FileManager.FileType.USERS, customerID);
    }

    public void topUpCredit(String userId, double amount) {
        if (!validate(userId, "userID") || !validate(amount, "amount")) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        // Implementation logic here
    }

    public void generateTransactionReceipt(String userId, String transactionId) {
        if (!validate(userId, "userID") || !validate(transactionId, "transactionId")) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        // Implementation logic here
    }

    public void sendReceiptNotification(String userId, String receiptId) {
        if (!validate(userId, "userID") || !validate(receiptId, "receiptId")) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        // Implementation logic here
    }

    // -------------- Validation Methods --------------

    private boolean validate(String value, String type) {
        if (value == null || value.trim().isEmpty()) return false;

        return switch (type) {
            case "userID" -> value.matches("^[A-Za-z0-9]{5,}$");
            case "name" -> value.matches("^[a-zA-Z\\s-' ]+$");
            case "email" -> value.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$");
            case "password" -> value.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$");
            case "phone" -> value.matches("^\\d{10}$");
            case "userType", "role" -> value.matches("^(admin|user|moderator)$");
            case "details" -> !value.trim().isEmpty();
            case "transactionId", "receiptId" -> value.matches("^[A-Za-z0-9]{10,}$");
            default -> false;
        };
    }

    private boolean validate(double amount, String type) {
        if ("amount".equals(type)) {
            return amount > 0;
        }
        return false;
    }
    
    public static boolean updateCustomerBalance(String customerID, double addAmount) {
        // Search for the user record by customerID.
        List<String> records = FileManager.searchRecords(FileManager.FileType.USERS, "userID", customerID);
        if (records.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Customer not found with ID: " + customerID);
            return false;
        }

        // Assume the record is in the format: userID;;name;;email;;phone;;password;;role;;status
        String record = records.get(0);
        String[] fields = record.split(FileManager.DELIMITER);

        if (fields.length < 4) {
            JOptionPane.showMessageDialog(null, "Invalid record format for customer: " + customerID);
            return false;
        }

        try {
            // Parse the current balance from the phone field (index 3)
            double currentBalance = Double.parseDouble(fields[3]);
            double newBalance = currentBalance + addAmount;

            // Update the record using updateSingleField. Here, fieldIndex is 3 (phone field)
            boolean updated = FileManager.updateSingleField(
                    FileManager.FileType.USERS,
                    customerID,
                    "balance", // this is just an identifier; updateSingleField doesn't use it internally
                    String.valueOf(newBalance),
                    3
            );

            if (updated) {
                JOptionPane.showMessageDialog(null, "Balance updated successfully. New balance: " + newBalance);
            }
            return updated;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Current balance is not a valid number: " + fields[3]);
            return false;
        }
    }

        public static void CreateReceipttAndSendNotification() {
        List<String> transactions = FileManager.getAllRecords(FileType.TRANSACTIONS);
        int count = 0; // count of notifications sent
        
        for (String record : transactions) {
            String[] parts = record.split(FileManager.DELIMITER);
            // Expecting: transactionID, orderID, customerID, amount, paymentDate, paymentStatus, receiptGenerated
            if (parts.length >= 7) {
                String transactionID = parts[0];
                String orderID = parts[1];
                String customerID = parts[2];
                String amount = parts[3];
                String paymentDate = parts[4];
                String paymentStatus = parts[5];
                String receiptGenerated = parts[6];
                
                // Only process if transaction is Completed and receipt is not yet generated
                if (paymentStatus.equalsIgnoreCase("Completed") && receiptGenerated.equalsIgnoreCase("false")) {
                    // Build a notification message that includes receipt info
                    String message = "Receipt for Transaction " + transactionID 
                            + ": Order " + orderID 
                            + ", Amount RM" + amount 
                            + ", Date: " + paymentDate;
                    
                    // Generate a notificationID
                    String notificationID = "ID" + FileManager.generateID();
                    
                    // Add the notification (using current time and isRead = false)
                    boolean notifAdded = FileManager.addNotification(notificationID, customerID, message, 
                                                LocalDateTime.now(), false);
                    if (notifAdded) {
                        // Update the transaction's receiptGenerated field to "true" (index 6)
                        boolean updateSuccess = FileManager.updateSingleField(FileType.TRANSACTIONS, transactionID, 
                                                "receiptGenerated", "true", 6);
                        if (updateSuccess) {
                            count++;
                        }
                    }
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, count + " receipt notifications generated and sent.");
    }
    // -------------- Getters and Setters --------------
//
//    // Getter for userID
//    public String getUserID() { return userID; }
//
//    // Getter and Setter for name
//    @Override
//    public String getName() { return name; }
//
//    @Override
//    public void setName(String name) {
//        if (!validate(name, "name")) {
//            throw new IllegalArgumentException("Invalid name format");
//        }
//        this.name = name;
//    }
//
//    // Getter and Setter for email
//    @Override
//    public String getEmail() { return email; }
//
//    @Override
//    public void setEmail(String email) {
//        if (!validate(email, "email")) {
//            throw new IllegalArgumentException("Invalid email format");
//        }
//        this.email = email;
//    }
//
//    // Getter and Setter for password
//    @Override
//    public String getPassword() { return password; }
//
//    @Override
//    public void setPassword(String password) {
//        if (!validate(password, "password")) {
//            throw new IllegalArgumentException("Invalid password format");
//        }
//        this.password = password;
//    }
//
//    // Getter and Setter for role
//    @Override
//    public String getRole() { return role; }
//
//    @Override
//    public void setRole(String role) {
//        if (!validate(role, "role")) {
//            throw new IllegalArgumentException("Invalid role");
//        }
//        this.role = role;
//    }
}
