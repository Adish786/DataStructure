package com.datastructure.concurrecy;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int currentPhaser;
        System.out.println("Starting.......");
        new MyThread1(phaser,"A");
        new MyThread1(phaser,"B");
        new MyThread1(phaser,"C");
        currentPhaser = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase  "+currentPhaser+" Completed");
        currentPhaser = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase  "+currentPhaser+" Completed");
        currentPhaser = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase  "+currentPhaser+" Completed");
        phaser.arriveAndDeregister();
        if(phaser.isTerminated()){
            System.out.println("The phaser is Terminated!");
        }
    }
}

class MyThread1{
    Phaser phaser;
    String name;
    MyThread1(Phaser p ,String n){
        this.phaser=p;
        this.name=n;
        p.register();
        new Thread(r).start();
    }
    Runnable r=()->{
        System.out.println("Thread "+name+" Beginning phase one");
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread "+name+" Beginning phase two");
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread "+name+" Beginning phase three");
      phaser.arriveAndDeregister();
    };
}
