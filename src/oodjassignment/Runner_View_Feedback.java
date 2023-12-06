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

public class Runner_View_Feedback extends javax.swing.JFrame {

    Runner currentUser;
    String formattedDate;
    
    public Runner_View_Feedback() {
        initComponents();
    }
    
    public Runner_View_Feedback(Runner currentUser) {
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
    
    public void ListOfUser(String Vendor, String Customer, Calendar date){
        jTableFeedback.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTableFeedback.getColumnModel().getColumn(1).setPreferredWidth(15);
        jTableFeedback.getColumnModel().getColumn(2).setPreferredWidth(15);
        jTableFeedback.getColumnModel().getColumn(3).setPreferredWidth(250);
        DefaultTableModel model = (DefaultTableModel)jTableFeedback.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTableFeedback.setRowSorter(sorter);
        model.setRowCount(0);
        Identifier.Role role = Identifier.Role.Order;
        String lowercaseVendor = Vendor.toLowerCase();
        String lowercaseCustomer = Customer.toLowerCase();
        Main_Database<Order> db = new Main_Database<>(role);
        ArrayList<Order> data = db.ReadData();
        // Here
        Calendar selectedDate = jDateChooser.getCalendar();
        if(selectedDate != null){
            LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            formattedDate = localDate.format(formatter);
        }
        else{
            formattedDate = "";
        }
        // There
//        for (int i=0;i<data.size();i++){
//            String lowercaseVendorData = data.get(i).getVendorID().toLowerCase();
//            String lowercaseCustomerData = data.get(i).getCustomerID().toLowerCase();
//            if(Vendor.equals("")){
//                if(Customer.equals("")){
//                    if(formattedDate.equals("")){
//                        model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), "Null", data.get(i).getCreated_Date() + " " + data.get(i).getCreated_Time(), "Null"});
//                    }
//                    else if(formattedDate.equals(data.get(i).getCreated_Date())){
//                        
//                    }
//                }
//                else if (lowercaseCustomerData.contains(lowercaseCustomer)){
//                    if(formattedDate.equals("")){
//                        model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), "Null", data.get(i).getCreated_Date() + " " + data.get(i).getCreated_Time(), "Null"});
//                    }
//                    else if(formattedDate.equals(data.get(i).getCreated_Date())){
//                        
//                    }
//                }
//                
//            }
//            else if (lowercaseVendorData.contains(lowercaseVendor)){
//                if(Customer.equals("")){
//                    if(formattedDate.equals("")){
//                        model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), "Null", data.get(i).getCreated_Date() + " " + data.get(i).getCreated_Time(), "Null"});
//                    }
//                    else if(formattedDate.equals(data.get(i).getCreated_Date())){
//                        
//                    }
//                }
//                else if (lowercaseCustomerData.contains(lowercaseCustomer)){
//                    if(formattedDate.equals("")){
//                        model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), "Null", data.get(i).getCreated_Date() + " " + data.get(i).getCreated_Time(), "Null"});
//                    }
//                    else if(formattedDate.equals(data.get(i).getCreated_Date())){
//                        
//                    }
//                }
//                model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), "Null", data.get(i).getCreated_Date() + " " + data.get(i).getCreated_Time(), "Null"});
//            }    
//        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLogOut = new javax.swing.JButton();
        User_Name = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFeedback = new javax.swing.JTable();
        jTextOrder = new javax.swing.JTextField();
        jLabelFilter = new javax.swing.JLabel();
        jLabelOrder = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonLogOut.setText("Back");
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });

        User_Name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        User_Name.setText("User");

        jTableFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Rating", "Date", "Review"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFeedback.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableFeedback);

        jTextOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextOrderActionPerformed(evt);
            }
        });
        jTextOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextOrderKeyReleased(evt);
            }
        });

        jLabelFilter.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelFilter.setText("Filter:");

        jLabelOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOrder.setText("Order ID:");

        jLabelDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDate.setText("Date:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(User_Name)
                        .addGap(269, 269, 269))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonLogOut)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelFilter)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelOrder)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)
                                .addComponent(jLabelDate)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(25, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLogOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(User_Name)
                .addGap(2, 2, 2)
                .addComponent(jLabelFilter)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelOrder)
                        .addComponent(jLabelDate))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        GoHomePage();
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void jTextOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextOrderActionPerformed

    private void jTextOrderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextOrderKeyReleased
//        String position = Role.getSelectedItem().toString();
//        String name = jTextName.getText();
//        ListOfUser(position, name);
    }//GEN-LAST:event_jTextOrderKeyReleased

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
            java.util.logging.Logger.getLogger(Runner_View_Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Runner_View_Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Runner_View_Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Runner_View_Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Runner_View_Feedback().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel User_Name;
    private javax.swing.JButton jButtonLogOut;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelFilter;
    private javax.swing.JLabel jLabelOrder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFeedback;
    private javax.swing.JTextField jTextOrder;
    // End of variables declaration//GEN-END:variables
}
