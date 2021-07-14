package queries;


import models.Customer;
import models.Status;
import models.Transaction;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

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
}
