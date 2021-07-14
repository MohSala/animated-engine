package dataaccess;

import models.Customer;
import models.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Deserialize {
    public static void serializeMockData(ArrayList<Customer> customers, List<Transaction> transactions) {
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/customer.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            customers = (ArrayList) in.readObject();
            transactions = (List<Transaction>) in.readObject();
            in.close();
            fileIn.close();
        }  catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Customer class not found");
            c.printStackTrace();
            return;
        }
    }
}
