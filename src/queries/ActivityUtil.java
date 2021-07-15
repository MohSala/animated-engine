package queries;
import models.Customer;
import models.Transaction;
import models.Wallet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public interface ActivityUtil {

    TriFunction<Customer, Integer, Integer, List<Transaction>> getTransactionInMonth = (c, tYear, tMonth) ->
            Stream.of(c)
                    .flatMap(cw -> cw.getCustomerWallet().stream())
                    .flatMap(wt -> wt.getTransactions().stream())
                    .filter(t -> UtilCompanion.compareDates(t.getTransactionDate(), LocalDate.of(tYear, tMonth, 1)) == 0)
                    .collect(Collectors.toList());

    TriFunction<List<Customer>, Integer, Integer, Long>getNoOfActiveCustomers = (customers, year, month) ->
            customers.stream()
                    .filter(c -> getTransactionInMonth.apply(c, year, month).size() > 0)
                    .map(cn -> cn.getFirstName() + " " + cn.getLastName())
                    .distinct()
                    .count();

    Function<List<Customer>, Long> getNoOfAllCustomers = (customers) ->
            customers.stream().count();

}