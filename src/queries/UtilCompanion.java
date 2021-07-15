package queries;
import models.Customer;
import models.Transaction;
import models.Wallet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

public class UtilCompanion {

    public static int compareDates(LocalDateTime d1, LocalDate d2) {
        int res = YearMonth.from(d1).compareTo(YearMonth.from(d2));
        return res;
    }

    public static List<Wallet> customerWalletsList(Customer c){
        List<Wallet> wallets = c.getCustomerWallet();
        return wallets;
    }

    public static Boolean monthlyTransactions(Transaction t, int tYear, int tMonth){
        return compareDates(t.getTransactionDate(), LocalDate.of(tYear, tMonth, 1)) == 0;
    }
    public static String fullName(Customer cn){
        return cn.getFirstName() + " " + cn.getLastName();
    }



}