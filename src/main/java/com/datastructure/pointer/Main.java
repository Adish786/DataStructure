package com.datastructure.pointer;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        map1.put("value",11);
        map2 =map1;
        map1.put("value",22);
        System.out.println(map1);
        System.out.println(map2);

    }

}
