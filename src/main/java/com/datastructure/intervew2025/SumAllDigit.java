package com.datastructure.intervew2025;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/*
Write a program Sum up the all the digits that are there in string until you reach single digit.
Example: input: 123456
when we sum all digits of "123456" then you will get "21" then when you sum up all digits in "21" then we will get "3"
output: 3
 */
public class SumAllDigit {
    public static void main(String[] args) {
        String input= "123456";

//        List<String> collect = Arrays.stream(input.split("")).filter(i -> i.startsWith("")).map(i -> i + i)
//                .collect(Collectors.toList());
//        System.out.println(collect);


        System.out.println(sumToSingleDigit(input));
    }

    public static int sumToSingleDigit(String input) {
        int sum = input.chars().filter(Character::isDigit).map(Character::getNumericValue).sum();
        while (sum >= 10) {
            sum = String.valueOf(sum).chars().map(Character::getNumericValue).sum();
        }
        return sum;
    }
    public static int sumDigitsUntilSingle(String input) {
        int sum = 0;
        while (input.length() > 1) {
            sum = 0;
            for (char ch : input.toCharArray()) {
                if (Character.isDigit(ch)) {
                    sum += Character.getNumericValue(ch);
                }
            }
            input = String.valueOf(sum);
        }
        return Integer.parseInt(input);
    }
}
