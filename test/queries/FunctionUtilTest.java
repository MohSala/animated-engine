package queries;

import dataaccess.MockData;
import models.Customer;
import models.Transaction;
import models.Wallet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionUtilTest {

    //MockData mock;
    ArrayList<Customer> cust = new ArrayList<>();
    List<Transaction> transactions = new ArrayList<>();
    @Before
    public void setUpModels(){


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

    }

    @Test
    public void testUserWithLongestDurationOfInactivity(){
        Long expected = ActivityUtil.getNoOfActiveCustomers.apply(cust, 0, 0);

        Assert.assertTrue(expected == 0);
    }

    @Test
    public void testGetNoOfActiveCustomers(){

        List<String> expected = DormantUtil.dormantCustomers.apply(cust);

        Assert.assertTrue(expected == Arrays.asList("Donny", "Joe"));
    }

    @Test
    public void testNumberOfTimesUsersHaveTransacted(){
        Integer a = cust.get(0).getCustomerTag();
        Integer b = cust.get(1).getCustomerTag();
        Long expected = NumberOfTUtil.numberOfTimesUsersHaveTransacted.apply(transactions,a,  b);
        Assert.assertTrue(expected == 2);
        Assert.assertTrue(a == 12345);
        Assert.assertTrue(b == 54342);

    }

    @Test
    public void testMostActiveUser() {
        List<String> expected = MostActiveUtil.mostActiveUser.apply(cust);
        List<String> actual = Arrays.asList("Esther");
        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void testDormantAccountUser() {
        List<String> expected = DormantUtil.dormantCustomers.apply(cust);
        List<String> actual = Arrays.asList("Joe", "Esther", "Donny", "John");
        Assert.assertTrue(expected.equals(actual));
    }


//    @Test
//    public void testGetCustomerListWith1kTransaction(){
//
//        long expected = TransactionUtil.getCustomerCountWith1kTransaction.apply(MockData.customerList(), 1000D);
//        Assert.assertTrue(expected > 0);
//    }
//
//    @Test
//    public void testGetNumberOfTransactionWithinAPeriod(){
//
//        long expected = NumberofTransacionUtil.getNumberOfTransactionWithinAPeriod.apply(MockData.TransactionList(), LocalDateTime.now());
//        Assert.assertTrue(expected > 0);
//    }
}