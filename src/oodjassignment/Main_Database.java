package oodjassignment;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oodjassignment.Roles.*;
import oodjassignment.Roles.Identifier.Role;


public class Main_Database<T> {
    File f1, f;
    FileInputStream fis;
    ObjectInputStream ois;
    FileOutputStream fos;
    ObjectOutputStream oos;
    int count, num;
    ArrayList<T> data = new ArrayList<>();
    T object;
    
    public Main_Database(Role role){
        switch (role) {
            case Admin -> {
                this.f1 = new File("Database\\Account");
                CreateFolder();
                this.f = new File("Database\\Account\\Admin.dat");
            }
            case Customer -> {
                this.f1 = new File("Database\\Account");
                CreateFolder();
                this.f = new File("Database\\Account\\Customer.dat");
            }
            case Runner -> {
                this.f1 = new File("Database\\Account");
                CreateFolder();
                this.f = new File("Database\\Account\\Runner.dat");
            }
            case Vendor -> {
                this.f1 = new File("Database\\Account");
                CreateFolder();
                this.f = new File("Database\\Account\\Vendor.dat");
            }
            case Delivery -> {
                this.f1 = new File("Database\\Others");
                CreateFolder();
                this.f = new File("Database\\Others\\Delivery.dat");
            }
            case Menu -> {
                this.f1 = new File("Database\\Others");
                CreateFolder();
                this.f = new File("Database\\Others\\Menu.dat");
            }
            case Order -> {
                this.f1 = new File("Database\\Others");
                CreateFolder();
                this.f = new File("Database\\Others\\Order.dat");
            }
            case Transaction -> {
                this.f1 = new File("Database\\Others");
                CreateFolder();
                this.f = new File("Database\\Others\\Transaction.dat");
            }
            case Notification -> {
                this.f1 = new File("Database\\Others");
                CreateFolder();
                this.f = new File("Database\\Others\\Notification.dat");
            }
            default -> {
            }
        }
        CreateFile();
    }

    public void CreateFolder(){
        if(!f1.exists()){
            f1.mkdirs();
            //create the folder,using mkdirs instead of mkdir is to open several folder
        }
    }
    
    public void CreateFile(){
        if(!f.exists()){
            try {
            f.createNewFile();
            } catch (IOException ex) {
                System.err.println("error");
            }
        }
    }
    
    public void readFile(){
        try {
            fis = new FileInputStream(f);
            if (fis.available() == 0) {
                ois = null;
            } else {
                ois = new ObjectInputStream(fis);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
            ois = null;  // Set ois to null to indicate that the file is not found
        } catch (IOException ex) {
            Logger.getLogger(Main_Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void writeFile(){
        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
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

    public ArrayList<T> ReadData(){
        int count = 0;
        readFile();
        ArrayList<T> data = new ArrayList<>();
        if (ois == null) {
            ReadClose();
            return new ArrayList<>();
        }
        while(true){
            try{
                object = (T) ois.readObject();
                data.add(object);
                count++;
            }catch(EOFException Ex){
                break;
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Main_Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setCount(count);
        ReadClose();
        return data;
    }
    
    public void ReadClose(){
        try {
            if (ois != null) {
                ois.close();
            }
            fis.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There is an error with the file!");
        }
    }
    
    public void WriteClose(){
        try {
            oos.close();
            fos.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There is an error with the file!");
        }
    }
    
    
    public void addData(Role role, T object){
        data = ReadData();
        data.add(object);
        updateData(role, data);
        
    }
    
    public void removeData(Role role, int num){
        data = ReadData();
        data.remove(num-1);
        updateData(role, data);
    }
    
    public void updateData(Role role, ArrayList<T> data){
        int num = 0;
        try{
            writeFile();
            switch (role) {
                case Admin -> {
                    for (Object a : data) {
                        if (a instanceof Admin admin) {
                            num++;
                            admin.setNumber(num);
                            oos.writeObject(a);
                        }
                    }
                }
                case Customer -> {
                    for (Object c : data) {
                        if (c instanceof Customer customer) {
                            num++;
                            String temp = customer.getId();
                            customer.setNumber(num);
                            oos.writeObject(c);
                        }
                    }
                }
                case Runner -> {
                    for (Object r : data) {
                        if (r instanceof Runner runner) {
                            num++;
                            runner.setNumber(num);
                            oos.writeObject(r);
                        }
                    }
                }
                case Vendor -> {
                    for (Object v : data) {
                        if (v instanceof Vendor vendor) {
                            num++;
                            String temp = vendor.getId();
                            // function call update vendor in menu
                            vendor.setNumber(num);
                            oos.writeObject(v);
                        }
                    }
                }
                case Delivery -> {
                    for (Object d : data) {
                        if (d instanceof Delivery delivery) {
                            num++;
                            delivery.setNumber(num);
                            oos.writeObject(d);
                        }
                    }
                }
                case Menu -> {
                    for (Object m : data) {
                        if (m instanceof Menu menu) {
                            num++;
                            menu.setNumber(num);
                            oos.writeObject(m);
                        }
                    }
                }
                case Order -> {
                    for (Object o : data) {
                        if (o instanceof Order order) {
                            num++;
                            order.setNumber(num);
                            oos.writeObject(o);
                        }
                    }
                }
                case Transaction -> {
                    for (Object t : data) {
                        if (t instanceof Transaction transaction) {
                            num++;
                            transaction.setNumber(num);
                            oos.writeObject(t);
                        }
                    }
                }
                case Notification -> {
                    for (Object n : data) {
                        if (n instanceof Notification notification) {
                            num++;
                            notification.setNumber(num);
                            oos.writeObject(n);
                        }
                    }
                }
                default -> {
                }
            }
        } catch (IOException ex) {
//            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
//                    Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
   
}



/*
menu
a function that change the menu object (vendor id section)
loop everything that have same id as temp, replace with new id
*/


/*
order
a function that change the menu object (vendor id section)(customer, runner)
loop everything that have same id as temp, replace with new id
*/


/*
Transaction
a function that change the menu object (vendor id section)(customer, runner)
loop everything that have same id as temp, replace with new id
*/