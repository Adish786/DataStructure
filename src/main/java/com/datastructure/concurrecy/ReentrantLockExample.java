package com.datastructure.concurrecy;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        MyThread3 t1 = new MyThread3(greeting,"Adish");
        MyThread3 t2 = new MyThread3(greeting,"Ansari");
        t1.start();
        t2.start();
    }
}


class Greeting{

ReentrantLock reentrantLock = new ReentrantLock();

    public void wish(String name){
reentrantLock.lock();
        for(int i =0;i<5;i++){
            try {
                Thread.sleep(2000);
                System.out.println("Hello " +name);
            }
            catch (InterruptedException e){
                throw  new RuntimeException(e);
            }
        }
        reentrantLock.unlock();
    }
}

class MyThread3 extends Thread{
    Greeting greeting;
    String  name;
    MyThread3(Greeting greeting ,String name){
        this.greeting=greeting;
        this.name=name;
    }
    public void run(){
        greeting.wish(name);
    }
}
