import java.util.ArrayList;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateRentalCost(int days);
}
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
class Car extends vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.10;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy";
    }
}
class Bike extends vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy";
    }
}
class Truck extends vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (rentalRate * days) + 2000;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.15;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy";
    }
}
public class VehicleRentalSystem {

    public static void main(String[] args) {

        ArrayList<vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR101", 1500, "CAR-INS-001"));
        vehicles.add(new Bike("BIKE202", 500, "BIKE-INS-002"));
        vehicles.add(new Truck("TRK303", 3000, "TRK-INS-003"));

        int days = 5;

        for (vehicle v : vehicles) {
            double rentalCost = v.calculateRentalCost(days);
            double insuranceCost = 0;

            if (v instanceof Insurable) {
                insuranceCost = ((Insurable) v).calculateInsurance();
            }

            System.out.println("Vehicle: " + v.getType());
            System.out.println("Rental Cost: " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println("----------------------");
        }
    }
}


