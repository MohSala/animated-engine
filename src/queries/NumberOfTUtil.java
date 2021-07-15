package queries;


import models.Customer;
import models.Status;
import models.Transaction;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface NumberOfTUtil {
    TriFunction<List<Transaction>,Integer, Integer, Long> numberOfTimesUsersHaveTransacted = (transaction,a, b) ->
            transaction.stream()
                    .filter(t-> t.getSender().getCustomer().getCustomerTag() == a &&
                            t.getReceiver().getCustomer().getCustomerTag() == b)
                    .filter(t -> t.getStatus() == Status.SUCCESSFUL)
                    .count();

    Function<List<Transaction>, Map<String, List<Transaction>>> cusListOfT = (transactions) ->
            transactions.stream()
                    .filter(t -> t.getStatus() == Status.SUCCESSFUL)
                    .collect(Collectors.groupingBy(t -> t.getSender().getCustomer().getFirstName()));

    Function<Customer, Long> numberOfTransactionPerUser = customer ->
            Stream.of(customer)
            .flatMap(c -> c.getCustomerWallet().stream())
            .mapToLong(w -> w.getTransactions().size())
            .sum();

    Function<List<Customer> , List<String>> customersWithTransactions = customers ->
            customers.stream()
            .filter(c -> numberOfTransactionPerUser.apply(c) > 1)
            .map(Customer::getFirstName)
                    .distinct()
            .collect(Collectors.toList());

}