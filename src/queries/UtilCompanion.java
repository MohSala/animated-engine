package queries;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
public class UtilCompanion {
    //need a date comparator
    public static int compareDates(LocalDateTime d1, LocalDateTime d2) {
        LocalDate date1 = d1.toLocalDate();
        LocalDate date2 = d1.toLocalDate();
        int res = YearMonth.from(date1).compareTo(YearMonth.from(date2));
        return res;
    }
}