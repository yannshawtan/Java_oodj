package oodjassignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import oodjassignment.Roles.*;

public class Manage_Menu extends javax.swing.JFrame {
    
    Vendor currentUser;
    String foodName, foodType, vendorId;
    double foodPrice;
    ButtonGroup buttonGroup = new ButtonGroup();
    Identifier.Role role = Identifier.Role.Menu;
    Main_Database<Menu> MD = new Main_Database<>(role);

    public Manage_Menu() {
        initComponents();
    }
    
    public Manage_Menu(Vendor currentUser) {
        initComponents();
        this.currentUser = currentUser;
        buttonGroup.add(radioFood);
        buttonGroup.add(radioBeverage);
        buttonGroup.add(radioDessert);
        vendorId = currentUser.getId();
        DisplayMenu();
    }
    
    public void AddMenu(String foodName, double foodPrice, String foodType, String vendorId) {
        Menu food = new Menu(foodName, foodPrice, foodType, vendorId);
        MD.addData(role, food);
        DisplayMenu();
    }
    
    public void DeleteMenu(String foodName) {
        ArrayList<Menu> data = MD.ReadData();
        for (int i = 0; i < data.size(); i++) {
            String checkVendorId = data.get(i).getVendorId();
            String checkFoodName = data.get(i).getFoodName();
            if (checkVendorId.equals(vendorId) && checkFoodName.equals(foodName)) {
                int num = data.get(i).getNumber();
                MD.removeData(role, num);
                DisplayMenu();
            }
        }
    }
    
    public void UpdateMenu(String newFoodName, double newFoodPrice, String newFoodType, String vendorId, String oldFoodName) {
        ArrayList<Menu> data = MD.ReadData();
        Menu food = new Menu(newFoodName, newFoodPrice, newFoodType, vendorId);
        for (int i = 0; i < data.size(); i++) {
            String checkVendorId = data.get(i).getVendorId();
            String checkFoodName = data.get(i).getFoodName();
            if (checkVendorId.equals(vendorId) && checkFoodName.equals(oldFoodName)) {
                data.set(i, food);
                MD.updateData(role, data);
                DisplayMenu();
            }
        }
    }
    
    public void ClearForm() {
        tfFoodName.setText("");
        tfFoodPrice.setText("");
        buttonGroup.clearSelection();
        menuSearch.setText("");
    }
    
    public final void DisplayMenu() {
        DefaultTableModel model = (DefaultTableModel) menuTB.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        menuTB.setRowSorter(sorter);
        model.setRowCount(0);
        ArrayList<Menu> data = MD.ReadData();
        for (int i = 0; i < data.size(); i++) {
            String checkVendorId = data.get(i).getVendorId();
            if (checkVendorId.equals(vendorId)) {
                model.addRow(new Object[] {data.get(i).getFoodName(), data.get(i).getFoodPrice(), data.get(i).getFoodType()});
            }
        }
    }
    
