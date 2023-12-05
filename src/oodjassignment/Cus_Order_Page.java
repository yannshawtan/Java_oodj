/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodjassignment;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import oodjassignment.Roles.*;
/**
 *
 * @author myste
 */
public class Cus_Order_Page extends javax.swing.JFrame {

    /**
     * Creates new form User_Order_Page
     */
    int count;
    Customer currentUser;
    String Status = "Pending Vendor";
    String CustomerID , Location;
    ArrayList<String> FoodName;
    Identifier.Role role = Identifier.Role.Order;
    Main_Database<Order> MD = new Main_Database<>(role);
    public String VendorID;
    public String Options;
    public Double TotalAmount;
    
    public Cus_Order_Page() {
        initComponents();
    }
    public Cus_Order_Page(String selectedId, Customer currentUser) {
        this.VendorID = selectedId;
        this.currentUser = currentUser;
        CustomerID = currentUser.getId();
        initComponents();
        Block.setVisible(false);
        BlockT.setVisible(false);
        Floor.setVisible(false);
        FloorT.setVisible(false);
        Room.setVisible(false);
        RoomT.setVisible(false);
        populateTable();
    }
    
    private Double calculateTotal() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    int rowCount = model.getRowCount();
    int FoodQuantity;
    double TotalAmount = 0.0;
    
    for (int i = 0; i < rowCount; i++) {
        Object quantityObj = model.getValueAt(i, 1);
        Object priceObj = model.getValueAt(i, 3);

        int quantity = 0;
        double price = 0;

        if (quantityObj instanceof Integer) {
            quantity = (Integer) quantityObj;
        } else if (quantityObj instanceof String) {
            quantity = Integer.parseInt((String) quantityObj);
        } else {
        }

        if (priceObj instanceof Double) {
            price = (Double) priceObj;
        } else if (priceObj instanceof String) {
            price = Double.parseDouble((String) priceObj);
        } else {
        }

        TotalAmount += price * quantity;
    }

    // Set the text of Total_display to the total
    Total_display.setText(String.format("%.2f", TotalAmount));
        return TotalAmount;
    }
    
    public void addOrder(String CustomerID, ArrayList<String> FoodName,
            String Options, Double TotalAmount, String Location, String Status, String VendorID) {
            Order food = new Order(CustomerID, FoodName, Options, TotalAmount, Location, Status, VendorID);
            MD.addData(role, food);
    }

    
    private String AddLocation(){
        String Blocks, Floors, Rooms;
        Blocks = (String) Block.getSelectedItem();
        Floors = (String) Floor.getSelectedItem();
        Rooms = (String) Room.getSelectedItem();
        String Location = null;
    if (!Optionsbox.getSelectedItem().equals("DineIn")){
        Location = Blocks + Floors + Rooms; 
    }
    return Location;
    }
    
    private void populateTable() {
        jTable1.setRowHeight(30);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);
        model.setRowCount(0);
        Identifier.Role role = Identifier.Role.Menu;
        Main_Database<Menu> MD = new Main_Database<>(role);
        ArrayList<Menu> data = MD.ReadData();
        count = MD.getCount();
        int FoodQuantity = 0;
        for (int i = 0; i < count; i++) {
            String menuVendorID = data.get(i).getVendorId();
            System.out.println(menuVendorID);
            if (VendorID.equals(menuVendorID)) {
                System.out.println(data.get(i).getFoodName());
                model.addRow(new Object[] {data.get(i).getFoodName(), FoodQuantity, data.get(i).getFoodType(), data.get(i).getFoodPrice()});
            }
        }
        jTable1.getColumnModel().getColumn(1).setCellEditor(new CellEditor());
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer(){
            
            public Component getTableCellEditorComponent(JTable jTable1, Object value, boolean isSelected, boolean hasFocus, int row, int column){
                super.getTableCellRendererComponent(jTable1, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);
                return this;
            }
            
        });
        model.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
            // Calculate the total price after the table data changes
            calculateTotal();
        }
    });
    }
    
    private ArrayList<String> populateFoodList() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ArrayList<String> FoodName = new ArrayList<>();

        for (int i = 0; i < model.getRowCount(); i++) {
            String foodNames = model.getValueAt(i, 0).toString();
            int foodQuantity = Integer.parseInt(model.getValueAt(i, 1).toString());
            for (int j = 0; j < foodQuantity; j++) {
                FoodName.add(foodNames);
            }
        }
        System.out.println(FoodName);
        return FoodName;
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Total_Price = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        Confirm = new javax.swing.JButton();
        Total_display = new java.awt.Label();
        Optionsbox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        BlockT = new javax.swing.JLabel();
        FloorT = new javax.swing.JLabel();
        RoomT = new javax.swing.JLabel();
        Block = new javax.swing.JComboBox<>();
        Floor = new javax.swing.JComboBox<>();
        Room = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Food/Drinks", "Quantity", "Type", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
        }

        jLabel1.setText("jLabel1");

        Total_Price.setName(""); // NOI18N
        Total_Price.setText("Total");

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Confirm.setText("Confirm");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });

        Total_display.setText("label1");

        Optionsbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DineIn", "Delivery" }));
        Optionsbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsboxActionPerformed(evt);
            }
        });

        jLabel2.setText("Dining Options");

        BlockT.setText("Block");

        FloorT.setText("Floor");

        RoomT.setText("Room Number");

        Block.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));
        Block.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlockActionPerformed(evt);
            }
        });

        Floor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        Room.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", " ", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(FloorT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BlockT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RoomT, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Optionsbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Block, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Floor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Total_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Total_display, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Confirm))
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Total_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Optionsbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BlockT)
                            .addComponent(Block, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FloorT)
                            .addComponent(Floor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RoomT)
                            .addComponent(Room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(155, 155, 155)
                        .addComponent(Total_display, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Confirm))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Total_Price.getAccessibleContext().setAccessibleName("Total_Label");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Customer_Menu_Page cmp = new Customer_Menu_Page(currentUser);
        cmp.setVisible(true);
        cmp.pack();
        cmp.setLocationRelativeTo(null);
        cmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        AddOrder(CustomerID, FoodName, Options, TotalAmount, Location, Status, VendorID);
    }//GEN-LAST:event_ConfirmActionPerformed

    private void OptionsboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsboxActionPerformed
        
    if(Optionsbox.getSelectedItem().equals("DineIn"))
       {
           Block.setVisible(false);
           BlockT.setVisible(false);
           Floor.setVisible(false);
           FloorT.setVisible(false);
           Room.setVisible(false);
           RoomT.setVisible(false);
       } else {
           Block.setVisible(true);
           BlockT.setVisible(true);
           Floor.setVisible(true);
           FloorT.setVisible(true);
           Room.setVisible(true);
           RoomT.setVisible(true);
       }
    }//GEN-LAST:event_OptionsboxActionPerformed

    private void BlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlockActionPerformed

    }//GEN-LAST:event_BlockActionPerformed

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
            java.util.logging.Logger.getLogger(Cus_Order_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cus_Order_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cus_Order_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cus_Order_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Block;
    private javax.swing.JLabel BlockT;
    private javax.swing.JButton Confirm;
    private javax.swing.JComboBox<String> Floor;
    private javax.swing.JLabel FloorT;
    private javax.swing.JComboBox<String> Optionsbox;
    private javax.swing.JComboBox<String> Room;
    private javax.swing.JLabel RoomT;
    private java.awt.Label Total_Price;
    private java.awt.Label Total_display;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
