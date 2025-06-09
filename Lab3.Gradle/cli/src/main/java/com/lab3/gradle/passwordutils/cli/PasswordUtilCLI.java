package com.lab3.gradle.passwordutils.cli;

import com.lab3.gradle.passwordutils.generator.PasswordGenerationService;
import com.lab3.gradle.passwordutils.hasher.PasswordHashingService;
import com.lab3.gradle.passwordutils.validator.PasswordValidationService;

import java.util.Scanner;

public class PasswordUtilCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose action:");
            System.out.println("1 - Validate password");
            System.out.println("2 - Hash password");
            System.out.println("3 - Generate password");
            System.out.println("0 - Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter password to validate: ");
                    String password = scanner.nextLine();
                    var passayResult = PasswordValidationService.passayValidate(password);
                    var zxcvbnResult = PasswordValidationService.zxcvbnValidate(password);
                    System.out.println(passayResult);
                    System.out.println("\n");
                    System.out.println(zxcvbnResult);
                }
                case "2" -> {
                    System.out.print("Enter password to hash: ");
                    String password = scanner.nextLine();
                    String hash = PasswordHashingService.hashPassword(password);
                    System.out.println("Hashed password: " + hash);
                }
                case "3" -> {
                    System.out.println("Do you want to enter length of generated password? (y)");
                    String defaultOrNot = scanner.nextLine().trim().toLowerCase();

                    if (defaultOrNot.equals("y")) {
                        System.out.print("Enter length of generated password: ");
                        try {
                            int length = Integer.parseInt(scanner.nextLine());
                            String password = PasswordGenerationService.generatePassword(length);
                            System.out.println("Generated password: " + password);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid length. Using default (12).");
                            String password = PasswordGenerationService.generatePassword();
                            System.out.println("Generated password: " + password);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        try {
                            String password = PasswordGenerationService.generatePassword();
                            System.out.println("Generated password: " + password);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
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
