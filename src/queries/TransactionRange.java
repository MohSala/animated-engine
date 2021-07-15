package queries;

import models.Customer;
import models.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface TransactionRange {
    //Transaction range for the system.

    Function<Double, Double> range = s -> s;

    Comparator<Double> amountComparatorHigh = Comparator.comparing(range).reversed();
    Comparator<Double> amountComparatorLow = Comparator.comparing(range);

    Function<List<Customer>, List<Double>> getAllTransaction = (custs) ->
            custs.stream()
            .flatMap(w -> w.getCustomerWallet().stream())
            .flatMap(t -> t.getTransactions().stream())
            .map(a -> a.getAmount())
            .filter(av -> av > 0.0)
            .collect(Collectors.toList());

    Function<List<Customer>, Optional<Double>> leastAmount = (c) ->
            getAllTransaction.apply(c)
            .stream()
            .sorted(amountComparatorLow)
            .findFirst();

    Function<List<Customer>, Optional<Double>> highestAmount = (c) ->
            getAllTransaction.apply(c)
                    .stream()
                    .sorted(amountComparatorHigh)
                    .findFirst();

    static String range (List<Customer> c) {
        Double least = leastAmount.apply(c).isPresent()
                ? leastAmount.apply(c).get(): 0;
        Double highest = highestAmount.apply(c).isPresent()
                ? highestAmount.apply(c).get(): 0;

        return highest +  "-" + least;
    }

}