package com.lab6.cicd;

public class Rabbits {
    public static int calculate(int n, int k) {
        int rabbits = 1;

        for (int i = 0; i < n; i++) {
            if (rabbits > k) {
                rabbits -= k;
            }
            rabbits *= 2;
        }
        return rabbits;
    }
}