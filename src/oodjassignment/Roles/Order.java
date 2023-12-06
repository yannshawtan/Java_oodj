package oodjassignment.Roles;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import oodjassignment.Date_Provider;

public class Order extends Identifier implements Serializable, Date_Provider{
    
    private String CustomerID, Options, Status, FeedbackForVendor, FeedbackForRunner, Location, VendorID ,Created_Dt, Created_Time ,RunnerId;
    private int RatingForVendor,RatingForRunner;

    private ArrayList<String> FoodName;
    private Double TotalAmount;
    public Order(String CustomerID, ArrayList<String> FoodName, String Options, Double TotalAmount, String Location, String Status, String VendorID){
        super("O"); 
        this.Status = Status;
        this.CustomerID = CustomerID;
        this.FoodName = FoodName;
        this.Options = Options;
        this.Location = Location;
        this.VendorID = VendorID;
        this.TotalAmount = TotalAmount;
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

    @Override
    public String toString() {
<<<<<<< HEAD
        return "ID " + getId() + ", CustomerID " + getCustomerID() +", FoodNames " + getFoodName()+ ", get VendorID " + getVendorID() + "Get Location " + getLocation()+"Total Amount" + getTotalAmount()+
                "Get Status: "+ getStatus() + ",getoption " +getOptions(); 
=======
        return "Order{" + "CustomerID=" + CustomerID + ", Options=" + Options + ", Status=" + Status + ", FeedbackForVendor=" + FeedbackForVendor + ", FeedbackForRunner=" + FeedbackForRunner + ", Location=" + Location + ", VendorID=" + VendorID + ", Created_Dt=" + Created_Dt + ", Created_Time=" + Created_Time + ", RunnerId=" + RunnerId + ", RatingForVendor=" + RatingForVendor + ", RatingForRunner=" + RatingForRunner + ", FoodName=" + FoodName + ", TotalAmount=" + TotalAmount + '}';
>>>>>>> master
    }
    
}
