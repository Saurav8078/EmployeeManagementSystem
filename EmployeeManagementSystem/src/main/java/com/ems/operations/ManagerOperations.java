package com.ems.operations;

import java.util.Scanner;

public class ManagerOperations {
//    private final ManagerService managerService;
//    private final Scanner scanner;
//
//    public ManagerOperations(ManagerService managerService, Scanner scanner) {
//        this.managerService = managerService;
//        this.scanner = scanner;
//    }

    public void displayMenu(Scanner scanner) {
        System.out.println("Manager Operations Menu:");
        System.out.println("1. Add Manager");
        System.out.println("2. Update Manager");
        System.out.println("3. Delete Manager");
        System.out.println("4. View Manager by ID");
        System.out.println("5. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addManager();
                break;
            case 2:
                updateManager();
                break;
            case 3:
                deleteManager();
                break;
            case 4:
                viewManagerById();
                break;
            case 5:
                System.out.println("Exiting Manager Operations...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu(scanner);
        }
    }

    private void addManager() {
        // Implement logic to take input and add manager
    }

    private void updateManager() {
        // Implement logic to take input and update manager
    }

    private void deleteManager() {
        // Implement logic to take input and delete manager
    }

    private void viewManagerById() {
        // Implement logic to take input and view manager by ID
    }
}
