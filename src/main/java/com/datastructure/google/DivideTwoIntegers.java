package com.datastructure.google;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend1 = 10, divisor1 = 3;
        int dividend2 = 7, divisor2 = -3;
        System.out.println(divide(dividend1, divisor1)); // Output: 3
        System.out.println(divide(dividend2, divisor2)); // Output: -2
    }
    public static int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);
        // Convert both numbers to their absolute values
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);
        int quotient = 0;
        // Use bit manipulation to find the quotient
        while (dividendAbs >= divisorAbs) {
            long temp = divisorAbs, multiple = 1;
            while (dividendAbs >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dividendAbs -= temp;
            quotient += multiple;
        }
        return negative ? -quotient : quotient;
    }
}
