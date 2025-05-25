package com.lab1.nativeimage;

import java.util.Scanner;

public class LostCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter amount of cards or 0 to end");
            int numberOfCards = scanner.nextInt();
            if (numberOfCards == 0) {
                break;
            }

            int result = 0;

            System.out.println("Enter cards you already have:");
            for (int i = 1; i <= numberOfCards; i++) {
                result ^= i;
                if (i < numberOfCards) {
                    result ^= scanner.nextInt();
                }
            }

            System.out.println("Lost card: " + result);
        }
    }
}