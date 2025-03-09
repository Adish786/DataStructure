package com.datastructure.hashTable;


import java.util.*;

public class HashTable {
    private int size =7;
    private Node[] dataMap;
    public HashTable(){
        dataMap = new Node[size];
    }

    class Node {
        private String key;
        private int value;
        private Node next;
        public Node(String key,int value){
            this.key=key;
            this.value =value;
        }
    }

            public void printTable(){
                for (int i = 0; i <dataMap.length ; i++) {
                    System.out.println(i + " :");
                    Node temp = dataMap[i];
                    while (temp!=null){
                        System.out.println(" { " +temp.key + "+" +temp.value + " } ");
                        temp = temp.next;
                    }
                }
            }
    private int hash(String key){
        int hash = 0;
        char[] keyHash = key.toCharArray();
        for (int i = 0; i <keyHash.length ; i++) {
            int asciiValue = keyHash[i];
            hash = (hash+asciiValue *23)% dataMap.length;
        }
        return hash;
    }

    public void  set(String key ,int value){
        int index = hash(key);
        Node newNode = new Node(key,value);
        if(dataMap[index]==null){
            dataMap[index] = newNode;
        }
        else {
            Node temp = dataMap[index];
            while (temp.next!=null){
                temp = temp.next;
            }
        temp.next = newNode;
        }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp!=null){
            if(temp.key==key) return temp.value;
            temp =temp.next;
        }
        return 0;
    }


    public ArrayList keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i <dataMap.length ; i++) {
            Node temp = dataMap[i];
         while (temp!=null){
             allKeys.add(temp.key);
             temp  =temp.next;
         }
        }
        return allKeys;
    }

    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> myHashMap = new HashMap<>();
        for (int i : array1) {
            myHashMap.put(i, true);
        }

        for (int j : array2) {
            if (myHashMap.get(j) != null) return true;
        }

        return false;
    }
    // TODO Intervew question
    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }
    //TODO Intervew Question
    public static Character firstNonRepeatingChar(String string) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (charCounts.get(c) == 1) {
                return c;
            }
        }
        return null;
    }

    //TODO Intervew question
    public static List<List<String>> groupAnagrams(String[] strings){
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strings) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            anagramMap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
   //TODO two sum
   public static int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
           int complement = target - nums[i];
           if (map.containsKey(complement)) {
               return new int[] { map.get(complement), i };
           }
           map.put(nums[i], i);
       }
       return new int[] {};
   }

   //TODO subArray sum
   public static int[] subarraySum(int[] nums, int target) {
       Map<Integer, Integer> sumIndex = new HashMap<>();
       sumIndex.put(0, -1);
       int currentSum = 0;
       for (int i = 0; i < nums.length; i++) {
           currentSum += nums[i];
           if (sumIndex.containsKey(currentSum - target)) {
               return new int[]{sumIndex.get(currentSum - target) + 1, i};
           }
           sumIndex.put(currentSum, i);
       }

       return new int[]{};
   }
   //TODO intervew question
    public static List<Integer> removeDuplicates(List<Integer> myList){
        Set<Integer> hash = new HashSet<>(myList);
        return new ArrayList<>(hash);
    }
    //TODO Intervew question
    public static boolean hasUniqueChars(String string){
        Set<Character> charSet = new HashSet<>();
        for (char ch : string.toCharArray()) {
            if (charSet.contains(ch)) {
                return false;
            }
            charSet.add(ch);
        }
        return true;
    }
    //TODO Intervew question
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        Set<Integer> set = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            int complement = target - num;
            if (set.contains(complement)) {
                result.add(new int[] {complement, num});
            }
        }
        return result;
    }

//TODO Intervew question
    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
























