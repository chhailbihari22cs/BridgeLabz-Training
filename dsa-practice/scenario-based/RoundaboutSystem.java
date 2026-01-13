import java.util.LinkedList;
import java.util.Queue;

// 1. Node for Circular Linked List
class VehicleNode {
    String vehicleID;
    VehicleNode next;

    public VehicleNode(String id) {
        this.vehicleID = id;
    }
}

// 2. Roundabout Manager
class TrafficManager {
    private VehicleNode head = null;
    private VehicleNode tail = null;
    private Queue<String> waitingQueue;
    private int queueCapacity;

    public TrafficManager(int capacity) {
        this.waitingQueue = new LinkedList<>();
        this.queueCapacity = capacity;
    }

    // --- Queue Logic (Waiting Area) ---
    public void addToWaitingArea(String vehicleID) {
        if (waitingQueue.size() >= queueCapacity) {
            System.out.println(" Queue Overflow: Waiting area full for " + vehicleID);
            return;
        }
        waitingQueue.add(vehicleID);
        System.out.println(" Wait " + vehicleID + " is waiting to enter the roundabout.");
    }

    // --- Circular Linked List Logic (Roundabout Flow) ---
    public void enterRoundabout() {
        if (waitingQueue.isEmpty()) {
            System.out.println(" Queue Underflow: No vehicles waiting.");
            return;
        }

        String vehicleID = waitingQueue.poll();
        VehicleNode newNode = new VehicleNode(vehicleID);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Pointing to itself (Circular)
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circularity
        }
        System.out.println(vehicleID + " has entered the roundabout.");
    }

    public void exitRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is already empty.");
            return;
        }

        System.out.println(" car " + head.vehicleID + " has exited the roundabout.");

        if (head == tail) { // Only one vehicle was there
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head; // Re-link tail to new head
        }
    }

    public void displayState() {
        System.out.println("\n--- Current Traffic State ---");
        System.out.print("Roundabout: ");
        if (head == null) {
            System.out.print("EMPTY");
        } else {
            VehicleNode temp = head;
            do {
                System.out.print("[" + temp.vehicleID + "] -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.print("(Back to " + head.vehicleID + ")");
        }
        System.out.println("\nWaiting Queue: " + waitingQueue);
        System.out.println("-----------------------------\n");
    }
}

// 3. Main Execution
public class RoundaboutSystem {
    public static void main(String[] args) {
        TrafficManager cityTraffic = new TrafficManager(3); // Queue capacity = 3

        // 1. Vehicles arriving at the signal
        cityTraffic.addToWaitingArea("Car-A");
        cityTraffic.addToWaitingArea("Car-B");
        cityTraffic.addToWaitingArea("Car-C");
        cityTraffic.addToWaitingArea("Car-D"); // Should overflow

        // 2. Vehicles entering the roundabout
        cityTraffic.enterRoundabout();
        cityTraffic.enterRoundabout();
        cityTraffic.displayState();

        // 3. One vehicle exits, another enters
        cityTraffic.exitRoundabout();
        cityTraffic.enterRoundabout();
        cityTraffic.displayState();

        // 4. Final exits
        cityTraffic.exitRoundabout();
        cityTraffic.exitRoundabout();
        cityTraffic.displayState();
    }
}