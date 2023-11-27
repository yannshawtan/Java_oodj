package oodjassignment;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Identifier.Role;


public class Account_Database<T>{
    
    private Main_Database<T> MD = null;
    private ArrayList<T> data;
    private int count;
    private Object currentUser;
    
    public Account_Database(Role role) {
        MD = new Main_Database<>(role);
    }
    
    public Main_Database<T> databaseType(Role role){
        switch (role) {
            case Admin -> MD = new Main_Database<>(role);
            case Customer -> MD = new Main_Database<>(role);
            case Vendor -> MD = new Main_Database<>(role);
            case Runner -> MD = new Main_Database<>(role);
        }
        return MD;
    }
    
    public void addUser(String name, String email, String pswd, Role role){
        MD = databaseType(role);
        switch (role) {
            case Admin -> {
                Admin a = new Admin(name, pswd, email);
                MD.addData(role, (T) a);
            }
            case Customer -> {
                Customer c = new Customer(name, pswd, email);
                MD.addData(role, (T) c);
            }
            case Vendor -> {
                Vendor v = new Vendor(name, pswd, email);
                MD.addData(role, (T) v);
            }
            case Runner -> {
                Runner r = new Runner(name, pswd, email);
                MD.addData(role, (T) r);
            }
        }
    }
    
    public boolean LoginValidation(String email, String pswd, Role role){
        MD = databaseType(role);
        data = MD.ReadData();
        //count = MD.getCount();
        for (int i = 0; i<data.size(); i++){
            if (data.get(i) instanceof Admin){
                Admin admin = (Admin) data.get(i);
                if (admin.getEmail().equals(email) && admin.getPassword().equals(pswd)) {
                    setUser(role, admin);
                    JOptionPane.showMessageDialog(null, "Login Success");
                    return true;
                }
            }
            else if (data.get(i) instanceof Customer){
                Customer customer = (Customer) data.get(i);
                if (customer.getEmail().equals(email) && customer.getPassword().equals(pswd)) {
                    setUser(role, customer);
                    JOptionPane.showMessageDialog(null, "Login Success");
                    return true;
                }
            }
            else if (data.get(i) instanceof Vendor){
                Vendor vendor = (Vendor) data.get(i);
                if (vendor.getEmail().equals(email) && vendor.getPassword().equals(pswd)) {
                    setUser(role, vendor);
                    JOptionPane.showMessageDialog(null, "Login Success");
                    return true;
                }
            }
            else if (data.get(i) instanceof Runner){
                Runner runner = (Runner) data.get(i);
                if (runner.getEmail().equals(email) && runner.getPassword().equals(pswd)) {
                    setUser(role, runner);
                    JOptionPane.showMessageDialog(null, "Login Success");
                    return true;
                }
            }
        }
        return false;
    }
    
    public void setUser(Role role, Object user) {
        switch (role) {
            case Admin:
                currentUser = (Admin) user;
                break;
            case Customer:
                currentUser = (Customer) user;
                break;
            case Vendor:
                currentUser = (Vendor) user;
                break;
            case Runner:
                currentUser = (Runner) user;
                break;
        }
    }

    public Object getCurrentUser() {
        return currentUser;
    }

    
    
