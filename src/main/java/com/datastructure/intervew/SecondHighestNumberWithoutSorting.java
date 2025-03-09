package com.datastructure.intervew;

public class SecondHighestNumberWithoutSorting {
    public static void main(String[] args) {
        int[] arr ={12,45,2,6,9,87,67,31};
        System.out.println(secondHighestNumber(arr));
    }
    public static int secondHighestNumber(int[] number){
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int num : number){
            if(num > firstMax){
                secondMax =firstMax;
                firstMax=num;
            } else if (num>secondMax && num!=firstMax) {
                secondMax=num;
            }
        }
        return (secondMax==Integer.MIN_VALUE)?-1:secondMax;
    }
}
