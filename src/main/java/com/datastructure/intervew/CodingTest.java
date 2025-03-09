package com.datastructure.intervew;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class CodingTest {
    public static void main(String[] args) {
        //TODO remove duplicate elements from a list using Java 8 streams
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<String> uniqueStrngs = listOfStrings.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueStrngs);
        //TODO find frequency of each character in a string using Java 8 streams
        String inputString = "Java Concept Of The Day";
        Map<Character, Long> map = inputString.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        //TODO How do you find frequency of each element in an array or a list
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> stationeryCountMap = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(stationeryCountMap);
        //TODO How do you sort the given list of decimals in reverse order
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        //TODO Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
        List<String> listOfStrings1 = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String stringJoining = listOfStrings1.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(stringJoining);
        //TODO From the given list of integers, print the numbers which are multiples of 5
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        listOfIntegers.stream().filter(i -> i % 5 == 0).forEach(System.out::println);
        //TODO Given a list of integers, find maximum and minimum of those numbers
        List<Integer> listOfIntegers1 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        int max = listOfIntegers1.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Maxmimun Element is : " + max);
        int min = listOfIntegers1.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Minimum Element is :" + min);
        //TODO  How do you merge two unsorted arrays into single sorted array using Java 8 streams?
        int[] a = new int[]{5, 7, 6, 11, 17};
        int[] b = new int[]{9, 6, 2, 4, 9, 12};
        int[] array = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
        System.out.println(Arrays.toString(array));
        //TODO How do you merge two unsorted arrays into single sorted array without duplicates?
        int[] a1 = new int[]{5, 7, 6, 11, 17};
        int[] b1 = new int[]{9, 6, 2, 4, 9, 12};
        int[] array1 = IntStream.concat(Arrays.stream(a1), Arrays.stream(b1)).sorted().distinct().toArray();
        System.out.println(array1);
        //TODO How do you get three maximum numbers and three minimum numbers from the given list of integers
        List<Integer> listOfIntegersMax = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        listOfIntegersMax.stream().sorted().limit(3).forEach(System.out::println);
        List<Integer> listOfIntegersMin = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        listOfIntegersMin.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
        //TODO Find sum of all digits of a number in Java 8
        int sum = 56734;
        Integer collect = Stream.of(String.valueOf(sum).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(collect);
        //TODO Find second largest number in an integer array?
        List<Integer> secondLarge = Arrays.asList(12, 43, 6, 2, 8, 1, 5, 9, 167, 331);
        Integer second = secondLarge.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(second);
        //TODO Given a list of strings, sort them according to increasing order of their length?
        List<String> listOfStringss = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        listOfStringss.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        //TODO Given an integer array, find sum and average of all elements?
        int[] as = new int[]{45, 12, 56, 15, 24, 75, 31, 89};
        int sum1 = Arrays.stream(a).sum();
        System.out.println("Sum = " + sum1);
        double average = Arrays.stream(as).average().getAsDouble();
        System.out.println("Average = " + average);
        // TODO How do you find common elements between two arrays?
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        list1.stream().filter(list2::contains).forEach(System.out::println);
        //TODO Reverse each word of a string using Java 8 streams?
        String str = "Java Concept Of The Day";
        String collect1 = Arrays.stream(str.split("")).map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining());
        System.out.println(collect1);
        //TODO How do you find sum of first 10 natural numbers?
        int sumOf = IntStream.range(1, 11).sum();
        System.out.println(sumOf);
        //TODO Reverse an integer array
        int[] arrays = new int[]{5, 1, 7, 3, 9, 6};
        int[] array2 = IntStream.rangeClosed(1, arrays.length).map(i -> arrays[arrays.length - i]).toArray();
        System.out.println(array2);
        //TODO Print first 10 even numbers
        IntStream.rangeClosed(1, 10).map(i -> i * 2).forEach(System.out::println);
        //TODO How do you find the most repeated element in an array?
        List<String> listOfStringsMap = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        Map<String, Long> elementCountMap = listOfStringsMap.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<String, Long> mostFrequentElement = elementCountMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Most Frequent Element : " + mostFrequentElement.getKey());
        System.out.println("Count : " + mostFrequentElement.getValue());
        //TODO Palindrome program using Java 8 streams
        String strPalindrome = "ROTATOR";
        boolean isItPalindrome = IntStream.rangeClosed(0, strPalindrome.length() / 2).noneMatch(i -> strPalindrome.charAt(i) != strPalindrome.charAt(strPalindrome.length() - i - 1));
        if (isItPalindrome) {
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }
        //TODO Given a list of strings, find out those strings which start with a number?
        List<String> listOfChar = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        listOfChar.stream().filter(str1 -> Character.isDigit(str1.charAt(0))).forEach(System.out::println);
        //TODO How do you extract duplicate elements from an array?
        List<Integer> listOfInteger = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
        Set<Integer> set = new HashSet<>();
        Set<Integer> collect2 = listOfInteger.stream().filter(i -> !set.add(i)).collect(Collectors.toSet());
        System.out.println(collect2);
        //TODO Print duplicate characters in a string?
        String inputStrings = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
        Set<String> set1 = new HashSet<>();
        Set<String> duplicateChars = Arrays.stream(inputStrings.split("")).filter(ch -> !set1.add(ch))
                .collect(Collectors.toSet());
        System.out.println(duplicateChars);
        //TODO Find first repeated character in a string?
        String inputChar = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
        String s = Arrays.stream(inputChar.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() > 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(s);
        // TODO second ways
        Map<String, Long> mapObject = Arrays.stream(inputChar.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String ss = mapObject.entrySet().stream().filter(i -> i.getValue() > 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(ss);
        //TODO Find first non-repeated character in a string?
        String s1 = Arrays.stream(inputChar.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(s1);
        //TODO second ways
        Map<String, Long> mapSen = Arrays.stream(inputChar.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String s2 = mapSen.entrySet().stream().filter(i -> i.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(s2);
        //TODO Fibonacci series
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(10).map(f -> f[0]).forEach(i -> System.out.print(i + " "));
        //TODO First 10 odd numbers
        Stream.iterate(new int[]{1, 3}, f -> new int[]{f[1], f[1] + 2}).limit(10).map(f -> f[0]).forEach(i -> System.out.print(i + " "));
        //TODO How do you get last element of an array?
        List<String> listOfStringsss = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        String lastElement = listOfStringsss.stream().skip(listOfStrings.size() - 1).findFirst().get();
        System.out.println(lastElement);
        //TODO Find the age of a person in years if the birthday has given?
        LocalDate birthDay = LocalDate.of(1985, 01, 23);
        LocalDate today = LocalDate.now();
        System.out.println(ChronoUnit.YEARS.between(birthDay, today));

        //TODO using Character
        List<Character> characters = Arrays.asList('a', 'd', 'a', 'w', 'q', 'p', 'd');
        long characterCount = characters.stream().count();
        System.out.println("Number of characters: " + characterCount);

        //TODO REMOVE DUPLICATE NUMBER FORM LIST
        List<String> list = Arrays.asList("1,3,5", "3,8,4", "9,1,6");
        List<Integer> uniqueNumbers = list.stream()
                .flatMap(sA -> Arrays.stream(sA.split(","))) // Split by comma and flatten
                .map(Integer::parseInt)                  // Convert to integers
                .distinct()                              // Remove duplicates
                .collect(Collectors.toList());           // Collect into a list
        System.out.println(uniqueNumbers);
        // output will :- [1, 3, 5, 8, 4, 9, 6]
        //TODO Find the First Non-Repeating Character in a String
        String strCOUNT = "swiss";
        Character firstNonRepeating = strCOUNT.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1) // Find non-repeating characters
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(firstNonRepeating); // Output: 'w
    }

    //TODO  Group a list of strings by their lengths using Java 8.
    {
        List<String> strings = Arrays.asList("apple", "bat", "cat", "dog", "elephant");
        Map<Integer, List<String>> groupedByLength = strings.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupedByLength);
        //OUTPUT :- {3=[bat, cat, dog], 5=[apple], 8=[elephant]}
    }

    //TODO  Write a program to count the occurrences of each word in a sentence using Java 8
    {
        String sentence = "the quick brown fox jumps over the lazy dog the fox";
        Map<String, Long> wordCounts = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(wordCounts);
        //OUTPUT :- {the=3, quick=1, brown=1, fox=2, jumps=1, over=1, lazy=1, dog=1}

    }

    //TODO How do you convert a list of strings to a map with string lengths as keys and the strings as values?
    {
        List<String> strings = Arrays.asList("one", "two", "three", "four");
        Map<Integer, String> map = strings.stream()
                .collect(Collectors.toMap(String::length, s -> s, (s1, s2) -> s1)); // Handle duplicates

        System.out.println(map);

        //OUTPUT :- {3=one, 5=three, 4=four}
    }

    //TODO How would you demonstrate the difference between sequential and parallel streams
    {
        System.out.println("Sequential Stream:");
        IntStream.range(1, 10)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + " : " + i));

        System.out.println("\nParallel Stream:");
        IntStream.range(1, 10)
                .parallel()
                .forEach(i -> System.out.println(Thread.currentThread().getName() + " : " + i));
    }

    //TODO Find the longest string in a list using Java 8.
    {
        List<String> strings = Arrays.asList("cat", "elephant", "tiger", "dog");
        String longest = strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println(longest); // Output: elephant
    }

    //TODO How do you check if two lists are equal, ignoring the order of elements?
    {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(4, 3, 2, 1);
        boolean areEqual = list1.stream().sorted().collect(Collectors.toList())
                .equals(list2.stream().sorted().collect(Collectors.toList()));

        System.out.println("Are lists equal? " + areEqual);
    }

    //TODO How do you implement a custom comparator using a lambda?
    {
        List<String> words = Arrays.asList("apple", "banana", "pear", "grape");
        List<String> sortedByVowelCount = words.stream()
                .sorted(Comparator.comparingInt(word -> countVowels(word)))
                .collect(Collectors.toList());
        System.out.println(sortedByVowelCount);
    }

    private static int countVowels(String word) {
        return (int) word.chars()
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1)
                .count();
    }

    //TODO Second Highest Number in Array List (Without Using Sorting)
    public static int secondHigeshtNumber(int[] number) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : number) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax && num != firstMax) {
                secondMax = num;
            }
        }
        return (secondMax == Integer.MIN_VALUE) ? -1 : secondMax;
    }
    // TODO Push All Zeroes to End of an Array Program
    public static int[] pushAllZeros(int[] arr) {
        int[] allNonZero = Arrays.stream(arr).filter(num -> num != 0).toArray();
        long allZero = Arrays.stream(arr).filter(num -> num == 0).count();
        int[] result = IntStream.concat(Arrays.stream(allNonZero), IntStream.generate((() -> 0)).limit(allZero)).toArray();
        return result;
    }

   //TODO  int[] arr = {1,2,3,4};  //output will = 9,8,7,6
        public static int[] addShiftedElement(int[] arr){
        int totalSum = stream(arr).sum();
        int[] array = stream(arr).map(num -> totalSum - num).toArray();
        return array;
    }
            //TODO String str = "AACCCEEA"  //Output will  2A3C2E1A
    public static String getCompressedString(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        // Iterate through the string
        for (int i = 1; i <= str.length(); i++) {
            // If the current character is the same as the previous one, increment the count
            if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                // Append the count and character to the result
                sb.append(count).append(str.charAt(i - 1));
                count = 1; // Reset count
            }
        }
        return sb.toString();
    }
        // TODO find the common character in the value output will = B C
         /*
        Map<Integer, List<String>> map1 = new HashMap<>();
        map1.put(1, Arrays.asList("A","B","C"));
        map1.put(2, Arrays.asList("D","B","C"));
        map1.put(3, Arrays.asList("B","Y","C"));
        map1.put(4, Arrays.asList("P","C","B"));
        System.out.println(findCommonCharacters(map1));
         */

    public static Set<String> findCommonCharacters(Map<Integer, List<String>> map) {
            return map.values().stream().map(HashSet::new)
                    .reduce((set1, set2) -> { set1.retainAll(set2); return set1;})
                    .orElse(null);
        }
    /*
    Given a String array, where each entry represents the name and marks of the student.
    TODO Find the average marks scored by each of these students?
Input :
String[] input = ["Akash 78", "Bharat 89", "Akash 90", "Akash 70", "Chetan 67", "Bharat 88", "Bharat 94", "Chetan 84"]
Output:
Akash : (78 + 90 + 70)/3
Bharat: (89 + 88 + 94)/3
Chetan: (67 + 84)/2
{Akash=79.33333333333333, Chetan=75.5, Bharat=90.33333333333333}
     */
    String[] input = {"Akash 78", "Bharat 89", "Akash 90", "Akash 70", "Chetan 67", "Bharat 88", "Bharat 94", "Chetan 84"};
    Map<String, Double> collect = Arrays.stream(input)
            .map(s -> s.split(" "))
            .collect(Collectors.groupingBy(s -> s[0],
                    Collectors.averagingDouble(
                            s -> Double.parseDouble(s[1]))));

/*
Write a program Sum up the all the digits that are there in string until you reach single digit.
Example: input: 123456
when we sum all digits of "123456" then you will get "21" then when you sum up all digits in "21" then we will get "3"
output: 3
 */
public static int sumToSingleDigit(String input) {
    int sum = input.chars().filter(Character::isDigit).map(Character::getNumericValue).sum();
    while (sum >= 10) {
        sum = String.valueOf(sum).chars().map(Character::getNumericValue).sum();
    }
    return sum;
}






}



