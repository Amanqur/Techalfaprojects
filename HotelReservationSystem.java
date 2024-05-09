import java.util.ArrayList
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    private static List<Room> availableRooms = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static int bookingIdCounter = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    System.out.println("Thank you for using our Hotel Reservation System!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private static void initializeRooms() {
        availableRooms.add(new Room("Standard", 100));
        availableRooms.add(new Room("Deluxe", 150));
        availableRooms.add(new Room("Suite", 200));
    }

    private static void searchAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : availableRooms) {
            System.out.println(room);
        }
    }

    private static void makeReservation() {
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter room type (Standard/Deluxe/Suite): ");
        String roomType = scanner.next();

        Room selectedRoom = null;
        for (Room room : availableRooms) {
            if (room.getType().equalsIgnoreCase(roomType)) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null) {
            availableRooms.remove(selectedRoom);
            Booking booking = new Booking(bookingIdCounter++, name, phoneNumber, selectedRoom);
            bookings.add(booking);
            System.out.println("Reservation successful! Your booking ID is: " + booking.getBookingId());
        } else {
            System.out.println("Invalid room type! Reservation failed.");
        }
    }

    private static void viewBookingDetails() {
        System.out.println("\nBooking Details:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}

class Room {
    private String type;
    private double price;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room Type: " + type + ", Price: $" + price;
    }
}

class Booking {
    private int bookingId;
    private String name;
    private String phoneNumber;
    private Room room;

    public Booking(int bookingId, String name, String phoneNumber, Room room) {
        this.bookingId = bookingId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.room = room;
    }

    public int getBookingId() {
        return bookingId;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + ", Name: " + name + ", Phone Number: " + phoneNumber + ", Room: " + room.getType();
    }
}