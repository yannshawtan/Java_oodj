package oodjassignment.Roles;

import java.io.Serializable;

public class Transaction extends Identifier implements Serializable{
    
    private String sender_Id, receiver_Id, Description;
    private double Amount;
    
    public Transaction() {
        super("T");
    }
    
}
