package TestScriptJava;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestEmployeeClass implements Comparable<TestEmployeeClass> {

    private String name;
    private int age;
    private double salary;

    // Default constructor
    public TestEmployeeClass() {
    }
    public TestEmployeeClass(String name, int age, double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(TestEmployeeClass other) {
        // Compare by name first
        int nameComparison = this.name.compareTo(other.name);

        // If names are equal, compare by salary
        if (nameComparison == 0) {
            return Double.compare(this.salary, other.salary);
        }

        return nameComparison;
    }

    @Override
    public String toString() {
        return "Employee{age=" + age + ", name='" + name + "', salary=" + salary + "}";
    }

    @Test
    public void TestCase()
        {
            List<TestEmployeeClass> employees = new ArrayList<>();
            employees.add(new TestEmployeeClass("John", 101, 50000.0));
            employees.add(new TestEmployeeClass("Alice", 102, 60000.0));
            employees.add(new TestEmployeeClass("Bob", 103, 55000.0));

            System.out.println("Before sorting:");
            for (TestEmployeeClass employee : employees) {
                System.out.println(employee);
            }

            Collections.sort(employees);

            System.out.println("\nAfter sorting by name and salary:");
            for (TestEmployeeClass employee : employees) {
                System.out.println(employee);
            }

        }


}

