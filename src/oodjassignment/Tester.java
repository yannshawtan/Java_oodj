/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodjassignment;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Customer;
import oodjassignment.Roles.Identifier;


public class Tester {
    
    public static void main(String[] args){
//        ArrayList<Admin> data;
//        ArrayList<Customer> data;
//        ArrayList<Runner> data;
        ArrayList<Vendor> data;
        int count;
//        Identifier.Role role = Identifier.Role.Admin;
//        Identifier.Role role = Identifier.Role.Customer;
//        Identifier.Role role = Identifier.Role.Runner;
        Identifier.Role role = Identifier.Role.Vendor;
//        Main_Database<Admin> MD = new Main_Database<>(role);
//        Main_Database<Runner> MD = new Main_Database<>(role);
        Main_Database<Vendor> MD = new Main_Database<>(role);
//        Account_Database<Customer> MD = new Account_Database<>(role);
        
        
        Admin a1 = new Admin("Zorus", "Zorus", "Zorus@gmail.com");
//        Customer c1 = new Customer("Zorus", "Zorus", "Zorus@gmail.com");
//        Admin a2 = new Admin("Shaw", "Shaw", "Shaw@gmail.com");
//        Admin a3 = new Admin("Dalton", "Dalton", "Dalton@gmail.com");
//        Admin a4 = new Admin("ZorusNew", "Zorus", "Zorus@gmail.com");
        //*/
        
        // Add data
        
        /*
//        MD.addData(role, c1);
        MD.addData(role, a1);
//        MD.addData(Admin, a2);
//        MD.addData(Admin, a3);
//        MD.addData(Admin, a4);
        //*/
        
        // Remove data, remember to check the location number as because u delete the item will affect its total number
        // For example, u delete item 4, from an list of only 4 item, next time u try that again it will cause error as now the list is only 3 item
        /*
        MD.removeData(Admin, 1);
        //*/
        
        // This will read the data as well as how u how many items
        
        data = MD.ReadData();
        count = MD.getCount();
        System.out.println(count + " item in the list");
        for (int i = 0; i<data.size();i++){
            System.out.println(data.get(i));
        }
        //*/
        
        // change a specific data
        /*
        data = MD.ReadData();
        count = MD.getCount();
        System.out.println(count + " is the size of the list");
        for (int i = 0; i<data.size();i++){
            if (data.get(i).getName().equals("Zorus")){
                data.get(i).setName("TheZorus");
                data.set(i, data.get(i));
            }
            System.out.println(data.get(i));
        }
        MD.updateData(Admin, data);
        //*/
        
        
        
    }
}