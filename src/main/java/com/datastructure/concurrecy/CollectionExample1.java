package com.datastructure.concurrecy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionExample1 {
    public static void main(String[] args) {
        Map<String,Integer> map = new ConcurrentHashMap<>();
    //   Map<String,Integer> map = new HashMap<>();
        map.put("One",1);
        map.put("Two",2);
        map.put("Three",3);
        map.put("Four",4);
        map.putIfAbsent("Five",5);
        Integer result = map.putIfAbsent("Four",4);
        map.remove("One",1);
        map.replace("Two",2,22);
        System.out.println("Result : " +result);
        System.out.println(map);
        Thread readThread = new Thread(()->{
            for(String key:map.keySet()){
                System.out.println("Key: "+key+ ",Value: " +map.get(key));
            }
        });
        readThread.start();
        Thread writeThread = new Thread(()->{
         map.put("Six",6);
        });
        writeThread.start();
    }
}
