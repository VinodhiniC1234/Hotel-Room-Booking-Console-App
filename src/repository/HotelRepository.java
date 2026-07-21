package repository;

import model.Room;
import java.util.ArrayList;

public class HotelRepository {

    public static ArrayList<Room> getRooms() {

        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room(101, "Single", 1500, true, 1));
        rooms.add(new Room(102, "Single", 1500, true, 1));

        rooms.add(new Room(201, "Double", 2500, true, 2));
        rooms.add(new Room(202, "Double", 2500, true, 2));

        rooms.add(new Room(301, "Deluxe", 4000, true, 3));
        rooms.add(new Room(302, "Deluxe", 4000, true, 3));

        rooms.add(new Room(401, "Suite", 6500, true, 5));
        rooms.add(new Room(402, "Suite", 6500, true, 5));

        return rooms;
    }
}