package oodjassignment.Roles;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author user
 */
public class Menu extends Identifier implements Serializable{
    private String foodName, foodType;
    private double foodPrice;
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    
    public Menu(String foodName, double foodPrice, String foodType){
        super("M");
        this.foodName = foodName;
        
    }
}
