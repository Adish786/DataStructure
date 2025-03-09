package com.datastructure.array;
/* Java program to generate all possible sub arrays/subArrays
  Complexity- O(n^3)
*/

public class SubArrays
{
   public static int arr[] = new int[]{1, 2, 3, 4};
   public static void subArray( int n)
    {
        for (int i=0; i <n; i++)
        {
            for (int j=i; j<n; j++)
            {
                // Print sub array between current starting and ending points
                for (int k=i; k<=j; k++)
                    System.out.print(arr[k]+" ");
                System.out.println();
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.println("All Non-empty Subarrays");
        subArray(arr.length);
    }
}
