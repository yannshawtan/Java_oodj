package oodjassignment;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Register_Database extends Main_Database{
    
    String [][]Data;
    User owner = new User();

    public Register_Database(String role) {
        super(role);
    }
    
    public void AddData(String usr, String tel, String mail, String pswd, String pst){
        try {
            super.writeFile();
            // Name, Email, Password, Position
            bw.write(usr + "," + tel + "," + mail + "," + pswd + "," + pst + ",\n");
            super.WriteClose();
            JOptionPane.showMessageDialog(null, "Register Complete!");
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File not found!");
        }
    }
    
    public boolean RegisterValidation(String name,String email,String pst){
        Data = super.ReadData();
        count = super.getCount();
        for (int i=0; i<count;i++){
            if ((Data[i][0].equals(name) || Data[i][2].equals(email)) && Data[i][4].equals(pst)){
                return true;
            }
        }
        return false;
    }
    
    public User getData(){
        return owner;
    }
}
