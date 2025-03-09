package com.datastructure.TGP;
import java.util.Stack;
/*
Dholu is very creative and wants to play with strings and he has a very good idea. You have given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order
Input Format:
first line consists of a string
Output Format:
print the output string
Sample Input:
cbacdcbc
Sample Output:
abcd
Input:
ropuptijikiloa
Expected output:
aijkloprtu
Explanation: Since if we only collect unique letters, they come out to be 'c', 'b', 'a' and 'd' and when they are arranged lexicographically the output is abcd.
Constraints:
1<= s.length<= 10000
Note: Input consists of only lower case letters
 */

public class DuplicateLetters {
    public static void main(String[] args) {
        String str = "ropuptijikiloa";
        System.out.println(removeDuplicateLetters(str));
    }
    public static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        boolean[] seen = new boolean[26];
        Stack<Integer> st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (seen[curr]) continue;
            while (!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()]){
                seen[st.pop()] = false;
            }
            st.push(curr);
            seen[curr] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append((char) (st.pop() + 'a'));
        return sb.reverse().toString();
    }
}
