/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodjassignment;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import oodjassignment.Roles.*;

/**
 *
 * @author user
 */
public class Runner_Order_List extends javax.swing.JFrame {

    Runner currentUser;
    String VendorId, CustomerId, CustomerName, Customer, Vendor, VendorName, OrderId;
    
    public Runner_Order_List() {
        initComponents();
    }
    
    public Runner_Order_List(Runner currentUser) {
        initComponents();
        this.currentUser = currentUser;
        User_Name.setText(currentUser.getName());
        jLabelOrder.setText("Order ID: ");
        jTextVendor.setEditable(false);
        jTextCustomer.setEditable(false);
        jTextLocation.setEditable(false);
        jTextFood.setEditable(false);
        ListOfHistory();
    }
    

    public void GoHomePage(){
        Runner_Home_Page hp = new Runner_Home_Page(currentUser);
        hp.setVisible(true);
        hp.pack();
        hp.setLocationRelativeTo(null);
        hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    public void ListOfHistory(){
        jTableOrder.getColumnModel().getColumn(0).setPreferredWidth(15);
        jTableOrder.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTableOrder.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTableOrder.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableOrder.getColumnModel().getColumn(4).setPreferredWidth(15);
        jTableOrder.getColumnModel().getColumn(5).setPreferredWidth(15);
        DefaultTableModel model = (DefaultTableModel)jTableOrder.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTableOrder.setRowSorter(sorter);
        model.setRowCount(0);
        Customer = jTextCustomer.getText();
        Vendor = jTextVendor.getText();
        Identifier.Role role = Identifier.Role.Order;
        Main_Database<Order> db = new Main_Database<>(role);
        ArrayList<Order> data = db.ReadData();
        Main_Database<Vendor> dbVendor = new Main_Database<>(Identifier.Role.Vendor);
        ArrayList<Vendor> dataVendor = dbVendor.ReadData();
        Main_Database<Customer> dbCustomer = new Main_Database<>(Identifier.Role.Customer);
        ArrayList<Customer> dataCustomer = dbCustomer.ReadData();
        Main_Database<Delivery> dbDelivery = new Main_Database<>(Identifier.Role.Delivery);
        ArrayList<Delivery> dataDelivery = dbDelivery.ReadData();
        // Print out all the order with Option being delivery and the OrderID does not exist in Delivery table
        // For completing, is the same concept but print out all based on Order ID with same runner ID in delivery Table that is OTW state
        // Send notification when complete order
        for (int i=0;i<data.size();i++){
            OrderId = data.get(i).getId();
            boolean state = true;
            for (Delivery dd : dataDelivery) {
                if(dd.getOrderId().equals(OrderId)){
                    state = false;
                    break;
                }
            }
            // Need to add status(Pending Runner, ReadyForCollection) change the option to enum
            if(data.get(i).getOptions().equals("Delivery") && state){
                VendorId = data.get(i).getVendorID();
                CustomerId = data.get(i).getCustomerID();
                for (Vendor dv : dataVendor) {
                    if(dv.getId().equals(VendorId)){
                        VendorName = dv.getName().toLowerCase();
                        break;
                    }
                }
                for (Customer dc : dataCustomer) {
                    if(dc.getId().equals(CustomerId)){
                        CustomerName = dc.getName().toLowerCase();
                        break;
                    }
                }
                model.addRow(new Object[] {OrderId, VendorName, CustomerName, data.get(i).getFoodName(), data.get(i).getLocation(), data.get(i).getTotalAmount()});
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        User_Name = new javax.swing.JLabel();
        jButtonLogOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrder = new javax.swing.JTable();
        jLabelOrder = new javax.swing.JLabel();
        jLabelVendor = new javax.swing.JLabel();
        jLabelCustomer = new javax.swing.JLabel();
        jLabelLocation = new javax.swing.JLabel();
        jLabelFood = new javax.swing.JLabel();
        jButtonAccept = new javax.swing.JButton();
        jTextVendor = new javax.swing.JTextField();
        jTextCustomer = new javax.swing.JTextField();
        jTextLocation = new javax.swing.JTextField();
        jTextFood = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        User_Name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        User_Name.setText("User");

        jButtonLogOut.setText("Back");
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });

        jTableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Vendor", "Customer", "Food", "Location", "Total"
            }
        ));
        jTableOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableOrder);

        jLabelOrder.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelOrder.setText("Order ID:");

        jLabelVendor.setText("Vendor:");

        jLabelCustomer.setText("Customer:");

        jLabelLocation.setText("Location:");

        jLabelFood.setText("Food:");

        jButtonAccept.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAccept.setText("Accept");
        jButtonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCustomer)
                            .addComponent(jLabelVendor))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(jTextVendor)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonLogOut)
                        .addGap(201, 201, 201)
                        .addComponent(User_Name)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelLocation)
                    .addComponent(jLabelOrder)
                    .addComponent(jLabelFood)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAccept)
                        .addGap(12, 12, 12)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFood, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(jTextLocation))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonLogOut))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(User_Name)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelOrder)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVendor)
                    .addComponent(jLabelLocation)
                    .addComponent(jTextVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jButtonAccept))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelFood)
                        .addComponent(jTextCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelCustomer)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        GoHomePage();
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void jTableOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrderMouseClicked
        try {
            int selectedRow = jTableOrder.getSelectedRow();
            String selectedOrderId = jTableOrder.getValueAt(selectedRow, 0).toString();
            String selectedVendor = jTableOrder.getValueAt(selectedRow, 1).toString();
            String selectedCustomer = jTableOrder.getValueAt(selectedRow, 2).toString();
            String selectedLocation = jTableOrder.getValueAt(selectedRow, 3).toString();
            String selectedFood = jTableOrder.getValueAt(selectedRow, 4).toString();
            jLabelOrder.setText("Order ID: " + selectedOrderId);
            jTextVendor.setText(selectedVendor);
            jTextCustomer.setText(selectedCustomer);
            jTextLocation.setText(selectedLocation);
            jTextFood.setText(selectedFood);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTableOrderMouseClicked

    private void jButtonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcceptActionPerformed
        // A function to accept order, basically create a Delivery table
    }//GEN-LAST:event_jButtonAcceptActionPerformed

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
            java.util.logging.Logger.getLogger(Runner_Order_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Runner_Order_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Runner_Order_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Runner_Order_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Runner_Order_List().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel User_Name;
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JLabel jLabelCustomer;
    private javax.swing.JLabel jLabelFood;
    private javax.swing.JLabel jLabelLocation;
    private javax.swing.JLabel jLabelOrder;
    private javax.swing.JLabel jLabelVendor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableOrder;
    private javax.swing.JTextField jTextCustomer;
    private javax.swing.JTextField jTextFood;
    private javax.swing.JTextField jTextLocation;
    private javax.swing.JTextField jTextVendor;
    // End of variables declaration//GEN-END:variables
}
