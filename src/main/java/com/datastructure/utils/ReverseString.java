package com.datastructure.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Collections.reverse;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Hello, World!";
       // String reversed = reverseString(input);
       // System.out.println("Reversed string: " + reversed);
        //TODO second ways
        char[] ch = input.toCharArray();
        for (int i = ch.length-1; i >=0 ; i--) {
            System.out.print(ch[i]);
        }
        // TODO Third ways
        String reversedStr = Arrays.stream(input.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
        System.out.println(reversedStr);

    }

    //TODO First ways
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }
    //TODO Third ways
    public static String reverseUsingStreams(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        lst -> { reverse(lst);
                            return lst.stream();
                        }))
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
