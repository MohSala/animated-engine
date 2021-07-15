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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    static Long numberofTimes(List<Transaction> t, Integer a, Integer b) {
        return
                NumberOfTUtil.numberOfTimesUsersHaveTransacted.apply(t,a,b);

    }

    static List<String> numOfCustomersGreaterThanOne(List<Customer> customers) {
        return NumberOfTUtil.customersWithTransactions.apply(customers);
    }

    static int percentageOfActiveCustomersPerMonth(List<Customer> customers, int year, int month){
        Long  a = ActivityUtil.getNoOfActiveCustomers.apply(customers, year, month);
        Long  b = ActivityUtil.getNoOfAllCustomers.apply(customers);
        double l = ((double)a/b)*100;
        return (int)l;
    }

    static List<String> cWithDailyMultipleTransactions(List<Customer> cust){
        List<String> customers = DailyMultipleTransaction
                .getCustomersWithMultipleTransactionsOnSameDay
                .apply(cust);

        return customers;
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
//          long res = ratio(cust, 2020,03);
        int res = percentageOfActiveCustomersPerMonth(cust, 2019, 10);
        List<String> result = cWithDailyMultipleTransactions(cust);
//          Double a = largestAmount(cust);
        String ar = TransactionRange.range(cust);
        System.out.println(ar);
//        List<String> res = dormantAccts(cust);
        System.out.println(res);
        System.out.println(result);
    }
}
