package com.ems.Main;

import com.ems.operations.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        while (true) {
            System.out.println("EMS Main Menu:");
            System.out.println("1. Employee Operations");
            System.out.println("2. Project Operations");
            System.out.println("3. Department Operations");
            System.out.println("4. Salary Operations");
            System.out.println("5. Attendance Operations");
            System.out.println("6. Manager Operations");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    EmployeeOperations employeeOperations = new EmployeeOperations();
                    employeeOperations.displayMenu(scanner);
                    break;
                case 2:
                    ProjectOperations projectOperations = new ProjectOperations();
                    projectOperations.displayMenu(scanner);
                    break;
                case 3:
                    DepartmentOperations departmentOperations = new DepartmentOperations();
                    departmentOperations.displayMenu();
                    break;
                case 4:
                    SalaryOperations salaryOperations = new SalaryOperations();
                    salaryOperations.displayMenu(scanner);
                    break;
                case 5:
                    AttendanceOperations attendanceOperations = new AttendanceOperations();
                    attendanceOperations.displayMenu(scanner);
                    break;
                case 6:
                    ManagerOperations managerOperations = new ManagerOperations();
                    managerOperations.displayMenu(scanner);
                    break;
                case 0:
                    System.out.println("Exiting EMS...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