    public boolean RegisterValidation(String email, Role role){
        MD = databaseType(role);
        data = MD.ReadData();
        for (int i = 0; i<data.size(); i++){
            if (data.get(i) instanceof Admin){
                Admin admin = (Admin) data.get(i);
                if (admin.getEmail().equals(email)){
                    return true;
                }
            }
            else if (data.get(i) instanceof Customer){
                Customer customer = (Customer) data.get(i);
                if (customer.getEmail().equals(email)){
                    return true;
                }
            }
            else if (data.get(i) instanceof Vendor){
                Vendor vendor = (Vendor) data.get(i);
                if (vendor.getEmail().equals(email)){
                    return true;
                }
            }
            else if (data.get(i) instanceof Runner){
                Runner runner = (Runner) data.get(i);
                if (runner.getEmail().equals(email)){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean AccountValidation(String email, Role role){
        MD = databaseType(role);
        data = MD.ReadData();
        for (int i = 0; i<data.size(); i++){
            if (data.get(i) instanceof Admin){
                Admin admin = (Admin) data.get(i);
                if (admin.getEmail().equals(email)){
                    return false;
                }
            }
            else if (data.get(i) instanceof Customer){
                Customer customer = (Customer) data.get(i);
                if (customer.getEmail().equals(email)){
                    return false;
                }
            }
            else if (data.get(i) instanceof Vendor){
                Vendor vendor = (Vendor) data.get(i);
                if (vendor.getEmail().equals(email)){
                    return false;
                }
            }
            else if (data.get(i) instanceof Runner){
                Runner runner = (Runner) data.get(i);
                if (runner.getEmail().equals(email)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void changePassword(String email, String password, Role role){
        MD = databaseType(role);
        data = MD.ReadData();
        for (int i = 0; i<data.size();i++){
            if (data.get(i) instanceof Admin){
                Admin admin = (Admin) data.get(i);
                if (admin.getEmail().equals(email)){
                    admin.setPassword(password);
                    data.set(i, (T) admin);
                    MD.updateData(role, data);
                    break;
                }
            }
            else if (data.get(i) instanceof Customer){
                Customer customer = (Customer) data.get(i);
                if (customer.getEmail().equals(email)){
                    customer.setPassword(password);
                    data.set(i, (T) customer);
                    MD.updateData(role, data);
                    break;
                }
            }
            else if (data.get(i) instanceof Vendor){
                Vendor vendor = (Vendor) data.get(i);
                if (vendor.getEmail().equals(email)){
                    vendor.setPassword(password);
                    data.set(i, (T) vendor);
                    MD.updateData(role, data);
                    break;
                }
            }
            else if (data.get(i) instanceof Runner){
                Runner runner = (Runner) data.get(i);
                if (runner.getEmail().equals(email)){
                    runner.setPassword(password);
                    data.set(i, (T) runner);
                    MD.updateData(role, data);
                    break;
                }
            }
        }
    }
    
    public boolean checkBalance(int amount, String email, Role role){
        MD = databaseType(role);
        data = MD.ReadData();
        for (int i = 0; i<data.size();i++){
            if (data.get(i) instanceof Customer){
                Customer customer = (Customer) data.get(i);
                if (customer.getEmail().equals(email)){
                    if (customer.getBalance() >= amount){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
            else if (data.get(i) instanceof Vendor){
                Vendor vendor = (Vendor) data.get(i);
                if (vendor.getEmail().equals(email)){
                    if (vendor.getBalance() >= amount){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
            else if (data.get(i) instanceof Runner){
                Runner runner = (Runner) data.get(i);
                if (runner.getEmail().equals(email)){
                    if (runner.getBalance() >= amount){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public void changeBalance(int amount, String email, Role role){
        MD = databaseType(role);
        data = MD.ReadData();
        for (int i = 0; i<data.size();i++){
            if (data.get(i) instanceof Customer){
                Customer customer = (Customer) data.get(i);
                if (customer.getEmail().equals(email)){
                    customer.updateBalance(amount);
                    data.set(i, (T) customer);
                    MD.updateData(role, data);
                    break;
                }
            }
            else if (data.get(i) instanceof Vendor){
                Vendor vendor = (Vendor) data.get(i);
                if (vendor.getEmail().equals(email)){
                    vendor.updateBalance(amount);
                    data.set(i, (T) vendor);
                    MD.updateData(role, data);
                    break;
                }
            }
            else if (data.get(i) instanceof Runner){
                Runner runner = (Runner) data.get(i);
                if (runner.getEmail().equals(email)){
                    runner.updateBalance(amount);
                    data.set(i, (T) runner);
                    MD.updateData(role, data);
                    break;
                }
            }
        }
    }
}