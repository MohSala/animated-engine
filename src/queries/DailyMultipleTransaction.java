package queries;

import models.Customer;

import java.util.List;
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
                    .map(tk -> tk.getKey())
                    .count();

    Function<List<Customer>, List<String>> getCustomersWithMultipleTransactionsOnSameDay = (cust) ->
           cust.stream()
            .filter(c -> getMultipleTransactionsPerDayPerCustomer.apply(c) > 0)
            .map(UtilCompanion::fullName)
            .distinct()
            .collect(Collectors.toList());

    static List<String> cWithDailyMultipleTransactions(List<Customer> cust){
        List<String> customers = DailyMultipleTransaction
                .getCustomersWithMultipleTransactionsOnSameDay
                .apply(cust);

        return customers;
    }

}
