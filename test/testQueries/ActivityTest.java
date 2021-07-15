package testQueries;

import models.Customer;
import models.Status;
import models.Transaction;
import models.Wallet;
import org.junit.Test;
import queries.ActivityUtil;
import queries.UtilCompanion;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


public class ActivityTest {

    @Test
    public void getTransactionInMonthTest(){
        Customer c1 = new Customer("John", "Bull", "bull@gmail.com", 2002, 12345);
        Customer c2 = new Customer("Esther", "Mukungu", "esther@gmail.com", 2002, 54342);
        Wallet w1 = new Wallet(1000, c1);
        Wallet w2 = new Wallet(1000, c2);
        Transaction t13 = new Transaction(200, w1,w2,
                LocalDateTime.of(2020, 03, 01, 02, 38),
                w2.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        w1.setTransactions(Arrays.asList(t13));

        List<Customer> cl = Arrays.asList(c1,c2);
        int t = ActivityUtil.percentageOfActiveCustomersPerMonth(cl,2020, 03);

        int expected = 50;

        assertEquals(t, expected);
    }

    @Test
    public void fullNameTest(){
        Customer custTest = new Customer("John", "Bull", "bull@gmail.com", 2002, 12345);

        String res = UtilCompanion.fullName(custTest);

        assertTrue(res.equals("John Bull"));
    }

}
