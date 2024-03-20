package com.ems.operations;

import java.util.Scanner;
import com.ems.entities.Department;
import com.ems.service.DepartmentService;

public class DepartmentOperations {
    private final DepartmentService departmentService = new DepartmentService();
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Department Operations Menu:");
            System.out.println("1. Add Department");
            System.out.println("2. Get Department by ID");
            System.out.println("3. Update Department");
            System.out.println("4. Delete Department");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    addDepartment();
                    break;
                case 2:
                    getDepartmentById();
                    break;
                case 3:
                    updateDepartment();
                    break;
                case 4:
                    deleteDepartment();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void addDepartment() {
        System.out.print("Enter department name: ");
        String name = scanner.nextLine();
        Department department = new Department();
        department.setName(name);
        departmentService.addDepartment(department);
        System.out.println("Department added successfully.");
    }

    private void getDepartmentById() {
        System.out.print("Enter department ID: ");
        long id = scanner.nextLong();
        Department department = departmentService.getDepartmentById(id);
        if (department != null) {
            System.out.println("Department found: " + department);
        } else {
            System.out.println("Department not found.");
        }
    }

    private void updateDepartment() {
        System.out.print("Enter department ID to update: ");
        long id = scanner.nextLong();
        Department department = departmentService.getDepartmentById(id);
        if (department != null) {
            System.out.print("Enter new department name: ");
            scanner.nextLine(); // Consume newline character
            String newName = scanner.nextLine();
            department.setName(newName);
            departmentService.updateDepartment(department);
            System.out.println("Department updated successfully.");
        } else {
            System.out.println("Department not found.");
        }
    }

    private void deleteDepartment() {
        System.out.print("Enter department ID to delete: ");
        long id = scanner.nextLong();
        Department department = departmentService.getDepartmentById(id);
        if (department != null) {
            departmentService.deleteDepartment(department);
            System.out.println("Department deleted successfully.");
        } else {
            System.out.println("Department not found.");
        }
    }

    public static void main(String[] args) {
        DepartmentOperations departmentOperations = new DepartmentOperations();
        departmentOperations.displayMenu();
    }
}
