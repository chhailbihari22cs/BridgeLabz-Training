import java.util.LinkedList;

public class MyHashMap {

    // Ek choti class data store karne ke liye (Key-Value Pair)
    static class Node {
        int key;
        String value;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 10; // Array ka size
    private static LinkedList<Node>[] buckets = new LinkedList[SIZE];

    // 1. Insertion (Data Daalna)
    public static void put(int key, String value) {
        int bucketIndex = Math.abs(key % SIZE);

        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<>();
        }

        // Agar key pehle se hai, toh value update kar do
        for (Node node : buckets[bucketIndex]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }

        // Agar nayi key hai, toh list mein add karo
        buckets[bucketIndex].add(new Node(key, value));
    }

    // 2. Retrieval (Data Nikalna)
    public static String get(int key) {
        int bucketIndex = Math.abs(key % SIZE);
        LinkedList<Node> list = buckets[bucketIndex];

        if (list != null) {
            for (Node node : list) {
                if (node.key == key) {
                    return node.value;
                }
            }
        }
        return "Key nahi mili!";
    }

    // 3. Deletion (Data Hatana)
    public static void remove(int key) {
        int bucketIndex = Math.abs(key % SIZE);
        LinkedList<Node> list = buckets[bucketIndex];

        if (list != null) {
            Node target = null;
            for (Node node : list) {
                if (node.key == key) {
                    target = node;
                    break;
                }
            }
            if (target != null) {
                list.remove(target);
                System.out.println("Key " + key + " ko hata diya gaya.");
            }
        }
    }

    public static void main(String[] args) {
        // Bina object banaye static methods use kar rahe hain
        put(1, "Bhai");
        put(2, "Dost");
        put(11, "Padosi"); // 1 aur 11 dono ka index 1 aayega (Collision!)

        System.out.println("Key 1: " + get(1));
        System.out.println("Key 11: " + get(11));

        remove(2);
        System.out.println("Key 2: " + get(2));
    }
}