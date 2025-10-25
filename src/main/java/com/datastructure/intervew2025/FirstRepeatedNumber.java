package com.datastructure.intervew2025;

import java.util.*;
import java.util.stream.IntStream;
/*
TODO Find the 1st repetitive value and its 1st index from the samplelist
List<Integer> samplelist = Arrays.asList(1,2,3,4,5,6,7,4,8,9,6);
First Repeated Number: 4
Index of Repeated : 7
 */
public class FirstRepeatedNumber {
    public static void main(String[] args) {
        List<Integer> samplelist = Arrays.asList(1,2,3,4,5,6,7,4,8,9,6);
        System.out.println(firstRepeatedNumber(samplelist));//output will :-  4,7
        List<Integer> sampleListRepeated = Arrays.asList(5,3,8,2,3,7,8,5);
        System.out.println(repeatedNumber(sampleListRepeated));  //First repeted number :3  First occurrence index1 Repetition index : 4
    }

    public static Optional<int[]> firstRepeatedNumber(List<Integer> samplelist ){
        Map<Integer,Integer> seen = new HashMap<>();
        Optional<int[]> result = IntStream.range(0,samplelist.size())
                .mapToObj(i->new int[]{i,samplelist.get(i)})
                .filter(entry->seen.putIfAbsent(entry[1],entry[0])!=null)
                .findFirst();
        if(result.isPresent()){
            int[] res = result.get();
            System.out.println("First Repeated Number: " +res[1] );
            System.out.println("Index of Repeation : " +res[0]);
        }
        else {
            System.out.println("No Repeated numbers found");
        }
        return result;
    }
    public static Optional<int[]> repeatedNumber(List<Integer> samplelist){
        Map<Integer,Integer> seen = new HashMap<>();
        Optional<int[]> result = IntStream.range(0,samplelist.size())
                .mapToObj(i->new int[]{i,samplelist.get(i)})
                .filter(entry->{
                            Integer firstIndex = seen.putIfAbsent(entry[1],entry[0]);
                            return firstIndex!=null;
                        }
                ).map(entry->new int[]{seen.get(entry[1]),entry[0],entry[1]})
                .findFirst();
        if(result.isPresent()){
            int[] res = result.get();
            System.out.println("First repeted number :" +res[2]);
            System.out.println("First occurrence index" +res[0]);
            System.out.println("Repetition index : " +res[1]);
        }
        else {
            System.out.println("No repeated numbers");
        }
        return result;
    }
}
