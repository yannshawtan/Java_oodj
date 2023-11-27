/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodjassignment.Roles;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import oodjassignment.Date_Provider;

/**
 *
 * @author user
 */
public class Delivery extends Identifier implements Serializable, Date_Provider{
    
    private String Name, Password, Email, Created_Dt, Created_Time;
    private double Balance, Rating;
    
    public Delivery(String Name, String Password, String Email, double Balance){
        super("D"); 
        this.Name = Name;
        this.Password = Password;
        this.Email = Email;
        this.Balance = Balance;
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
    
    public void setBalance(double Balance){
        this.Balance = Balance;
    }
    
    public double getBalance(){
        return Balance;
    }
    
    public String getCreated_Date(){
        return Created_Dt;
    }
    
    public String getCreated_Time(){
        return Created_Time;
    }
    
    public void setRating(double Rating){
        this.Rating = Rating;
    }
    
    public double getRating(){
        return Rating;
    }
    
    public String toString(){
        return getNumber() + ". This is " + getName() + ", from "+ getId();
    }
    
    
}
