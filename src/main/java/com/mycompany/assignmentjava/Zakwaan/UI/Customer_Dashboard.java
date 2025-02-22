/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.UI;

import com.mycompany.assignmentjava.Utilites.ObjectWriter;
import com.mycompany.assignmentjava.Zakwaan.Classes.Customer;
import javax.swing.JFrame;

/**
 *
 * @author zechn
 */
public class Customer_Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Customer_HomePage
     * @param customerID
     * @param name
     * @param email
     * @param password
     * @param role
     * @param address
     * @param phoneNumber
     * @param walletID
     */
    //Customer object attribute
    private Customer customer;
    
    public Customer_Dashboard(String[] userDetails) {
        //initialize customer
        initComponents();
        Customer newCustomer = ObjectWriter.getCustomerByUserDetails(userDetails);
        this.customer = newCustomer;
    }

    public Customer_Dashboard() {
        //Initialize GUI
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btn_viewVendors = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_Notifications = new javax.swing.JButton();
        btn_orderHistory = new javax.swing.JButton();
        btn_transactionHistory = new javax.swing.JButton();
        btn_helpCentre = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btn_viewVendors.setText("View Vendors");
        btn_viewVendors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewVendorsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Dashboard");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn_Notifications.setText("Notifications");
        btn_Notifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NotificationsActionPerformed(evt);
            }
        });

        btn_orderHistory.setText("Order History");
        btn_orderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orderHistoryActionPerformed(evt);
            }
        });

        btn_transactionHistory.setText("Transaction History");
        btn_transactionHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transactionHistoryActionPerformed(evt);
            }
        });

        btn_helpCentre.setText("Help Centre");
        btn_helpCentre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_helpCentreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(188, 188, 188))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_orderHistory)
                            .addComponent(btn_viewVendors))
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_transactionHistory)
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_Notifications)
                            .addComponent(btn_helpCentre))
                        .addGap(183, 183, 183))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btn_viewVendors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_orderHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_transactionHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_helpCentre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Notifications)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_viewVendorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewVendorsActionPerformed
        // TODO add your handling code here:
        Customer_VendorSelection window = new Customer_VendorSelection(this.customer);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }//GEN-LAST:event_btn_viewVendorsActionPerformed

    private void btn_orderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orderHistoryActionPerformed
        // TODO add your handling code here:
        Customer_OrderHistory window = new Customer_OrderHistory(this.customer);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }//GEN-LAST:event_btn_orderHistoryActionPerformed

    private void btn_transactionHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transactionHistoryActionPerformed
        // TODO add your handling code here:
        Customer_TransactionHistory window = new Customer_TransactionHistory(this.customer);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }//GEN-LAST:event_btn_transactionHistoryActionPerformed

    private void btn_helpCentreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_helpCentreActionPerformed
        // TODO add your handling code here:
        Customer_HelpCentre window = new Customer_HelpCentre(this.customer);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }//GEN-LAST:event_btn_helpCentreActionPerformed

    private void btn_NotificationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NotificationsActionPerformed
        // TODO add your handling code here:
        Customer_Notifications window = new Customer_Notifications(this.customer);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }//GEN-LAST:event_btn_NotificationsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customer_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Dashboard().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Notifications;
    private javax.swing.JButton btn_helpCentre;
    private javax.swing.JButton btn_orderHistory;
    private javax.swing.JButton btn_transactionHistory;
    private javax.swing.JButton btn_viewVendors;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
