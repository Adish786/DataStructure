package com.datastructure.utils;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(n));
    }
    //TODO this is iterative approch
    public  static int fact(int n){
        int res = 1;
        for (int i = 1; i <=n ; i++) {
           // res = res*i;
            res *= i;
        }
        return res;
    }
}
