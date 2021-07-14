package queries;
import models.Customer;
import models.Transaction;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public interface ActivityUtil {
    /* Get the percentage of active customers within a particular month
        criteria: ratio of customers who transacted(received and sent) to the registered total for any month registered in percentage
        make month generic, but for test fix it
    */
    TriFunction<Customer, Integer, Integer, Optional<Transaction>> getTransactionInMonth = (c, tYear, tMonth) ->
            Stream.of(c)
                    .flatMap(cw -> cw.getCustomerWallet().stream())
                    .flatMap(wt -> wt.getTransactions().stream())
                    .filter(td ->
                            UtilCompanion.compareDates(
                                    td.getTransactionDate(), LocalDateTime.of(tYear, tMonth, 1, 0, 0)) == 0)
                    .findAny();

    TriFunction<List<Customer>, Integer, Integer, Long> getNoOfActiveCustomers = (customers, year, month) ->
            customers.stream()
                    .filter(c -> getTransactionInMonth.apply(c, year, month).isPresent())
                    .map(cn -> cn.getFirstName() + " " + cn.getLastName())
                    .distinct()
                    .count();
    Function<List<Customer>, Long> getNoOfAllCustomers = (customers) ->
            (long) customers.size();

}