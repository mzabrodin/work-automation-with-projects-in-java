package com.lab2.maven.passwordcli;

import com.lab2.maven.passwordhash.PasswordHashingService;
import com.lab2.maven.passwordvalidation.PasswordValidatorService;

import java.util.Scanner;

public class PasswordCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose action:");
            System.out.println("1 - Validate password");
            System.out.println("2 - Hash password");
            System.out.println("0 - Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter password to validate: ");
                    String password = scanner.nextLine();
                    var result = PasswordValidatorService.validate(password);
                    System.out.println(result);
                }
                case "2" -> {
                    System.out.print("Enter password to hash: ");
                    String password = scanner.nextLine();
                    String hash = PasswordHashingService.hashPassword(password);
                    System.out.println("Hashed password: " + hash);
                }
                case "0" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }
}