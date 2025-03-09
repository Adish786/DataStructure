package com.datastructure.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuketSort1 {
    public static void main(String[] args) {
//TODO Wrong
    }




    public static String bucketSortCars(String array) {
        if (array.length() == 0) {
            return "";
        }
        int maxLength = 0;
        for (String str : array.split("")) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }
        List<List<String>> buckets = new ArrayList<>(maxLength + 1);
        for (int i = 0; i <= maxLength; i++) {
            buckets.add(new ArrayList<>());
        }
        for (String str : array.split("")) {
            buckets.get(str.length()).add(str);
        }
        int index = 0;
        for (List<String> bucket : buckets) {
            Collections.sort(bucket);
            for (String str : bucket) {
                array.split("")[index++] = str;
            }
        }
        return array;
    }
}
