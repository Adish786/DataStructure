package com.datastructure.intervew;



import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CodingJava8 {
    public static void main(String[] args) {
        //TODO Group by first character and count
        List<String> words = Arrays.asList("apple","banana","oragne","kiwi","apricot");
        Map<Character, Long> result = words.stream().collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.counting()));
        System.out.println(result);
        //TODO Find Most Frequent Element
        List<String> iteams = Arrays.asList("a","b","a","c","a","b");
    String mostFrequent =  iteams.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()))
            .entrySet().stream().max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey).orElse(null);
        System.out.println(mostFrequent);
        //TODO Group Strings by Length
        List<String> wordsString = Arrays.asList("java","node","spring","golang");
        Map<Integer, List<String>> count = wordsString.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(count);
        //TODO Sort Map By Value in Descending Order
        Map<String,Integer> map =Map.of("apple",5,"banana",10,"orange",20);
        LinkedHashMap<String,Integer> shortMap= map.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2)->e1,LinkedHashMap::new));
        System.out.println(shortMap);
        //TODO Flatten Nested List & Remove Duplicates
        List<List<String>> nested  = Arrays.asList(
                Arrays.asList("apple","banana"),
                Arrays.asList("banana","orange"),
                Arrays.asList("grape","mango"),
                Arrays.asList("apple","orange"));
        List<String> collect = nested.stream().flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
        System.out.println(collect);
        //TODO Find duplcate elements in list
        List<String> names = Arrays.asList("java","python","java","golang","python","C++");
        Set<String> seen = new HashSet<>();
        Set<String> duplcate = names.stream().filter(name->!seen.add(name)).collect(Collectors.toSet());
        System.out.println(duplcate);
        //TODO Sum of All digits in a String
        String str = "a1b2c3";
        int sum = str.chars().filter(Character::isDigit).map(Character::getNumericValue).sum();
        System.out.println(sum);
        //TODO Sort a List Of Objects by Multiple fields
/*
        List<User> users = Arrays.asList(
                new User(1,"Adish"),
                new User(2,"Ansari"),
                new User(3,"Adi"));
      users.sort(Comparator.comparing(User::getName).thenComparing(User::getId));

 */

        /*
        Input : [2,4,[4,6,7],8,[10]] output : [2,4,4,6,7,8,10]
         */
 List<Object> input = Arrays.asList(2, 4, Arrays.asList(4, 6, 7), 8, Arrays.asList(10));

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





    }



    public  class User {
        int id;
        String name ;
        public User(int id,String name){
            this.id=id;
            this.name=name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
