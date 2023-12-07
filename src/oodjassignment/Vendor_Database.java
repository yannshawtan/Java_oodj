package oodjassignment;

import java.util.ArrayList;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Identifier.Role;
import oodjassignment.Roles.Order.Status;

public class Vendor_Database<T> extends Main_Database{
    
    
    public Vendor_Database(Identifier.Role role) {
        super(role);
    }
    
    public void acceptOrder(String VendorId, String OrderId){
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
                    }
                    case InKitchen -> {
                        order.setStatus(Status.ReadyForCollection);
                        data.set(i, order);
                        db.updateData(Role.Order, data);
                        //                Notification_Database<Vendor> nb = new Notification_Database(Role.Vendor);
                        //                nb.CreateNotification(VendorId, order.getVendorID(), AcceptDeliery);
                        //                nb.CreateNotification(VendorId, order.getCustomerID(), AcceptDeliery);
                        break;
                    }
                    default -> {
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
    
}
