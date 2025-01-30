package com.mycompany.assignmentjava.Lucien;

import com.mycompany.assignmentjava.Utilites.User;

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
    public void createUser(String userId, String userType) {
        if (!validate(userId, "userID") || !validate(userType, "userType")) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        // Implementation logic here
    }

    // Create user with detailed info
    public void createUser(String name, String phone, String role, String email, String password) {
        if (!validate(name, "name") || !validate(phone, "phone") ||
            !validate(role, "role") || !validate(email, "email") ||
            !validate(password, "password")) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        // Implementation logic here
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

    public void deleteUser(String userId) {
        if (!validate(userId, "userID")) {
            throw new IllegalArgumentException("Invalid userID");
        }
        // Implementation logic here
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
