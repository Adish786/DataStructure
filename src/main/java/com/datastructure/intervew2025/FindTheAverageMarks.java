package com.datastructure.intervew2025;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
/*
Find the average marks scored by each of these students?
        Input :
        String[] input = ["Akash 78", "Bharat 89", "Akash 90", "Akash 70", "Chetan 67", "Bharat 88", "Bharat 94", "Chetan 84"]
        Output:
        Akash : (78 + 90 + 70)/3
        Bharat: (89 + 88 + 94)/3
        Chetan: (67 + 84)/2
        */
public class FindTheAverageMarks {
    public static void main(String[] args) {
        String[] input = {"Akash 78", "Bharat 89", "Akash 90", "Akash 70", "Chetan 67", "Bharat 88", "Bharat 94", "Chetan 84"};
        Map<String, Double> collect = Arrays.stream(input)
                .map(s -> s.split(" "))
                .collect(Collectors.groupingBy(s -> s[0],
                        Collectors.averagingDouble(
                                s -> Double.parseDouble(s[1]))));
        System.out.println(collect);
    }

}
