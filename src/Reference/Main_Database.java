package Reference;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main_Database {
    File f1, f;
    FileReader fr;
    FileWriter fw;
    BufferedWriter bw;
    BufferedReader br;
    int count;
    
    public Main_Database(String type){
        switch (type) {
            case "Account":
                this.f1 = new File("Database\\Login_Database");
                CreateFolder();
                this.f = new File("Database\\Login_Database\\UserData.txt");
                break;
            case "Appointment":
                this.f1 = new File("Database\\Appointment_Database");
                CreateFolder();
                this.f = new File("Database\\Appointment_Database\\Appointment.txt");
                break;
            case "Medical":
                this.f1 = new File("Database\\Medical_Database");
                CreateFolder();
                this.f = new File("Database\\Medical_Database\\Medical.txt");
                break;
            default:
                break;
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
                String [] value = line.split(",");
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
}
