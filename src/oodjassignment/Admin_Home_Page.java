package oodjassignment;

import javax.swing.JFrame;
import oodjassignment.Roles.*;

/**
 *
 * @author user
 */
public class Admin_Home_Page extends javax.swing.JFrame {

    Admin currentUser;
    
    public Admin_Home_Page() {
        initComponents();
        User_Name.setText("Error");
    }
    
    public Admin_Home_Page(Admin currentUser) {
        initComponents();
        this.currentUser = currentUser;
        User_Name.setText(currentUser.getName());
    }
    
    public void GoLoginPage(){
        Login_Page lp = new Login_Page();
        lp.setVisible(true);
        lp.pack();
        lp.setLocationRelativeTo(null);
        lp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    public void GoRegister(){
        Register_Page rp = new Register_Page(currentUser);
        rp.setVisible(true);
        rp.pack();
        rp.setLocationRelativeTo(null);
        rp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    public void GoForgetPassword(){
        Forget_Password_Page fp = new Forget_Password_Page(currentUser);
        fp.setVisible(true);
        fp.pack();
        fp.setLocationRelativeTo(null);
        fp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }

    public void GoSearchUser(){
        Search_User su = new Search_User(currentUser);
        su.setVisible(true);
        su.pack();
        su.setLocationRelativeTo(null);
        su.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    public void GoTransaction(){
        Account_Transaction w = new Account_Transaction(currentUser);
        w.setVisible(true);
        w.pack();
        w.setLocationRelativeTo(null);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ToRegister = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        User_Name = new javax.swing.JLabel();
        ToForgetPassword = new javax.swing.JButton();
        ToSearchUser = new javax.swing.JButton();
        jButtonWIthdraw = new javax.swing.JButton();
        jButtonLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ToRegister.setText("Register User");
        ToRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToRegisterActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Welcome Back");

        User_Name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        User_Name.setText("User");

        ToForgetPassword.setText("Forget Password");
        ToForgetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToForgetPasswordActionPerformed(evt);
            }
        });

        ToSearchUser.setText("Search User");
        ToSearchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToSearchUserActionPerformed(evt);
            }
        });

        jButtonWIthdraw.setText("Transaction");
        jButtonWIthdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWIthdrawActionPerformed(evt);
            }
        });

        jButtonLogOut.setText("Log Out");
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLogOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(User_Name))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ToRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ToForgetPassword)
                            .addComponent(ToSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonWIthdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonLogOut)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(User_Name)
                .addGap(18, 18, 18)
                .addComponent(ToRegister)
                .addGap(18, 18, 18)
                .addComponent(ToForgetPassword)
                .addGap(18, 18, 18)
                .addComponent(ToSearchUser)
                .addGap(18, 18, 18)
                .addComponent(jButtonWIthdraw)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ToRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToRegisterActionPerformed
        GoRegister();
    }//GEN-LAST:event_ToRegisterActionPerformed

    private void ToForgetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToForgetPasswordActionPerformed
        GoForgetPassword();
    }//GEN-LAST:event_ToForgetPasswordActionPerformed

    private void ToSearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToSearchUserActionPerformed
        GoSearchUser();
    }//GEN-LAST:event_ToSearchUserActionPerformed

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        GoLoginPage();
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void jButtonWIthdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWIthdrawActionPerformed
        GoTransaction();
    }//GEN-LAST:event_jButtonWIthdrawActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Home_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ToForgetPassword;
    private javax.swing.JButton ToRegister;
    private javax.swing.JButton ToSearchUser;
    private javax.swing.JLabel User_Name;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JButton jButtonWIthdraw;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
