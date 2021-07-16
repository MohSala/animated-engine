package queries;

import models.Customer;
import models.Status;
import models.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiFunction;

public interface NumberofTransacionUtil {

    TriFunction<List<Transaction>, LocalDateTime, LocalDateTime, Long> getNumberOfTransactionWithinAPeriod = (transactions, startDate, endDate) ->
            transactions.stream()
            .filter(x -> startDate.equals(x.getTransactionDate()) && endDate.equals(x.getTransactionDate()))
            .count();
}
