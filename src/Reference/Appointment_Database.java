package Reference;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Appointment_Database extends Main_Database{
    FileReader fr;
    FileWriter fw;
    String [][]rawData;
    int count;

    public Appointment_Database() {
        super("Appointment");
    }
    
    public void AddAppointment(String name, String date, String timeslot, String approval){
        try {
            super.writeFile();
            // Name, Telephone, Email, Password, Position
            bw.write(name + "," + date + "," + timeslot + "," + approval + ",\n");
            super.WriteClose();
        } 
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "There is an error opening the file!");
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There is an error with the file!");
        }
    }

    public void StatusUpdate(String name, String date, String timeslot, String status, String newStatus){
        try {
            rawData = super.ReadData();
            count = super.getCount();
            for (int i = 0; i<count; i++){
                if (rawData[i][0].equals(name) && rawData[i][1].equals(date) && rawData[i][2].equals(timeslot)&& rawData[i][3].equals(status)){
                    rawData[i][3] = newStatus;
                }
            }
            super.newWriteFile();
            for (int i=0; i<count;i++){
                String line= "";
                for (int j = 0; j<rawData[i].length;j++){
                    line += rawData[i][j] + ",";
                }
                line += "\n";
                bw.write(line);
            }
            super.WriteClose();
        } catch (IOException ex) {
            Logger.getLogger(Medical_Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[][] CustomerList(String name){
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
        
       
    public String[][] checkTimeSlot(String name, String date){
        String [] timeSlot = {"8AM-10AM","10AM-12PM","12PM-2PM","2PM-4PM","4PM-6PM"};
        rawData = super.ReadData();
        String [][]finalData = new String [100][];
        count = super.getCount();
        boolean exist = true;
        int value = 0;
        for (int i = 0;i<count;i++){
            if (date.equals(rawData[i][1])){
                exist = false;
                for (int j = 0;j<5;j++){
                    String[] newData ={name, date, timeSlot[j]};
                    finalData[value] = newData;
                    value++;
                }
                break;
            }
        }
        
        if (exist){
            for (int j = 0;j<5;j++){
                String[] newData ={name, date, timeSlot[j]};
                finalData[value] = newData;
                value++;
            }
        }
        else{
            for (int i = 0;i<count;i++){
                if (date.equals(rawData[i][1])){
                    for (int j = 0;j<5;j++){
                        if (timeSlot[j].equals(rawData[i][2])){
                            String[] newData ={name, date, ""};
                            finalData[j] = newData;
                        }
                    }
                }
            }
        }
        super.setCount(value);
        return finalData;
    }
    
}
