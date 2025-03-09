package com.datastructure.intervew;

public class DecimalToBinary {
    public static void main(String[] args) {
        int[] examples = {0,27,5};
        for(int example: examples ){
            String binary = decimalToBinary(example);
            System.out.println(example + "  is  "  + binary);
        }
    }
    public static String decimalToBinary(int decimal){
        if(decimal==0){
            return "";
        }
        return decimalToBinary(decimal/2)+decimal%2;
    }
}
