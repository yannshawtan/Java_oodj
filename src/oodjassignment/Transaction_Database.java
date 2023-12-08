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
    
    public void runnerReceiveTXN(Runner currentUser, String custId, String orderId) {
        Main_Database<Order> OD = new Main_Database<>(Role.Order);
        ArrayList<Order> orderData = OD.ReadData();
        Main_Database<Transaction> TD = new Main_Database<>(Role.Transaction);
        for (int i = 0; i < orderData.size(); i++) {
            Order order = (Order) orderData.get(i);
            if (order.getId().equals(orderId)) {
                double amount = order.getTotalAmount();
                double finalAmount = amount * 5/105;
                Transaction t = new Transaction(custId, currentUser.getId(), Transaction.Type.OrderFood, finalAmount, orderId);
                TD.addData(Role.Transaction, t);
//                addData(Role.Transaction, t);
            }
        }
    }
    
    public String adminTXN(Admin currentUser, String receiverId, double finalAmount, String action) {
        String created_dt = "",created_Time = "";
        switch (action){
            case "Withdraw" -> {
                Transaction t = new Transaction(currentUser.getId(), receiverId, Transaction.Type.OrderFood, finalAmount, null);
                created_dt = t.getCurrentDate();
                created_Time = t.getCreatedTime();
                addData(Role.Transaction, t);
            }
            case "Deposit" -> {
                Transaction t = new Transaction(receiverId, currentUser.getId(), Transaction.Type.OrderFood, finalAmount, null);
                created_dt = t.getCurrentDate();
                created_Time = t.getCreatedTime();
                addData(Role.Transaction, t);
            }
        }
        ArrayList<Transaction> transactionData = ReadData();
        for (int i = 0; i < transactionData.size(); i++) {
            Transaction transaction = (Transaction) transactionData.get(i);
            if (created_dt.equals(transaction.getCreatedDt()) && created_Time.equals(transaction.getCreatedTime())){
                return transaction.getId();
            }
        }
        return "";
    }
}
