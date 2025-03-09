package com.datastructure.String;

public class LongestSubString {
    static int startIndex =0;
    static int maxIndex =1;
    public static void main(String[] args) {
        String str = new String("Ncbeebcz");
        int n =str.length();
        for (int i = 0; i <n-1 ; i++) {
            checkPalindrome(str,1,i);  //odd length
            checkPalindrome(str,1,i+1);  //even length
        }
        System.out.println("Length of longest substring - " +maxIndex);
        System.out.println("Length of Palindromic Substring  - " +str.substring(startIndex,startIndex+maxIndex));
    }

    private static void checkPalindrome(String str ,int i,int j){
        int n = str.length();
        while (i >=0 && j<n ){
            if(str.charAt(i)!=str.charAt(j)) return;
            int length = j-i+1;
            if(length>maxIndex){
                maxIndex = length;
                startIndex =i;
            }
            i--;
            j++;
        }
    }
}
