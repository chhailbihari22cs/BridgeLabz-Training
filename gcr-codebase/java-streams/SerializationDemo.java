import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class (Serializable hona zaroori hai)
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Best practice
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Dept: " + department + ", Salary: " + salary;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        String fileName = "employees.txt";
        List<Employee> employees = new ArrayList<>();

        // 1. Kuch data add karte hain
        employees.add(new Employee(1, "Rahul", "IT", 50000));
        employees.add(new Employee(2, "Simran", "HR", 60000));

        // 2. SERIALIZATION (File mein save karna)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }

        System.out.println("------------------------------------");

        // 3. DESERIALIZATION (File se wapas lana)
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            List<Employee> deserializedList = (List<Employee>) ois.readObject();
            
            System.out.println("Data retrieved from file:");
            for (Employee emp : deserializedList) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
    }
}

