package oodjassignment.Roles;

import java.io.Serializable;

public class Identifier implements Serializable{
        private String Prefix,Id;
        private int Number;

    public enum Role {
        Admin,
        Customer,
        Runner,
        Vendor,
        Delivery,
        Menu,
        Order,
        Transaction,
        Notification
    }

    public Identifier(String Prefix){
        this.Prefix = Prefix;
    }    

    public void setPrefix(String Prefix){
        // in future if wanna change the prefix
        this.Prefix = Prefix;
    }
    
    public String getPrefix(){
        return Prefix;
    }
    
    public String getId(){
        return Id;
    }
    
    public void setNumber(int Number){
        this.Number = Number;
        this.Id = Prefix + Number;
    }
    
    public int getNumber(){
        return Number;
    }
    
    public String toString(){
        return ", from "+ getPrefix();
    }
}
