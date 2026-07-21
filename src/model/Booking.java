package model;

import java.time.LocalDate;

public class Booking {

    private String bookingId;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private long numberOfNights;
    private double totalAmount;
    private String bookingStatus;

    public Booking(String bookingId,
                   Guest guest,
                   Room room,
                   LocalDate checkInDate,
                   LocalDate checkOutDate,
                   long numberOfNights,
                   double totalAmount,
                   String bookingStatus) {

        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfNights = numberOfNights;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public long getNumberOfNights() {
        return numberOfNights;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {

        return "\n=============================="
                + "\nBOOKING DETAILS"
                + "\n=============================="
                + "\nBooking ID : " + bookingId
                + "\nGuest Name : " + guest.getGuestName()
                + "\nPhone : " + guest.getPhoneNumber()
                + "\nEmail : " + guest.getEmail()
                + "\nRoom ID : " + room.getRoomId()
                + "\nRoom Type : " + room.getRoomType()
                + "\nCheck-In : " + checkInDate
                + "\nCheck-Out : " + checkOutDate
                + "\nNights : " + numberOfNights
                + "\nTotal Amount : ₹" + totalAmount
                + "\nStatus : " + bookingStatus
                + "\n==============================";
    }
}