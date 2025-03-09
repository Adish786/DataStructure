package com.datastructure.graind75.easy;
/*
Given two binary strings a and b, return their sum as a binary string.
Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    int i=a.length()-1;  int j=b.length()-1;  int carry=0;
    while (i>=0 || j>=0 || carry==1){
            int total = carry;
            if(i>=0) total +=a.charAt(i--) -'0';
            if(j>=0) total +=b.charAt(j--)-'0';
            result.append(total%2);
            carry = total/2;
        }
    return  result.reverse().toString();
    }
    public static void main(String[] args) {
        String a="1010";
        String b="1011";
        System.out.println(addBinary(a,b));
    }
}
