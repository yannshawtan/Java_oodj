/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodjassignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Identifier.Role;
import oodjassignment.Roles.Order.Status;

/**
 *
 * @author user
 */
public class Runner_Database<T> extends Main_Database{
    
    
    public Runner_Database(Identifier.Role role) {
        super(role);
    }
    
    public void UpdateOrder(String RunnerId, String OrderId){
        Main_Database<Order> db = new Main_Database<>(Role.Order);
        ArrayList<Order> data = db.ReadData();
        Main_Database<Delivery> dd = new Main_Database<>(Role.Delivery);
        ArrayList<Delivery> ddata = dd.ReadData();
        for (int i = 0; i<data.size(); i++) {
            Order order = (Order) data.get(i);
            if (order.getId().equals(OrderId)) {
                System.out.println(order.getStatus());
                switch (order.getStatus()) {
                    case PendingRunner -> {
                        order.setStatus(Status.InKitchen);
                        order.setRunnerId(RunnerId);
                        data.set(i, order);
                        db.updateData(Role.Order, data);
                        break;
                    }
                    case ReadyForCollection -> {
                        order.setStatus(Status.OutForDelivery);
                        data.set(i, order);
                        db.updateData(Role.Order, data);
                        Delivery d = new Delivery(RunnerId, OrderId);
                        dd.addData(Role.Delivery, d);
                        Notification_Database<Notification> nb = new Notification_Database(Role.Notification);
                        nb.pickUpByRunner(RunnerId, order.getVendorID(),order.getCustomerID(), OrderId );
                        break;
                    }
                    case OutForDelivery -> {
                        order.setStatus(Status.Completed);
                        data.set(i, order);
                        db.updateData(Role.Order, data);
                        Notification_Database<Notification> nb = new Notification_Database(Role.Notification);
                        nb.completedByRunner(RunnerId, order.getVendorID(),order.getCustomerID(), OrderId );
                        break;
                    }
                    default -> {
                    }
                }
            }
        }
    }
    
    public Runner getMoney(Runner currentUser, String OrderId){
        Main_Database<Order> db = new Main_Database<>(Role.Order);
        ArrayList<Order> data = db.ReadData();
        ArrayList<Runner> rdata = ReadData();
        for (int i = 0; i<data.size(); i++) {
            Order order = (Order) data.get(i);
            if (order.getId().equals(OrderId)) {
                for (int j = 0; j<rdata.size(); j++) {
                    Runner runner = (Runner) rdata.get(j);
                    if (runner.getId().equals(currentUser.getId())){
                        double money = order.getTotalAmount()*5/105;
                        runner.updateBalance(money);
                        currentUser.updateBalance(money);
                        rdata.set(j, runner);
                        updateData(Role.Runner, rdata);
                        Transaction_Database<Transaction> td = new Transaction_Database(Role.Transaction);
                        td.runnerReceiveTXN(currentUser, order.getCustomerID(), order.getId());
                        return currentUser;
                    }
                }
            }
        }
        return currentUser;
    }
    
    public double getTotalAmount(String RunnerId, String interval) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        double totalAmount = 0.0;
        Transaction_Database<Transaction> td = new Transaction_Database(Role.Transaction);
        ArrayList<Transaction> data = td.ReadData();
        for (Transaction transaction : data) {
            if (transaction.getReceiverId().equals(RunnerId)){
                LocalDate transactionDate = LocalDate.parse(transaction.getCreatedDt(), formatter);
                switch (interval) {
                    case "Daily" -> {
                        if (transactionDate.equals(currentDate)) {
                            totalAmount += transaction.getAmount();
                        }
                    }
                    case "Monthly" -> {
                        if (isSameMonth(transactionDate, currentDate)) {
                            totalAmount += transaction.getAmount();
                        }
                    }
                    case "Yearly" -> {
                        if (transactionDate.getYear() == currentDate.getYear()) {
                            totalAmount += transaction.getAmount();
                        }
                    }
                    default -> throw new IllegalArgumentException("Invalid interval: " + interval);
                }
            }
        }
        return totalAmount;
    }

    private boolean isSameMonth(LocalDate date1, LocalDate date2) {
    return date1.getYear() == date2.getYear() && date1.getMonth() == date2.getMonth();
}
    
}
