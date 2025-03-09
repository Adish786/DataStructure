package com.datastructure.intervew;

public class Factorial {
    public static int calculateFactorial(int nums){
        if(nums==0 || nums ==1){
            return 1;
        }
        return nums * calculateFactorial(nums-1);
    }
    public static void main(String[] args) {
        int[] examples = {5, 7, 1};
        for (int number : examples) {
            int factorial = calculateFactorial(number);
            System.out.println("Factorial of " + number + ": " + factorial);
        }
    }
}
