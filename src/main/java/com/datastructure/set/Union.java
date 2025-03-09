package com.datastructure.set;

import java.util.HashSet;
import java.util.Set;

public class Union {
    public static void main(String[] args) {
        Set<Integer> arr1 = new HashSet<>();
        arr1.add(1);
        arr1.add(6);
        arr1.add(5);
        arr1.add(9);
        arr1.add(2);
        arr1.add(8);
        arr1.add(4);
        arr1.add(7);
        Set<Integer> arr2 = new HashSet<>();
        arr2.add(1);
        arr2.add(10);
        arr2.add(5);
        arr2.add(21);
        arr2.add(2);
        arr2.add(22);
        arr2.add(40);
        arr2.add(7);
        System.out.println(union(arr1,arr2));
    }

  public  static <T> Set<T> union(Set<T> a, Set<T> b)
    {
        Set<T> res = new HashSet<T>(a);
        res.addAll(b);
        return res;
    }

}
