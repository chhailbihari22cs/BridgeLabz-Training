import java.util.ArrayList;

abstract class Employee {
    private int employeeId;
    private String name;
    protected double baseSalary;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and Setters (Encapsulation)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary; // Fixed salary
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private String department;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name, hourlyRate);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return baseSalary * hoursWorked;
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        Employee e1 = new FullTimeEmployee(101, "Vishal", 50000);
        Employee e2 = new PartTimeEmployee(102, "Karan", 500, 40);

        ((Department) e1).assignDepartment("IT");
        ((Department) e2).assignDepartment("HR");

        employees.add(e1);
        employees.add(e2);

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Department: " +
                    ((Department) emp).getDepartmentDetails());
            System.out.println("---------------------");
        }
    }
}
