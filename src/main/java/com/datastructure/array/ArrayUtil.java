package com.datastructure.array;

public class ArrayUtil {

    public void printArray(int[] arr){
        int n = arr.length;
        for (int i = 0; i <n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public void arrayDemo(){
        int[] myArray = new int[5];   //default values
        myArray[0]=5;
        myArray[1]=4;
        myArray[2]=3;
        myArray[3]=2;
        myArray[4]=1;
        myArray[2]=10;
        printArray(myArray);
        System.out.println(myArray.length);
    }
  public  int[] removeEven(int[] arr){
        int oddCount =0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]%2!=0){
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int idx =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                result[idx] = arr[i];
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.arrayDemo();
    }


    }
