package queries;

import models.Customer;
import models.Status;
import models.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiFunction;

public interface NumberofTransacionUtil {

    BiFunction<List<Transaction>, LocalDateTime, Long> getNumberOfTransactionWithinAPeriod = (transactions, date) ->null;
//            transactions.stream()
//                    .flatMap(trans -> cust.getCustomerWallet().stream())
//                    .flatMap(wal -> wal.getTransactions().stream())
//                    .map(x -> (Transaction)x)
//                    .filter(wal -> wal.getStatus() == Status.SUCCESSFUL && wal.getAmount() > amt)
//                    .count();
}
