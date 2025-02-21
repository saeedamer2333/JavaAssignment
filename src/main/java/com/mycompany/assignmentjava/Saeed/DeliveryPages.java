/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.assignmentjava.Saeed;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class DeliveryPages extends javax.swing.JFrame {

    /**
     * Creates new form DeliveryPages
     */
    
    private Deliveryrunner Runner;
    private String RunnerID;
    public DeliveryPages() {
       initComponents();
        // initate as homepage
        populateTaskTable();
       //initiate as teh first fliter 
       updateDashboard("day");
       
    }
    
 public DeliveryPages(String[] userDetails) {
        //Initialize attributes
        this.RunnerID = userDetails[0];
       
    }
 
 
    
    private void populatedata(JTable table ,String [] columns ,  List<String[]> data) {
       // Retrieve the list of tasks assigned to this runner
       

       // Column names for JTable
       

       // Create a DefaultTableModel to hold the task data
       DefaultTableModel model = new DefaultTableModel(columns, 0);

       // Add the rows to the table model
       for (String[] rowdata : data) {
           model.addRow(rowdata);
       }

       // Set the model to the JTable
       table.setModel(model);
   }
    
    private void populateTaskTable() {
        
        
        String[] columns = {"Task ID","Customer Name", "Vendor Name", "Products", "Status","Address", "Delivery Fees", "Total Amount", "Order Date"};
        Runner  = new  Deliveryrunner();
       List<String[]> task = Runner.getTask("runner2");
       populatedata(tasktable,columns,task);
    
    // Add MouseListener to jTable5 to handle row clicks and display data in JTextFields
        tasktable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            // Get the selected row index
            int row = tasktable.getSelectedRow();
            
            // Get the data from the selected row
            if (row != -1) {
                 String TaksID = (String) tasktable.getValueAt(row, 0);        // taskid
                String customerName = (String) tasktable.getValueAt(row, 1);  // Customer Name column
                String vendorName = (String) tasktable.getValueAt(row, 2);    // Vendor Name column
                String products = (String) tasktable.getValueAt(row, 3);      // Products column
                String status = (String) tasktable.getValueAt(row, 4);        // Status column
                String deliveryFees = (String) tasktable.getValueAt(row, 5);  // Delivery Fees column
                String totalAmount = (String) tasktable.getValueAt(row, 6);   // Total Amount column
                String orderDate = (String) tasktable.getValueAt(row, 7);     // Order Date column
                
                // Set the values into the JTextFields
                taskidtxf.setText(TaksID);
                CutomerNametxfe.setText(customerName);
                vendorNametxf.setText(vendorName);
                Producttxf.setText(products);
                statustxf.setText(status);
                Producttxf.setText(deliveryFees);
                totalamounttxf.setText(totalAmount);
                orderdatetxf.setText(orderDate);
            }
        }
    });
}

    
    
    
     private void initfilterComponents() {
        // Add ComboBox ActionListener to handle filter change
        revenuflitercob.addActionListener(evt -> {
            String selectedFilter = (String) revenuflitercob.getSelectedItem();
            String filter = selectedFilter.toLowerCase();  // Convert to lower case for comparison
            updateDashboard(filter);  // Update the dashboard based on selected filter
  
        });

        // Other initializations...
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    private void updateDashboard(String dateRange) {
        // Get revenue data for the selected filter (daily, monthly, yearly)
        List<String[]> revenueData = Runner.getRevenueData(dateRange, "runner2" );

        // Convert the revenue data to a 2D array for JTable display
        String[][] data = new String[revenueData.size()][3];
        for (int i = 0; i < revenueData.size(); i++) {
            data[i][0] = revenueData.get(i)[0];  // Order Date
            data[i][1] = revenueData.get(i)[1];  // Revenue (Delivery Fee)
            data[i][2] = revenueData.get(i)[2]; // Order counts
        }

        // Define column names for the JTable
        String[] columnNames = {"Order Date", "Revenue", "Order Count"};

        // Update the table model with the new data
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable2.setModel(model);  // Populate the jTable with the data
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CutomerNametxfe1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        homepage = new javax.swing.JPanel();
        CutomerNametxfe = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasktable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        updatestatuscomb = new javax.swing.JComboBox<>();
        vendorNametxf = new javax.swing.JTextField();
        statustxf = new javax.swing.JTextField();
        Producttxf = new javax.swing.JTextField();
        totalamounttxf = new javax.swing.JTextField();
        orderdatetxf = new javax.swing.JTextField();
        taskidtxf = new javax.swing.JTextField();
        dashbord = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        revenuflitercob = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        notificationpnl = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        orderstable = new javax.swing.JTable();
        acceptbtn = new javax.swing.JButton();
        declinebtn = new javax.swing.JButton();
        historypnl = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        historytbl = new javax.swing.JTable();
        CustomerFeedbackpnl = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        homepagebtn = new javax.swing.JButton();
        dashboradbtn = new javax.swing.JButton();
        orderbtn = new javax.swing.JButton();
        History = new javax.swing.JButton();
        customerreviewbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setText("Update status");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tasktable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tasktable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Order Details");

        updatestatuscomb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pick up", "On the way", "Delivered" }));

        Producttxf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProducttxfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homepageLayout = new javax.swing.GroupLayout(homepage);
        homepage.setLayout(homepageLayout);
        homepageLayout.setHorizontalGroup(
            homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homepageLayout.createSequentialGroup()
                .addGroup(homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homepageLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(homepageLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vendorNametxf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CutomerNametxfe, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Producttxf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statustxf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalamounttxf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updatestatuscomb, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderdatetxf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taskidtxf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(homepageLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        homepageLayout.setVerticalGroup(
            homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepageLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(taskidtxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CutomerNametxfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vendorNametxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Producttxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(statustxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalamounttxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderdatetxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updatestatuscomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homepageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("hompage", homepage);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Total Reveun", "Ordercounts"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        revenuflitercob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day", "Month", "Year" }));
        revenuflitercob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revenuflitercobActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Filter ");

        javax.swing.GroupLayout dashbordLayout = new javax.swing.GroupLayout(dashbord);
        dashbord.setLayout(dashbordLayout);
        dashbordLayout.setHorizontalGroup(
            dashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashbordLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(revenuflitercob, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashbordLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
                .addContainerGap())
        );
        dashbordLayout.setVerticalGroup(
            dashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashbordLayout.createSequentialGroup()
                .addGroup(dashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashbordLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3))
                    .addGroup(dashbordLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(revenuflitercob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dashborad", dashbord);

        orderstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(orderstable);

        acceptbtn.setText("Accept");
        acceptbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        declinebtn.setText("Decline");
        declinebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declinebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout notificationpnlLayout = new javax.swing.GroupLayout(notificationpnl);
        notificationpnl.setLayout(notificationpnlLayout);
        notificationpnlLayout.setHorizontalGroup(
            notificationpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationpnlLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(acceptbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(declinebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(notificationpnlLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
                .addContainerGap())
        );
        notificationpnlLayout.setVerticalGroup(
            notificationpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notificationpnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addGroup(notificationpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(declinebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acceptbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Notification", notificationpnl);

        historytbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(historytbl);

        javax.swing.GroupLayout historypnlLayout = new javax.swing.GroupLayout(historypnl);
        historypnl.setLayout(historypnlLayout);
        historypnlLayout.setHorizontalGroup(
            historypnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historypnlLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
                .addContainerGap())
        );
        historypnlLayout.setVerticalGroup(
            historypnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historypnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("history", historypnl);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Feedback", "Date"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout CustomerFeedbackpnlLayout = new javax.swing.GroupLayout(CustomerFeedbackpnl);
        CustomerFeedbackpnl.setLayout(CustomerFeedbackpnlLayout);
        CustomerFeedbackpnlLayout.setHorizontalGroup(
            CustomerFeedbackpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerFeedbackpnlLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
                .addContainerGap())
        );
        CustomerFeedbackpnlLayout.setVerticalGroup(
            CustomerFeedbackpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerFeedbackpnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Review", CustomerFeedbackpnl);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        homepagebtn.setText("Home Page");
        homepagebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homepagebtnActionPerformed(evt);
            }
        });

        dashboradbtn.setText("Dashborad");
        dashboradbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboradbtnActionPerformed(evt);
            }
        });

        orderbtn.setText("Order");
        orderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderbtnActionPerformed(evt);
            }
        });

        History.setText("History");
        History.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryActionPerformed(evt);
            }
        });

        customerreviewbtn.setText("Custoemr Review");
        customerreviewbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerreviewbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homepagebtn)
                .addGap(18, 18, 18)
                .addComponent(orderbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dashboradbtn)
                .addGap(18, 18, 18)
                .addComponent(History)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerreviewbtn)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homepagebtn)
                    .addComponent(dashboradbtn)
                    .addComponent(orderbtn)
                    .addComponent(History)
                    .addComponent(customerreviewbtn))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void revenuflitercobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revenuflitercobActionPerformed
        // TODO add your handling code here:
        initfilterComponents();
    }//GEN-LAST:event_revenuflitercobActionPerformed

    private void homepagebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homepagebtnActionPerformed
        // TODO add your handling code here:
        
        jTabbedPane1.setSelectedIndex(0);
        
        
         // retreive task from order.txt
        String[] columns = {"Task ID","Customer Name", "Vendor Name", "Products", "Status", "Address","Delivery Fees", "Total Amount", "Order Date"};
        Runner  = new  Deliveryrunner();
       List<String[]> task = Runner.getTask("runner2");
       populatedata(tasktable,columns,task);
    }//GEN-LAST:event_homepagebtnActionPerformed

    private void dashboradbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboradbtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        
    }//GEN-LAST:event_dashboradbtnActionPerformed

    private void orderbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderbtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        
        // retrive the data of avavible orders
        String[] columns = {"Task Id","Customer Name", "Vendor Name", "Products", "Status", "Address","Delivery Fees", "Total Amount", "Order Date"};
        Runner  = new  Deliveryrunner();
       List<String[]> orders = Runner.getOrdersForRunner("runner2");
       populatedata(orderstable,columns,orders);
    }//GEN-LAST:event_orderbtnActionPerformed

    private void HistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
     List<String[]> historyData = Runner.getHistory("runner2");  // Use the appropriate runner ID
    
    // Define the columns you want to display
    String[] columns = {"Customer Name", "Vendor Name", "Products", "Status", "Delivery Fees", "Total Amount", "Order Date"};
    
    // Populate the JTable with the data
    populatedata(historytbl, columns, historyData);
    
    
    }//GEN-LAST:event_HistoryActionPerformed

    private void customerreviewbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerreviewbtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_customerreviewbtnActionPerformed

    private void ProducttxfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProducttxfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProducttxfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    updatestatuscomb.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Get the selected status from the combo box
        String selectedStatus = (String) updatestatuscomb.getSelectedItem();
        
        // Get the orderID from UI
        String orderID = taskidtxf.getText(); // Retrieve text entered in the JTextField
        
        // Check if orderID is not empty
        if (orderID.trim().isEmpty()) {
            // Show an error dialog if the orderID is empty
            JOptionPane.showMessageDialog(null, "Select raw ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
      
        // Call the UpdateOrderStatus method
        Runner.UpdateOrderStatus(orderID,selectedStatus,RunnerID); 
    }
    });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void declinebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declinebtnActionPerformed
        // TODO add your handling code here:
        orderstable.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        // Get the selected row index
        int row = orderstable.getSelectedRow();
        
         if (row == -1) {
            // No row selected, show a warning dialog
            JOptionPane.showMessageDialog(null, "Please select a row to reject the order.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;  // Exit the method if no row is selected
        }
        // Get the orderID, runnerI from the selected row
       String orderID = (String) orderstable.getValueAt(row, 0);  // Assuming orderID is in the first column
         
        

        // Call the rejectOrder method with the extracted parameters
       Runner.rejectOrder(orderID,"runner2");
    }
});
        
    }//GEN-LAST:event_declinebtnActionPerformed

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
            java.util.logging.Logger.getLogger(DeliveryPages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliveryPages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliveryPages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeliveryPages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeliveryPages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CustomerFeedbackpnl;
    private javax.swing.JTextField CutomerNametxfe;
    private javax.swing.JTextField CutomerNametxfe1;
    private javax.swing.JButton History;
    private javax.swing.JTextField Producttxf;
    private javax.swing.JButton acceptbtn;
    private javax.swing.JButton customerreviewbtn;
    private javax.swing.JButton dashboradbtn;
    private javax.swing.JPanel dashbord;
    private javax.swing.JButton declinebtn;
    private javax.swing.JPanel historypnl;
    private javax.swing.JTable historytbl;
    private javax.swing.JPanel homepage;
    private javax.swing.JButton homepagebtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JPanel notificationpnl;
    private javax.swing.JButton orderbtn;
    private javax.swing.JTextField orderdatetxf;
    private javax.swing.JTable orderstable;
    private javax.swing.JComboBox<String> revenuflitercob;
    private javax.swing.JTextField statustxf;
    private javax.swing.JTextField taskidtxf;
    private javax.swing.JTable tasktable;
    private javax.swing.JTextField totalamounttxf;
    private javax.swing.JComboBox<String> updatestatuscomb;
    private javax.swing.JTextField vendorNametxf;
    // End of variables declaration//GEN-END:variables

    private List<String[]> Viewtask(String RunnerID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
