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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author myste
 */
public class Menu_Database extends Main_Database{
    ArrayList<ArrayList<String>>rawData;
    
    
    public Menu_Database(String type) {
        super("Menu");
    }
    
   public List<List<String>> getMenuItemsForCustomer(String vendorID) {
    ArrayList<ArrayList<String>> rawData = super.ReadData();
    int count = super.getCount();
    List<List<String>> menuItems = new ArrayList<>();

    for (int i = 0; i < count; i++) {
        String menuVendorID = rawData.get(i).get(1);

        if (vendorID.equals(menuVendorID)) {
            String name = rawData.get(i).get(2);
            int quantity = 0;
            String type = rawData.get(i).get(4);
            double price = Double.parseDouble(rawData.get(i).get(3));

            List<String> menuItem = new ArrayList<>();
            menuItem.add(name);
            menuItem.add(String.valueOf(quantity));
            menuItem.add(type);
            menuItem.add(String.valueOf(price));

            menuItems.add(menuItem);
        }
    }

    return menuItems;
}
}

