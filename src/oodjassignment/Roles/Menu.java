package oodjassignment.Roles;

import java.io.Serializable;
import java.text.DecimalFormat;


public class Menu extends Identifier implements Serializable{
    private String foodName, foodType, vendorId;
    private double foodPrice;
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    
    public Menu(String foodName, double foodPrice, String foodType, String vendorId){
        super("M");
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodType = foodType;
        this.vendorId = vendorId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }
    
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }
    
    public String getVendorId() {
        return vendorId;
    }
}