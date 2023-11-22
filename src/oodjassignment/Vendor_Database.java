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
public class Vendor_Database extends Main_Database{
    ArrayList<ArrayList<String>>rawData;
    public Vendor_Database() {
        
        super("Vendor");
    }

    public List<User> populateVendorListForAllUsers() {
        rawData = super.ReadData();
        int counts = super.getCount();
        List<User> finalData = new ArrayList<>();

        for (int i = 0; i < counts; i++) {
            ArrayList<String> userData = rawData.get(i);
            User user = new User();
            user.setId(userData.get(0));
            user.setName(userData.get(1));
            finalData.add(user);
        }

        super.setCount(finalData.size());
        return finalData;
    }
    

}
