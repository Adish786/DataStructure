package com.datastructure.String;


import java.util.*;
class MaxDepth {
    public static int maxDepth(String s) {
        int count=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
                st.push(i);
            else if(s.charAt(i) == ')')
            {
                if(count < st.size())
                    count = st.size();
                st.pop();
            }
        }
        return count;
    }
    public static void main (String[] args) {
        System.out.println(maxDepth("( ((X)) (((Y))) )"));
    }
}
