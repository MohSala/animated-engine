package queries;

import dataaccess.Deserialize;
import models.Customer;
import models.Transaction;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Long numberofTimes(List<Transaction> t, Integer a, Integer b) {
        return
                NumberOfTUtil.numberOfTimesUsersHaveTransacted.apply(t,a,b);

    }

    static List<String> numOfCustomersGreaterThanOne(List<Customer> customers) {
        return NumberOfTUtil.customersWithTransactions.apply(customers);
    }

    static long ratio(List<Customer> customers, int year, int month){
        long res = ActivityUtil.getNoOfActiveCustomers.apply(customers, year, month)
                /ActivityUtil.getNoOfAllCustomers.apply(customers);
        return res;
    }

    static List<String> dormantAccts(List<Customer> cus) {
        return DormantUtil.dormantCustomers.apply(cus);
    }

//    static Map cusList(List<Transaction> t) {
//        return NumberOfTUtil.cusListOfT.apply(t);
//    }
    public static void main(String[] args) {
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
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Customer class not found");
            c.printStackTrace();
            return;
        }

//        List<Transaction> t = transactions;
//        Integer a = cust.get(0).getCustomerTag();
//        Integer b = cust.get(0).getCustomerTag();
//        Long r = numberofTimes(t,a,  b);
//          Long res = ratio(cust, 2020,3);
//        System.out.println(res);
        List<String> res = dormantAccts(cust);
        System.out.println(res);
    }
}
