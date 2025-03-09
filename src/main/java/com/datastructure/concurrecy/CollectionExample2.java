package com.datastructure.concurrecy;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CollectionExample2 {
    public static void main(String[] args) {
       // Set<String> set = new HashSet<>();
        Set<String> set = new CopyOnWriteArraySet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");
        set.add("Six");
        Thread readerThread = new Thread(()->
        {
            System.out.println("Read thread started");
            for(String str : set){
                System.out.println("Read : "+str);
            }
        });
        Thread writerThread = new Thread(()->
        {
            System.out.println("Modify thread started");
            set.add("Seven");
        });
        readerThread.start();
        writerThread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(set);
    }
}
