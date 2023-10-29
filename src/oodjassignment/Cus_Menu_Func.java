/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodjassignment;

import Reference.Medical_Database;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.DecimalFormat;
import javax.swing.JTable;

/**
 *
 * @author myste
 */
public class Cus_Menu_Func extends Main_Database{
    private String [][]rawData;
    
    public Cus_Menu_Func(String type) {
        super("Menu");
    }
    
    public String[][] getMenuItemsForCustomer(String vendorID) {
        rawData = super.ReadData();
        int count = super.getCount();
        String[][] menuItems = new String[count][4];
        int menuItemCount = 0;

        for (int i = 0; i < count; i++) {
            String menuVendorID = rawData[i][1];
            System.out.println(menuVendorID);  

            if (vendorID.equals(menuVendorID)) {
                String name = rawData[i][2];
                System.out.println(name);
                int quantity = 0;
                String type = rawData[i][3];
                double price = Double.parseDouble(rawData[i][4]);
                
                menuItems[menuItemCount][0] = name;
                menuItems[menuItemCount][1] = String.valueOf(quantity);
                menuItems[menuItemCount][2] = type;
                menuItems[menuItemCount][3] = String.valueOf(price);
                menuItemCount++;
            }
        }
        String[][] result = new String[menuItemCount][4];
        System.arraycopy(menuItems, 0, result, 0, menuItemCount);
        return result;
    }
}
