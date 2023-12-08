package oodjassignment.Roles;

import java.io.Serializable;

public class Notification extends Identifier implements Serializable{
    
    private String senderId,receiverId, message;
    private State state;
    
    public enum State{
        Seen,
        Sent
    }
    
    public Notification(String senderId, String receiverId, String message) {
        super("N");
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.state = State.Sent;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getMessage() {
        return message;
    }

    public State getState() {
        return state;
    }

    public void setMessage(String message) {
        this.message = message;
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
        return "Notification{" + "senderId=" + senderId + ", receiverId=" + receiverId + ", message=" + message + ", state=" + state + '}';
    }

}
