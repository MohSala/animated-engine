package testQueries;

import models.Customer;
import models.Status;
import models.Transaction;
import models.Wallet;
import org.junit.Test;
import queries.DailyMultipleTransaction;
import queries.TransactionRange;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MultipleTransactionsTest {
    @Test
    public void getMultipleTransactionsTest(){
        Customer c1 = new Customer("John", "Bull", "bull@gmail.com", 2002, 12345);
        Customer c2 = new Customer("Esther", "Mukungu", "esther@gmail.com", 2002, 54342);
        Wallet w1 = new Wallet(1000, c1);
        Wallet w2 = new Wallet(500, c2);
        Transaction t12 = new Transaction(10, w2,w1,
                LocalDateTime.of(2020, 03, 01, 02, 38),
                w2.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t13 = new Transaction(200, w1,w2,
                LocalDateTime.of(2020, 03, 01, 02, 38),
                w2.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t14 = new Transaction(100, w1,w2,
                LocalDateTime.of(2020, 03, 01, 8, 30),
                w2.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        w1.setTransactions(Arrays.asList(t13, t14));
        w2.setTransactions(Arrays.asList(t12));

        List<Customer> cl = Arrays.asList(c1,c2);

        List<String> res = DailyMultipleTransaction.cWithDailyMultipleTransactions(cl);
        List<String> expected = Arrays.asList("John Bull");

        assertEquals(res, expected);
    }
}
