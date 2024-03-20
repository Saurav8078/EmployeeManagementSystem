package com.ems.operations;

import java.util.Scanner;

public class SalaryOperations {
//    private final EntityManager entityManager;
//    private final Scanner scanner;

//    public SalaryOperations(EntityManager entityManager, Scanner scanner) {
//        this.entityManager = entityManager;
//        this.scanner = scanner;
//    }

    public void displayMenu(Scanner scanner) {
        System.out.println("Salary Operations Menu:");
        System.out.println("1. Add Salary");
        System.out.println("2. Update Salary");
        System.out.println("3. Delete Salary");
        System.out.println("4. View Salary by ID");
        System.out.println("5. View All Salaries");
        System.out.println("0. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addSalary();
                break;
            case 2:
                updateSalary();
                break;
            case 3:
                deleteSalary();
                break;
            case 4:
                viewSalaryById();
                break;
            case 5:
                viewAllSalaries();
                break;
            case 0:
                System.out.println("Exiting Salary Operations...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu(scanner);
        }
    }

    private void addSalary() {
        // Implement logic to add salary
    }

    private void updateSalary() {
        // Implement logic to update salary
    }

    private void deleteSalary() {
        // Implement logic to delete salary
    }

    private void viewSalaryById() {
        // Implement logic to view salary by ID
    }

    private void viewAllSalaries() {
        // Implement logic to view all salaries
    }
}
