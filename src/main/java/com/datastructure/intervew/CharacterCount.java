package com.datastructure.intervew;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterCount {
    public static void main(String[] args) {
        String str = "Hello, World!";
        HashMap<Character, Integer> charCount = new HashMap<>();
        for(char c : str.toCharArray()){
            if(charCount.containsKey(c)){
                charCount.put(c,charCount.get(c)+1);
            }
            else{
                charCount.put(c,1);
            }
        }
        Map<Integer,String> hashmap = new HashMap<>();
        hashmap.put(22,"A");
        hashmap.put(55,"B");
        hashmap.put(33,"Z");
        hashmap.put(44,"M");
        hashmap.put(99,"I");
        hashmap.put(88,"X");
        //TODO sort this hashmap based on values alphabetically and print sorted hashmap

     //   Map<Integer, String> sortedMap = hashmap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new ));
     //   sortedMap.forEach((key, value) -> System.out.println(key + " : " + value));
        // TODO Second ways Get entries of the HashMap
        List<Map.Entry<Integer, String>> list = new ArrayList<>(hashmap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> entry1, Map.Entry<Integer, String> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });
        LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println(charCount);
        //TODO using Character anf Long
        Map<Character,Long> collect=  str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(collect);

                    //TODO using Character
        List<Character> characters = Arrays.asList('a','d','a','w','q','p','d');
        long characterCount = characters.stream().count();
        System.out.println("Number of characters: " + characterCount);
        CharacterCount character = new CharacterCount();
        System.out.println(character.countFrequency("hello")); // {'h': 1, 'e': 1, 'l': 2, 'o': 1}


        /*
        Input: "aaabccccdd"
        Compressed Output: "a3b1c4d2"
         */
        String str1 = "aaabccccdd";
        Map<Character, Long> collect1 = str1.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);
    }
    public Map<Character, Integer> countFrequency(String s) {
        Map<Character, Integer> freqDict = new HashMap<>(); // Initialize frequency dictionary
        for (char c : s.toCharArray()) {
            freqDict.put(c, freqDict.getOrDefault(c, 0) + 1); // Update the count for the character
        }
        return freqDict;

    }

    /*
"I am Adish"
I -> 1
am -> 2
Adish-> 5
 */
    {
        String str = "I am Adish";
        Map<String, Integer> wordLengths = Stream.of(str.split(" ")).collect(Collectors.toMap(word -> word,
                word -> word.length()));
        wordLengths.forEach((word, length) ->
                System.out.println(word + " -> " + length)
        );
    }




}
