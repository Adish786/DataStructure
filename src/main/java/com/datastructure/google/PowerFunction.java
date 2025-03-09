package com.datastructure.google;

public class PowerFunction {
    public static void main(String[] args) {
        double x1 = 2.1000;
        int n1 = 3;
        double x2 = 2.0000;
        int n2 = -2;
        System.out.println(pow(x1, n1)); // Output: 9.26100
        System.out.println(pow(x2, n2)); // Output: 0.25000
    }

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        while (N > 0) {
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            N /= 2;
        }

        return result;
    }
}
