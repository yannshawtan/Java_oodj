package oodjassignment;

public class Order_But_Useless{
    private String Id, Prefix, Customer_ID, Menu_ID, Food, Quantity, Created_Dt,Status, Total_Amount,
            Rating_For_Vendor, Feedback_For_Vendor, Rating_For_Runner, Feedback_For_Runner;
    
    public void setPrefix(String prefix) {
        this.Prefix = "O";
    }
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(String Customer_ID) {
        this.Customer_ID = Customer_ID;
    }

    public String getMenu_ID() {
        return Menu_ID;
    }

    public void setMenu_ID(String Menu_ID) {
        this.Menu_ID = Menu_ID;
    }

    public String getPrefix() {
        return Prefix;
    }   

    public String getFood() {
        return Food;
    }

    public void setFood(String Food) {
        this.Food = Food;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getCreated_Dt() {
        return Created_Dt;
    }

    public void setCreated_Dt(String Created_Dt) {
        this.Created_Dt = Created_Dt;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getTotal_Amount() {
        return Total_Amount;
    }

    public void setTotal_Amount(String Total_Amount) {
        this.Total_Amount = Total_Amount;
    }

    public String getRating_For_Vendor() {
        return Rating_For_Vendor;
    }

    public void setRating_For_Vendor(String Rating_For_Vendor) {
        this.Rating_For_Vendor = Rating_For_Vendor;
    }

    public String getFeedback_For_Vendor() {
        return Feedback_For_Vendor;
    }

    public void setFeedback_For_Vendor(String Feedback_For_Vendor) {
        this.Feedback_For_Vendor = Feedback_For_Vendor;
    }

    public String getRating_For_Runner() {
        return Rating_For_Runner;
    }

    public void setRating_For_Runner(String Rating_For_Runner) {
        this.Rating_For_Runner = Rating_For_Runner;
    }

    public String getFeedback_For_Runner() {
        return Feedback_For_Runner;
    }

    public void setFeedback_For_Runner(String Feedback_For_Runner) {
        this.Feedback_For_Runner = Feedback_For_Runner;
    }
    
}