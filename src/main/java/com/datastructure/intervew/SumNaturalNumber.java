package com.datastructure.intervew;

public class SumNaturalNumber {
    public static void main(String[] args) {
        int[] examples = {5, 10, 1};
        for (int N : examples) {
            int sum = calculateSum(N);
            System.out.println("Sum of first " + N + " natural numbers: " + sum);
        }
    }

    public static int calculateSum(int n){
        if(n<=0){
            return 0;
        }
        return n+calculateSum(n-1);
    }
}
