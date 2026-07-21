package service;

import model.Booking;
import model.Guest;
import model.Room;
import repository.HotelRepository;
import utility.BookingIdGenerator;
import utility.DateUtil;
import utility.FileManager;

import java.time.LocalDate;
import java.util.ArrayList;

public class HotelService {

    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    public HotelService() {
        rooms = HotelRepository.getRooms();
        bookings = new ArrayList<>();
    }

    // Display all available rooms
    public void displayAvailableRooms() {

        System.out.println("\n========== AVAILABLE ROOMS ==========");

        boolean found = false;

        for (Room room : rooms) {

            if (room.isAvailable()) {

                System.out.println("--------------------------------");
                System.out.println("Room ID       : " + room.getRoomId());
                System.out.println("Room Type     : " + room.getRoomType());
                System.out.println("Price/Night   : ₹" + room.getPricePerNight());
                System.out.println("Max Capacity  : " + room.getMaxCapacity());
                System.out.println("Status        : Available");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No rooms available.");
        }
    }

    // Search room by type
    public void searchRoomByType(String roomType) {

        boolean found = false;

        System.out.println("\n========== SEARCH RESULT ==========");

        for (Room room : rooms) {

            if (room.isAvailable()
                    && room.getRoomType().equalsIgnoreCase(roomType)) {

                System.out.println("--------------------------------");
                System.out.println("Room ID       : " + room.getRoomId());
                System.out.println("Room Type     : " + room.getRoomType());
                System.out.println("Price/Night   : ₹" + room.getPricePerNight());
                System.out.println("Max Capacity  : " + room.getMaxCapacity());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching rooms found.");
        }
    }

    // Find room using room ID
    private Room getRoomById(int roomId) {

        for (Room room : rooms) {

            if (room.getRoomId() == roomId) {
                return room;
            }
        }

        return null;
    }
            // Create Booking
    public void createBooking(int roomId,
                              String guestName,
                              String phone,
                              String email,
                              String idProof,
                              LocalDate checkIn,
                              LocalDate checkOut,
                              int guestCount) {

        Room room = getRoomById(roomId);

        if (room == null) {
            System.out.println("Invalid Room ID.");
            return;
        }

        if (!room.isAvailable()) {
            System.out.println("Room is already booked.");
            return;
        }

        if (guestName == null || guestName.trim().isEmpty()) {
            System.out.println("Guest name cannot be empty.");
            return;
        }

        if (!DateUtil.isValidDate(checkIn, checkOut)) {
            System.out.println("Invalid check-in/check-out dates.");
            return;
        }

        if (guestCount > room.getMaxCapacity()) {
            System.out.println("Guest count exceeds room capacity.");
            return;
        }

        long nights = DateUtil.calculateNights(checkIn, checkOut);

        if (nights <= 0) {
            System.out.println("Booking must be at least 1 night.");
            return;
        }

        double totalAmount = nights * room.getPricePerNight();

        Guest guest = new Guest(
                guestName,
                phone,
                email,
                idProof
        );

        String bookingId = BookingIdGenerator.generateBookingId();

        Booking booking = new Booking(
                bookingId,
                guest,
                room,
                checkIn,
                checkOut,
                nights,
                totalAmount,
                "CONFIRMED"
        );

        bookings.add(booking);

        room.setAvailable(false);

        FileManager.saveBooking(booking);

        System.out.println("\n====================================");
        System.out.println("      BOOKING CONFIRMED");
        System.out.println("====================================");
        System.out.println("Booking ID : " + bookingId);
        System.out.println("Guest Name : " + guestName);
        System.out.println("Room ID    : " + room.getRoomId());
        System.out.println("Room Type  : " + room.getRoomType());
        System.out.println("Check-In   : " + checkIn);
        System.out.println("Check-Out  : " + checkOut);
        System.out.println("Nights     : " + nights);
        System.out.println("Total Bill : ₹" + totalAmount);
        System.out.println("====================================");
    }

    // Calculate Bill
    public double calculateBill(int roomId, int nights) {

        Room room = getRoomById(roomId);

        if (room == null) {
            return 0;
        }

        return room.getPricePerNight() * nights;
    }

    // Find Booking by Booking ID
    private Booking findBooking(String bookingId) {

        for (Booking booking : bookings) {

            if (booking.getBookingId().equalsIgnoreCase(bookingId)) {
                return booking;
            }

        }

        return null;
    }
        // View Booking
    public void viewBooking(String bookingId) {

        Booking booking = findBooking(bookingId);

        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        System.out.println("\n========== BOOKING DETAILS ==========");
        System.out.println("Booking ID : " + booking.getBookingId());
        System.out.println("Guest Name : " + booking.getGuest().getGuestName());
        System.out.println("Phone      : " + booking.getGuest().getPhoneNumber());
        System.out.println("Email      : " + booking.getGuest().getEmail());
        System.out.println("Room ID    : " + booking.getRoom().getRoomId());
        System.out.println("Room Type  : " + booking.getRoom().getRoomType());
        System.out.println("Check-In   : " + booking.getCheckInDate());
        System.out.println("Check-Out  : " + booking.getCheckOutDate());
        System.out.println("Nights     : " + booking.getNumberOfNights());
        System.out.println("Total Bill : ₹" + booking.getTotalAmount());
        System.out.println("Status     : " + booking.getBookingStatus());
    }

    // Cancel Booking
    public void cancelBooking(String bookingId) {

        Booking booking = findBooking(bookingId);

        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        if (booking.getBookingStatus().equalsIgnoreCase("CANCELLED")) {
            System.out.println("Booking is already cancelled.");
            return;
        }

        booking.setBookingStatus("CANCELLED");
        booking.getRoom().setAvailable(true);

        System.out.println("\nBooking cancelled successfully.");
        System.out.println("Room " + booking.getRoom().getRoomId() + " is now available.");
    }

    // View All Bookings
    public void viewAllBookings() {

        if (bookings.isEmpty()) {
            System.out.println("\nNo bookings available.");
            return;
        }

        System.out.println("\n========== ALL BOOKINGS ==========");

        for (Booking booking : bookings) {

            System.out.println("--------------------------------------");
            System.out.println("Booking ID : " + booking.getBookingId());
            System.out.println("Guest      : " + booking.getGuest().getGuestName());
            System.out.println("Room       : " + booking.getRoom().getRoomType());
            System.out.println("Room ID    : " + booking.getRoom().getRoomId());
            System.out.println("Amount     : ₹" + booking.getTotalAmount());
            System.out.println("Status     : " + booking.getBookingStatus());

        }
    }

    // Show Booking History
    public void showBookingHistory() {

        FileManager.displayBookingHistory();

    }

    // Total Bookings
    public int getTotalBookings() {

        return bookings.size();

    }

    // Check Bookings
    public boolean hasBookings() {

        return !bookings.isEmpty();

    }

}
    