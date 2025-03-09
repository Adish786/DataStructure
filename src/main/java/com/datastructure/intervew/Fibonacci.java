package com.datastructure.intervew;


public class Fibonacci {
    public static boolean isFibonacci(int N)
    {
      //  int N = 0;
        if (N == 0 || N == 1)
            return true;
        int a = 0, b = 1, c;
        while (true) {
            c = a + b;
            a = b;
            b = c;
            if (c == N)
                return true;
            else if (c >= N) {
                return false;
            }
        }
    }
    //TODO Second ways
    public static int fibRecursion(int count) {
        if (count == 0) {
            return 0;
        } // Oth fibonacci is 0
        if (count == 1 || count == 2) {
            return 1;  // 1st and 2nd Fibonacci are 1 and 1 only
        }
        return fibRecursion(count - 1) + fibRecursion(count - 2);
    }


    public static void main(String[] args) {
        /*
        for (int i = 1; i <= 10; i++) {
            if (isFibonacci(i)) {
                System.out.println(
                        i + " is a Fibonacci number.");
            }
            else {
                System.out.println(
                        i + " is not a Fibonacci number.");
            }
        }

         */
        int fib_len = 9;
        System.out.print("Fibonacci Series of " + fib_len + " numbers is: \n");
        for (int i = 0; i < fib_len; i++) {
            System.out.print(fibRecursion(i) + " ");
        }
    }

    }

