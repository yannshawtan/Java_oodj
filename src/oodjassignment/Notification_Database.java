/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodjassignment;

import java.util.ArrayList;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Identifier.Role;

/**
 *
 * @author user
 */
public class Notification_Database<T> extends Main_Database{
    
    private ArrayList<T> data;
    private int count;
    private Object currentUser;
    
    public Notification_Database(Identifier.Role role) {
        super(role);
    }
    
    
    public void CreateNotification(String senderId, String receiverId, String message){
        Notification d = new Notification(senderId, receiverId, message);
        addData(Role.Delivery, d); 
    }
    
    public void acceptedByVendor(Vendor sender, String receiver, String orderId) {
        String vendorId = sender.getId();
        String vendorName = sender.getName();
        String message = orderId + ": Your order has been accepted by " + vendorName;
        Main_Database<Notification> ND = new Main_Database<>(Role.Notification);
        Notification n = new Notification(vendorId, receiver, message);
        ND.addData(Role.Notification, n);
    }
    
    public void pickUpByRunner(String sender, String receiver1, String receiver2, String orderId) {
        String message = orderId + ": Food is out for delivery!";
        Main_Database<Notification> ND = new Main_Database<>(Role.Notification);
        Notification n1 = new Notification(sender, receiver1, message);
        Notification n2 = new Notification(sender, receiver2, message);
        ND.addData(Role.Notification, n1);
        ND.addData(Role.Notification, n2);
    }
    
    public void completedByRunner(String sender, String receiver1, String receiver2, String orderId) {
        String message = orderId + ": Food has been delivered!";
        Main_Database<Notification> ND = new Main_Database<>(Role.Notification);
        Notification n1 = new Notification(sender, receiver1, message);
        Notification n2 = new Notification(sender, receiver2, message);
        ND.addData(Role.Notification, n1);
        ND.addData(Role.Notification, n2);
    }
    
    public void transaction(String sender, String receiverId, String transactionId, String action, double amount) {
        String message = transactionId;
        switch (action){
            case "Withdraw" -> {
                message = transactionId + ": " + amount + " has been deducted from your wallet!";
            }
            // Display new amount
            case "Deposit" -> {
                message = transactionId + ": " + amount + " has been added to your wallet!";
            }
        }
        Notification n = new Notification(sender, receiverId, message);
        addData(Role.Notification, n);
    }
    
//    public void DisplayNotification(String receiverId){
//        data = ReadData();
//        Notification.Condition condition = null;
//        for (int i = 0; i<data.size(); i++){
//            if (data.get(i) instanceof Notification){
//                Notification noti = (Notification) data.get(i);
//                condition = noti.getCondition();
//                
//            }
//        }
//    }
    
}
