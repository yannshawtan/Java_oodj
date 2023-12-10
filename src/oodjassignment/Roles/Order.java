package oodjassignment.Roles;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import oodjassignment.Date_Provider;

public class Order extends Identifier implements Serializable, Date_Provider{
    
    private String CustomerID, FeedbackForVendor, FeedbackForRunner, Location, VendorID ,Created_Dt, Created_Time ,RunnerId;
    private int RatingForVendor,RatingForRunner;
    private Status Status;
    private Options Options;
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    
    public enum Status{
        PendingVendor,
        PendingRunner,
        InKitchen,
        ReadyForCollection,
        OutForDelivery,
        Completed,
        Decline,
        Cancelled
    }
    
    public enum Options{
        DineIn,
        TakeAway,
        Delivery
    }
    
    private ArrayList<String> FoodName;
    private double TotalAmount;
    public Order(String CustomerID, ArrayList<String> FoodName, Options Options, double TotalAmount, String Location, Status Status, String VendorID){
        super("O"); 
        this.Status = Status;
        this.CustomerID = CustomerID;
        this.FoodName = FoodName;
        this.Options = Options;
        this.Location = Location;
        this.VendorID = VendorID;
        setTotalAmount(TotalAmount);
        this.Created_Dt = getCurrentDate();
        this.Created_Time = getCurrentTime();
    }
    
    public String getRunnerId() {
        return RunnerId;
    }

    public void setRunnerId(String RunnerId) {
        this.RunnerId = RunnerId;
    }
    
    public String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        return formatDate(currentDate);
    }
    
    public String getCurrentTime(){
        LocalTime currentTime = LocalTime.now();
        return formatTime(currentTime);
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCreated_Dt() {
        return Created_Dt;
    }
    
    public String getCreated_Time() {
        return Created_Time;
    }
    
    public Options getOptions() {
        return Options;
    }

    public void setOptions(Options Options) {
        this.Options = Options;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status Status) {
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

    public String getStringRatingForVendor() {
        if (RatingForVendor == 0){
            return "null";
        }
        else{
            return String.valueOf(RatingForVendor);
        }
    }

    public void setRatingForVendor(int RatingForVendor) {
        this.RatingForVendor = RatingForVendor;
    }

    public int getRatingForRunner() {
        return RatingForRunner;
    }

    public String getStringRatingForRunner() {
        if (RatingForRunner == 0){
            return "null";
        }
        else{
            return String.valueOf(RatingForRunner);
        }
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

    public double getTotalAmount() {
        String formattedAmount = decimalFormat.format(TotalAmount);
        double TotalAmount = Double.parseDouble(formattedAmount);
        return TotalAmount;
    }

    public void setTotalAmount(double TotalAmount) {
        String formattedAmount = decimalFormat.format(TotalAmount);
        double parsedAmount = Double.parseDouble(formattedAmount);
        this.TotalAmount = parsedAmount;
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

    @Override
    public String toString() {

        return "Order{" + "CustomerID=" + CustomerID + ", FeedbackForVendor=" + FeedbackForVendor + ", FeedbackForRunner=" + FeedbackForRunner + ", Location=" + Location + ", VendorID=" + VendorID + ", Created_Dt=" + Created_Dt + ", Created_Time=" + Created_Time + ", RunnerId=" + RunnerId + ", RatingForVendor=" + RatingForVendor + ", RatingForRunner=" + RatingForRunner + ", Status=" + Status + ", Options=" + Options + ", FoodName=" + FoodName + ", TotalAmount=" + TotalAmount + '}';

    }
    
}
