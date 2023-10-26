package oodjassignment;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Main_Database {
    File f1, f;
    FileReader fr;
    FileWriter fw;
    BufferedWriter bw;
    BufferedReader br;
    int count;
    String [][]Data;
    
    public Main_Database(String type){
        // UPGRADE THIS SYSTEM, TO SUIT CURRENT PROJECT
        // 2 different file, 1 name account(admin,customer,vendor,runner), another one name others
        switch (type) {
            case "Admin" -> {
                this.f1 = new File("Database\\Account");
                CreateFolder();
                this.f = new File("Database\\Account\\Admin.txt");
            }
            case "Customer" -> {
                this.f1 = new File("Database\\Account");
                CreateFolder();
                this.f = new File("Database\\Account\\Customer.txt");
            }
            case "Runner" -> {
                this.f1 = new File("Database\\Account");
                CreateFolder();
                this.f = new File("Database\\Account\\Runner.txt");
            }
            case "Vendor" -> {
                this.f1 = new File("Database\\Account");
                CreateFolder();
                this.f = new File("Database\\Account\\Vendor.txt");
            }
            case "Delivery" -> {
                this.f1 = new File("Database\\Others");
                CreateFolder();
                this.f = new File("Database\\Others\\Delivery.txt");
            }
            case "Menu" -> {
                this.f1 = new File("Database\\Others");
                CreateFolder();
                this.f = new File("Database\\Others\\Menu.txt");
            }
            case "Order" -> {
                this.f1 = new File("Database\\Others");
                CreateFolder();
                this.f = new File("Database\\Others\\Order.txt");
            }
            case "Transaction" -> {
                this.f1 = new File("Database\\Others");
                CreateFolder();
                this.f = new File("Database\\Others\\Transaction.txt");
            }
            default -> {
            }
        }
        try {
            f.createNewFile();
        } catch (IOException ex) {
            System.err.println("error");
        }
        
    }
    
     public void CreateFolder(){
        if(!f1.exists()){
            f1.mkdirs();
            //create the folder,using mkdirs instead of mkdir is to open several folder
        }
    }
    
    public void readFile(){
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"File not found!");
        }
    }
    
    public void writeFile(){
        try {
            fw = new FileWriter(f,true);
            bw = new BufferedWriter(fw);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File not found!");
        }
    }
    
    public void newWriteFile(){
        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File not found!");
        }
    }
    
    public void setCount(int count){
        this.count = count;
    }
    
    public int getCount(){
        return count;
    }
    
    public String[][] ReadData(){
        String [][]Data = new String [100][];
        String line;
        int count = 0;
        readFile();
        try {
            while((line = br.readLine()) != null){
                String [] value = line.split("\\|");
                Data[count] = value;
                count++;
            }
            setCount(count);
            ReadClose();
            return Data;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There is an error with the file!");
        }
        ReadClose();
        return Data;
    }
        
    
    public void ReadClose(){
        try {
            br.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There is an error with the file!");
        }
    }
    public void WriteClose(){
        try {
            bw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There is an error with the file!");
        }
    }
    
    public String GetNextId(String pst){
        Data = ReadData();
        count = getCount() - 1;
        String lastID = Data[count][0].substring(1);
        int lastIdNum = Integer.parseInt(lastID);
        int newIDNum = lastIdNum + 1;
        String prefix = "";
        switch (pst) {
            case "Admin" -> {
                prefix = "A";
            }
            case "Customer" -> {
                prefix = "C";
            }
            case "Vendor" -> {
                prefix = "V";
            }
            case "Runner" -> {
                prefix = "R";
            }
            case "Delivery" -> {
                prefix = "D";
            }
            case "Menu" -> {
                prefix = "M";
            }
            case "Order" -> {
                prefix = "O";
            }
            case "Transaction" -> {
                prefix = "T";
            }
            default -> {
            }
        }
        String newId = prefix + newIDNum;
        return newId;
    }
    
    public String GetCurrentDateandTime(String pst){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);
        return formattedDate;
        
    }
    
}
