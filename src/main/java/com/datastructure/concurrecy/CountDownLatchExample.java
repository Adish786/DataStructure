package com.datastructure.concurrecy;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        for(int i =1;i<=3;i++){
            new Thread(
                    ()->{
              System.out.println("Task completed By Thread" +Thread.currentThread().getId());
             latch.countDown();
                    }).start();
        }
        try {
            latch.await();
            System.out.println("All tasks completed. Proceeding to the next Step !");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
