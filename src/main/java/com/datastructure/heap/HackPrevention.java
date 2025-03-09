package com.datastructure.heap;
/*
You are in charge for securing a system which contains confidential data which must not get into the hands of the enemies. You are tasked with designing a password and according to the agency a good password has the following properties:
It has at least 6 characters and at most 20 characters.
It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
It does not contain three repeating characters in a row, for example "aaa" will be a bad password.
You are given a string 's' on which you can perform several operation:
Insert one character to string 's',
Delete one character from string, or
Replace one character of string with another character.
Determine the minimum number of operation required to convert the string 's' into a good password.
Input:
The input consists of a single string s, representing the password that needs to be converted into a good password.
Output:
The output is a single integer representing the minimum number of operations required to convert the string s into a good password.
Examples
Sample Input - 1:
"BrEEEHiM"
Sample Output - 1:
1
Explanation:
You can just delete one "E" to make the password good from the given s.
Sample Input- 2:
"JaP"
Sample Output - 2:
3
Explanation:
You have to insert three new characters to make the password length at least 6, so that the given string 's' can turn into a good password.
Constraints:
1<=length of string 's'<=50
 */
public class HackPrevention {
    public static void main(String[] args) {
        String s = "BrEEEHiM";
        System.out.println(solve(s));
    }
    public static int solve(String s) {
        int n = s.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        int replace = 0, remove = 0, insert = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasDigit = true;
        }
        int missingTypes = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);
        if (n < 6) {
            insert = 6 - n;
            return Math.max(missingTypes, insert);
        } else if (n > 20) {
            remove = n - 20;
        }
        int oneSeq = 0, twoSeq = 0;
        for (int i = 2; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                int length = 2;
                while (i < n && s.charAt(i) == s.charAt(i - 1)) {
                    length++;
                    i++;
                }
                replace += length / 3;
                if (length % 3 == 0) oneSeq++;
                else if (length % 3 == 1) twoSeq++;
            }
        }
        if (n > 20) {
            replace -= Math.min(remove, oneSeq * 1);
            replace -= Math.min(Math.max(remove - oneSeq, 0), twoSeq * 2) / 2;
            replace -= Math.max(remove - oneSeq - 2 * twoSeq, 0) / 3;
        }
        return remove + Math.max(missingTypes, replace);

    }
}
