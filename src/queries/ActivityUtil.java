package queries;
import models.Customer;
import models.Transaction;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public interface ActivityUtil {

    TriFunction<Customer, Integer, Integer, List<Transaction>> getTransactionInMonth = (c, tYear, tMonth) ->
            Stream.of(c)
                    .flatMap(cw -> cw.getCustomerWallet().stream())
                    .flatMap(wt -> wt.getTransactions().stream())
                    .filter(t -> UtilCompanion.monthlyTransactions(t, tYear, tMonth))
                    .collect(Collectors.toList());

    TriFunction<List<Customer>, Integer, Integer, Long>getNoOfActiveCustomers = (customers, year, month) ->
            customers.stream()
                    .filter(c -> getTransactionInMonth.apply(c, year, month).size() > 0)
                    .map(UtilCompanion::fullName)
                    .distinct()
                    .count();

    Function<List<Customer>, Long> getNoOfAllCustomers = (customers) ->
            customers.stream().count();

    static int percentageOfActiveCustomersPerMonth(List<Customer> customers, int year, int month){
        Long  a = ActivityUtil.getNoOfActiveCustomers.apply(customers, year, month);
        Long  b = ActivityUtil.getNoOfAllCustomers.apply(customers);
        double l = ((double)a/b)*100;
        return (int)l;
    }

}