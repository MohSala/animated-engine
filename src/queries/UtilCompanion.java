package queries;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
public class UtilCompanion {

    public static int compareDates(LocalDateTime d1, LocalDate d2) {
        int res = YearMonth.from(d1).compareTo(YearMonth.from(d2));
        return res;
    }

}