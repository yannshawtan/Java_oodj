package oodjassignment;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Identifier;
import static oodjassignment.Roles.Notification.Condition.*;

public class Tester {
    
    public static void main(String[] args){
//        ArrayList<Admin> data;
//        ArrayList<Customer> data;
        ArrayList<Order> data;
//        ArrayList<Notification> data;
//        ArrayList<Runner> data;
//        ArrayList<Menu> data;
        ArrayList<String> foodName = new  ArrayList<String>();
        foodName.add("Burger");
        foodName.add("Fried");
        int count;
//        Identifier.Role role = Identifier.Role.Admin;
//        Identifier.Role role = Identifier.Role.Customer;
        Identifier.Role role = Identifier.Role.Order;
//        Identifier.Role role = Identifier.Role.Notification;
//        Identifier.Role role = Identifier.Role.Runner;
//        Identifier.Role role = Identifier.Role.Menu;
//        Main_Database<Admin> MD = new Main_Database<>(role);
//        Main_Database<Runner> MD = new Main_Database<>(role);
//        Main_Database<Menu> MD = new Main_Database<>(role);
        Account_Database<Order> MD = new Account_Database<>(role);
//        Account_Database<Notification> MD = new Account_Database<>(role);
//        Account_Database<Customer> MD = new Account_Database<>(role);
        
        
//        Admin a1 = new Admin("Rudory", "nastyru", "rudory@gmail.com");
//        Customer c1 = new Customer("Zorus", "Zorus", "Zorus@gmail.com");
//        Admin a2 = new Admin("Shaw", "Shaw", "Shaw@gmail.com");
//        Admin a3 = new Admin("Dalton", "Dalton", "Dalton@gmail.com");
//        Admin a4 = new Admin("ZorusNew", "Zorus", "Zorus@gmail.com");
//        Vendor v2 = new Vendor("McDonald's", "mcdonald", "mcd@tech.uni");
        Order o1 = new Order("C1", foodName, "Dine in", 10.50, "B-05-06", "Pending", "V1");
        o1.setRunnerId("R1");
        Menu f1 = new Menu("Chili Pan Mee", 8.90, "Food", "V1"); 
        Notification n1 = new Notification("A1", "C1", TopUp); 
        // Add data
        
        
//        MD.addData(role, n1);
        MD.addData(role, o1);
//        MD.addData(role, c1);
//        MD.addData(role, a1);
//        MD.addData(role, a2);
//        MD.addData(role, a3);
//        MD.addData(role, a4);
//        MD.addData(role, v2);
//        MD.addData(role, f1);
        //*/
        
        // Remove data, remember to check the location number as because u delete the item will affect its total number
        // For example, u delete item 4, from an list of only 4 item, next time u try that again it will cause error as now the list is only 3 item
        /*
        MD.removeData(role, 1);
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
        MD.updateData(role, data);
        //*/
        
        
        
    }
}
