package com.ems.operations;

import java.util.Scanner;

public class ProjectOperations {
//    private final ProjectService projectService;
//    private final Scanner scanner;

//    public ProjectOperations(ProjectService projectService, Scanner scanner) {
//        this.projectService = projectService;
//        this.scanner = scanner;
//    }

    public void displayMenu(Scanner scanner) {
        System.out.println("Project Operations Menu:");
        System.out.println("1. Add Project");
        System.out.println("2. Update Project");
        System.out.println("3. Delete Project");
        System.out.println("4. View Project by ID");
        System.out.println("5. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addProject();
                break;
            case 2:
                updateProject();
                break;
            case 3:
                deleteProject();
                break;
            case 4:
                viewProjectById();
                break;
            case 5:
                System.out.println("Exiting Project Operations...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu(scanner);
        }
    }

    private void addProject() {
        // Implement logic to take input and add project
    }

    private void updateProject() {
        // Implement logic to take input and update project
    }

    private void deleteProject() {
        // Implement logic to take input and delete project
    }

    private void viewProjectById() {
        // Implement logic to take input and view project by ID
    }
}
