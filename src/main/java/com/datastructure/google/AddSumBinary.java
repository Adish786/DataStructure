package com.datastructure.google;

public class AddSumBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0'; // Add bit from a
            if (j >= 0) sum += b.charAt(j--) - '0'; // Add bit from b
            result.insert(0, sum % 2); // Use insert to prepend
            carry = sum / 2; // Determine new carry
        }
        return result.toString(); // No need to reverse
    }
    public static void main(String[] args) {
        AddSumBinary sumBinary = new AddSumBinary();
        System.out.println(sumBinary.addBinary("10110", "10101")); // "101011"
        System.out.println(sumBinary.addBinary("111", "1"));      // "1000"
        System.out.println(sumBinary.addBinary("0", "0"));        // "0"
    }
}
