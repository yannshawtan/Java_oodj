package oodjassignment.Roles;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import oodjassignment.Date_Provider;

public class Transaction extends Identifier implements Serializable, Date_Provider{
    
    private String sender_Id, receiver_Id, Created_Dt, Created_Time, order_Id;
    private double Amount;
    private Type type;
    
    private enum Type{
        Withdraw,
        TopUp,
        OrderFood,
        Delivery
    }

    public Transaction(String sender_Id, String receiver_Id, Type type, double Amount) {
        super("T");
        this.sender_Id = sender_Id;
        this.receiver_Id = receiver_Id;
        this.type = type;
        this.order_Id = "null";
        this.Amount = Amount;
    }
    
    public Transaction(String sender_Id, String receiver_Id, Type type, double Amount, String order_Id) {
        super("T");
        this.sender_Id = sender_Id;
        this.receiver_Id = receiver_Id;
        this.type = type;
        this.order_Id = order_Id;
        this.Amount = Amount;
    }
    
    public String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        return formatDate(currentDate);
    }
    
    public String getCurrentTime(){
        LocalTime currentTime = LocalTime.now();
        return formatTime(currentTime);
    }

    public String getSender_Id() {
        return sender_Id;
    }

    public String getReceiver_Id() {
        return receiver_Id;
    }

    public Type getType() {
        return type;
    }

    public String getCreated_Dt() {
        return Created_Dt;
    }

    public String getCreated_Time() {
        return Created_Time;
    }

    public String getOrder_Id() {
        return order_Id;
    }

    public double getAmount() {
        return Amount;
    }

    public void setSender_Id(String sender_Id) {
        this.sender_Id = sender_Id;
    }

    public void setReceiver_Id(String receiver_Id) {
        this.receiver_Id = receiver_Id;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id = order_Id;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }
    
    
}
