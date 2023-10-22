/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodjassignment;

/**
 *
 * @author myste
 */
public class Customer_Func extends Main_Database{
    
    
    public Customer_Func() {
        super("Vendor");
    }

    public String[][] populateVendorListForAllNames() {
        String[][] rawData;
        rawData = super.ReadData();
        count = super.getCount();
        String[][] finalData = new String[100][];
        int value = 0;
        
        for (int i = 0; i < count; i++) {
        finalData[value] = rawData[i];
        value++;
        }
        
        super.setCount(value);
        return finalData;
    }
}
