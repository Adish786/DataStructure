package com.datastructure.intervew2025;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Coding8 {
    @Data
    public class Employee {
      protected   String name;
      protected   int salary;
        Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }
    }
    List<Employee> employees = Arrays.asList(
            new Employee("Alice", 5000),
            new Employee("Bob", 7000),
            new Employee("Charlie", 4000)
    );
    public static void main(String[] args) {
         /*  TODO   Input : [2,4,[4,6,7],8,[10]] output : [2,4,4,6,7,8,10] */
        List<Object> input = Arrays.asList(2, 4, Arrays.asList(4, 6, 7), 8, Arrays.asList(10));
        System.out.println(returnSingleList(input));
        /* TODO Find max and min */
        List<Integer> list = Arrays.asList(1,2,3,5,6,9,10,3,5);
        Integer max = list.stream().max(Integer::compareTo).get();
        Integer min = list.stream().min(Integer::compareTo).get();
        System.out.println("Max: "  +max);
        System.out.println("Min :" +min);

        String str = "Adish";
        str.chars().mapToObj(i->(char)i).forEach(System.out::println);
                    //TODO Second Way
        Arrays.stream(str.split("")).forEach(System.out::println);
        char[] chars = str.toCharArray();
        System.out.println(Arrays.toString(chars));
        /* TODO List<String> list = Arrays.asList("Mango","Banana","Apple","Papaya");
            Key =5 value =[Mango,Apple]
            key = 6 value =[Papaya,Banana]
         */
        List<String> listStringSize = Arrays.asList("Mango","Banana","Apple","Papaya");
        Map<Integer, List<String>> result = listStringSize.stream().collect(Collectors.groupingBy(String::length));
        result.forEach((k, v) -> System.out.println("Key = " + k + " Value = " + v));
        //TODO Find max and min salary of employees
      //  Employee maxSalaryEmp = employees.stream().max(Comparator.comparingInt(i->i.salary)).orElse(null);
      //  Employee minSalaryEmp = employees.stream().min(Comparator.comparingInt(i->i.salary)).orElse(null);
            //TODO Flatten a nested list
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4, 5),
                Arrays.asList(6, 7)
        );
        List<Integer> flatList = numbers.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatList); // [1, 2, 3, 4, 5, 6, 7]
        //TODO Find duplicate elements in a list
        List<Integer> nums = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6);
        Set<Integer> findDuplicate = nums.stream().filter(i -> Collections.frequency(nums, i) > 1).collect(Collectors.toSet());
        System.out.println(findDuplicate);
        //TODO Sort employees by salary (descending) and then by name
        //List<Employee> descending = employees.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(n -> n.getName())).collect(Collectors.toList());
       // System.out.println(descending);
        //TODO Find the longest word in a sentence
        String sentence = "Java 8 interview questions are tricky";
        String s = Arrays.stream(sentence.split("")).max(Comparator.comparing(String::length)).get();
        System.out.println(s);

        //TODO Partition numbers into even and odd
        List<Integer> numbersEvenOrOdd = IntStream.rangeClosed(1,10).boxed().toList();
        Map<Boolean, List<Integer>> evenOrOdd = numbersEvenOrOdd.stream().collect(Collectors.partitioningBy(i -> i % 2 == 1));
        System.out.println("Even" +evenOrOdd.get(true));
        System.out.println("Odd" +evenOrOdd.get(false));

        //TODO Convert List<Employee> to Map<name, salary>
       // Map<String, Integer> empMap = employees.stream().collect(Collectors.toMap(e -> e.name, e -> e.salary));

        //TODO Find sum of length of unique characters of all substrings in a
        // strings, using Java 8( Ex: abc, o/p: 10)
        // a, b, c, ab, bc,  abc  -- Total count is 10
        String inputs = "abc";
        int sum = IntStream.range(0, inputs.length()).boxed()
                .flatMap(i -> IntStream.range(i + 1, inputs.length() + 1)
                        .mapToObj(j -> inputs.substring(i, j)))
                .mapToInt(s1 -> (int) s1.chars().distinct().count()).sum();
        System.out.println("Sum of unique character counts = " + sum);
        Map<Integer, List<String>> map1 = new HashMap<>();
        map1.put(1, Arrays.asList("A","B","C"));
        map1.put(2, Arrays.asList("D","B","C"));
        map1.put(3, Arrays.asList("B","Y","C"));
        map1.put(4, Arrays.asList("P","C","B"));
        System.out.println(findCommonCharacters(map1));
        //TODO second largest number
        List<Integer> list1 = Arrays.asList(1,3,5,23,7,9,8);
        Integer sort = list1.stream().distinct().sorted((a, b) -> b - a).skip(1).findFirst().get();
        System.out.println(sort);

    }
    public static Set<String> findCommonCharacters(Map<Integer, List<String>> map) {
        return map.values().stream().map(HashSet::new)
        .reduce((set1, set2) -> { set1.retainAll(set2); return set1;}).orElse(null);
    }

    public static List<Integer> returnSingleList(List<Object> input){
        List<Integer> output = input.stream()
                .flatMap(obj -> {
                    if (obj instanceof Integer) {
                        return Stream.of((Integer) obj);
                    } else if (obj instanceof List) {
                        return ((List<?>) obj).stream().map(e -> (Integer) e);
                    }
                    return Stream.empty();
                })
                .collect(Collectors.toList());
        System.out.println(output);
        return output;
    }

}
