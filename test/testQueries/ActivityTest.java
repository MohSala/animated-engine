package testQueries;

import models.Customer;
import models.Status;
import models.Transaction;
import models.Wallet;
import org.junit.Test;
import queries.ActivityUtil;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ActivityTest {

    @Test
    public void getPercentageOfActiveCustomersPerMonthTest(){
          Customer c1 = TestsSerialize.runSerializeC().get(0);
          Customer c2 = TestsSerialize.runSerializeC().get(0);

        List<Customer> cl = Arrays.asList(c1,c2);

        double t = ActivityUtil.percentageOfActiveCustomersPerMonth(cl,2019, 9);

        double expected = 50;

        assertTrue(t == 50);
    }

    @Test
    public void getPercentageOfActiveCustomersPerMonthTestFail(){
        Customer c1 = TestsSerialize.runSerializeC().get(0);
        Customer c2 = TestsSerialize.runSerializeC().get(0);

        List<Customer> cl = Arrays.asList(c1,c2);

        double t = ActivityUtil.percentageOfActiveCustomersPerMonth(cl,2020, 9);

        double expected = 50;

        assertTrue(t == 0);
    }

}
