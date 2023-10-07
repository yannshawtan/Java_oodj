package Reference;

import java.io.*;
import javax.swing.JOptionPane;

public class Login_Database extends Main_Database{
    String [][]Data;
    User owner = new User();

    public Login_Database() {
        super("Account");
    }
    
    public void AddData(String usr, String tel, String mail, String pswd, String pst){
        try {
            super.writeFile();
            // Name, Telephone, Email, Password, Position
            bw.write(usr + "," + tel + "," + mail + "," + pswd + "," + pst + ",\n");
            super.WriteClose();
            JOptionPane.showMessageDialog(null, "Register Complete!");
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File not found!");
        }
    }
        
    public boolean LoginValidation(String name,String pswd,String pst){
        Data = super.ReadData();
        count = super.getCount();
        for (int i = 0; i<count; i++){
            if (Data[i][0].equals(name) && Data[i][3].equals(pswd) && Data[i][4].equals(pst)){
                owner.setName(Data[i][0]);
                owner.setPhoneNo(Data[i][1]);
                owner.setEmail(Data[i][2]);
                owner.setPosition(Data[i][4]);
                JOptionPane.showMessageDialog(null, "Login Success");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Incorrect username or password!");
        return false;
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
