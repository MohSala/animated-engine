package testQueries;

import models.Customer;
import org.junit.Test;
import queries.TransactionRange;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class TransactionRangeTest {

    @Test
    public void getTransactionRange(){
        Customer c1 = TestsSerialize.runSerializeC().get(0);
        Customer c2 = TestsSerialize.runSerializeC().get(0);

        List<Customer> cl = Arrays.asList(c1,c2);
        String res = TransactionRange.range(cl);
        String expected = "450.0-1.0";

        assertEquals(res, expected);
    }
}
