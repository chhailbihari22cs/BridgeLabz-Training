import java.util.ArrayList;

abstract class vehicle {
    private String vehicleId;
    private String driverName;
    protected double ratePerKm;

    public vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Encapsulation
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName);
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

class Car extends vehicle implements GPS {
    private String location = "Unknown";

    public Car(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

class Bike extends vehicle implements GPS {
    private String location = "Unknown";

    public Bike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm * 0.9;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

class Auto extends vehicle implements GPS {
    private String location = "Unknown";

    public Auto(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return (distance * ratePerKm) + 20;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

public class RideHailing {

    public static void calculateRides(ArrayList<vehicle> vehicles, double distance) {
        for (vehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.println("Fare: " + v.calculateFare(distance));
            System.out.println("---------------------");
        }
    }

    public static void main(String[] args) {

        ArrayList<vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR101", "Vishal", 15));
        vehicles.add(new Bike("BIKE202", "Karan", 8));
        vehicles.add(new Auto("AUTO303", "Rohit", 10));

        calculateRides(vehicles, 12);
    }
}
