package com.t2012e.controller;

import com.t2012e.entity.Employee;
import com.t2012e.model.EmployeeModel;

import java.util.Scanner;

public class EmployeeController {
    public EmployeeModel employeeModel = new EmployeeModel();
    public Scanner scanner = new Scanner(System.in);

    public void register(){
        Employee employee = new Employee();
        boolean check = true;
     while (true){
         System.out.println("Enter employee name:");
         String name = scanner.nextLine();
         System.out.println("Enter employee address:");
         String address = scanner.nextLine();
         System.out.println("Enter employee email:");
         String email = scanner.nextLine();
         System.out.println("Enter employee account:");
         String account = scanner.nextLine();
         System.out.println("Enter employee password:");
         String pwd = scanner.nextLine();
         if (!(employeeModel.checkExistAccount(account))) {
             System.out.println("The account does not exist yet (Enter 'yes' to creat new)");
             String choie = scanner.nextLine();
             switch (choie){
                 case "yes":
                     employee = new Employee(name, address, email, account, pwd);
                     if (employeeModel.register(employee)) {
                         System.out.println("Action success!");
                     }
                     return;
                 case "no":
                     break;
             }
         }else{
             System.out.println("Account already exists, please re-enter!");
         }
     }
    }

    public void login(){
        while (true){
            System.out.println("Enter employee account:");
            String account = scanner.nextLine();
            System.out.println("Enter employee password:");
            String pwd = scanner.nextLine();
            if (employeeModel.login(account, pwd)!= null) {
                System.out.println("Action success!\n");
                System.out.println((employeeModel.login(account, pwd)).toString());
                return;
            }else{
                System.out.println("wrong account information!");
            }
        }
    }



}
