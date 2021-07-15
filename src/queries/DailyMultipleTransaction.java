package queries;

import models.Customer;
import models.Transaction;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface DailyMultipleTransaction {
    //List of customers with multiple transactions on the same day

    Function<Customer, Long> getMultipleTransactionsPerDayPerCustomer = (c) ->
            Stream.of(c)
                    .flatMap(cw -> cw.getCustomerWallet().stream())
                    .flatMap(wt -> wt.getTransactions().stream())
                    .collect(Collectors.groupingBy(t -> t.getTransactionDate().toLocalDate()))
                    .entrySet().stream()
                    .filter(tl -> tl.getValue().size() > 1)
                    .count();

    Function<List<Customer>, List<String>> getCustomersWithMultipleTransactionsOnSameDay = (cust) ->
           cust.stream()
           .filter(c -> getMultipleTransactionsPerDayPerCustomer.apply(c) > 0)
            .map(cn -> cn.getFirstName() + " " + cn.getLastName())
            .distinct()
            .collect(Collectors.toList());

}
