package com.ems.operations;

import com.ems.entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeOperations {
    private final List<Employee> employees = new ArrayList<>();
    private long nextEmployeeId = 1;

    public void displayMenu(Scanner scanner) {
        System.out.println("Employee Operations Menu:");
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. View Employee by ID");
        System.out.println("5. View All Employees");
        System.out.println("0. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addEmployee(scanner);
                break;
            case 2:
                updateEmployee(scanner);
                break;
            case 3:
                deleteEmployee(scanner);
                break;
            case 4:
                viewEmployeeById(scanner);
                break;
            case 5:
                viewAllEmployees();
                break;
            case 0:
                System.out.println("Exiting Employee Operations...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu(scanner);
        }
    }

    private void addEmployee(Scanner scanner) {
        System.out.println("Enter employee name:");
        String name = scanner.nextLine();

        Employee employee = new Employee();
        employee.setId(nextEmployeeId++);
        employee.setName(name);
        employees.add(employee);

        System.out.println("Employee added successfully!");
    }

    private void updateEmployee(Scanner scanner) {
        System.out.println("Enter employee ID to update:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee not found with ID: " + id);
            return;
        }

        System.out.println("Enter new name for the employee:");
        String newName = scanner.nextLine();
        employee.setName(newName);

        System.out.println("Employee updated successfully!");
    }

    private void deleteEmployee(Scanner scanner) {
        System.out.println("Enter employee ID to delete:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee not found with ID: " + id);
            return;
        }

        employees.remove(employee);

        System.out.println("Employee deleted successfully!");
    }

    private void viewEmployeeById(Scanner scanner) {
        System.out.println("Enter employee ID:");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee not found with ID: " + id);
        } else {
            System.out.println("Employee Details:");
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
        }
    }

    private void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("All Employees:");
            for (Employee employee : employees) {
                System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName());
            }
        }
    }

    private Employee findEmployeeById(long id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
