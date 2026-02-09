package EmployeeSalaryCategorization;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainApp {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Amit", "IT", 60000),
                new Employee("Neha", "HR", 50000),
                new Employee("Karan", "IT", 70000),
                new Employee("Riya", "HR", 55000),
                new Employee("Arjun", "Finance", 65000));

        Map<String, Double> avgSalaryByDept = employees.stream().collect(Collectors.groupingBy(e -> e.department,
                Collectors.averagingDouble(e -> e.salary)));

        System.out.println(avgSalaryByDept);

    }

}