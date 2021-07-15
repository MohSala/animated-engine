package testQueries;

import models.Customer;
import models.Transaction;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class TestsSerialize {
    public static ArrayList<Customer> runSerializeC(){
        ArrayList<Customer> cust = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + "/src/tmp/customer.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            cust = (ArrayList) in.readObject();
            transactions = (List<Transaction>) in.readObject();
            in.close();
            fileIn.close();
        }  catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return cust;
    }
}
