package com.datastructure.concurrecy;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionExample {
    public static void main(String[] args) {
       // List<String> list = new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        Thread readerThread = new Thread(()->
        {
            System.out.println("Read thread started");
            for(String str : list){
                System.out.println("Read : "+str);
            }
        });
        Thread writerThread = new Thread(()->
        {
            System.out.println("Modify thread started");
            list.add("Seven");
        });
        readerThread.start();
        writerThread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list);
    }
}
