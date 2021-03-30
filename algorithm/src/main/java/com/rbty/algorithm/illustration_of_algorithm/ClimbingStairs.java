package com.rbty.algorithm.illustration_of_algorithm;

public class ClimbingStairs {
    public static int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(numWays(0));
    }
}
