package oodjassignment;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login_Page extends javax.swing.JFrame {
    
    User owner = new User();
    public Login_Page() {
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TFuser = new javax.swing.JTextField();
        Blogin = new javax.swing.JButton();
        Breset = new javax.swing.JButton();
        JCshow_password = new javax.swing.JCheckBox();
        PFpassword = new javax.swing.JPasswordField();
        Role = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("LOGIN PAGE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Email:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password:");

        TFuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFuserActionPerformed(evt);
            }
        });

        Blogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Blogin.setText("Login");
        Blogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloginActionPerformed(evt);
            }
        });

        Breset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Breset.setText("Reset");
        Breset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BresetActionPerformed(evt);
            }
        });

        JCshow_password.setText("Show Password");
        JCshow_password.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JCshow_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCshow_passwordActionPerformed(evt);
            }
        });

        PFpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PFpasswordActionPerformed(evt);
            }
        });

        Role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Vendor", "Runner", "Admin" }));
        Role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoleActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Go to admin to register account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFuser)
                                    .addComponent(PFpassword)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(Breset, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCshow_password)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Blogin)
                                .addGap(16, 16, 16)))))
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(PFpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JCshow_password)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Breset)
                    .addComponent(Blogin))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void GoCustomerHomePage(){
       Customer_Home_Page chp = new Customer_Home_Page(owner);
        chp.setVisible(true);
        chp.pack();
        chp.setLocationRelativeTo(null);
        chp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    public void GoAdminHomePage(){
        Admin_Home_Page ahp = new Admin_Home_Page(owner);
        ahp.setVisible(true);
        ahp.pack();
        ahp.setLocationRelativeTo(null);
        ahp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    public void GoRegisterPage(){
//        Register_Page rp = new Register_Page();
//        rp.setVisible(true);
//        rp.pack();
//        rp.setLocationRelativeTo(null);
//        rp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.dispose();
    }
    
    
    private void TFuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFuserActionPerformed

    private void BloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloginActionPerformed
        String Email = TFuser.getText();
        String Password = PFpassword.getText();
        if (Email.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill out your email!");
        }
        else if(Password.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill out your password!");
        }
        else{
            String Position = Role.getSelectedItem().toString();
            Account_Database db = new Account_Database(Position);
            if (db.LoginValidation(Email, Password,Position)){
                switch (Position) {
                    case "Customer" -> {
                        owner = db.getData();
                        GoCustomerHomePage();
                    }
                    case "Admin" -> {
                        owner = db.getData();
                        GoAdminHomePage();
                    }
                    case "Vendor" -> {
                        owner = db.getData();
                        //GoVendorHomePage();
                    }
                    case "Runner" -> {
                        owner = db.getData();
                        //GoRunnerHomePage();
                    }
                    default -> {
                    }
                }
            }
        }
    }//GEN-LAST:event_BloginActionPerformed

    private void JCshow_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCshow_passwordActionPerformed
        if (JCshow_password.isSelected()){
            PFpassword.setEchoChar((char)0);
        }
        else{
            PFpassword.setEchoChar('*');
        }
    }//GEN-LAST:event_JCshow_passwordActionPerformed

    private void PFpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PFpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PFpasswordActionPerformed

    private void BresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BresetActionPerformed
        TFuser.setText("");
        PFpassword.setText("");
    }//GEN-LAST:event_BresetActionPerformed

    private void RoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoleActionPerformed
 
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
            java.util.logging.Logger.getLogger(Login_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Blogin;
    private javax.swing.JButton Breset;
    private javax.swing.JCheckBox JCshow_password;
    private javax.swing.JPasswordField PFpassword;
    private javax.swing.JComboBox<String> Role;
    private javax.swing.JTextField TFuser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
