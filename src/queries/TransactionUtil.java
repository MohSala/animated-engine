package queries;

import models.Customer;
import models.Status;
import models.Transaction;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface TransactionUtil {
    BiFunction<List<Customer>, Double, Long> getCustomerCountWith1kTransaction = (customers, amt) ->
            customers.stream()
                    .flatMap(cust -> cust.getCustomerWallet().stream())
                    .flatMap(wal -> wal.getTransactions().stream())
                    .map(x -> (Transaction)x)
                    .filter(wal -> wal.getStatus() == Status.SUCCESSFUL && wal.getAmount() > amt)
                    .count();



    Function<List<Transaction>, Double> getTransactionSumPerCustomer = transactionSum ->
            //Stream.of(transactionSum)
            transactionSum.stream()
                    .filter(x -> x.getStatus() == Status.SUCCESSFUL)
                    .mapToDouble(x -> x.getAmount()).sum();




}

