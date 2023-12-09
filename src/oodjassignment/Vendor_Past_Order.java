package oodjassignment;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Identifier.*;
import oodjassignment.Roles.Order.*;

public class Vendor_Past_Order extends javax.swing.JFrame {
    
    Vendor currentUser;
    String vendorId, date;

    public Vendor_Past_Order() {
        initComponents();
    }
    
    public Vendor_Past_Order(Vendor currentUser) {
        initComponents();
        this.currentUser = currentUser;
        vendorId = currentUser.getId();
        date = "";
        revenueTF.setEditable(false);
        
        DisplayOrder(date);
    }
    
    public void Return() {
        Vendor_Manage_Order MO = new Vendor_Manage_Order(currentUser);
        MO.setVisible(true);
        MO.pack();
        MO.setLocationRelativeTo(null);
        MO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    public double deductDeliveryFee(Options option, double amount) {
        double newAmount = amount;
        if (option == Order.Options.Delivery) {
            newAmount *= 100.0/105.0;
        }
        return newAmount;
    }
    
    
    public void calcRevenue() {
        double totalRevenue = 0.00;
        DefaultTableModel model = (DefaultTableModel) historyTB.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        historyTB.setRowSorter(sorter);
        for (int i = 0; i<sorter.getViewRowCount(); i++) {
            double revenue = (Double) model.getValueAt(i, 3);
            totalRevenue += revenue;
        }
        revenueTF.setText(String.format("%.2f", totalRevenue));
    }
    
    public void DisplayOrder(String date) {
        DefaultTableModel model = (DefaultTableModel) historyTB.getModel();
        model.setRowCount(0);
        Main_Database<Order> db = new Main_Database<>(Role.Order);
        ArrayList<Order> data = db.ReadData();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        historyTB.setRowSorter(sorter);
        for (Order order : data) {
            if (order.getVendorID().equals(vendorId) && (order.getStatus() == Order.Status.Completed || order.getStatus() == Order.Status.OutForDelivery)) {
                model.addRow(new Object[] {order.getId(), order.getCustomerID(), order.getCreated_Dt(), deductDeliveryFee(order.getOptions(), order.getTotalAmount())});
            }
        }
        if (date.length() > 0) {
            sorter.setRowFilter(RowFilter.regexFilter(date));
            double totalRevenue = 0.0;
            for (int i = 0; i < sorter.getViewRowCount(); i++) {
                int viewRowIndex = sorter.convertRowIndexToModel(i);
                double revenue = (double) model.getValueAt(viewRowIndex, 3);
                totalRevenue += revenue;
            }
            revenueTF.setText(String.valueOf(totalRevenue));    
        } else {
            historyTB.setRowSorter(null);
            double totalRevenue = 0.0;
            for (int i = 0; i < sorter.getViewRowCount(); i++) {
                int viewRowIndex = sorter.convertRowIndexToModel(i);
                double revenue = (double) model.getValueAt(viewRowIndex, 3);
                totalRevenue += revenue;
            }
            revenueTF.setText(String.valueOf(totalRevenue));
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jPanel1 = new javax.swing.JPanel();
        labelName1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnGuide = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        historyTB = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        revenueTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(79, 93, 117));

        labelName1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelName1.setForeground(new java.awt.Color(255, 255, 255));
        labelName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName1.setText("Order History");

        btnBack.setText("back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnGuide.setText("revenue guide");
        btnGuide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuideActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(labelName1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnGuide)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(labelName1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnGuide)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        historyTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer ID", "Date", "Revenue"
            }
        ));
        historyTB.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                historyTBAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        historyTB.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                historyTBPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(historyTB);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Please Search A Date:");

        revenueTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        revenueTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        revenueTF.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Total Revenue:");

        dateTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTFActionPerformed(evt);
            }
        });
        dateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateTFKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(revenueTF, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(revenueTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Return();
    }//GEN-LAST:event_btnBackActionPerformed

    private void dateTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTFActionPerformed

    private void dateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateTFKeyReleased
        // TODO add your handling code here:
        String date = dateTF.getText();
        DisplayOrder(date);
    }//GEN-LAST:event_dateTFKeyReleased

    private void historyTBAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_historyTBAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_historyTBAncestorAdded

    private void historyTBPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_historyTBPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_historyTBPropertyChange

    private void btnGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuideActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, """
                                            Revenue Guide with Examples:
                                            
                                            1. [Daily Revenue]
                                               Search: 08-Dec-2023
                                            
                                            2. [Monthly Revenue]
                                               Search: Dec-2023
                                            
                                            3. [Yearly Revenue] 
                                               Search: 2023
                                            
                                            """);
    }//GEN-LAST:event_btnGuideActionPerformed

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
            java.util.logging.Logger.getLogger(Vendor_Past_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendor_Past_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendor_Past_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendor_Past_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendor_Past_Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGuide;
    private javax.swing.JTextField dateTF;
    private javax.swing.JTable historyTB;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelName1;
    private javax.swing.JTextField revenueTF;
    // End of variables declaration//GEN-END:variables
}
