/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodjassignment;


import javax.swing.DefaultListModel;


/**
 *
 * @author myste
 */
public class Customer_Func extends Main_Database{
    
    String [][]rawData;
    
    public Customer_Func(String type) {
        super("Vendor");
    }

    public String[][] VendorList(int Id,String name){
        rawData = super.ReadData();
        String [][]finalData = new String [100][];
        count = super.getCount();
        int value = 0;
        for (int i = 0; i<count; i++){
            if (rawData[i][0].equals(Id) && rawData[i][1].equals(name)){
                finalData[value] = rawData[i];
                value++;
            }
        }
        super.setCount(value);
        return finalData;
    }
    
    private void loadVendorIDs(DefaultListModel<String> model) {
        
    }
}
