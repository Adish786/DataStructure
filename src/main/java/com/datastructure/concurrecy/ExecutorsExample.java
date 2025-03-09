package com.datastructure.concurrecy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {
    public static void main(String[] args) {
        //     ExecutorService ex = Executors.newFixedThreadPool(3);
        //  ExecutorService ex = Executors.newCachedThreadPool();
        ScheduledExecutorService ex = Executors.newScheduledThreadPool(3);
      /*
        for (int i =0;i<=10;i++){
            ex.execute(new Task(i));
       //Thread t1 = new Thread(new Task(i));
       //t1.start();
}
        ex.shutdown();
       */
        ex.scheduleAtFixedRate(new Task(9),3,1, TimeUnit.SECONDS);

    }
}
class Task implements Runnable{
private int taskId;
public Task(int taskId){
    this.taskId=taskId;
}
    @Override
    public void run() {
        System.out.println("Task " + taskId + "  is running on thread: " +Thread.currentThread().getName());

    }
}
