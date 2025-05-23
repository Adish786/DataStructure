package com.datastructure.intervew;
/*
Minimum Platforms Required for Given Arrival and Departure Times
Last Updated : 02 Sep, 2024
We are given two arrays that represent the arrival and departure times of trains, the task is to find the minimum number of platforms required so that no train waits.
Examples:
Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}, dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)
Input: arr[] = {9:00, 9:40}, dep[] = {9:10, 12:00}
Output: 1
Explanation: Only one platform is needed.
 */
public class MinimumPlatforms {
    public static int findPlatform(int arr[], int dep[], int n)
    {
        // plat_needed indicates number of platforms
        // needed at a time
        int plat_needed = 1, result = 1;
        // run a nested  loop to find overlap
        for (int i = 0; i < n; i++) {
            // minimum platform
            plat_needed = 1;
            for (int j = 0; j < n; j++) {
                if (i != j)
                    // check for overlap
                    if (arr[i] >= arr[j] && dep[j] >= arr[i])
                        plat_needed++;
            }
            result = Math.max(result, plat_needed);
        }
        return result;
    }
    //TODO Second Ways
    static int countPlatforms(int n,int arr[],int dep[])
    {
        int ans=1; //final value
        for(int i=0;i<=n-1;i++)
        {
            int count=1; // count of overlapping interval of only this   iteration
            for(int j=i+1;j<=n-1;j++)
            {
                if((arr[i]>=arr[j] && arr[i]<=dep[j]) || (arr[j]>=arr[i] && arr[j]<=dep[i]))
                {
                    count++;
                }
            }
            ans=Math.max(ans,count); //updating the value
        }
        return ans;
    }
    public static void main(String[] args)
    {
        int arr[] = { 100, 300, 500 };
        int dep[] = { 900, 400, 600 };
        int n = 3;
        System.out.println(findPlatform(arr, dep, n));
    }
}
