/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.assignmentjava.Shariq.UI;

import com.mycompany.assignmentjava.Shariq.Classes.Manager;
import com.mycompany.assignmentjava.Utilites.FileManager;
import java.awt.PopupMenu;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ysssh
 */
public class ManagerRevenueDashboardJFrame extends javax.swing.JFrame {
    Manager manager;

    /**
     * Creates new form Manager_RevenueDashboard
     * @param manager
     */
    
    public ManagerRevenueDashboardJFrame() {
        initComponents();
    }
    
    public ManagerRevenueDashboardJFrame(Manager manager) {
        initComponents();
        this.manager = manager;
        
        showAllVendors();
        showTotalRevenue();
        showTotalOrders();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotalRevenue = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTotalOrders = new javax.swing.JLabel();
        lblAvgOrder = new javax.swing.JLabel();
        lblAvgOrderValue = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSelectVendor = new javax.swing.JButton();
        lblTotalRevenueVendor = new javax.swing.JLabel();
        lblTotalOrdersVendor = new javax.swing.JLabel();
        lblAvgOrderVendor = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        btnRefreshVendors = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listVendors = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 500));

        jLabel1.setText("Vendor Performance");

        jLabel2.setText("Overview");

        jLabel3.setText("Total Revenue:");

        lblTotalRevenue.setText("[]");

        jLabel5.setText("Total Orders:");

        lblTotalOrders.setText("[]");

        lblAvgOrder.setText("Avg. Order Value:");

        lblAvgOrderValue.setText("[]");

        jLabel4.setText("Vendors");

        btnSelectVendor.setText("Select Vendor");
        btnSelectVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectVendorActionPerformed(evt);
            }
        });

        lblTotalRevenueVendor.setText("Revenue Generated:");

        lblTotalOrdersVendor.setText("Total Orders:");

        lblAvgOrderVendor.setText("Avg. Order Value:");

        jLabel11.setText("Target Revenue:");

        btnRefreshVendors.setText("⟳");
        btnRefreshVendors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshVendorsActionPerformed(evt);
            }
        });

        listVendors.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listVendors);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAvgOrder)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblAvgOrderValue))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblTotalRevenue)
                                            .addGap(98, 98, 98)
                                            .addComponent(jLabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblTotalOrders))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalOrdersVendor)
                                    .addComponent(lblAvgOrderVendor))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotalRevenueVendor)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(141, 141, 141)
                                .addComponent(btnRefreshVendors))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSelectVendor)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTotalRevenue)
                    .addComponent(jLabel5)
                    .addComponent(lblTotalOrders))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvgOrder)
                    .addComponent(lblAvgOrderValue))
                .addGap(55, 55, 55)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnRefreshVendors))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTotalOrdersVendor)
                        .addGap(22, 22, 22)
                        .addComponent(lblTotalRevenueVendor)
                        .addGap(18, 18, 18)
                        .addComponent(lblAvgOrderVendor)
                        .addGap(137, 137, 137)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(btnSelectVendor)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectVendorActionPerformed
        int selectedIndex = this.listVendors.getSelectedIndex();
        selectVendor(selectedIndex);
        showTotalOrdersOfVendor();
    }//GEN-LAST:event_btnSelectVendorActionPerformed

    private void btnRefreshVendorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshVendorsActionPerformed
        showAllVendors();
    }//GEN-LAST:event_btnRefreshVendorsActionPerformed

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
            java.util.logging.Logger.getLogger(ManagerRevenueDashboardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerRevenueDashboardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerRevenueDashboardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerRevenueDashboardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerRevenueDashboardJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefreshVendors;
    private javax.swing.JButton btnSelectVendor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAvgOrder;
    private javax.swing.JLabel lblAvgOrderValue;
    private javax.swing.JLabel lblAvgOrderVendor;
    private javax.swing.JLabel lblTotalOrders;
    private javax.swing.JLabel lblTotalOrdersVendor;
    private javax.swing.JLabel lblTotalRevenue;
    private javax.swing.JLabel lblTotalRevenueVendor;
    private javax.swing.JList<String> listVendors;
    // End of variables declaration//GEN-END:variables
    
    private void showAllVendors(){
        manager.monitorVendorPerformance.loadAllVendors();
        //(convert List<String> to String[] for JList)
        String[] vendorNames = manager.monitorVendorPerformance.listAllVendorNames().toArray(new String[0]);
        listVendors.setListData(vendorNames);
    }
    
    private void showTotalRevenue() {
        // DEBUG System.out.println("total orders: " + String.valueOf(manager.monitorVendorPerformance.calcTotalOrders()));
        this.lblTotalRevenue.setText("MYR " + String.valueOf(manager.monitorVendorPerformance.calcTotalRevenue()));
        this.lblTotalRevenueVendor.setText("MYR " + String.valueOf(manager.monitorVendorPerformance.calcTotalRevenue()));
    }
    
    private void showTotalOrders() {
        // DEBUG System.out.println("total orders: " + String.valueOf(manager.monitorVendorPerformance.calcTotalOrders()));
        this.lblTotalOrders.setText(String.valueOf(manager.monitorVendorPerformance.calcTotalOrders()));
        
    }
    
    private void showAvgOrder() {
        // DEBUG System.out.println("total orders: " + String.valueOf(manager.monitorVendorPerformance.calcTotalOrders()));
        this.lblAvgOrder.setText("MYR " + String.valueOf(manager.monitorVendorPerformance.calcAvgOrderValue()));
        this.lblAvgOrderVendor.setText("MYR " + String.valueOf(manager.monitorVendorPerformance.calcAvgOrderValue()));
    }

    private void showTotalOrdersOfVendor() {

    }

    private void selectVendor(int index) {
        if (index >= 0 && index < manager.monitorVendorPerformance.getVendorList().size()) {
            manager.monitorVendorPerformance.selectVendor(index);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a vendor.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
}
