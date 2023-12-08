/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodjassignment;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import oodjassignment.Roles.Menu;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Order.Options;
import oodjassignment.Roles.Order.Status;

/**
 *
 * @author myste
 */
public class Cus_Order_History extends javax.swing.JFrame {

    /**
     * Creates new form Order_History
     */
    
    Customer currentUser;
    Identifier.Role role = Identifier.Role.Order;
    String SelectedId;
    Main_Database<Order> MD = new Main_Database<>(role);
    public Cus_Order_History(Customer currentUser) {
        initComponents();
        System.out.println(currentUser);
        this.currentUser = currentUser;
        Vendor.setVisible(false);
        Runner.setVisible(false);
        DisplayHistory();
        OrderId.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        OrderhistoryT = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        View = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        OrderId = new javax.swing.JTextField();
        Vendor = new javax.swing.JButton();
        Runner = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OrderhistoryT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "OrderID", "TotalPrice", "Options", "Status", "Created Date", "Created Time"
            }
        ));
        OrderhistoryT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderhistoryTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(OrderhistoryT);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Order History");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        View.setText("View Receipt");
        View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewActionPerformed(evt);
            }
        });

        jLabel2.setText("Selected Order");

        OrderId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderIdActionPerformed(evt);
            }
        });

        Vendor.setText("Vendor rating");
        Vendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VendorActionPerformed(evt);
            }
        });

        Runner.setText("Runner Rating");
        Runner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunnerActionPerformed(evt);
            }
        });

        jButton2.setText("check for feedback");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(View)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(342, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(OrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Runner)
                    .addComponent(Vendor)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(OrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(25, 25, 25)
                        .addComponent(Vendor)
                        .addGap(34, 34, 34)
                        .addComponent(Runner)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(View))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Customer_Home_Page chp = new Customer_Home_Page(currentUser);
        chp.setVisible(true);
        chp.pack();
        chp.setLocationRelativeTo(null);
        chp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewActionPerformed
        SelectedId = OrderId.getText();
        GoCusReceipt(SelectedId);
        System.out.println(SelectedId);
    }//GEN-LAST:event_ViewActionPerformed
    
    private void GoCusReceipt(String SelectedId){
        Cus_Receipt cs = new Cus_Receipt(SelectedId, currentUser);
        cs.setVisible(true);
        cs.pack();
        cs.setLocationRelativeTo(null);
        cs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    private void GovendorFeedback(String SelectedId){
        Cus_Vendorfb vf = new Cus_Vendorfb(SelectedId, currentUser);
        vf.setVisible(true);
        vf.pack();
        vf.setLocationRelativeTo(null);
        vf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    private void GorunnerFeedback(String SelectedId){
        Cus_Runnerfb rf = new Cus_Runnerfb(SelectedId, currentUser);
        rf.setVisible(true);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    private void DisplayHistory() {
        DefaultTableModel model = (DefaultTableModel) OrderhistoryT.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        OrderhistoryT.setRowSorter(sorter);
        model.setRowCount(0);
        ArrayList<Order> data = MD.ReadData();
        String CustomerID = currentUser.getId();
        for (int i = 0; i < data.size(); i++) {
            String checkOrderId = data.get(i).getCustomerID();
            if (checkOrderId.equals(CustomerID)) {
                model.addRow(new Object[] {data.get(i).getId(), data.get(i).getTotalAmount(), data.get(i).getOptions(), data.get(i).getStatus(), data.get(i).getCreated_Dt(),data.get(i).getCreated_Time()});
            }
        }
        
    }

    private void processFeedbackVisibility(Order order) {
        String VFeedback = order.getFeedbackForVendor();
        String RFeedback = order.getFeedbackForRunner();
        Status status = order.getStatus();
        Options options = order.getOptions();
        System.out.println(VFeedback);

        if (options == Options.DineIn && status == Status.Completed && VFeedback == null) {
            Vendor.setVisible(true);
        }

        if (options == Options.Delivery && status == Status.Completed && RFeedback == null) {
            Runner.setVisible(true);
        }
    }
    
    private void OrderIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderIdActionPerformed
        OrderId.setEditable(false);
    }//GEN-LAST:event_OrderIdActionPerformed

    private void OrderhistoryTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderhistoryTMouseClicked
                                       
        try {
            int selectedRow = OrderhistoryT.getSelectedRow();
            String SelectedId = OrderhistoryT.getValueAt(selectedRow, 0).toString();
            OrderId.setText(SelectedId);
            ArrayList<Order> data = MD.ReadData();
            for (int i = 0; i < data.size(); i++) {
            String checkOrderId = data.get(i).getId();
            
            if (checkOrderId.equals(SelectedId)) {
                processFeedbackVisibility(data.get(i));
            }
            
            
        }
            
            
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OrderhistoryTMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void VendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VendorActionPerformed
        SelectedId = OrderId.getText();
        GovendorFeedback(SelectedId);
        System.out.println(SelectedId);
    }//GEN-LAST:event_VendorActionPerformed

    private void RunnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunnerActionPerformed
        SelectedId = OrderId.getText();
        GorunnerFeedback(SelectedId);
    }//GEN-LAST:event_RunnerActionPerformed
    
    
    
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
            java.util.logging.Logger.getLogger(Cus_Order_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cus_Order_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cus_Order_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cus_Order_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//                new Cus_Order_History().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField OrderId;
    private javax.swing.JTable OrderhistoryT;
    private javax.swing.JButton Runner;
    private javax.swing.JButton Vendor;
    private javax.swing.JButton View;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
