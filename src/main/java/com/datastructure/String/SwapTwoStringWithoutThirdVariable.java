package com.datastructure.String;
/*
Java Program to Swap two Strings Without Using any Third Variable
 */
public class SwapTwoStringWithoutThirdVariable {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "World";
        System.out.println("Strings before swap: a = " + a + " and b = "+b);
        // append 2nd string to 1st
        a = a + b;
        // store initial string a in string b
        b = a.substring(0,a.length()-b.length());
        // store initial string b in string a
        a = a.substring(b.length());
        // print String after swapping
        System.out.println("Strings after swap: a = " + a + " and b = " + b);


    }
}
