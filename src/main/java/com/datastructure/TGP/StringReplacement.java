package com.datastructure.TGP;
import java.util.HashSet;
import java.util.Set;
/*
String Replacement
You are given a binary string s, consisting only of only '0', and another binary string t, consisting of both '0' and '1'.
In one move, you can replace any '0' in the string s with string t. Note that after the replacement string s might contain elements which are not '0'.
You can perform an arbitrary number of moves (including zero). How many different binary strings can you obtain(leading zeroes are also allowed)? Print the number, or report that it is infinitely large.
Two strings are considered different if they have different length, or they differ at some index.
Example
Input 1 :
000
0
Output 1
1
Explanation:
`In the first example, you can replace any 0 with the zero in another string and it won't make any difference.
Example
Input 2 :
00
1
Output 2
4
Explanation:
`The 4 outputs would be 01, 00, 10 and 11.
 */

public class StringReplacement {
    public static int solve(String s, String t) {
        if (t.length() > 1 && t.contains("0")) {
            return -1;
        }
        Set<String> result = new HashSet<>();
        explore(s, t, 0, new StringBuilder(), result);
        return result.size();
    }
    private static void explore(String s, String t, int index, StringBuilder current, Set<String> result) {
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }
        explore(s, t, index + 1, current.append('0'), result);
        current.deleteCharAt(current.length() - 1);
        explore(s, t, index + 1, current.append(t), result);
        current.delete(current.length() - t.length(), current.length());
    }
    public static void main(String[] args) {
        String s = "00";
        String t = "1";
        System.out.println(solve(s,t));
    }
}
