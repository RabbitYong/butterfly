package com.rbty.algorithm.illustration_of_algorithm;

public class Fibonacci {
    public static int fib(int n) {
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    public static int fib2(int n) {
        int a = 0;
        int b = 1;
        if (n == 0)
            return a;
        if (n == 1)
            return b;
        for (int i = 2; i <= n; i++) {
            int temp = a;
            a = b;
            b = (temp + b) % 1000000007;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(fib2(5));
    }
}
