/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodjassignment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Order.Options;

/**
 *
 * @author myste
 */
public class Cus_Reorder extends javax.swing.JFrame {

    /**
     * Creates new form Cus_Reorder
     */
    Customer currentUser;
    private Double TotalAmount = 0.0;
    private String selectedOrderID;
    private String Location,VendorID,currentUserID;
    private ArrayList<String> FoodName;
    Identifier.Role role = Identifier.Role.Order;
    Main_Database<Order> MD = new Main_Database<>(role);
    
    public Cus_Reorder(String selectedOrderID,Customer currentUser) {
        initComponents();
        this.selectedOrderID = selectedOrderID;
        this.currentUser = currentUser;
        this.VendorID = VendorID;
        this.currentUserID = currentUser.getId();
        Block.setVisible(false);
           BlockT.setVisible(false);
           Floor.setVisible(false);
           FloorT.setVisible(false);
           Room.setVisible(false);
           RoomT.setVisible(false);
    }
    
    public void GoCustomerHomePage(){
        Customer_Home_Page chp = new Customer_Home_Page((Customer) currentUser);
        chp.setVisible(true);
        chp.pack();
        chp.setLocationRelativeTo(null);
        chp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    public Order addOrder(String CustomerID, ArrayList<String> FoodName, Order.Options Options, Double TotalAmount, String Location, Order.Status Status, String VendorID) {
        Order food = new Order(CustomerID, FoodName, Options, TotalAmount, Location, Status, VendorID);
        MD.addData(role, food);
        return food;
    }
    
    private void AddLocation(){
        String Blocks, Floors, Rooms;
        Blocks = (String) Block.getSelectedItem();
        Floors = (String) Floor.getSelectedItem();
        Rooms = (String) Room.getSelectedItem();
    if (Optionsbox.getSelectedItem().equals("Delivery")){
        Location = Blocks+ "-" + Floors + "-" + Rooms; 
    }
    }
    
    private void totalcal(){
        TotalAmount = 0.0;
        Options option = null;
        ArrayList<Order> data = MD.ReadData();
        for (int i = 0; i < data.size(); i++) {
            String checkOrderId = data.get(i).getId();
            if (checkOrderId.equals(selectedOrderID)) {
                TotalAmount = data.get(i).getTotalAmount();
                option = data.get(i).getOptions();
            }
        }
        if (Optionsbox.getSelectedItem().toString().equals("Delivery") && option.equals(Options.DineIn)) {
            // Add 5% to TotalAmount for delivery
            TotalAmount *= 1.05 ;
        }else {
            TotalAmount =TotalAmount;
        }
    }
    private void getOrder(){
        ArrayList<Order> data = MD.ReadData();
        for (int i = 0; i < data.size(); i++) {
            String checkOrderId = data.get(i).getId();
            if (checkOrderId.equals(selectedOrderID)) {
                VendorID = data.get(i).getVendorID();
                FoodName = data.get(i).getFoodName();
            }
        }
    }
    
    private void moneydeduct() {
        Identifier.Role roles = Identifier.Role.Customer;
        Main_Database<Customer> MD = new Main_Database<>(roles);
        ArrayList<Customer>data = MD.ReadData();
        TotalAmount *= -1;
        BigDecimal roundedAmount = new BigDecimal(TotalAmount).setScale(2, RoundingMode.HALF_UP);
        TotalAmount = roundedAmount.doubleValue();
        for (int i = 0; i<data.size();i++){
            if (data.get(i).getId().equals(currentUserID)){
                currentUser.updateBalance(TotalAmount);
                data.get(i).updateBalance(TotalAmount);
                data.set(i, data.get(i));
                MD.updateData(roles, data);
                break;
            }
        }
        
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
        jTextArea1 = new javax.swing.JTextArea();
        Optionsbox = new javax.swing.JComboBox<>();
        Back = new javax.swing.JButton();
        Confirm = new javax.swing.JButton();
        BlockT = new javax.swing.JLabel();
        FloorT = new javax.swing.JLabel();
        RoomT = new javax.swing.JLabel();
        Block = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Floor = new javax.swing.JComboBox<>();
        Room = new javax.swing.JComboBox<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Optionsbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DineIn", "TakeAway", "Delivery" }));
        Optionsbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsboxActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Confirm.setText("Confirm");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });

        BlockT.setText("Block");

        FloorT.setText("Floor");

        RoomT.setText("Room");

        Block.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));

        jLabel4.setText("Reorder");

        Floor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        Room.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Confirm)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RoomT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(FloorT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Floor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BlockT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(Block, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(Optionsbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel4)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Optionsbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BlockT)
                    .addComponent(Block, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FloorT)
                    .addComponent(Floor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoomT)
                    .addComponent(Room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back)
                    .addComponent(Confirm))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        AddLocation();
        getOrder();
        totalcal();
        String selectedOptionString = (String) Optionsbox.getSelectedItem();
        Order.Options options = Order.Options.valueOf(selectedOptionString);
        Double Cbalance = currentUser.getBalance();
        Notification_Database<Notification> nd = new Notification_Database<>(Identifier.Role.Notification);
        Order.Status status = Order.Status.PendingVendor;
        try{
            if (Cbalance < TotalAmount) {throw new IllegalArgumentException("Insufficient credits please topup at admin");}
            
           Order newOrder = addOrder(currentUser.getId(), FoodName, options, TotalAmount, Location, status, VendorID);
            nd.SendOrderToVendor(currentUser.getId(), VendorID, newOrder.getId(),currentUser.getName());
            moneydeduct();
            GoCustomerHomePage();
            JOptionPane.showMessageDialog(null, "Order Sent");
        }catch (IllegalArgumentException e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        
    }//GEN-LAST:event_ConfirmActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Cus_Receipt ch = new Cus_Receipt(selectedOrderID,currentUser);
        ch.setVisible(true);
        ch.pack();
        ch.setLocationRelativeTo(null);
        ch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void OptionsboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsboxActionPerformed
        if (Optionsbox.getSelectedItem()==("Delivery")){
            Block.setVisible(true);
           BlockT.setVisible(true);
           Floor.setVisible(true);
           FloorT.setVisible(true);
           Room.setVisible(true);
           RoomT.setVisible(true);
        } else {
           Block.setVisible(false);
           BlockT.setVisible(false);
           Floor.setVisible(false);
           FloorT.setVisible(false);
           Room.setVisible(false);
           RoomT.setVisible(false);
        }
    }//GEN-LAST:event_OptionsboxActionPerformed

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
            java.util.logging.Logger.getLogger(Cus_Reorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cus_Reorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cus_Reorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cus_Reorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Cus_Reorder().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JComboBox<String> Block;
    private javax.swing.JLabel BlockT;
    private javax.swing.JButton Confirm;
    private javax.swing.JComboBox<String> Floor;
    private javax.swing.JLabel FloorT;
    private javax.swing.JComboBox<String> Optionsbox;
    private javax.swing.JComboBox<String> Room;
    private javax.swing.JLabel RoomT;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
