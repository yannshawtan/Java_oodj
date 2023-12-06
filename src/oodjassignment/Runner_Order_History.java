/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodjassignment;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import oodjassignment.Roles.*;

public class Runner_Order_History extends javax.swing.JFrame {

    Runner currentUser;
    String formattedDate, VendorId, CustomerId, Customer, Vendor, CustomerName, VendorName;
    
    public Runner_Order_History() {
        initComponents();
        ListOfHistory();
    }
    
    public Runner_Order_History(Runner currentUser) {
        initComponents();
        this.currentUser = currentUser;
        User_Name.setText(currentUser.getName());
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
        Calendar selectedDate = jDateChooser.getCalendar();
        if(selectedDate != null){
            LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            formattedDate = localDate.format(formatter);
        }
        else{
            formattedDate = "";
        }
        for (int i=0;i<data.size();i++){
            String lowercaseVendorData = data.get(i).getVendorID().toLowerCase();
            String lowercaseCustomerData = data.get(i).getCustomerID().toLowerCase();
            if(data.get(i).getRunnerId()!= null && data.get(i).getRunnerId().equals(currentUser.getId())){
                VendorId = data.get(i).getVendorID();
                CustomerId = data.get(i).getCustomerID();
                for (Vendor dv : dataVendor) {
                    if(dv.getId().equals(VendorId)){
                        VendorName = dv.getName();
                        break;
                    }
                }
                for (Customer dc : dataCustomer) {
                    if(dc.getId().equals(CustomerId)){
                        CustomerName = dc.getName();
                        break;
                    }
                }
                if(Vendor.equals("")){
                    if(Customer.equals("")){
                        if(formattedDate.equals("")){
                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
                        }
                        else if(formattedDate.equals(data.get(i).getCreated_Dt())){
                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
                        }
                    }
                    else if (lowercaseCustomerData.contains(lowercaseCustomer)){
                        if(formattedDate.equals("")){
                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
                        }
                        else if(formattedDate.equals(data.get(i).getCreated_Dt())){
                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
                        }
                    }

                }
                else if (lowercaseVendorData.contains(lowercaseVendor)){
                    if(Customer.equals("")){
                        if(formattedDate.equals("")){
                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
                        }
                        else if(formattedDate.equals(data.get(i).getCreated_Dt())){
                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
                        }
                    }
                    else if (lowercaseCustomerData.contains(lowercaseCustomer)){
                        if(formattedDate.equals("")){
                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
                        }
                        else if(formattedDate.equals(data.get(i).getCreated_Dt())){
                            model.addRow(new Object[] {data.get(i).getId(), VendorName, CustomerName, data.get(i).getTotalAmount(), data.get(i).getStringRatingForRunner(), data.get(i).getCreated_Dt() + " " + data.get(i).getCreated_Time()});
                        }
                    }
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLogOut = new javax.swing.JButton();
        User_Name = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrder = new javax.swing.JTable();
        jTextVendor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextCustomer = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonLogOut.setText("Back");
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });

        User_Name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        User_Name.setText("User");

        jTableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Vendor", "Customer", "Total", "Rating", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOrder.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableOrder);

        jTextVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextVendorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Filter:");

        jTextCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCustomerActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Customer:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Vendor:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Date:");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(250, 250, 250))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(34, 34, 34)
                                        .addComponent(jTextVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(37, 37, 37)
                                        .addComponent(jTextCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonLogOut)
                        .addGap(255, 255, 255)
                        .addComponent(User_Name)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonLogOut)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(User_Name)
                        .addGap(77, 77, 77)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        GoHomePage();
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void jTextVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextVendorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextVendorActionPerformed

    private void jTextCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCustomerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ListOfHistory();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Runner_Order_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Runner_Order_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Runner_Order_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Runner_Order_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Runner_Order_History().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel User_Name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonLogOut;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableOrder;
    private javax.swing.JTextField jTextCustomer;
    private javax.swing.JTextField jTextVendor;
    // End of variables declaration//GEN-END:variables
}
