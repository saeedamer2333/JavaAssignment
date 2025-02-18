package com.mycompany.assignmentjava.AbdulRehman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.mycompany.assignmentjava.Utilites.FileManager;

public class VendorForm extends JFrame {
    private Vendor vendor;

    public VendorForm(String[] userDetails) {
        this.vendor = new Vendor(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4]);
        setTitle("Vendor Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create buttons for the main options
        JButton updateItemsButton = new JButton("Update Items");
        JButton acceptDeclineOrdersButton = new JButton("Accept/Decline Orders");
        JButton showCustomerReviewsButton = new JButton("Show Customer Reviews");
        JButton showOrderHistoryButton = new JButton("Show Order History");
        JButton revenueDashboardButton = new JButton("Revenue Dashboard");

        // Add action listeners to the buttons
        updateItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUpdateItemsForm();
            }
        });

        acceptDeclineOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAcceptDeclineOrdersForm();
            }
        });

        showCustomerReviewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCustomerReviews();
            }
        });

        showOrderHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOrderHistory();
            }
        });

        revenueDashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRevenueDashboard();
            }
        });

        // Layout for the main options
        setLayout(new GridLayout(5, 1));
        add(updateItemsButton);
        add(acceptDeclineOrdersButton);
        add(showCustomerReviewsButton);
        add(showOrderHistoryButton);
        add(revenueDashboardButton);
    }

    private void showUpdateItemsForm() {
        JFrame updateItemsFrame = new JFrame("Update Items");
        updateItemsFrame.setSize(400, 300);
        updateItemsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateItemsFrame.setLocationRelativeTo(null);

        // Create buttons for item management
        JButton createItemButton = new JButton("Create Item");
        JButton deleteItemButton = new JButton("Delete Item");
        JButton readItemButton = new JButton("Read Item");
        JButton updateItemButton = new JButton("Update Item");

        // Add action listeners to the buttons
        createItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = JOptionPane.showInputDialog("Enter product name:");
                double price = Double.parseDouble(JOptionPane.showInputDialog("Enter product price:"));
                boolean success = vendor.createItem(productName, price);
                JOptionPane.showMessageDialog(null, success ? "Item created successfully." : "Failed to create item.");
            }
        });

        deleteItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productID = JOptionPane.showInputDialog("Enter product ID to delete:");
                boolean success = vendor.deleteItem(productID);
                JOptionPane.showMessageDialog(null, success ? "Item deleted successfully." : "Failed to delete item.");
            }
        });

        readItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> items = vendor.viewItems();
                JTextArea textArea = new JTextArea(String.join("\n", items));
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setPreferredSize(new Dimension(500, 400));
                JOptionPane.showMessageDialog(null, scrollPane, "Items", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        updateItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productID = JOptionPane.showInputDialog("Enter product ID to update:");
                String fieldName = JOptionPane.showInputDialog("Enter field name to update:");
                String newValue = JOptionPane.showInputDialog("Enter new value:");
                boolean success = vendor.updateItem(productID, fieldName, newValue);
                JOptionPane.showMessageDialog(null, success ? "Item updated successfully." : "Failed to update item.");
            }
        });

        // Layout for item management options
        updateItemsFrame.setLayout(new GridLayout(4, 1));
        updateItemsFrame.add(createItemButton);
        updateItemsFrame.add(deleteItemButton);
        updateItemsFrame.add(readItemButton);
        updateItemsFrame.add(updateItemButton);

        updateItemsFrame.setVisible(true);
    }

    private void showCustomerReviews() {
        List<String> reviews = vendor.viewCustomerReviews();
        StringBuilder formattedReviews = new StringBuilder();
        formattedReviews.append("Customer Reviews\n");
        formattedReviews.append("-------------------------------------------------\n");
        for (String review : reviews) {
            String[] reviewDetails = review.split(FileManager.DELIMITER);
            formattedReviews.append("Customer ID: ").append(reviewDetails[1]).append("\n");
            formattedReviews.append("Runner ID: ").append(reviewDetails[2]).append("\n");
            formattedReviews.append("Order ID: ").append(reviewDetails[3]).append("\n");
            formattedReviews.append("Review: ").append(reviewDetails[5]).append("\n");
            formattedReviews.append("Rating: ").append(reviewDetails[6]).append("/5\n");
            formattedReviews.append("Date: ").append(reviewDetails[7]).append("\n");
            formattedReviews.append("-------------------------------------------------\n");
        }
        JTextArea textArea = new JTextArea(formattedReviews.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        JOptionPane.showMessageDialog(null, scrollPane, "Customer Reviews", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showOrderHistory() {
        JFrame orderHistoryFrame = new JFrame("Order History");
        orderHistoryFrame.setSize(600, 400);
        orderHistoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        orderHistoryFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton dailyButton = new JButton("Daily Orders");
        JButton monthlyButton = new JButton("Monthly Orders");
        JButton quarterlyButton = new JButton("Quarterly Orders");
        JButton halfYearlyButton = new JButton("Half-Yearly Orders");
        JButton yearlyButton = new JButton("Yearly Orders");

        dailyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOrders("daily");
            }
        });

        monthlyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOrders("monthly");
            }
        });

        quarterlyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOrders("quarterly");
            }
        });

        halfYearlyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOrders("half-yearly");
            }
        });

        yearlyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOrders("yearly");
            }
        });

        panel.add(dailyButton);
        panel.add(monthlyButton);
        panel.add(quarterlyButton);
        panel.add(halfYearlyButton);
        panel.add(yearlyButton);

        orderHistoryFrame.add(panel);
        orderHistoryFrame.setVisible(true);
    }

    private void showOrders(String period) {
        List<String> orders = vendor.viewOrdersByPeriod(period);
        StringBuilder formattedOrders = new StringBuilder();
        formattedOrders.append("Order History - ").append(period.substring(0, 1).toUpperCase()).append(period.substring(1)).append("\n");
        formattedOrders.append("-------------------------------------------------\n");
        for (String order : orders) {
            String[] orderDetails = order.split(FileManager.DELIMITER);
            formattedOrders.append("Order ID: ").append(orderDetails[0]).append("\n");
            formattedOrders.append("Customer ID: ").append(orderDetails[1]).append("\n");
            formattedOrders.append("Products: ").append(orderDetails[6]).append("\n");
            formattedOrders.append("Order Date: ").append(orderDetails[11]).append("\n");
            formattedOrders.append("-------------------------------------------------\n");
        }
        JTextArea textArea = new JTextArea(formattedOrders.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        JOptionPane.showMessageDialog(null, scrollPane, "Order History", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showRevenueDashboard() {
        JFrame revenueFrame = new JFrame("Revenue Dashboard");
        revenueFrame.setSize(600, 400);
        revenueFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        revenueFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton dailyButton = new JButton("Daily Revenue");
        JButton monthlyButton = new JButton("Monthly Revenue");
        JButton quarterlyButton = new JButton("Quarterly Revenue");
        JButton halfYearlyButton = new JButton("Half-Yearly Revenue");
        JButton yearlyButton = new JButton("Yearly Revenue");

        dailyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRevenue("daily");
            }
        });

        monthlyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRevenue("monthly");
            }
        });

        quarterlyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRevenue("quarterly");
            }
        });

        halfYearlyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRevenue("half-yearly");
            }
        });

        yearlyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRevenue("yearly");
            }
        });

        panel.add(dailyButton);
        panel.add(monthlyButton);
        panel.add(quarterlyButton);
        panel.add(halfYearlyButton);
        panel.add(yearlyButton);

        revenueFrame.add(panel);
        revenueFrame.setVisible(true);
    }

    private void showRevenue(String period) {
        double revenue = vendor.viewRevenueByPeriod(period);
        String message = "Total Revenue (" + period.substring(0, 1).toUpperCase() + period.substring(1) + "): $" + revenue;
        JOptionPane.showMessageDialog(null, message, "Revenue Dashboard", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showAcceptDeclineOrdersForm() {
        List<String> pendingOrders = vendor.viewPendingOrders();
        if (pendingOrders.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No pending orders found.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (String order : pendingOrders) {
            String[] orderDetails = order.split(FileManager.DELIMITER);
            String orderInfo = "Order ID: " + orderDetails[0] + "\nCustomer ID: " + orderDetails[1] + "\nProducts: " + orderDetails[6];
            int response = JOptionPane.showOptionDialog(null, orderInfo, "Accept/Decline Order",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Accept", "Decline"}, "Accept");

            boolean success;
            if (response == JOptionPane.YES_OPTION) {
                success = vendor.updateOrderStatus(orderDetails[0], true);
                JOptionPane.showMessageDialog(null, success ? "Order accepted." : "Failed to accept order.");
            } else if (response == JOptionPane.NO_OPTION) {
                success = vendor.updateOrderStatus(orderDetails[0], false);
                JOptionPane.showMessageDialog(null, success ? "Order declined." : "Failed to decline order.");
            }
        }
    }

    public static void main(String[] args) {
        String[] userDetails = {"V001", "Test Vendor", "testvendor@example.com", "+1234567890", "Password123"};
        VendorForm vendorForm = new VendorForm(userDetails);
        vendorForm.setVisible(true);
    }
}
