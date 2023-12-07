package oodjassignment.Roles;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import oodjassignment.Date_Provider;

public class Transaction extends Identifier implements Serializable, Date_Provider{
    
    private String senderId, receiverId, CreatedDt, CreatedTime, orderId;
    private double Amount;
    private Type type;
    
    public enum Type {
        Withdraw,
        TopUp,
        OrderFood,
        Delivery
    }
    
    
    // Top-up or Withdraw Constructor
    public Transaction(String senderId, String receiverId, Type type, double Amount) {
        super("T");
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.type = type;
        this.orderId = "null";
        this.Amount = Amount;
    }
    
    // OrderFood or Delivery Constructor
    public Transaction(String senderId, String receiverId, Type type, double Amount, String orderId) {
        super("T");
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.type = type;
        this.orderId = orderId;
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

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public Type getType() {
        return type;
    }

    public String getCreatedDt() {
        return CreatedDt;
    }

    public String getCreatedTime() {
        return CreatedTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return Amount;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    @Override
    public String toString() {
        return "Transaction{" + "senderId=" + senderId + ", receiverId=" + receiverId + ", CreatedDt=" + CreatedDt + ", CreatedTime=" + CreatedTime + ", orderId=" + orderId + ", Amount=" + Amount + ", type=" + type + '}';
    }
    
    
}
