package main;

import service.HotelService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HotelService hotelService = new HotelService();

        int choice;

        do {

            System.out.println("\n========================================");
            System.out.println("      HOTEL ROOM BOOKING SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Search Room by Type");
            System.out.println("3. Book a Room");
            System.out.println("4. View Booking");
            System.out.println("5. Cancel Booking");
            System.out.println("6. View All Bookings");
            System.out.println("7. Booking History");
            System.out.println("8. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    hotelService.displayAvailableRooms();
                    break;

                case 2:

                    System.out.print("Enter Room Type (Single/Double/Deluxe/Suite): ");
                    String roomType = scanner.nextLine();

                    hotelService.searchRoomByType(roomType);

                    break;

                case 3:

                    try {

                        System.out.print("Enter Room ID: ");
                        int roomId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Guest Name: ");
                        String guestName = scanner.nextLine();

                        System.out.print("Phone Number: ");
                        String phone = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        System.out.print("ID Proof: ");
                        String idProof = scanner.nextLine();

                        System.out.print("Check-In Date (yyyy-MM-dd): ");
                        LocalDate checkIn =
                                LocalDate.parse(scanner.nextLine());

                        System.out.print("Check-Out Date (yyyy-MM-dd): ");
                        LocalDate checkOut =
                                LocalDate.parse(scanner.nextLine());

                        System.out.print("Number of Guests: ");
                        int guests = scanner.nextInt();
                        scanner.nextLine();

                        hotelService.createBooking(
                                roomId,
                                guestName,
                                phone,
                                email,
                                idProof,
                                checkIn,
                                checkOut,
                                guests
                        );

                    } catch (DateTimeParseException e) {

                        System.out.println("Invalid date format.");
                        System.out.println("Example: 2026-08-15");

                    } catch (Exception e) {

                        System.out.println("Invalid input.");

                    }

                    break;

                case 4:

                    System.out.print("Enter Booking ID: ");
                    String bookingId = scanner.nextLine();

                    hotelService.viewBooking(bookingId);

                    break;

                case 5:

                    System.out.print("Enter Booking ID: ");
                    String cancelId = scanner.nextLine();

                    hotelService.cancelBooking(cancelId);

                    break;

                case 6:

                    hotelService.viewAllBookings();

                    break;

                case 7:

                    hotelService.showBookingHistory();

                    break;

                case 8:

                    System.out.println();
                    System.out.println("========================================");
                    System.out.println(" Thank you for using Hotel Booking App ");
                    System.out.println("========================================");

                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 8);

        scanner.close();

    }
}