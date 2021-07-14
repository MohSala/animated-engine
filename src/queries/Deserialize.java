package queries;

import models.Customer;
import models.Transaction;
import models.Wallet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Deserialize {
    static Long numberofTimes(List<Transaction> t, Integer a, Integer b) {
        return
                NumberOfTUtil.numberOfTimesUsersHaveTransacted.apply(t,a,b);

    }

    static Map cusList(List<Transaction> t) {
        return NumberOfTUtil.cusListOfT.apply(t);
    }

    public static void main(String[] args) {
        ArrayList<Customer> cust = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/customer.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            cust = (ArrayList) in.readObject();
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


        List<Transaction> t = transactions;
        Integer a = cust.get(0).getCustomerTag();
        Integer b = cust.get(0).getCustomerTag();
        Long r = numberofTimes(t,a,  b);

        System.out.println(r);
//        for (Transaction t : transactions) {
//            System.out.println(t.getStatus());
//        }
    }
}
