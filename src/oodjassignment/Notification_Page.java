/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodjassignment;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Identifier.Role;
import oodjassignment.Roles.Notification.State;

public class Notification_Page extends javax.swing.JFrame {

    Object currentUser;
    String ReceivedId, Sender, SenderId,selectedId, selectedSender, selectedMessage;
    
    public Notification_Page() {
        initComponents();
        ListOfNotification();
    }
    
    public Notification_Page(Runner currentUser) {
        initComponents();
        this.currentUser = (Runner) currentUser;
        User_Name.setText(currentUser.getName());
        ListOfNotification();
        jButtonMarkAsRead.setEnabled(false);
    }
    
    public Notification_Page(Vendor currentUser) {
        initComponents();
        this.currentUser = (Vendor) currentUser;
        User_Name.setText(currentUser.getName());
        ListOfNotification();
        jButtonMarkAsRead.setEnabled(false);
    }
    
    public Notification_Page(Customer currentUser) {
        initComponents();
        this.currentUser = (Customer) currentUser;
        User_Name.setText(currentUser.getName());
        ListOfNotification();
        jButtonMarkAsRead.setEnabled(false);
    }

    public void Return(){
        if (currentUser instanceof Runner runner){
            Runner_Home_Page rp = new Runner_Home_Page(runner);
            rp.setVisible(true);
            rp.pack();
            rp.setLocationRelativeTo(null);
            rp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else if (currentUser instanceof Customer customer){
            Customer_Home_Page cp = new Customer_Home_Page(customer);
            cp.setVisible(true);
            cp.pack();
            cp.setLocationRelativeTo(null);
            cp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else if (currentUser instanceof Vendor vendor){
            Vendor_Home_Page vp = new Vendor_Home_Page(vendor);
            vp.setVisible(true);
            vp.pack();
            vp.setLocationRelativeTo(null);
            vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        this.dispose();
    }
    
    public void ListOfNotification(){
        int count = 0;
        jTableNotification.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTableNotification.getColumnModel().getColumn(1).setPreferredWidth(15);
        jTableNotification.getColumnModel().getColumn(2).setPreferredWidth(200);
        DefaultTableModel model = (DefaultTableModel)jTableNotification.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTableNotification.setRowSorter(sorter);
        model.setRowCount(0);
        Main_Database<Notification> db = new Main_Database<>(Role.Notification);
        ArrayList<Notification> data = db.ReadData();
        Main_Database<Runner> rb = new Main_Database<>(Role.Runner);
        ArrayList<Runner> rdata = rb.ReadData();
        Main_Database<Customer> cb = new Main_Database<>(Role.Customer);
        ArrayList<Customer> cdata = cb.ReadData();
        Main_Database<Vendor> vb = new Main_Database<>(Role.Vendor);
        ArrayList<Vendor> vdata = vb.ReadData();
        Main_Database<Admin> ab = new Main_Database<>(Role.Admin);
        ArrayList<Admin> adata = ab.ReadData();
        for (int i=0;i<data.size();i++){
            this.ReceivedId = data.get(i).getReceiverId();
            this.SenderId = data.get(i).getSenderId();
            switch (SenderId.charAt(0)) {
                case 'V':
                    for (Vendor dv : vdata) {
                        if(dv.getId().equals(SenderId)){
                            this.Sender = dv.getName();
                            break;
                        }
                    }       break;
                case 'R':
                    for (Runner rc : rdata) {
                        if(rc.getId().equals(SenderId)){
                            this.Sender = rc.getName();
                            break;
                        }
                    }   break;
                case 'C':
                    for (Customer dc : cdata) {
                        if(dc.getId().equals(SenderId)){
                            this.Sender = dc.getName();
                            break;
                        }
                    }   break;
                case 'A':
                    for (Admin ac : adata) {
                        if(ac.getId().equals(SenderId)){
                            this.Sender = ac.getName();
                            break;
                        }
                    }   break;
                default:
                    break;
            }
            if (currentUser instanceof Runner runner){
                if (ReceivedId.equals(runner.getId()) && data.get(i).getState().equals(State.Sent)){
                    count++;
                    model.addRow(new Object[] {data.get(i).getId(), Sender, data.get(i).getMessage()});
                }
            }
            else if (currentUser instanceof Customer customer){
                if (ReceivedId.equals(customer.getId()) && data.get(i).getState().equals(State.Sent)){
                    count++;
                    model.addRow(new Object[] {data.get(i).getId(), Sender, data.get(i).getMessage()});
                }
            }
            else if (currentUser instanceof Vendor vendor){
                if (ReceivedId.equals(vendor.getId()) && data.get(i).getState().equals(State.Sent)){
                    count++;
                    model.addRow(new Object[] {data.get(i).getId(), Sender, data.get(i).getMessage()});
                }
            }
        }
        if (count == 0){
            jButtonMarkAllAsRead.setEnabled(false);
        }
        else{
            jButtonMarkAllAsRead.setEnabled(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLogOut = new javax.swing.JButton();
        User_Name = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNotification = new javax.swing.JTable();
        jButtonMarkAllAsRead = new javax.swing.JButton();
        jButtonMarkAsRead = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonLogOut.setText("Back");
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });

        User_Name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        User_Name.setText("User");

        jTableNotification.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Noti_ID", "Sender", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableNotification.getTableHeader().setReorderingAllowed(false);
        jTableNotification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNotificationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNotification);

        jButtonMarkAllAsRead.setText("Mark all as read");
        jButtonMarkAllAsRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMarkAllAsReadActionPerformed(evt);
            }
        });

