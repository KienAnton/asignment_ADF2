package com.t2012e.view;

import com.t2012e.controller.EmployeeController;

import java.util.Scanner;

public class Menu {
    public Scanner scanner = new Scanner(System.in);
    public EmployeeController employeeController = new EmployeeController();
    public void generateMenu(){
        while (true){
            System.out.println("Employee manager");
            System.out.println("----------------------------");
            System.out.println("1. Register.");
            System.out.println("2. Login.");
            System.out.println("3. Exit.");
            System.out.println("-----------------------------");
            System.out.println("Please enter your choice (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    employeeController.register();
                    break;
                case 2:
                    employeeController.login();
                    break;
                case 3:
                    break;
            }
            if (choice == 3) {
                break;
            }
        }
    }
}
