package com.mycompany.assignmentjava.AbdulRehman;

import com.mycompany.assignmentjava.Utilites.FileManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VendorWithOrderHistory extends Vendor {

    public VendorWithOrderHistory(String vendorId, String name, String email, String phone, String password) {
        super(vendorId, name, email, phone, password);
    }

    public VendorWithOrderHistory() {
        super();
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
}
