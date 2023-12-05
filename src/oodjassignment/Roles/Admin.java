package oodjassignment.Roles;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import oodjassignment.Date_Provider;

public class Admin extends Identifier implements Serializable, Date_Provider{
    
    private String Name, Password, Email, Created_Dt, Created_Time;
    
    public Admin(String Name, String Password, String Email){
        super("A"); 
        this.Name = Name;
        this.Password = Password;
        this.Email = Email;
        this.Created_Dt = getCurrentDate();
        this.Created_Time = getCurrentTime();
    }
    
    public String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        return formatDate(currentDate);
    }
    
    public String getCurrentTime(){
        LocalTime currentTime = LocalTime.now();
        return formatTime(currentTime);
    }
    
    public void setName(String Name){
        this.Name = Name;
    }
    
    public String getName(){
        return Name;
    }
    
    public void setEmail(String Email){
        this.Email = Email;
    }
    
    public String getEmail(){
        return Email;
    }
    
    public void setPassword(String Password){
        this.Password = Password;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public String getCreated_Date(){
        return Created_Dt;
    }
    
    public String getCreated_Time(){
        return Created_Time;
    }
    
    public String toString(){
        return getNumber() + "," + getId() + ". This is " + getName() + ", from "+ getCreated_Time();
    }
    
}
