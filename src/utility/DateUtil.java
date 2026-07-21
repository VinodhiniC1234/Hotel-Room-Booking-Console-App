package utility;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    public static long calculateNights(LocalDate checkIn, LocalDate checkOut) {

        return ChronoUnit.DAYS.between(checkIn, checkOut);

    }

    public static boolean isValidDate(LocalDate checkIn, LocalDate checkOut) {

        return checkOut.isAfter(checkIn);

    }

}