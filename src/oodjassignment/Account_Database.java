package oodjassignment;

import java.util.ArrayList;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Identifier.Role;


public class Account_Database<T> extends Main_Database{
    
    private ArrayList<T> data;
    private int count;
    private Object currentUser;
    
    public Account_Database(Role role) {
        super(role);
    }
    
    public void addUser(String name, String email, String pswd, Role role){
        switch (role) {
            case Admin -> {
                Admin a = new Admin(name, pswd, email);
                addData(role, (T) a);
            }
            case Customer -> {
                Customer c = new Customer(name, pswd, email);
                addData(role, (T) c);
            }
            case Vendor -> {
                Vendor v = new Vendor(name, pswd, email);
                addData(role, (T) v);
            }
            case Runner -> {
                Runner r = new Runner(name, pswd, email);
                addData(role, (T) r);
            }
        }
    }
    
    public boolean LoginValidation(String email, String pswd, Role role){
        data = ReadData();
        for (int i = 0; i<data.size(); i++){
            if (data.get(i) instanceof Admin){
                Admin admin = (Admin) data.get(i);
                if (admin.getEmail().equals(email) && admin.getPassword().equals(pswd)) {
                    setUser(role, admin);
                    return true;
                }
            }
            else if (data.get(i) instanceof Customer){
                Customer customer = (Customer) data.get(i);
                if (customer.getEmail().equals(email) && customer.getPassword().equals(pswd)) {
                    setUser(role, customer);
                    return true;
                }
            }
            else if (data.get(i) instanceof Vendor){
                Vendor vendor = (Vendor) data.get(i);
                if (vendor.getEmail().equals(email) && vendor.getPassword().equals(pswd)) {
                    setUser(role, vendor);
                    return true;
                }
            }
            else if (data.get(i) instanceof Runner){
                Runner runner = (Runner) data.get(i);
                if (runner.getEmail().equals(email) && runner.getPassword().equals(pswd)) {
                    setUser(role, runner);
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
        data = ReadData();
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
        data = ReadData();
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
    
    public boolean PasswordRepetation(String password, Role role){
        data = ReadData();
        for (int i = 0; i<data.size(); i++){
            if (data.get(i) instanceof Admin){
                Admin admin = (Admin) data.get(i);
                if (admin.getPassword().equals(password)){
                    return false;
                }
            }
            else if (data.get(i) instanceof Customer){
                Customer customer = (Customer) data.get(i);
                if (customer.getPassword().equals(password)){
                    return false;
                }
            }
            else if (data.get(i) instanceof Vendor){
                Vendor vendor = (Vendor) data.get(i);
                if (vendor.getPassword().equals(password)){
                    return false;
                }
            }
            else if (data.get(i) instanceof Runner){
                Runner runner = (Runner) data.get(i);
                if (runner.getPassword().equals(password)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void changePassword(String email, String password, Role role){
        data = ReadData();
        for (int i = 0; i<data.size();i++){
            if (data.get(i) instanceof Admin){
                Admin admin = (Admin) data.get(i);
                if (admin.getEmail().equals(email)){
                    admin.setPassword(password);
                    data.set(i, (T) admin);
                    updateData(role, data);
                    break;
                }
            }
            else if (data.get(i) instanceof Customer){
                Customer customer = (Customer) data.get(i);
                if (customer.getEmail().equals(email)){
                    customer.setPassword(password);
                    data.set(i, (T) customer);
                    updateData(role, data);
                    break;
                }
            }
            else if (data.get(i) instanceof Vendor){
                Vendor vendor = (Vendor) data.get(i);
                if (vendor.getEmail().equals(email)){
                    vendor.setPassword(password);
                    data.set(i, (T) vendor);
                    updateData(role, data);
                    break;
                }
            }
            else if (data.get(i) instanceof Runner){
                Runner runner = (Runner) data.get(i);
                if (runner.getEmail().equals(email)){
                    runner.setPassword(password);
                    data.set(i, (T) runner);
                    updateData(role, data);
                    break;
                }
            }
        }
    }
    
    public boolean checkBalance(double amount, String email, Role role){
        data = ReadData();
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
    
    public void changeBalance(double amount, String email, Role role){
        data = ReadData();
        for (int i = 0; i<data.size();i++){
            if (data.get(i) instanceof Customer){
                Customer customer = (Customer) data.get(i);
                if (customer.getEmail().equals(email)){
                    customer.updateBalance(amount);
                    data.set(i, (T) customer);
                    updateData(role, data);
                    break;
                }
            }
            else if (data.get(i) instanceof Vendor){
                Vendor vendor = (Vendor) data.get(i);
                if (vendor.getEmail().equals(email)){
                    vendor.updateBalance(amount);
                    data.set(i, (T) vendor);
                    updateData(role, data);
                    break;
                }
            }
            else if (data.get(i) instanceof Runner){
                Runner runner = (Runner) data.get(i);
                if (runner.getEmail().equals(email)){
                    runner.updateBalance(amount);
                    data.set(i, (T) runner);
                    updateData(role, data);
                    break;
                }
            }
        }
    }
}