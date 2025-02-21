package com.mycompany.assignmentjava.AbdulRehman;

import com.mycompany.assignmentjava.Utilites.User;
import com.mycompany.assignmentjava.Utilites.FileManager;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vendor extends User {
    protected String vendorID;

    // Constructor
    public Vendor(String vendorId, String name, String email, String phone, String password) {
        super(name, email, phone, password, "Vendor");
        this.vendorID = vendorId;
    }
    //Wanted an extra constructor for something thanks :) -zakwaan
    public Vendor(String vendorId, String name, String email, String phone, String password, String role) {
        super(vendorId, name, email, phone, password, role);
        this.vendorID = vendorId;
    }

    // Constructor with random values
    public Vendor() {
        super(
            "V" + UUID.randomUUID().toString().substring(0, 3),
            "Vendor" + UUID.randomUUID().toString().substring(0, 2) + "@example.com",
            "+1234567890",
            "Password123",
            "Vendor"
        );
        this.vendorID = "VID" + FileManager.generateID();
    }

    // Getter for vendorID
    public String getVendorID() {
        return vendorID;
    }

    // Method to create an item
    public boolean createItem(String productName, double price) {
        String productID = "PID" + FileManager.generateID();
        return FileManager.addProduct(productID, this.vendorID, productName, price);
    }

    // Method to view items
    public List<String> viewItems() {
        return FileManager.searchRecords(FileManager.FileType.PRODUCTS, "vendorID", this.vendorID);
    }

    // Method to view customer reviews
    public List<String> viewCustomerReviews() {
        List<String> reviews = FileManager.searchRecords(FileManager.FileType.REVIEWS, "vendorID", this.vendorID);
        System.out.println("Vendor ID: " + this.vendorID);
        System.out.println("Reviews found: " + reviews.size());
        for (String review : reviews) {
            System.out.println(review);
        }
        return reviews;
    }

    // Method to update an item
    public boolean updateItem(String productID, String fieldName, String newValue) {
        int fieldIndex = getFieldIndex(FileManager.FileType.PRODUCTS, fieldName);
        if (fieldIndex == -1) {
            FileManager.showErrorDialog("Invalid field name: " + fieldName);
            return false;
        }
        return FileManager.updateSingleField(FileManager.FileType.PRODUCTS, productID, fieldName, newValue, fieldIndex);
    }

    // Method to delete an item
    public boolean deleteItem(String productID) {
        return FileManager.deleteRecord(FileManager.FileType.PRODUCTS, productID);
    }

    // Method to update order status
    public boolean updateOrderStatus(String orderID, boolean isAccepted) {
        List<String> orders = FileManager.searchRecords(FileManager.FileType.ORDERS, "vendorID", this.vendorID);
        for (String order : orders) {
            String[] orderDetails = order.split(FileManager.DELIMITER);
            if (orderDetails[0].equals(orderID) && orderDetails[9].equalsIgnoreCase("Pending")) {
                String newStatus = isAccepted ? "Available" : "Rejected";
                return FileManager.updateSingleField(FileManager.FileType.ORDERS, orderID, "status", newStatus, 8);
            }
        }
        return false;
    }

    // Method to view pending orders
    public List<String> viewPendingOrders() {
        List<String> allOrders = FileManager.searchRecords(FileManager.FileType.ORDERS, "vendorID", this.vendorID);
        List<String> pendingOrders = new ArrayList<>();
        for (String order : allOrders) {
            String[] orderDetails = order.split(FileManager.DELIMITER);
            if (orderDetails[9].equalsIgnoreCase("Pending")) {
                pendingOrders.add(order);
            }
        }
        return pendingOrders;
    }

    // Method to view orders by period
    public List<String> viewOrdersByPeriod(String period) {
        List<String> allOrders = FileManager.searchRecords(FileManager.FileType.ORDERS, "vendorID", this.vendorID);
        List<String> filteredOrders = new ArrayList<>();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (String order : allOrders) {
            String[] orderDetails = order.split(FileManager.DELIMITER);
            LocalDate orderDate = LocalDate.parse(orderDetails[12], formatter);

            switch (period.toLowerCase()) {
                case "daily":
                    if (orderDate.equals(now)) {
                        filteredOrders.add(order);
                    }
                    break;
                case "monthly":
                    if (orderDate.getMonth() == now.getMonth() && orderDate.getYear() == now.getYear()) {
                        filteredOrders.add(order);
                    }
                    break;
                case "quarterly":
                    if (orderDate.getYear() == now.getYear() && (orderDate.getMonthValue() - 1) / 3 == (now.getMonthValue() - 1) / 3) {
                        filteredOrders.add(order);
                    }
                    break;
                case "half-yearly":
                    if (orderDate.getYear() == now.getYear() && (orderDate.getMonthValue() - 1) / 6 == (now.getMonthValue() - 1) / 6) {
                        filteredOrders.add(order);
                    }
                    break;
                case "yearly":
                    if (orderDate.getYear() == now.getYear()) {
                        filteredOrders.add(order);
                    }
                    break;
            }
        }
        return filteredOrders;
    }

    // Method to view revenue by period
    public double viewRevenueByPeriod(String period) {
        List<String> allOrders = FileManager.searchRecords(FileManager.FileType.ORDERS, "vendorID", this.vendorID);
        double totalRevenue = 0;
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (String order : allOrders) {
            String[] orderDetails = order.split(FileManager.DELIMITER);
            LocalDate orderDate = LocalDate.parse(orderDetails[12], formatter);
            String status = orderDetails[9];

            if (!status.equalsIgnoreCase("Available")) {
                continue;
            }

            switch (period.toLowerCase()) {
                case "daily":
                    if (orderDate.equals(now)) {
                        totalRevenue += Double.parseDouble(orderDetails[11]);
                    }
                    break;
                case "monthly":
                    if (orderDate.getMonth() == now.getMonth() && orderDate.getYear() == now.getYear()) {
                        totalRevenue += Double.parseDouble(orderDetails[11]);
                    }
                    break;
                case "quarterly":
                    if (orderDate.getYear() == now.getYear() && (orderDate.getMonthValue() - 1) / 3 == (now.getMonthValue() - 1) / 3) {
                        totalRevenue += Double.parseDouble(orderDetails[11]);
                    }
                    break;
                case "half-yearly":
                    if (orderDate.getYear() == now.getYear() && (orderDate.getMonthValue() - 1) / 6 == (now.getMonthValue() - 1) / 6) {
                        totalRevenue += Double.parseDouble(orderDetails[11]);
                    }
                    break;
                case "yearly":
                    if (orderDate.getYear() == now.getYear()) {
                        totalRevenue += Double.parseDouble(orderDetails[11]);
                    }
                    break;
            }
        }
        return totalRevenue;
    }

    // Method to view menu items
    public List<String> viewMenu() {
        return FileManager.searchRecords(FileManager.FileType.PRODUCTS, "vendorID", this.vendorID);
    }

    // Helper method to get the index of a field in the file
    private int getFieldIndex(FileManager.FileType fileType, String fieldName) {
        String header = FileManager.getAllRecords(fileType).get(0);
        String[] headers = header.split(",");
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equalsIgnoreCase(fieldName)) {
                return i;
            }
        }
        return -1;
    }
}