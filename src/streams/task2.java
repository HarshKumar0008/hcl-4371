package streams;


import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    String department;
    int salary;

    Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class task2 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Rahul", "IT", 50000),
                new Employee("Aman", "HR", 30000),
                new Employee("Ravi", "IT", 60000),
                new Employee("Priya", "HR", 40000),
                new Employee("Raj", "Sales", 35000)
        );

        Map<String, Integer> result = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.summingInt(e -> e.salary)
                ));

        result.forEach((dept, total) ->
                System.out.println(dept + " = " + total));
    }
}