package Reference;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Medical_Database extends Main_Database{
    String [][]rawData;

    public Medical_Database() {
        super("Medical");
    }
    
    public boolean DataValidation(String name, String diagnosis, String date){
        rawData = super.ReadData();
        count = super.getCount();
        for (int i = 0; i<count; i++){
            if (rawData[i][0].equals(name) && rawData[i][1].equals(diagnosis) && rawData[i][2].equals(date)){
                JOptionPane.showMessageDialog(null, "The data already exist!");
                return false;
            }
        }
        return true;
    }
    
    public void OverwriteMedical(JTable table){
        //https://youtu.be/LP7_DlIe670
        try {
            super.newWriteFile();
            for (int i=0; i<table.getRowCount();i++){
                for(int j=0;j<table.getColumnCount();j++){
                    bw.write(table.getValueAt(i,j).toString() + ",");
                } 
                bw.write("\n");
            }
            super.WriteClose();
        } catch (IOException ex) {
            Logger.getLogger(Medical_Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public String[][] MedicalList(String name){
        rawData = super.ReadData();
        String [][]finalData = new String [100][];
        count = super.getCount();
        int value = 0;
        for (int i = 0; i<count; i++){
            if (rawData[i][0].equals(name)){
                finalData[value] = rawData[i];
                value++;
            }
        }
        super.setCount(value);
        return finalData;
    }
    
}
