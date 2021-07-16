package queries;

import models.Customer;
import models.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface MostActiveUtil {
    Function<List<Customer>, Map<String, List<Transaction>>> usersWithTransactions = customers ->
            customers.stream()
            .flatMap(customer -> customer.getCustomerWallet().stream())
            .flatMap(wallet -> wallet.getTransactions().stream())
            .collect(Collectors.groupingBy(transaction -> transaction.getSender().getCustomer().getFirstName()));

    Function<List<Transaction>, Long> returnNoOfTransactions = transactions ->
            (long) transactions.size();

    Function<List<Customer>, List<String>> mostActiveUser = customers ->
            usersWithTransactions.apply(customers).entrySet().stream()
            .map( customer -> new Map.Entry<String, Long>() {
                @Override
                public String getKey() {
                    return customer.getKey();
                }

                @Override
                public Long getValue() {
                    return returnNoOfTransactions.apply(customer.getValue());
                }

                @Override
                public Long setValue(Long value) {
                    return null;
                }
            })
            .sorted((c1,c2) -> Math.toIntExact(c2.getValue()) - Math.toIntExact(c1.getValue()))
            .map(customer -> customer.getKey())
                    .limit(1)
            .collect(Collectors.toList());
}
