package com.datastructure.intervew;

public class PrimeOrNot {
    public static void main(String[] args) {
        int[] examples = {7, 12, 23};
        for (int example : examples) {
            boolean isPrime = isPrime(example);
            System.out.println(example + " is prime: " + isPrime);
        }
    }
    public static boolean isPrime(int number){
        if(number<2){
            return false;
        }
        if(number==2){
            return true;
        }
        return checkPrimeNumber(number ,2);
    }
    private static boolean checkPrimeNumber(int number , int divisor){
        if(divisor>Math.sqrt(number)){
            return true;
        }
        if(number %divisor == 0){
            return false;
        }
        return  checkPrimeNumber(number ,divisor+1);
    }
}
