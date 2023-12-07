package oodjassignment.Roles;

import java.io.Serializable;

public class Notification extends Identifier implements Serializable{
    
    private String senderId,receiverId;
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
    
    public Notification(String senderId, String receiverId, Condition condition) {
        super("N");
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.condition = condition;
        this.state = State.Sent;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
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

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public String toString() {
        return "Notification{" + "senderId=" + senderId + ", receiverId=" + receiverId + ", condition=" + condition + ", state=" + state + '}';
    }
    
    
    
}
