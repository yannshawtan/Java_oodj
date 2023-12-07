/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodjassignment;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import oodjassignment.Roles.*;

/**
 *
 * @author user
 */
public class Runner_Order_List extends javax.swing.JFrame {

    Runner currentUser;
    String VendorId, CustomerId, Customer, Vendor, CustomerName, VendorName, Location, Food;
    
    public Runner_Order_List() {
        initComponents();
    }
    
    public Runner_Order_List(Runner currentUser) {
        initComponents();
        this.currentUser = currentUser;
        User_Name.setText(currentUser.getName());
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
        jTableOrder.getColumnModel().getColumn(3).setPreferredWidth(25);
        jTableOrder.getColumnModel().getColumn(4).setPreferredWidth(15);
        jTableOrder.getColumnModel().getColumn(5).setPreferredWidth(100);
        DefaultTableModel model = (DefaultTableModel)jTableOrder.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTableOrder.setRowSorter(sorter);
        model.setRowCount(0);
        Customer = jTextCustomer.getText();
        Vendor = jTextVendor.getText();
        Identifier.Role role = Identifier.Role.Order;
        String lowercaseVendor = Vendor.toLowerCase();
        String lowercaseCustomer = Customer.toLowerCase();
        Main_Database<Order> db = new Main_Database<>(role);
        ArrayList<Order> data = db.ReadData();
        Main_Database<Vendor> dbVendor = new Main_Database<>(Identifier.Role.Vendor);
        ArrayList<Vendor> dataVendor = dbVendor.ReadData();
        Main_Database<Customer> dbCustomer = new Main_Database<>(Identifier.Role.Customer);
        ArrayList<Customer> dataCustomer = dbCustomer.ReadData();
        // Print out all the order with Option being delivery and the OrderID does not exist in Delivery table
        // For completing, is the same concept but print out all based on Order ID with same runner ID in delivery Table that is OTW state
        // Send notification when complete order
        for (int i=0;i<data.size();i++){
            if(data.get(i).getRunnerId()!= null && data.get(i).getRunnerId().equals(currentUser.getId())){
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
                if(Vendor.equals("")){
                    if(Customer.equals("")){
//                        if(formattedDate.equals("")){
//                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
//                        }
//                        else if(formattedDate.equals(data.get(i).getCreated_Dt())){
//                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
//                        }
                    }
                    else if (CustomerName.contains(lowercaseCustomer)){
//                        if(formattedDate.equals("")){
//                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
//                        }
//                        else if(formattedDate.equals(data.get(i).getCreated_Dt())){
//                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
//                        }
                    }

                }
                else if (VendorName.contains(lowercaseVendor)){
                    if(Customer.equals("")){
//                        if(formattedDate.equals("")){
//                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
//                        }
//                        else if(formattedDate.equals(data.get(i).getCreated_Dt())){
//                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
//                        }
                    }
                    else if (CustomerName.contains(lowercaseCustomer)){
//                        if(formattedDate.equals("")){
//                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
//                        }
//                        else if(formattedDate.equals(data.get(i).getCreated_Dt())){
//                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
//                        }
                    }
                }
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
        jButton1 = new javax.swing.JButton();
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
        jScrollPane1.setViewportView(jTableOrder);

        jLabelOrder.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelOrder.setText("Order ID:");

        jLabelVendor.setText("Vendor:");

        jLabelCustomer.setText("Customer:");

        jLabelLocation.setText("Location:");

        jLabelFood.setText("Food:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Accept");

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
                        .addComponent(jButton1)
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
                        .addComponent(jButton1))
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
    private javax.swing.JButton jButton1;
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
