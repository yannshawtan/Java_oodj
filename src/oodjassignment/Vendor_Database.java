package oodjassignment;

import java.util.ArrayList;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Identifier.Role;
import oodjassignment.Roles.Order.Status;

public class Vendor_Database<T> extends Main_Database{
    
    
    public Vendor_Database(Identifier.Role role) {
        super(role);
    }
    
    public void updateOrder(String VendorId, String OrderId){
        Main_Database<Order> db = new Main_Database<>(Role.Order);
        ArrayList<Order> data = db.ReadData();
        for (int i = 0; i<data.size(); i++) {
            Order order = (Order) data.get(i);
            if (order.getId().equals(OrderId)) {
                switch (order.getStatus()) {
                    case PendingVendor -> {
                        if (order.getOptions() == Order.Options.DineIn || order.getOptions() == Order.Options.TakeAway) {
                            order.setStatus(Status.InKitchen);
                            data.set(i, order);
                            db.updateData(Role.Order, data);
                            break;
                        }
                        
                        if (order.getOptions() == Order.Options.Delivery) {
                            order.setStatus(Status.PendingRunner);
                            data.set(i, order);
                            db.updateData(Role.Order, data);
                            break;
                        }
                        break;
                    }
                    case InKitchen -> {
                        order.setStatus(Status.ReadyForCollection);
                        data.set(i, order);
                        db.updateData(Role.Order, data);
                        break;
                    }
                    default -> {
                    }
                }
            }
        }
    }
    
    public void collectedOrder(String VendorId, String OrderId){
        Main_Database<Order> db = new Main_Database<>(Role.Order);
        ArrayList<Order> data = db.ReadData();
        for (int i = 0; i<data.size(); i++) {
            Order order = (Order) data.get(i);
            if (order.getId().equals(OrderId)) {
                switch (order.getStatus()) {
                    case ReadyForCollection -> {
                        order.setStatus(Status.Completed);
                        data.set(i, order);
                        db.updateData(Role.Order, data);
                        break;
                    }
                }
            }
        }
    }
    
    public void declineOrder(String VendorId, String OrderId){
        Main_Database<Order> db = new Main_Database<>(Role.Order);
        ArrayList<Order> data = db.ReadData();
        for (int i = 0; i<data.size(); i++) {
            Order order = (Order) data.get(i);
            if (order.getId().equals(OrderId)) {
                switch (order.getStatus()) {
                    case PendingVendor -> {
                        order.setStatus(Status.Decline);
                        data.set(i, order);
                        db.updateData(Role.Order, data);
                        break;
                    }
                }
            }
        }
    }
    
    public Vendor getMoney(Vendor currentUser, String OrderId){
        Main_Database<Order> db = new Main_Database<>(Role.Order);
        ArrayList<Order> data = db.ReadData();
        ArrayList<Vendor> rdata = ReadData();
        for (int i = 0; i<data.size(); i++) {
            Order order = (Order) data.get(i);
            if (order.getId().equals(OrderId)) {
                for (int j = 0; j<rdata.size(); j++) {
                    Vendor vendor = (Vendor) rdata.get(j);
                    if (vendor.getId().equals(currentUser.getId())){
                        double money = order.getTotalAmount();
                        if (order.getOptions() == Order.Options.Delivery) {
                            money = order.getTotalAmount()*100/105;
                        }
                        vendor.updateBalance(money);
                        currentUser.updateBalance(money);
                        rdata.set(j, vendor);
                        updateData(Role.Vendor, rdata);
                        return currentUser;
                    }
                }
            }
        }
        return currentUser;
    }
    
    public void refundMoney(String custId, String orderId) {
        Main_Database<Order> ob = new Main_Database<>(Role.Order);
        ArrayList<Order> data = ob.ReadData();
        Main_Database<Customer> cd = new Main_Database<>(Role.Customer);
        ArrayList<Customer> cdata = cd.ReadData();
        for (int i = 0; i<data.size(); i++) {
            Order order = (Order) data.get(i);
            if (orderId.equals(order.getId())) {
                for (int j = 0; j<cdata.size(); j++) {
                    Customer customer = (Customer) cdata.get(j);
                    if (custId.equals(customer.getId())){
                        double money = order.getTotalAmount();
                        customer.updateBalance(money);
                        cdata.set(j, customer);
                        cd.updateData(Role.Customer, cdata);
                        break;
                    }
                }
            }
        }
    }
    
}
