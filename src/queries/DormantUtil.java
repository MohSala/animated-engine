package queries;

import models.Customer;
import models.Transaction;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

public interface DormantUtil {
        Function<List<Customer>, Optional<Map.Entry<Integer, List<Transaction>>>> userWithLongestDurationOfInactivity = customers ->
                customers.stream()
                .flatMap(customer -> customer.getCustomerWallet().stream())
                .flatMap(wallet -> wallet.getTransactions().stream())
                .collect( Collectors.groupingBy(transaction ->
                        (int)  ChronoUnit.HOURS.between(transaction.getTransactionDate(), LocalDateTime.now())))
                .entrySet().stream()
                .findFirst();

        Function<List<Customer>, List<String>> dormantCustomers = customers ->
                userWithLongestDurationOfInactivity.apply(customers)
                .stream()
                .flatMap(c -> c.getValue().stream())
                .map(transaction -> transaction.getSender().getCustomer().getFirstName())
                        .distinct()
                .collect(Collectors.toList());
}
