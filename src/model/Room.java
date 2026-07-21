package model;

public class Room {

    private int roomId;
    private String roomType;
    private double pricePerNight;
    private boolean available;
    private int maxCapacity;

    public Room(int roomId, String roomType, double pricePerNight, boolean available, int maxCapacity) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.available = available;
        this.maxCapacity = maxCapacity;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Room ID : " + roomId +
                "\nRoom Type : " + roomType +
                "\nPrice/Night : ₹" + pricePerNight +
                "\nMaximum Capacity : " + maxCapacity +
                "\nAvailable : " + (available ? "Yes" : "No");
    }
}