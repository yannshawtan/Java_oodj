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
    
    
    public void CreateNotification(String senderId, String receiverId, Notification.Condition condition){
        Notification d = new Notification(senderId, receiverId, condition);
        addData(Role.Delivery, d);
        
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
