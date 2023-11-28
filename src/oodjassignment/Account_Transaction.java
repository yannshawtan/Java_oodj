/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodjassignment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oodjassignment.Roles.Admin;
import oodjassignment.Roles.Customer;
import oodjassignment.Roles.Identifier;
import static oodjassignment.Roles.Identifier.Role.Admin;
import static oodjassignment.Roles.Identifier.Role.Runner;
import static oodjassignment.Roles.Identifier.Role.Vendor;

/**
 *
 * @author user
 */
public class Account_Transaction extends javax.swing.JFrame {

    Admin currentUser;
    
    public Account_Transaction() {
        initComponents();
    }

    public Account_Transaction(Admin currentUser) {
        initComponents();
        this.currentUser = currentUser;
    }
    
    public void Return(){
        Admin_Home_Page hp = new Admin_Home_Page(currentUser);
        hp.setVisible(true);
        hp.pack();
        hp.setLocationRelativeTo(null);
        hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonReturn = new javax.swing.JButton();
        Role = new javax.swing.JComboBox<>();
        jEmail = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jTextPassword = new javax.swing.JPasswordField();
        jShowPassword = new javax.swing.JCheckBox();
        jAmount = new javax.swing.JLabel();
        jPassword = new javax.swing.JLabel();
        jTextAmount = new javax.swing.JTextField();
        jBConfirm = new javax.swing.JButton();
        jBReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Action = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonReturn.setText("Return");
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });

        Role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Vendor", "Runner" }));

        jEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jEmail.setText("Email:");

        jTextEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextEmailActionPerformed(evt);
            }
        });

        jShowPassword.setText("Show Password");
        jShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowPasswordActionPerformed(evt);
            }
        });

        jAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jAmount.setText("Amount:");

        jPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPassword.setText("Password:");

        jTextAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAmountActionPerformed(evt);
            }
        });

        jBConfirm.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jBConfirm.setText("Confirm");
        jBConfirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConfirmActionPerformed(evt);
            }
        });

        jBReset.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jBReset.setText("Reset");
        jBReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Transaction Page");
        jLabel1.setToolTipText("");

        Action.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Withdraw", "Deposit" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addGap(52, 66, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jShowPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPassword)
                        .addGap(18, 18, 18)
                        .addComponent(jTextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButtonReturn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBReset)
                            .addGap(18, 18, 18)
                            .addComponent(jBConfirm))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jAmount)
                            .addGap(18, 18, 18)
                            .addComponent(jTextAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Action, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Action, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEmail)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jShowPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAmount)
                    .addComponent(jTextAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBConfirm)
                    .addComponent(jBReset)
                    .addComponent(jButtonReturn))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturnActionPerformed
        Return();
    }//GEN-LAST:event_jButtonReturnActionPerformed

    private void jTextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextEmailActionPerformed

    private void jShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowPasswordActionPerformed
        if (jShowPassword.isSelected()){
            jTextPassword.setEchoChar((char)0);
        }
        else{
            jTextPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jShowPasswordActionPerformed

    private void jTextAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAmountActionPerformed

    private void jBConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfirmActionPerformed
        String position = Role.getSelectedItem().toString();
        Identifier.Role role = Identifier.Role.valueOf(position);
        String action = Action.getSelectedItem().toString();
        String email = jTextEmail.getText();
        String password = jTextPassword.getText();
        String amountString = jTextAmount.getText();
        try {
            // create a function to make sure they can only enter 2 decimal place
            BigDecimal amountBigDecimal = new BigDecimal(amountString);
            amountBigDecimal = amountBigDecimal.setScale(2, RoundingMode.HALF_UP);
            double amount = amountBigDecimal.doubleValue();
            if (email.equals("")){
                JOptionPane.showMessageDialog(null, "Please fill out your email!");
            }
            else if(password.equals("")){
                JOptionPane.showMessageDialog(null, "Please fill out your password!");
            }
            else{
                Account_Database db = new Account_Database(role);
                if (!db.LoginValidation(email, password, role)){
                    JOptionPane.showMessageDialog(null, "Invalid email or password");
                }
                else{
                    if (amount <= 0.0){
                        JOptionPane.showMessageDialog(null, "Please enter an amount atleast more than 0");
                    }
                    else{
                        switch (action){
                            case "Withdraw" -> {
                                if(db.checkBalance(amount, email, role)){
                                    amount *= -1;
                                    System.out.println(amount);
                                    db.changeBalance(amount, email, role);
                                    jTextAmount.setText("");
                                    JOptionPane.showMessageDialog(null, "Transaction complete!");
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "insufficient Amount!");
                                }
                            }
                            // Display new amount
                            case "Deposit" -> {
                                db.changeBalance(amount, email, role);
                                jTextAmount.setText("");
                                JOptionPane.showMessageDialog(null, "Transaction complete!");
                            }
                        }
                    }
                }
            }
        }   catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input in amount! Please enter a valid number!");
        }
        
    }//GEN-LAST:event_jBConfirmActionPerformed

    private void jBResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResetActionPerformed
        jTextEmail.setText("");
        jTextPassword.setText("");
        jTextAmount.setText("");
    }//GEN-LAST:event_jBResetActionPerformed

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
            java.util.logging.Logger.getLogger(Account_Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Account_Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Account_Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Account_Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Account_Transaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Action;
    private javax.swing.JComboBox<String> Role;
    private javax.swing.JLabel jAmount;
    private javax.swing.JButton jBConfirm;
    private javax.swing.JButton jBReset;
    private javax.swing.JButton jButtonReturn;
    private javax.swing.JLabel jEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jPassword;
    private javax.swing.JCheckBox jShowPassword;
    private javax.swing.JTextField jTextAmount;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JPasswordField jTextPassword;
    // End of variables declaration//GEN-END:variables
}
