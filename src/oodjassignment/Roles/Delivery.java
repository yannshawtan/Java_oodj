package oodjassignment.Roles;

import java.io.Serializable;

public class Delivery extends Identifier implements Serializable{
    
    private String runner_Id, order_Id;
    private Status status;
    
    private enum Status{
        OTW,
        Delivered
    }
    
    public Delivery(String runner_Id, String order_Id) {
        super("D");
        this.runner_Id = runner_Id;
        this.order_Id = order_Id;
        this.status = Status.OTW;
    }

    public String getRunner_Id() {
        return runner_Id;
    }

    public String getOrder_Id() {
        return order_Id;
    }

    public Status getStatus() {
        return status;
    }

    public void setRunner_Id(String runner_Id) {
        this.runner_Id = runner_Id;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id = order_Id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Delivery{" + "runner_Id=" + runner_Id + ", order_Id=" + order_Id + ", status=" + status + '}';
    }
    
}
