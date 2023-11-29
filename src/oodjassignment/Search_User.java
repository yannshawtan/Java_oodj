package oodjassignment;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Identifier;

public class Search_User extends javax.swing.JFrame {

    Admin currentUser;
    int counts;
    
    public Search_User() {
        initComponents();
        String Position = Role.getSelectedItem().toString();
        ListOfUser(Position, "");
    }
    
    public Search_User(Admin currentUser) {
        initComponents();
        this.currentUser = currentUser;
        String Position = Role.getSelectedItem().toString();
        ListOfUser(Position, "");
    }

    public void Return(){
        Admin_Home_Page hp = new Admin_Home_Page(currentUser);
        hp.setVisible(true);
        hp.pack();
        hp.setLocationRelativeTo(null);
        hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    public void ListOfUser(String Position, String name){
        jTableUser.getColumnModel().getColumn(0).setPreferredWidth(15);
        jTableUser.getColumnModel().getColumn(3).setPreferredWidth(30);
        jTableUser.getColumnModel().getColumn(5).setPreferredWidth(30);
        DefaultTableModel model = (DefaultTableModel)jTableUser.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTableUser.setRowSorter(sorter);
        model.setRowCount(0);
        Identifier.Role role = Identifier.Role.valueOf(Position);
        String lowercaseName = name.toLowerCase();
        switch (role) {
            case Admin -> {
                Main_Database<Admin> db = new Main_Database<>(role);
                ArrayList<Admin> data = db.ReadData();
                counts = db.getCount();
                for (int i=0;i<counts;i++){
                    String lowercaseData = data.get(i).getName().toLowerCase();
                    if(name.equals("")){
                        model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), "Null", data.get(i).getCreated_Date() + " " + data.get(i).getCreated_Time(), "Null"});
                    }
                    else if (lowercaseData.contains(lowercaseName)){
                        model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), "Null", data.get(i).getCreated_Date() + " " + data.get(i).getCreated_Time(), "Null"});
                    }    
                }
            }
            case Customer -> {
                Main_Database<Customer> db = new Main_Database(role);
                ArrayList<Customer> data = db.ReadData();
                counts = db.getCount();
                for (int i=0;i<counts;i++){
                    String lowercaseData = data.get(i).getName().toLowerCase();
                    if(name.equals("")){
                        model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), data.get(i).getStringBalance(), data.get(i).getCreated_Date() + " "+ data.get(i).getCreated_Time(), "Null"});
                    }
                    else if (lowercaseData.contains(lowercaseName)){
                        model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), data.get(i).getStringBalance(), data.get(i).getCreated_Date() + " " + data.get(i).getCreated_Time(), "Null"});
                    }    
                }
            }
            case Vendor -> {
                Account_Database db = new Account_Database(role);
                ArrayList<Vendor> data = db.ReadData();
                counts = db.getCount();
                for (int i=0;i<counts;i++){
                    String lowercaseData = data.get(i).getName().toLowerCase();
                    if(name.equals("")){
                        model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), data.get(i).getStringBalance(), data.get(i).getCreated_Date() + " " + data.get(i).getCreated_Time(), data.get(i).getStringRating()});
                    }
                    else if (lowercaseData.contains(lowercaseName)){
                        model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), data.get(i).getStringBalance(), data.get(i).getCreated_Date() + " " + data.get(i).getCreated_Time(), data.get(i).getStringRating()});
                    }    
                }
            }
            case Runner -> {
                Account_Database db = new Account_Database(role);
                ArrayList<Runner> data = db.ReadData();
                counts = db.getCount();
                for (int i=0;i<counts;i++){
                    String lowercaseData = data.get(i).getName().toLowerCase();
                    if(name.equals("")){
                        model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), data.get(i).getStringBalance(), data.get(i).getCreated_Date() + " " + data.get(i).getCreated_Time(), data.get(i).getStringRating()});
                    }
                    else if (lowercaseData.contains(lowercaseName)){
                        model.addRow(new Object[] {data.get(i).getId(), data.get(i).getName(), data.get(i).getEmail(), data.get(i).getStringBalance(), data.get(i).getCreated_Date() + " " + data.get(i).getCreated_Time(), data.get(i).getStringRating()});
                    }    
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextName = new javax.swing.JTextField();
        jButtonReturn = new javax.swing.JButton();
        Role = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Search User");

        jTextName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextNameKeyReleased(evt);
            }
        });

        jButtonReturn.setText("Return");
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });

        Role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Vendor", "Runner", "Admin" }));
        Role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoleActionPerformed(evt);
            }
        });

        jTableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Email", "Balance", "Date Created", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(240, 240, 240))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonReturn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(264, 264, 264))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReturn))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturnActionPerformed
        Return();
    }//GEN-LAST:event_jButtonReturnActionPerformed

    private void RoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleActionPerformed
        String position = Role.getSelectedItem().toString();
        String name = jTextName.getText();
        ListOfUser(position, name);
    }//GEN-LAST:event_RoleActionPerformed

    private void jTextNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNameKeyReleased
        String position = Role.getSelectedItem().toString();
        String name = jTextName.getText();
        ListOfUser(position, name);
    }//GEN-LAST:event_jTextNameKeyReleased

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
            java.util.logging.Logger.getLogger(Search_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search_User().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Role;
    private javax.swing.JButton jButtonReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUser;
    private javax.swing.JTextField jTextName;
    // End of variables declaration//GEN-END:variables
}
