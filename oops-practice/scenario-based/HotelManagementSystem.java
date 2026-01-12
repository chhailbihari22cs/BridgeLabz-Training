import java.util.*;

// Custom Exception for Room Unavailability
class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(String message) {
        super(message);
    }
}

// Interface for Pricing Strategy
interface PricingStrategy {
    double calculatePrice(int nights);
}

// Seasonal Pricing Strategy
class SeasonalPricing implements PricingStrategy {
    @Override
    public double calculatePrice(int nights) {
        return nights * 2000;
    }
}

// Regular Pricing Strategy
class RegularPricing implements PricingStrategy {
    @Override
    public double calculatePrice(int nights) {
        return nights * 1500;
    }
}

// Base Room Class
class Room {
    int roomNumber;
    boolean isAvailable;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }
}

// Deluxe Room Class (Inheritance)
class DeluxeRoom extends Room {
    public DeluxeRoom(int roomNumber) {
        super(roomNumber);
    }
}

// Standard Room Class (Inheritance)
class StandardRoom extends Room {
    public StandardRoom(int roomNumber) {
        super(roomNumber);
    }
}

// Hotel Management System
class HotelManagementSystem {
    private List<Room> rooms;
    private PricingStrategy pricingStrategy;

    public HotelManagementSystem(PricingStrategy pricingStrategy) {
        this.rooms = new ArrayList<>();
        this.pricingStrategy = pricingStrategy;
        initializeRooms();
    }

    private void initializeRooms() {
        for (int i = 1; i <= 5; i++) {
            rooms.add(new DeluxeRoom(i));
        }
        for (int i = 6; i <= 15; i++) {
            rooms.add(new StandardRoom(i));
        }
    }

    public Room bookRoom(int roomNumber, int nights) throws RoomNotAvailableException {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                if (room.isAvailable()) {
                    room.setAvailability(false);
                    double price = pricingStrategy.calculatePrice(nights);
                    System.out.println(
                            "Room " + roomNumber + " booked for " + nights + " nights. Total Price: ₹" + price);
                    return room;
                } else {
                    throw new RoomNotAvailableException("Room " + roomNumber + " is not available.");
                }
            }
        }
        throw new RoomNotAvailableException("Room " + roomNumber + " does not exist.");
    }

    public void releaseRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.setAvailability(true);
                System.out.println("Room " + roomNumber + " is now available.");
                return;
            }
        }
        System.out.println("Room " + roomNumber + " does not exist.");
    }
}