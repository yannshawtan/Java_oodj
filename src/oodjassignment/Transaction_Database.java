package oodjassignment;

import java.util.ArrayList;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Identifier.Role;

public class Transaction_Database<T> extends Main_Database{
    
    
    public Transaction_Database(Identifier.Role role) {
        super(role);
    }
    
    
    public Vendor vendorReceiveTXN(Vendor currentUser, String custId, String orderId) {
        Main_Database<Order> OD = new Main_Database<>(Role.Order);
        ArrayList<Order> orderData = OD.ReadData();
        Main_Database<Transaction> TD = new Main_Database<>(Role.Transaction);
        for (int i = 0; i < orderData.size(); i++) {
            Order order = (Order) orderData.get(i);
            if (order.getId().equals(orderId)) {
                double amount = order.getTotalAmount();
                double vendorCut = amount * 100/105;
                switch (order.getOptions()) {
                    case DineIn -> {
                        Transaction t = new Transaction(custId, currentUser.getId(), Transaction.Type.OrderFood, amount, orderId);
                        TD.addData(Role.Transaction, t);
                    }
                    case TakeAway -> {
                        Transaction t = new Transaction(custId, currentUser.getId(), Transaction.Type.OrderFood, amount, orderId);
                        TD.addData(Role.Transaction, t);
                    }
                    case Delivery -> {
                        Transaction t = new Transaction(custId, currentUser.getId(), Transaction.Type.OrderFood, vendorCut, orderId);
                        TD.addData(Role.Transaction, t);
                    }
                    default -> {
                    }
                }
            }
        }
        return currentUser;
    }
    
}
