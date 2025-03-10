/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.UI;

import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Utilites.ObjectWriter;
import com.mycompany.assignmentjava.Zakwaan.Classes.Customer;
import com.mycompany.assignmentjava.Zakwaan.Classes.Product;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zechn
 */
public class Customer_FoodMenu extends javax.swing.JFrame {

    /**
     * Creates new form Customer_VendorSelection
     */
    
    private Vendor vendor;
    private Customer customer;
    private int selectedRowIndex;
    private Product selectedProduct;
    
    public Customer_FoodMenu(Customer customer, Vendor vendor) {
        initComponents();
        this.customer = customer;
        this.vendor = vendor;
        System.out.println(this.vendor.getVendorID());
        
        addRowsToTable();
    }
    
    public Customer_FoodMenu() {
        initComponents();
    }
    
    //------Methods
    public void addRowsToTable(){
        DefaultTableModel model = (DefaultTableModel)table_FoodMenu.getModel();
        List<Product> productsList = ObjectWriter.getProductListByVendorID(this.vendor.getVendorID());
        Object rowData[] = new Object[2];
        
        for (Product product : productsList){
            rowData[0] = product.getProductName();
            rowData[1] = product.getPrice();
            model.addRow(rowData);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_Back = new javax.swing.JButton();
        btn_AddToCart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_FoodMenu = new javax.swing.JTable();
        btn_GoToCart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Menu");

        btn_Back.setText("Back");

        btn_AddToCart.setText("Add to Cart");
        btn_AddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddToCartActionPerformed(evt);
            }
        });

        table_FoodMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Price"
            }
        ));
        table_FoodMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_FoodMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_FoodMenu);

        btn_GoToCart.setText("Go to Cart");
        btn_GoToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GoToCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 625, Short.MAX_VALUE)
                        .addComponent(btn_AddToCart))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_GoToCart)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_GoToCart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Back)
                    .addComponent(btn_AddToCart))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_FoodMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_FoodMenuMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)table_FoodMenu.getModel();
        if(selectedRowIndex != -1){
            selectedRowIndex = table_FoodMenu.getSelectedRow();
        }
    }//GEN-LAST:event_table_FoodMenuMouseClicked

    private void btn_AddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddToCartActionPerformed
        // TODO add your handling code here:
        List<Product> productsList = ObjectWriter.getProductListByVendorID(this.vendor.getVendorID());
        selectedProduct = productsList.get(selectedRowIndex);
        this.customer.customerCart.addProductToCart(selectedProduct);
    }//GEN-LAST:event_btn_AddToCartActionPerformed

    private void btn_GoToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GoToCartActionPerformed
        // TODO add your handling code here:
        Customer_Cart window = new Customer_Cart(this.customer);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }//GEN-LAST:event_btn_GoToCartActionPerformed

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
            java.util.logging.Logger.getLogger(Customer_FoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_FoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_FoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_FoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_FoodMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddToCart;
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_GoToCart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_FoodMenu;
    // End of variables declaration//GEN-END:variables
}
