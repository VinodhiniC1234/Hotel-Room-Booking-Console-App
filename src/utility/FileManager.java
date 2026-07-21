package utility;

import model.Booking;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "data/bookings.txt";

    // Save a booking to file
    public static void saveBooking(Booking booking) {

        try {

            File folder = new File("data");

            if (!folder.exists()) {
                folder.mkdir();
            }

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(FILE_NAME, true));

            writer.write("--------------------------------------------");
            writer.newLine();

            writer.write("Booking ID : " + booking.getBookingId());
            writer.newLine();

            writer.write("Guest Name : " + booking.getGuest().getGuestName());
            writer.newLine();

            writer.write("Phone : " + booking.getGuest().getPhoneNumber());
            writer.newLine();

            writer.write("Email : " + booking.getGuest().getEmail());
            writer.newLine();

            writer.write("Room ID : " + booking.getRoom().getRoomId());
            writer.newLine();

            writer.write("Room Type : " + booking.getRoom().getRoomType());
            writer.newLine();

            writer.write("Check In : " + booking.getCheckInDate());
            writer.newLine();

            writer.write("Check Out : " + booking.getCheckOutDate());
            writer.newLine();

            writer.write("Nights : " + booking.getNumberOfNights());
            writer.newLine();

            writer.write("Total Amount : ₹" + booking.getTotalAmount());
            writer.newLine();

            writer.write("Status : " + booking.getBookingStatus());
            writer.newLine();

            writer.write("--------------------------------------------");
            writer.newLine();

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving booking.");

        }

    }

    // Display booking history
    public static void displayBookingHistory() {

        try {

            File file = new File(FILE_NAME);

            if (!file.exists()) {

                System.out.println("\nNo booking history found.");

                return;
            }

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            System.out.println("\n========= BOOKING HISTORY =========\n");

            while ((line = reader.readLine()) != null) {

                System.out.println(line);

            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error reading booking history.");

        }

    }

    // Load all booking lines
    public static ArrayList<String> loadBookings() {

        ArrayList<String> bookingList = new ArrayList<>();

        try {

            File file = new File(FILE_NAME);

            if (!file.exists()) {

                return bookingList;

            }

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                bookingList.add(line);

            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Unable to load bookings.");

        }

        return bookingList;

    }

    // Clear booking history
    public static void clearHistory() {

        try {

            PrintWriter writer = new PrintWriter(FILE_NAME);

            writer.close();

            System.out.println("Booking history cleared.");

        } catch (Exception e) {

            System.out.println("Unable to clear booking history.");

        }

    }

}