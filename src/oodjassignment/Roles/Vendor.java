package oodjassignment.Roles;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import oodjassignment.Date_Provider;

public class Vendor extends Identifier implements Serializable, Date_Provider{
    private String Name, Password, Email, Created_Dt, Created_Time, stringRating;
    private double Balance, temp, Rating;
    private int totalRating, countRating;
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    
    public Vendor(String Name, String Password, String Email){
        super("D"); 
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
    
    public void updateBalance(double amount) {
        String formattedAmount = decimalFormat.format(amount);
        double parsedAmount = Double.parseDouble(formattedAmount);
        this.Balance += parsedAmount;
    }
    
    public double getBalance(){
        return Balance;
    }
    
    public String getStringBalance(){
        return String.valueOf(Balance);
    }
    
    public String getCreated_Date(){
        return Created_Dt;
    }
    
    public String getCreated_Time(){
        return Created_Time;
    }
    
    public void setRating(int total, int num){
        temp = (double)total/num;
        this.stringRating = decimalFormat.format(temp);
    }
    
    public String getStringRating(){
        return stringRating;
    }
    
    public double getRating(){
        Rating = Double.parseDouble(stringRating);
        return Rating;
    }
    
    public void newTotalRating(int totalRating){
        this.totalRating += totalRating;
        this.countRating ++;
        setRating(this.totalRating, countRating);
    }
    
    public int getTotalRating(){
        return totalRating;
    }
    
    public int getCountRating(){
        return countRating;
    }
    
    public String toString(){
        return getNumber() + ". This is " + getName() + ", from "+ getId();
    }
}
