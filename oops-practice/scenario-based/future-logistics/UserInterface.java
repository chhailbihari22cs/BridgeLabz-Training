import java.util.*;

abstract class GoodsTransport {
    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    public GoodsTransport(String transportId, String transportDate, int transportRating) {
        this.transportId = transportId;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }

    public abstract String vehicleSelection();

    public abstract float calculateTotalCharge();
}

class BrickTransport extends GoodsTransport {
    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating,
            float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public String vehicleSelection() {
        if (brickQuantity < 300)
            return "Truck";
        if (brickQuantity <= 500)
            return "Lorry";
        return "MonsterLorry";
    }

    public float calculateTotalCharge() {
        float price = brickPrice * brickQuantity;
        float tax = price * 0.3f;
        float discount = (transportRating == 5) ? price * 0.20f : (transportRating >= 3) ? price * 0.10f : 0;

        return price + tax + getVehiclePrice() - discount;
    }

    private float getVehiclePrice() {
        switch (vehicleSelection().toLowerCase()) {
            case "truck":
                return 1000;
            case "lorry":
                return 1700;
            default:
                return 3000;
        }
    }
}

class TimberTransport extends GoodsTransport {
    private float length, radius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating,
            float length, float radius, String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.length = length;
        this.radius = radius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    public String vehicleSelection() {
        float area = 2 * 3.147f * radius * length;
        if (area < 250)
            return "Truck";
        if (area <= 400)
            return "Lorry";
        return "MonsterLorry";
    }

    public float calculateTotalCharge() {
        float volume = 3.147f * radius * radius * length;
        float rate = timberType.equalsIgnoreCase("Premium") ? 0.25f : 0.15f;
        float price = volume * timberPrice * rate;
        float tax = price * 0.3f;
        float discount = (transportRating == 5) ? price * 0.20f : (transportRating >= 3) ? price * 0.10f : 0;

        return price + tax + getVehiclePrice() - discount;
    }

    private float getVehiclePrice() {
        switch (vehicleSelection().toLowerCase()) {
            case "truck":
                return 1000;
            case "lorry":
                return 1700;
            default:
                return 3000;
        }
    }
}

class Utility {
    public static boolean validateTransportId(String id) {
        return id.matches("RTS\\d{3}[A-Z]");
    }

    public static GoodsTransport parseDetails(String input) {
        String[] d = input.split(":");

        if (!validateTransportId(d[0])) {
            System.out.println("Transport id " + d[0] + " is invalid");
            System.out.println("Please provide a valid record");
            return null;
        }

        if (d[3].equalsIgnoreCase("BrickTransport")) {
            return new BrickTransport(d[0], d[1], Integer.parseInt(d[2]),
                    Float.parseFloat(d[4]),
                    Integer.parseInt(d[5]),
                    Float.parseFloat(d[6]));
        }

        return new TimberTransport(d[0], d[1], Integer.parseInt(d[2]),
                Float.parseFloat(d[4]),
                Float.parseFloat(d[5]),
                d[6],
                Float.parseFloat(d[7]));
    }
}

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Goods Transport details");
        String input = sc.nextLine();

        GoodsTransport gt = Utility.parseDetails(input);
        if (gt == null)
            return;

        System.out.println("Transporter id : " + gt.transportId);
        System.out.println("Date of transport : " + gt.transportDate);
        System.out.println("Rating of the transport : " + gt.transportRating);
        System.out.println("Vehicle for transport : " + gt.vehicleSelection());
        System.out.println("Total charge : " + gt.calculateTotalCharge());
    }
}