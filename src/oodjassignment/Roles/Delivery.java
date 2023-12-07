package oodjassignment.Roles;

import java.io.Serializable;

public class Delivery extends Identifier implements Serializable{
    
    private String runnerId, orderId;
    private Status status;
    
    public enum Status{
        OTW,
        Delivered
    }
    
    public Delivery(String runnerId, String orderId) {
        super("D");
        this.runnerId = runnerId;
        this.orderId = orderId;
        this.status = Status.OTW;
    }

    public String getRunnerId(){
        return runnerId;
    }

    public String getOrderId(){
        return orderId;
    }

    public Status getStatus(){
        return status;
    }

    public void setRunnerId(String runnerId){
        this.runnerId = runnerId;
    }

    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "Delivery{" + "runnerId=" + runnerId + ", orderId=" + orderId + ", status=" + status + '}';
    }
    
}
