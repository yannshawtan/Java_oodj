package oodjassignment.Roles;

import java.io.Serializable;
import java.util.ArrayList;

public class Order extends Identifier implements Serializable{
    
    private String CustomerID,CreatedDt,Options,Status,FeedbackForVendor, FeedbackForRunner, Location, VendorID;
    private int RatingForVendor,RatingForRunner;
    private ArrayList<String> FoodName;
    private Double TotalAmount;
    public Order(String CustomerID, ArrayList<String> FoodName,
            String Options, Double TotalAmount, String Location, String Status, String VendorID){
        super("O"); 
        this.Status = Status;
        this.CustomerID = CustomerID;
        this.FoodName = FoodName;
        this.Options = Options;
        this.Location = Location;
        this.VendorID = VendorID;
        this.TotalAmount = TotalAmount;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCreatedDt() {
        return CreatedDt;
    }

    public void setCreatedDt(String CreatedDt) {
        this.CreatedDt = CreatedDt;
    }

    public String getOptions() {
        return Options;
    }

    public void setOptions(String Options) {
        this.Options = Options;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getFeedbackForVendor() {
        return FeedbackForVendor;
    }

    public void setFeedbackForVendor(String FeedbackForVendor) {
        this.FeedbackForVendor = FeedbackForVendor;
    }

    public String getFeedbackForRunner() {
        return FeedbackForRunner;
    }

    public void setFeedbackForRunner(String FeedbackForRunner) {
        this.FeedbackForRunner = FeedbackForRunner;
    }

    public int getRatingForVendor() {
        return RatingForVendor;
    }

    public void setRatingForVendor(int RatingForVendor) {
        this.RatingForVendor = RatingForVendor;
    }

    public int getRatingForRunner() {
        return RatingForRunner;
    }

    public void setRatingForRunner(int RatingForRunner) {
        this.RatingForRunner = RatingForRunner;
    }

    public ArrayList<String> getFoodName() {
        return FoodName;
    }

    public void setFoodName(ArrayList<String> FoodName) {
        this.FoodName = FoodName;
    }

    public Double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(Double TotalAmount) {
        this.TotalAmount = TotalAmount;
    }
    
    public String getVendorID() {
        return VendorID;
    }

    public void setVendorID(String VendorID) {
        this.VendorID = VendorID;
    }
    
    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String toString() {
        return "ID" + getId() + ", CustomerID:" + getCustomerID();
    }
    
}
