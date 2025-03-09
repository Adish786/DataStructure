package com.datastructure.intervew;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "RaceCar";
        String s2 = "CarRace";

        s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        if (s1.equals(s2))
        {
            System.out.println("Two strings are anagrams");
        }
        else
        {
            System.out.println("Two strings are not anagrams");
        }

                                    // TODO Second Approch
        String s3 = "race";
        String s4 = "care";
        s3= s3.toLowerCase();
        s4= s4.toLowerCase();
       if(s3.length() ==s4.length()){
           char[] toCarArray1 = s3.toCharArray();
           char[] toCarArray2 = s4.toCharArray();
           Arrays.sort(toCarArray1);
           Arrays.sort(toCarArray2);
           boolean result = Arrays.equals(toCarArray1,toCarArray2);
           if(result) {
               System.out.println(s3 + " and " + s4 + " are anagram.");
           }
           else {
               System.out.println(s3 + " and " + s4 + " are not anagram.");
           }
       }
       else {
           System.out.println(s3 + " and " + s4 + " are not anagram.");
       }
        }
    }