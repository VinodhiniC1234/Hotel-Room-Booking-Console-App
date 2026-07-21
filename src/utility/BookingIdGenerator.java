package utility;

import java.util.Random;

public class BookingIdGenerator {

    public static String generateBookingId() {

        Random random = new Random();

        int number = 1000 + random.nextInt(9000);

        return "BK" + number;
    }

}