    public final void DisplayMenu(String search) {
        DefaultTableModel model = (DefaultTableModel) menuTB.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        menuTB.setRowSorter(sorter);
        model.setRowCount(0);
        ArrayList<Menu> data = MD.ReadData();
        String lowercaseSearch = search.toLowerCase();
        for (int i = 0; i < data.size(); i++) {
            String lowercaseFoodName = data.get(i).getFoodName().toLowerCase();
            String checkVendorId = data.get(i).getVendorId();
            if (checkVendorId.equals(vendorId)) {
                if (search.equals("")) {
                    model.addRow(new Object[] {data.get(i).getFoodName(), data.get(i).getFoodPrice(), data.get(i).getFoodType()});
                } else if (lowercaseFoodName.contains(lowercaseSearch)) {
                    model.addRow(new Object[] {data.get(i).getFoodName(), data.get(i).getFoodPrice(), data.get(i).getFoodType()});
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelName1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfFoodPrice = new javax.swing.JTextField();
        tfFoodName = new javax.swing.JTextField();
        radioBeverage = new javax.swing.JRadioButton();
        radioFood = new javax.swing.JRadioButton();
        radioDessert = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuTB = new javax.swing.JTable();
        menuSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        labelName1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelName1.setForeground(new java.awt.Color(0, 0, 0));
        labelName1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelName1.setText("Vendor Dashboard");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1053, 570));

        jPanel2.setBackground(new java.awt.Color(79, 93, 117));

        btnBack.setText("back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        logo.setBackground(new java.awt.Color(255, 255, 255));
        logo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setText("Tech University");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(logo)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(39, 39, 39))))
        );

        jPanel1.setBackground(new java.awt.Color(191, 192, 192));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Manage Menu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Price (RM):");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Food Name:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Type:");

        tfFoodPrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfFoodPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFoodPriceActionPerformed(evt);
            }
        });

        tfFoodName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfFoodName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFoodNameActionPerformed(evt);
            }
        });

        radioBeverage.setText("Beverage");
        radioBeverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBeverageActionPerformed(evt);
            }
        });

        radioFood.setText("Food");
        radioFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFoodActionPerformed(evt);
            }
        });

        radioDessert.setText("Dessert");
        radioDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDessertActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Action:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioBeverage)
                                    .addComponent(radioFood)
                                    .addComponent(radioDessert))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfFoodPrice)
                            .addComponent(tfFoodName))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfFoodPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(radioFood))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioBeverage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioDessert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(52, 52, 52))
        );

        jPanel3.setBackground(new java.awt.Color(79, 93, 117));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        menuTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Name", "Price (RM)", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        menuTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(menuTB);

        menuSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSearchActionPerformed(evt);
            }
        });
        menuSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                menuSearchKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Search Food:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(menuSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(menuSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1033, 597));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Vendor_Home_Page VHP = new Vendor_Home_Page(currentUser);
        VHP.setVisible(true);
        VHP.pack();
        VHP.setLocationRelativeTo(null);
        VHP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void radioFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFoodActionPerformed
        // TODO add your handling code here:
        foodType = "Food";
    }//GEN-LAST:event_radioFoodActionPerformed

    private void radioBeverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBeverageActionPerformed
        // TODO add your handling code here:
        foodType = "Beverage";
    }//GEN-LAST:event_radioBeverageActionPerformed

    private void radioDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDessertActionPerformed
        // TODO add your handling code here:
        foodType = "Dessert";
    }//GEN-LAST:event_radioDessertActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            foodName = tfFoodName.getText();
            foodPrice = Math.round(Double.parseDouble(tfFoodPrice.getText()) * 100.0) / 100.0;
            if (foodName.isEmpty()) {throw new IllegalArgumentException("Please enter a food name.");}
            if (foodType.isEmpty()) {throw new IllegalArgumentException("Please select a food type.");}
            AddMenu(foodName, foodPrice, foodType, vendorId);
            ClearForm();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric value for the food price.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btnAddActionPerformed

    private void tfFoodNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFoodNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFoodNameActionPerformed

    private void tfFoodPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFoodPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFoodPriceActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (menuTB.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(null, "You must only select ONE row at a time");
        }
        
        if (menuTB.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        
        if (menuTB.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Table is empty");
        }
        
        if (menuTB.getSelectedRowCount() == 1) {
            int selectedRow = menuTB.getSelectedRow();
            String selectedFood = menuTB.getValueAt(selectedRow, 0).toString();
            DeleteMenu(selectedFood);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (menuTB.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(null, "You must only select ONE row at a time");
        }
        
        if (menuTB.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        
        if (menuTB.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Table is empty");
        }
        
        if (menuTB.getSelectedRowCount() == 1) {
            int selectedRow = menuTB.getSelectedRow();
            String oldFoodName = menuTB.getValueAt(selectedRow, 0).toString();
            try {
                foodName = tfFoodName.getText();
                foodPrice = Math.round(Double.parseDouble(tfFoodPrice.getText()) * 100.0) / 100.0;
                if (foodName.isEmpty()) {throw new IllegalArgumentException("Please enter a food name.");}
                if (foodType.isEmpty()) {throw new IllegalArgumentException("Please select a food type.");}
                UpdateMenu(foodName, foodPrice, foodType, vendorId, oldFoodName);
                ClearForm();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric value for the food price.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void menuTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTBMouseClicked
        // TODO add your handling code here:
        try {
            int selectedRow = menuTB.getSelectedRow();
            String selectedFoodName = menuTB.getValueAt(selectedRow, 0).toString();
            String selectedFoodPrice = menuTB.getValueAt(selectedRow, 1).toString();
            String selectedFoodType = menuTB.getValueAt(selectedRow, 2).toString();
            tfFoodName.setText(selectedFoodName);
            tfFoodPrice.setText(selectedFoodPrice);
            if (selectedFoodType.equals("Food")) {radioFood.setSelected(true); foodType = "Food";} 
            if (selectedFoodType.equals("Beverage")) {radioBeverage.setSelected(true); foodType = "Beverage";}
            if (selectedFoodType.equals("Dessert")) {radioDessert.setSelected(true); foodType = "Dessert";}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuTBMouseClicked

    private void menuSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSearchActionPerformed

    private void menuSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menuSearchKeyReleased
        // TODO add your handling code here:
        String search = menuSearch.getText();
        DisplayMenu(search);
    }//GEN-LAST:event_menuSearchKeyReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelName1;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField menuSearch;
    private javax.swing.JTable menuTB;
    private javax.swing.JRadioButton radioBeverage;
    private javax.swing.JRadioButton radioDessert;
    private javax.swing.JRadioButton radioFood;
    private javax.swing.JTextField tfFoodName;
    private javax.swing.JTextField tfFoodPrice;
    // End of variables declaration//GEN-END:variables
}
