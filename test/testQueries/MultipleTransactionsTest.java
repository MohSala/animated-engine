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
        Customer c1 = TestsSerialize.runSerializeC().get(0);
        Customer c2 = TestsSerialize.runSerializeC().get(0);

        List<Customer> cl = Arrays.asList(c1,c2);

        List<String> res = DailyMultipleTransaction.cWithDailyMultipleTransactions(cl);
        List<String> expected = Arrays.asList("John Bull");

        assertEquals(res, expected);
    }
}