        jButtonMarkAsRead.setText("Mark as read");
        jButtonMarkAsRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMarkAsReadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtonLogOut))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(257, 257, 257)
                                .addComponent(User_Name)))
                        .addGap(0, 257, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonMarkAllAsRead)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonMarkAsRead)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLogOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(User_Name)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMarkAllAsRead)
                    .addComponent(jButtonMarkAsRead))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        Return();
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void jButtonMarkAllAsReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarkAllAsReadActionPerformed
        Main_Database<Notification> db = new Main_Database<>(Identifier.Role.Notification);
        ArrayList<Notification> data = db.ReadData();
        for (int i=0;i<data.size();i++){
            Notification notification = (Notification) data.get(i);
            if (currentUser instanceof Runner runner){
                if (ReceivedId.equals(runner.getId())){
                    notification.setState(State.Seen);
                    data.set(i, notification);
                    db.updateData(Role.Notification, data);
                }
            }
            else if (currentUser instanceof Customer customer){
                if (ReceivedId.equals(customer.getId())){
                    notification.setState(State.Seen);
                    data.set(i, notification);
                    db.updateData(Role.Notification, data);
                }
            }
            else if (currentUser instanceof Vendor vendor){
                if (ReceivedId.equals(vendor.getId())){
                    notification.setState(State.Seen);
                    data.set(i, notification);
                    db.updateData(Role.Notification, data);
                }
            }
        }
        ListOfNotification();
    }//GEN-LAST:event_jButtonMarkAllAsReadActionPerformed

    private void jButtonMarkAsReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarkAsReadActionPerformed
        Main_Database<Notification> db = new Main_Database<>(Identifier.Role.Notification);
        ArrayList<Notification> data = db.ReadData();
        for (int i=0;i<data.size();i++){
            Notification notification = (Notification) data.get(i);
            if(notification.getId().equals(selectedId)){
                notification.setState(State.Seen);
                data.set(i, notification);
                db.updateData(Role.Notification, data);
            }
        }
        jButtonMarkAsRead.setEnabled(false);
        ListOfNotification();
    }//GEN-LAST:event_jButtonMarkAsReadActionPerformed

    private void jTableNotificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNotificationMouseClicked
        try {
            int selectedRow = jTableNotification.getSelectedRow();
            this.selectedId = jTableNotification.getValueAt(selectedRow, 0).toString();
            this.selectedSender = jTableNotification.getValueAt(selectedRow, 1).toString();
            this.selectedMessage = jTableNotification.getValueAt(selectedRow, 2).toString();
            jButtonMarkAsRead.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTableNotificationMouseClicked

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
            java.util.logging.Logger.getLogger(Notification_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notification_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notification_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notification_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notification_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel User_Name;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JButton jButtonMarkAllAsRead;
    private javax.swing.JButton jButtonMarkAsRead;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNotification;
    // End of variables declaration//GEN-END:variables
}
