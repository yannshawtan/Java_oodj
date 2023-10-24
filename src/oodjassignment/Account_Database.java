package oodjassignment;

import java.io.*;
import javax.swing.JOptionPane;

public class Account_Database extends Main_Database{
    String [][]Data;
    String [][]rawData;
    User owner = new User();
    
    public Account_Database(String role) {
        super(role);
    }
    
    public void AddData(String usr, String mail, String pswd, String pst){
        try {
            String id = GetNextId(pst);
//            String id = "Test";
            super.writeFile();
            // Need to create a function to find the latest id and date
            String dateCreate = GetCurrentDate(pst);
            String balance = "0.0";
            // Name, Email, Password, Position
            switch (pst) {
                case "Admin" -> {
                    //A1|Zorus|Zorus@email.com|Zorus|27/09/2023 14:30:45|
                    bw.write(id + "|" + usr + "|" + mail + "|" + pswd + "|" + dateCreate + "|\n");
                }
                case "Customer" -> {
                    //C1|Zorus|Zorus@email.com|Zorus|27/09/2023 14:30:45|10.50|
                    bw.write(id + "|" + usr + "|" + mail + "|" + pswd + "|" + dateCreate+ "|" + balance + "|\n");
                }
                case "Vendor" -> {
                    //V1|Zorus|Zorus@email.com|Zorus|27/09/2023 14:30:45|10.50|5.0|
                    bw.write(id + "|" + usr + "|" + mail + "|" + pswd + "|" + dateCreate+ "|" + balance + "|\n");
                }
                case "Runner" -> {
                    //R1|Zorus|Zorus@email.com|Zorus|27/09/2023 14:30:45|10.50|5.0|
                    bw.write(id + "|" + usr + "|" + mail + "|" + pswd + "|" + dateCreate+ "|" + balance + "|\n");
                }
                default -> {
                }
            }
            super.WriteClose();
            JOptionPane.showMessageDialog(null, "Register Complete!");
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File not found!");
        }
    }
    
    public boolean LoginValidation(String email, String pswd, String pst){
        Data = super.ReadData();
        count = super.getCount();
        for (int i = 0; i<count; i++){
            if (Data[i][2].equals(email) && Data[i][3].equals(pswd)){
                switch (pst) {
                    case "Admin" -> {
                        owner.setId(Data[i][0]);
                        owner.setName(Data[i][1]);
                        owner.setEmail(Data[i][2]);
                        owner.setPassword(Data[i][3]);
                        owner.setPrefix("A");
                        owner.setCreated_Dt(Data[i][4]);
                    }
                    case "Customer" -> {
                        owner.setId(Data[i][0]);
                        owner.setName(Data[i][1]);
                        owner.setEmail(Data[i][2]);
                        owner.setPassword(Data[i][3]);
                        owner.setPrefix("C");
                        owner.setCreated_Dt(Data[i][4]);
                        owner.setBalance(Data[i][5]);
                    }
                    case "Vendor" -> {
                        owner.setId(Data[i][0]);
                        owner.setName(Data[i][1]);
                        owner.setEmail(Data[i][2]);
                        owner.setPassword(Data[i][3]);
                        owner.setPrefix("V");
                        owner.setCreated_Dt(Data[i][4]);
                        owner.setBalance(Data[i][5]);
                        owner.setRating(Data[i][6]);
                    }
                    case "Runner" -> {
                        owner.setId(Data[i][0]);
                        owner.setName(Data[i][1]);
                        owner.setEmail(Data[i][2]);
                        owner.setPassword(Data[i][3]);
                        owner.setPrefix("R");
                        owner.setCreated_Dt(Data[i][4]);
                        owner.setBalance(Data[i][5]);
                        owner.setRating(Data[i][6]);
                    }
                    default -> {
                    }
                }
                JOptionPane.showMessageDialog(null, "Login Success");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Incorrect username or password!");
        return false;
    }
    
    public boolean RegisterValidation(String name, String email){
        Data = super.ReadData();
        count = super.getCount();
        for (int i=0; i<count;i++){
            if ((Data[i][1].equals(name) || Data[i][2].equals(email))){
                return true;
            }
        }
        return false;
    }
    
    public User getData(){
        return owner;
    }
    
    public boolean AccountValidation(String email){
        Data = super.ReadData();
        count = super.getCount();
        for (int i=0; i<count;i++){
            if (Data[i][2].equals(email)){
                return false;
            }
        }
        return true;
    }
    
    public void changePassword(String email, String password){
        try {
            rawData = super.ReadData();
            count = super.getCount();
            for (int i = 0; i<count; i++){
                if (rawData[i][2].equals(email)){
                    rawData[i][3] = password;
                }
            }
            super.newWriteFile();
            for (int i=0; i<count;i++){
                String line= "";
                for (int j = 0; j<rawData[i].length;j++){
                    line += rawData[i][j] + "|";
                }
                line += "\n";
                bw.write(line);
            }
            super.WriteClose();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
    
}