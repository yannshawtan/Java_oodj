/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodjassignment;

import java.util.ArrayList;
import oodjassignment.Roles.Identifier;

/**
 *
 * @author user
 */
public class Runner_Database<T> extends Main_Database{
    
    private ArrayList<T> data;
    private int count;
    private Object currentUser;
    
    public Runner_Database(Identifier.Role role) {
        super(role);
    }
    
    public void AcceptOrder(){

    }
    
}
