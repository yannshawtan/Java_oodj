package oodjassignment.Roles;

import java.io.Serializable;

public class Notification extends Identifier implements Serializable{
    
    private String sender_Id,receiver_Id;
    private Condition condition;
    private State state;
    
    public enum Condition{
        Withdraw,
        TopUp,
        Accept,
        Decline,
        AcceptDeliery,
        Delivered,
        Pending
        
    }
    
    public enum State{
        Seen,
        Sent
    }
    
    public Notification(String sender_Id, String receiver_Id, Condition condition) {
        super("N");
        this.sender_Id = sender_Id;
        this.receiver_Id = receiver_Id;
        this.condition = condition;
        this.state = State.Sent;
    }

    public String getSender_Id() {
        return sender_Id;
    }

    public String getReceiver_Id() {
        return receiver_Id;
    }

    public Condition getCondition() {
        return condition;
    }

    public State getState() {
        return state;
    }

    public void setCondition(Condition Condition) {
        this.condition = condition;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setSender_Id(String sender_Id) {
        this.sender_Id = sender_Id;
    }

    public void setReceiver_Id(String receiver_Id) {
        this.receiver_Id = receiver_Id;
    }

    @Override
    public String toString() {
        return "Notification{" + "sender_Id=" + sender_Id + ", receiver_Id=" + receiver_Id + ", condition=" + condition + ", state=" + state + '}';
    }
    
    
    
}
