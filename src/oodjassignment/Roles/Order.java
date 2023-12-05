package oodjassignment.Roles;

import java.io.Serializable;
import java.util.ArrayList;

public class Order extends Identifier implements Serializable{
    
    private String OrderID,CustomerID,CreatedDt,Options,Status,CompletedDt,FeedbackForVendor, FeedbackForRunner;
    private int RatingForVendor,RatingForRunner;
    private ArrayList FoodName;
    private Double TotalAmount;
    public Order(String OrderID, String CustomerID, ArrayList FoodName, String CreatedDt,
            String Options, String Status, Double TotalAmount,String CompletedDt, int RatingForVendor,String FeedbackForVendor,
            int RatingForRunner, String FeedbackForRunner){
        super("O"); 
        this.OrderID = OrderID;
        this.CompletedDt = CompletedDt;
        this.CreatedDt = CreatedDt;
        
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
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

    public String getCompletedDt() {
        return CompletedDt;
    }

    public void setCompletedDt(String CompletedDt) {
        this.CompletedDt = CompletedDt;
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

    public ArrayList getFoodName() {
        return FoodName;
    }

    public void setFoodName(ArrayList FoodName) {
        this.FoodName = FoodName;
    }

    public Double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(Double TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

   
    
    
}
