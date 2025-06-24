package com.lab6.cicd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of months:");
        int months = scanner.nextInt();

        System.out.println("Enter number of rabbits:");
        int rabbits = scanner.nextInt();

        int result = Rabbits.calculate(months, rabbits);
        System.out.printf("After %d months, %d rabbits live on the TTV planet", months, result);
    }
}