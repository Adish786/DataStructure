package com.datastructure.concurrecy;

import java.util.concurrent.*;

public class ExecutorsExample1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        System.out.println("Starting");
        Future<Integer> sum = ex.submit(new Sum(10));
        Future<Double> squareRoot = ex.submit(new SquareRoot(16));
        Future<Integer> factorial = ex.submit(new Factorial(5));
   System.out.println(sum.get());
   System.out.println(squareRoot.get());
   System.out.println(factorial.get());
   ex.shutdown();
   System.out.println("Completed");
    }
}

class Sum implements Callable<Integer> {
int stop;
Sum(int v){
    stop=v;
}
    @Override
    public Integer call() throws Exception {
    int sum =0;
    for(int i =0;i<=stop;i++){
     sum+=i;
    }
    return sum;
    }
}

class SquareRoot implements Callable<Double> {
    double num;
    SquareRoot(double num){
        this.num=num;
    }
    @Override
    public Double call() throws Exception {
        return  Math.sqrt(num);
    }
}

class Factorial implements Callable<Integer>{

    int stop;
    Factorial(int v){
        stop=v;
    }
    @Override
    public Integer call() throws Exception {
       int fact =1;
       for(int i =2;i<stop;i++){
           fact *=i;
       }
        return fact;
    }
}