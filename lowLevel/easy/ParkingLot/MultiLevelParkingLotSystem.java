package ParkingLot;

import java.util.*;

// Enum for Parking Spot Type
enum SpotType {
    SMALL, MEDIUM, LARGE
}

// Enum for Vehicle Type
enum VehicleType {
    MOTORCYCLE, CAR, BUS
}

// Singleton ParkingLot Class
class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingLevel> levels;

    private ParkingLot() {
        levels = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(ParkingLevel level) {
        levels.add(level);
    }

    public ParkingSpot assignSpot(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            ParkingSpot spot = level.findAvailableSpot(vehicle);
            if (spot != null) {
                level.assignSpot(vehicle, spot);
                return spot;
            }
        }
        return null; // No spot available
    }

    public void releaseSpot(ParkingLevel level, ParkingSpot spot) {
        level.releaseSpot(spot);
    }
}

// ParkingLevel Class
class ParkingLevel {
    private int levelNumber;
    private List<ParkingSpot> spots;
    private Map<SpotType, List<ParkingSpot>> availableSpots;

    public ParkingLevel(int levelNumber) {
        this.levelNumber = levelNumber;
        this.spots = new ArrayList<>();
        this.availableSpots = new HashMap<>();
        for (SpotType type : SpotType.values()) {
            availableSpots.put(type, new ArrayList<>());
        }
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
        availableSpots.get(spot.getSpotType()).add(spot);
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        SpotType spotType = vehicle.getSize();
        List<ParkingSpot> spotsForType = availableSpots.get(spotType);
        if (spotsForType != null && !spotsForType.isEmpty()) {
            return spotsForType.get(0); // Return the first available spot
        }
        return null;
    }

    public void assignSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.assignVehicle(vehicle);
        availableSpots.get(spot.getSpotType()).remove(spot);
    }

    public void releaseSpot(ParkingSpot spot) {
        spot.removeVehicle();
        availableSpots.get(spot.getSpotType()).add(spot);
    }

    public void dummy() {
        System.out.println(levelNumber);
    }

}

// Abstract ParkingSpot Class
abstract class ParkingSpot {
    private String spotNumber;
    private SpotType spotType;
    private boolean isOccupied;
    private ParkingLevel level;

    public ParkingSpot(String spotNumber, SpotType spotType, ParkingLevel level) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.level = level;
        this.isOccupied = false;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void assignVehicle(Vehicle vehicle) {
        isOccupied = true;
    }

    public void removeVehicle() {
        isOccupied = false;
    }

    public void dummy() {
        System.out.println(spotNumber);
        System.out.println(level);
    }
}

// SmallSpot, MediumSpot, LargeSpot Classes (Inherit from ParkingSpot)
class SmallSpot extends ParkingSpot {
    public SmallSpot(String spotNumber, ParkingLevel level) {
        super(spotNumber, SpotType.SMALL, level);
    }
}

class MediumSpot extends ParkingSpot {
    public MediumSpot(String spotNumber, ParkingLevel level) {
        super(spotNumber, SpotType.MEDIUM, level);
    }
}

class LargeSpot extends ParkingSpot {
    public LargeSpot(String spotNumber, ParkingLevel level) {
        super(spotNumber, SpotType.LARGE, level);
    }
}

// Abstract Vehicle Class
abstract class Vehicle {
    private String licensePlate;
    private VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public abstract SpotType getSize();

    public void dummy() {
        System.out.println(licensePlate);
    }
}

// Motorcycle, Car, Bus Classes (Inherit from Vehicle)
class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, VehicleType.MOTORCYCLE);
    }

    @Override
    public SpotType getSize() {
        return SpotType.SMALL;
    }
}

class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }

    @Override
    public SpotType getSize() {
        return SpotType.MEDIUM;
    }
}

class Bus extends Vehicle {
    public Bus(String licensePlate) {
        super(licensePlate, VehicleType.BUS);
    }

    @Override
    public SpotType getSize() {
        return SpotType.LARGE;
    }
}

// Ticket Class
class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private ParkingLevel level;
    private Date entryTime;
    private Date exitTime;
    private double fee;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot, ParkingLevel level) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.level = level;
        this.entryTime = new Date(); // Set current time as entry time
    }

    public void setExitTime() {
        this.exitTime = new Date(); // Set current time as exit time
        calculateFee();
    }

    private void calculateFee() {
        long duration = exitTime.getTime() - entryTime.getTime();
        long hours = (duration / (1000 * 60 * 60)) % 24;
        this.fee = hours * 10.0; // Example fee calculation: $10 per hour
    }

    public double getFee() {
        return fee;
    }

    public void dummy() {
        System.out.println(ticketId + vehicle + spot + level);
    }

}

// Payment Class
class Payment {
    private String paymentId;
    private Ticket ticket;
    private double amount;

    public Payment(String paymentId, Ticket ticket) {
        this.paymentId = paymentId;
        this.ticket = ticket;
        this.amount = ticket.getFee();
    }

    public void processPayment() {
        // Example payment processing logic
        System.out.println("Payment of $" + amount + " processed for ticket: " + ticket + paymentId);
    }
}

// Main Class to Test the Design
public class MultiLevelParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        // Create levels and spots
        ParkingLevel level1 = new ParkingLevel(1);
        level1.addSpot(new SmallSpot("1A", level1));
        level1.addSpot(new MediumSpot("1B", level1));
        level1.addSpot(new LargeSpot("1C", level1));

        ParkingLevel level2 = new ParkingLevel(2);
        level2.addSpot(new SmallSpot("2A", level2));
        level2.addSpot(new MediumSpot("2B", level2));
        level2.addSpot(new LargeSpot("2C", level2));

        parkingLot.addLevel(level1);
        parkingLot.addLevel(level2);

        // Vehicles enter and are assigned spots
        Vehicle motorcycle = new Motorcycle("MOTO123");
        Vehicle car = new Car("CAR123");
        Vehicle bus = new Bus("BUS123");

        ParkingSpot spot1 = parkingLot.assignSpot(motorcycle);
        ParkingSpot spot2 = parkingLot.assignSpot(car);
        ParkingSpot spot3 = parkingLot.assignSpot(bus);

        // Generate tickets
        Ticket ticket1 = new Ticket("T1", motorcycle, spot1, level1);
        Ticket ticket2 = new Ticket("T2", car, spot2, level1);
        Ticket ticket3 = new Ticket("T3", bus, spot3, level2);

        // Vehicles exit and payments are processed
        ticket1.setExitTime();
        Payment payment1 = new Payment("P1", ticket1);
        payment1.processPayment();

        ticket2.setExitTime();
        Payment payment2 = new Payment("P2", ticket2);
        payment2.processPayment();

        ticket3.setExitTime();
        Payment payment3 = new Payment("P3", ticket3);
        payment3.processPayment();

        // Release spots
        parkingLot.releaseSpot(level1, spot1);
        parkingLot.releaseSpot(level1, spot2);
        parkingLot.releaseSpot(level2, spot3);
    }
}
