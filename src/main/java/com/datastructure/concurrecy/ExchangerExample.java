package com.datastructure.concurrecy;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static final Exchanger<String> exchanger = new Exchanger<>();
    public static void main(String[] args) {
        Thread t1 = new Thread(
                ()->{
                    exchangeData("Thread 1 : Sending Data","Data from Thread 1");
                });
        Thread t2 = new Thread(
                ()->{
                    exchangeData("Thread 2 : Sending Data","Data from Thread 2");
                });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void exchangeData(String message,String dataToSend){
        try {
            System.out.println(message+" : "+dataToSend);
           String receiveData =  exchanger.exchange(dataToSend);
           System.out.println(message + "Recived" + receiveData);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
