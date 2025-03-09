package com.datastructure.utils;

public class ArrayRange {
    public static void main(String[] args) {
        int[] array = {3,7,10,2,5,8};
        int max = array[0];
        int min = array[0];
        for (int i = 0; i <array.length ; i++) {
            if(array[i]>max){
                max=array[i];
            }
            if(array[i]<min){
                min = array[i];
            }
        }
        int range = max-min;
        System.out.println("Range is "+range);
        System.out.println("Maximum value is" +max);
        System.out.println("Minimum is" +min);    }


}
