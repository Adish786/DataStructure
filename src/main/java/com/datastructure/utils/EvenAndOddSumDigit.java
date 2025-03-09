package com.datastructure.utils;

import java.util.Scanner;
/*
Even and Odd Digit Sums
Write a program that takes an integer 'n' as input and prints the sum of all its
even digits and the sum of all its odd digits separately. Digits refer to numbers,
not places within the integer
Input :- 987654  Output :- 18 , 21
Explanation:
In the input integer 987654,
the even digits are 8, 6, and 4.
Their sum is 8 + 6 + 4 = 18 .
The odd digits in the input are 9, 7, and 5. Their sum is 9 + 7 + 5 = 21.
Therefore, the program outputs "18 21", where 18 is the sum of even digits and 21
is the sum of odd digits
 */

public class EvenAndOddSumDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        calculateDigitSums(number);
        scanner.close();
    }
    public static void calculateDigitSums(int n) {
        int evenSum = 0;
        int oddSum = 0;
        while (n != 0) {
            int digit = n % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            } else {
                oddSum += digit;
            }
            n /= 10;
        }
        System.out.println("Sum of even digits: " + evenSum);
        System.out.println("Sum of odd digits: " + oddSum);
    }
}
