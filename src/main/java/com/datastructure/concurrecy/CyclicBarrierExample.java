package com.datastructure.concurrecy;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()-> {
            System.out.println("Barrier Reached!");
        });
        System.out.println("Starting...");
        new MyThread(cyclicBarrier,"A");
        new MyThread(cyclicBarrier,"B");
        new MyThread(cyclicBarrier,"C");
    }
}

class MyThread{
    CyclicBarrier cyclicBarrier;
    String name;
    MyThread(CyclicBarrier cyclicBarrier,String name){
        this.cyclicBarrier=cyclicBarrier;
        this.name=name;
    new Thread(r1).start();
    }
    Runnable r1 = ()->{
        System.out.println(name);
        try{
//            cyclicBarrier.await();
            cyclicBarrier.await(10, TimeUnit.SECONDS);
        }
        catch (InterruptedException | BrokenBarrierException e){
            throw  new RuntimeException();
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    };
}