/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodjassignment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author myste
 */
public class Customer_Func extends Main_Database{
    
    
    public Customer_Func() {
        super("Vendor");
    }

    public List<User> populateVendorListForAllUsers() {
        String[][] rawData = super.ReadData();
        int counts = super.getCount();
        List<User> finalData = new ArrayList<>();

        for (int i = 0; i < counts; i++) {
            String[] userData = rawData[i];
            User user = new User();
            user.setId(userData[0]);
            user.setName(userData[1]);
            finalData.add(user);
        }

        super.setCount(finalData.size());
        return finalData;
    }
}
