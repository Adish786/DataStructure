package com.datastructure.Integer;

public class SwapTwoVariables {
    public static void main(String arg[]){
        swap(5,10);
    }
    public static void swap(int a, int b) {
        if (a == b) {
            System.out.println(a + " " + b);
            return;
        }
        System.out.println(b + " " + a);
    }
}
