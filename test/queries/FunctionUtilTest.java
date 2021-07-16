package queries;

import dataaccess.MockData;
import models.Customer;
import models.Transaction;
import models.Wallet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FunctionUtilTest {
    List<Customer> customers;
    List<Wallet> wallet;
    List<Transaction> transactions;
    //MockData mock;

    @Before
    public void setUpModels(){


    }

    @Test
    public void testUserWithLongestDurationOfInactivity(){
        Long expected = ActivityUtil.getNoOfActiveCustomers.apply(MockData.customerList(), 0, 0);

        Assert.assertTrue(expected == 0);
    }

    @Test
    public void testGetNoOfActiveCustomers(){

        List<String> expected = DormantUtil.dormantCustomers.apply(MockData.customerList());

        Assert.assertTrue(expected == Arrays.asList("Donny", "Joe"));
    }

    @Test
    public void testNumberOfTimesUsersHaveTransacted(){


    }

    @Test
    public void testGetCustomerListWith1kTransaction(){

        long expected = TransactionUtil.getCustomerCountWith1kTransaction.apply(MockData.customerList(), 1000D);
        Assert.assertTrue(expected > 0);
    }
}
