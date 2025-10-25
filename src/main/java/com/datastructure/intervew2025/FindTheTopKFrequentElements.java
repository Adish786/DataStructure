package com.datastructure.intervew2025;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheTopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(topKFrequent(nums,k));
    }

    public static List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer, Long> freq = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
       return freq.entrySet().stream().sorted((a,b)->Long.compare(b.getValue(),a.getValue()))
                .limit(k).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
