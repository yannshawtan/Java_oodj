package oodjassignment;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import oodjassignment.Roles.*;

public class Vendor_View_Feedback extends javax.swing.JFrame {
    
    Vendor currentUser;
    String vendorId;

    public Vendor_View_Feedback() {
        initComponents();
    }
    
    public Vendor_View_Feedback(Vendor currentUser) {
        initComponents();
        this.currentUser = currentUser;
        vendorId = currentUser.getId();
        DisplayFeedback("");
    }
    
    public void Return() {
        Vendor_Home_Page HP = new Vendor_Home_Page(currentUser);
        HP.setVisible(true);
        HP.pack();
        HP.setLocationRelativeTo(null);
        HP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    public void DisplayFeedback(String search) {
        DefaultTableModel model = (DefaultTableModel) feedbackTB.getModel();
        model.setRowCount(0);
        Main_Database<Order> db = new Main_Database<>(Identifier.Role.Order);
        ArrayList<Order> data = db.ReadData();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        feedbackTB.setRowSorter(sorter);
        for (Order order : data) {
            if (order.getVendorID().equals(vendorId) && order.getStatus() == Order.Status.Completed) {
                model.addRow(new Object[] {order.getId(), order.getCreated_Dt(), order.getRatingForVendor(), order.getFeedbackForVendor()});
            }
        }
        if (search.length() > 0) {
            sorter.setRowFilter(RowFilter.regexFilter(search));
        } else {
            feedbackTB.setRowSorter(null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelName1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedbackTB = new javax.swing.JTable();
        btnExpand = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(79, 93, 117));

        labelName1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelName1.setForeground(new java.awt.Color(255, 255, 255));
        labelName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName1.setText("View Feedback");

        btnBack.setText("back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnBack)
                .addGap(82, 82, 82)
                .addComponent(labelName1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(labelName1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        feedbackTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Date", "Rating", "Feedback"
            }
        ));
        jScrollPane1.setViewportView(feedbackTB);

        btnExpand.setText("expand feedback");
        btnExpand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpandActionPerformed(evt);
            }
        });

        jLabel1.setText("Search");

        searchTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTFActionPerformed(evt);
            }
        });
        searchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTFKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(btnExpand)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExpand)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Return();
    }//GEN-LAST:event_btnBackActionPerformed

    private void searchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTFActionPerformed

    private void searchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFKeyReleased
        // TODO add your handling code here:
        String search = searchTF.getText();
        DisplayFeedback(search);
    }//GEN-LAST:event_searchTFKeyReleased

    private void btnExpandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpandActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (feedbackTB.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(null, "You must only select ONE row at a time");
        }
        
        if (feedbackTB.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        
        if (feedbackTB.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Table is empty");
        }
        
        if (feedbackTB.getSelectedRowCount() == 1) {
            int selectedRow = feedbackTB.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) feedbackTB.getModel();
            Object feedbackObj = model.getValueAt(selectedRow, 3);
            if (feedbackObj != null) {
                String feedback = feedbackObj.toString();
                JOptionPane.showMessageDialog(null, feedback);
            } else {
                JOptionPane.showMessageDialog(null, "The selected row has no feedback");
            }
        }
    }//GEN-LAST:event_btnExpandActionPerformed

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
            java.util.logging.Logger.getLogger(Vendor_View_Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendor_View_Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendor_View_Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendor_View_Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendor_View_Feedback().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExpand;
    private javax.swing.JTable feedbackTB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelName1;
    private javax.swing.JTextField searchTF;
    // End of variables declaration//GEN-END:variables
}
