import java.util.*;

// Vehicle Node for Circular Linked List
class Vehicle {
    String plateNumber;
    Vehicle next;

    Vehicle(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}

public class TrafficManager {
    private Vehicle head = null; // Circular List ka start
    private Vehicle tail = null; // Circular List ka end
    private Queue<String> waitingQueue = new LinkedList<>();
    private final int QUEUE_CAPACITY = 3; // Queue ki limit

    // 1. Waiting Queue mein car add karna (Queue Handling)
    public void enterWaitingArea(String carPlate) {
        if (waitingQueue.size() >= QUEUE_CAPACITY) {
            System.out.println(" Queue Overflow: Waiting area full hai for " + carPlate);
        } else {
            waitingQueue.add(carPlate);
            System.out.println(carPlate + " is waiting to enter roundabout.");
        }
    }

    // 2. Queue se nikaal (Circular List) mein daalna
    public void moveToRoundabout() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue Underflow: No cars waiting!");
            return;
        }

        String carPlate = waitingQueue.poll();
        Vehicle newVehicle = new Vehicle(carPlate);

        if (head == null) {
            head = newVehicle;
            tail = newVehicle;
            newVehicle.next = head; // Circle ban gaya
        } else {
            tail.next = newVehicle;
            tail = newVehicle;
            tail.next = head; // connected tail to head to maintain circle
        }
        System.out.println(carPlate + " entered the roundabout.");
    }

    // 3. Roundabout se car remove karna
    public void exitRoundabout() {
        if (head == null) {
            System.out.println("Empty Roundabout!");
            return;
        }
        System.out.println(head.plateNumber + " exited the roundabout.");
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head; // Circle maintain rakha
        }
    }

    // 4. Roundabout ki current state print karna
    public void printRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }
        System.out.print(" Roundabout State: ");
        Vehicle temp = head;
        do {
            System.out.print(temp.plateNumber + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Start)");
    }

    public static void main(String[] args) {
        TrafficManager tm = new TrafficManager();

        // 1. Cars waiting area mein aayi
        tm.enterWaitingArea("KA-01");
        tm.enterWaitingArea("DL-02");
        tm.enterWaitingArea("MH-03");
        tm.enterWaitingArea("UP-04"); // Ye overflow hoga

        // 2. Cars roundabout mein gayi
        tm.moveToRoundabout();
        tm.moveToRoundabout();

        tm.printRoundabout();

        // 3. Ek car bahar nikal gayi
        tm.exitRoundabout();
        tm.printRoundabout();
    }
}
