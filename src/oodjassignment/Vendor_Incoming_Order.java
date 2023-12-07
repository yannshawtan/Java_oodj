package oodjassignment;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import oodjassignment.Roles.*;

public class Vendor_Incoming_Order extends javax.swing.JFrame {
    
    Vendor currentUser;
    Identifier.Role role = Identifier.Role.Order;
    Main_Database<Order> MD = new Main_Database<>(role);
    String vendorId;

    public Vendor_Incoming_Order() {
        initComponents();
    }
    
    public Vendor_Incoming_Order(Vendor currentUser) {
        initComponents();
        this.currentUser = currentUser;
        vendorId = currentUser.getId();
        DisplayOrder();
    }
    
    public void Return() {
        Vendor_Manage_Order MO = new Vendor_Manage_Order(currentUser);
        MO.setVisible(true);
        MO.pack();
        MO.setLocationRelativeTo(null);
        MO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
    
    public HashMap<String, Integer> getUniqueFood(ArrayList<String> foods) {
        HashMap<String, Integer> foodMap = new HashMap<>();
        for (String food : foods) {
            if (foodMap.containsKey(food)) {
                foodMap.put(food, foodMap.get(food) + 1);
            } else {
                foodMap.put(food, 1);
            }
        }
        return foodMap;
    }
    
    public String findCustomerName(String custId) {
        String custName = "";
        Identifier.Role role = Identifier.Role.Customer;
        Main_Database<Customer> MD = new Main_Database<>(role);
        ArrayList<Customer> data = MD.ReadData();
        for (int i = 0; i < data.size(); i++) {
            String checkCustomerId = data.get(i).getId();
            if (checkCustomerId.equals(custId)) {
                custName = data.get(i).getName();
                break;
            }
        }
        return custName;
    }
    
    public String concatDateTime(String date, String time) {
        return date + " " + time;
    }
    
    public final void DisplayFood(HashMap<String, Integer> foodMap) {
        DefaultTableModel model = (DefaultTableModel) foodTB.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        foodTB.setRowSorter(sorter);
        model.setRowCount(0);
        for (HashMap.Entry<String, Integer> entry : foodMap.entrySet()) {
            String name = entry.getKey();
            int amount = entry.getValue();
            model.addRow(new Object[]{name, amount});
        }
    }
    
    public final void DisplayOrder() {
        orderTB.getColumnModel().getColumn(0).setPreferredWidth(15);
        orderTB.getColumnModel().getColumn(1).setPreferredWidth(15);
        orderTB.getColumnModel().getColumn(2).setPreferredWidth(100);
        DefaultTableModel model = (DefaultTableModel) orderTB.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        orderTB.setRowSorter(sorter);
        model.setRowCount(0);
        ArrayList<Order> data = MD.ReadData();
        for (int i = 0; i < data.size(); i++) {
            String checkVendorId = data.get(i).getVendorID();
            String checkStatus = data.get(i).getStatus();
            if (checkVendorId.equals(vendorId) && checkStatus.equals("Pending Vendor")) {
                model.addRow(new Object[] {data.get(i).getId(), findCustomerName(data.get(i).getCustomerID()), concatDateTime(data.get(i).getCreated_Dt(), data.get(i).getCreated_Time())});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelName1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelCustomer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelOrderId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelOrderTime = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        foodTB = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelOrderTotal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelOption = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelName2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTB = new javax.swing.JTable();
        btnAccept = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnDecline = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        labelName1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelName1.setForeground(new java.awt.Color(0, 0, 0));
        labelName1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelName1.setText("Order Details");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Customer:");

        labelCustomer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCustomer.setForeground(new java.awt.Color(0, 0, 0));
        labelCustomer.setText("please select a row");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Order ID:");

        labelOrderId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelOrderId.setForeground(new java.awt.Color(0, 0, 0));
        labelOrderId.setText("please select a row");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Order Time:");

        labelOrderTime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelOrderTime.setForeground(new java.awt.Color(0, 0, 0));
        labelOrderTime.setText("please select a row");

        foodTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(foodTB);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Food:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Order Total:");

        labelOrderTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelOrderTotal.setForeground(new java.awt.Color(0, 0, 0));
        labelOrderTotal.setText("please select a row");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Option:");

        labelOption.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelOption.setForeground(new java.awt.Color(0, 0, 0));
        labelOption.setText("please select a row");

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelName1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelOrderId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelOrderTime, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(labelOrderTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelOption, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelName1)
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelOrderId))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelCustomer))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelOrderTime))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(labelOrderTotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOption)
                    .addComponent(jLabel11))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(79, 93, 117));

        labelName2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelName2.setForeground(new java.awt.Color(255, 255, 255));
        labelName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName2.setText("Incoming Order");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelName2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelName2)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        orderTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer Name", "Created At"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(orderTB);
        if (orderTB.getColumnModel().getColumnCount() > 0) {
            orderTB.getColumnModel().getColumn(0).setMinWidth(100);
            orderTB.getColumnModel().getColumn(0).setMaxWidth(150);
            orderTB.getColumnModel().getColumn(1).setMinWidth(125);
            orderTB.getColumnModel().getColumn(1).setMaxWidth(150);
            orderTB.getColumnModel().getColumn(2).setMinWidth(200);
        }

        btnAccept.setText("Accept");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnDecline.setText("Decline");
        btnDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDecline, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnAccept)
                    .addComponent(btnDecline))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Return();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeclineActionPerformed

    private void orderTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTBMouseClicked
        // TODO add your handling code here:
        try {
            String orderId, custName = "", orderTime = "", option = "";
            double orderTotal = 0;
            ArrayList<String> food = new ArrayList<String>();
            HashMap<String, Integer> foodMap;
            
            int selectedRow = orderTB.getSelectedRow();
            orderId = orderTB.getValueAt(selectedRow, 0).toString();
            ArrayList<Order> data = MD.ReadData();
            for (int i = 0; i < data.size(); i++) {
                String checkOrderId = data.get(i).getId();
                if (checkOrderId.equals(orderId)) {
                    custName = findCustomerName(data.get(i).getCustomerID());
                    orderTime = concatDateTime(data.get(i).getCreated_Dt(), data.get(i).getCreated_Time());
                    option = data.get(i).getOptions();
                    orderTotal = data.get(i).getTotalAmount();
                    food = data.get(i).getFoodName();
                }
            }
            labelOrderId.setText(orderId);
            labelCustomer.setText(custName);
            labelOrderTime.setText(orderTime);
            labelOrderTotal.setText(String.valueOf(orderTotal));
            labelOption.setText(option);
            
            foodMap = getUniqueFood(food);
            DisplayFood(foodMap);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_orderTBMouseClicked

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
            java.util.logging.Logger.getLogger(Vendor_Incoming_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendor_Incoming_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendor_Incoming_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendor_Incoming_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendor_Incoming_Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDecline;
    private javax.swing.JTable foodTB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCustomer;
    private javax.swing.JLabel labelName1;
    private javax.swing.JLabel labelName2;
    private javax.swing.JLabel labelOption;
    private javax.swing.JLabel labelOrderId;
    private javax.swing.JLabel labelOrderTime;
    private javax.swing.JLabel labelOrderTotal;
    private javax.swing.JTable orderTB;
    // End of variables declaration//GEN-END:variables

}
