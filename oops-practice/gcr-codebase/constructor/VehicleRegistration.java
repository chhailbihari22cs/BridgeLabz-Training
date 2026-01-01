class Vehicle {
    // Instance variables
    String ownerName;
    String vehicleType;

    // Class variable
    static double registrationFee = 5000;

    // Constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method
    void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName +
                " | Vehicle: " + vehicleType +
                " | Registration Fee: ₹" + registrationFee);
    }

    // Class method
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }
}

public class VehicleRegistration {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Vishal", "Bike");
        v1.displayVehicleDetails();
    }
}
