package com.datastructure.intervew;
/*
There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
You are given an integer array gain of length n where gain[i] is the net gain in altitude between points  and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
Example 1:
Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
Example 2:
Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 */

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        int[] gain1 = {-5,1,5,0,-7};
        int[] gain2 = {-4,-3,-2,-1,4,3,2};
        int gcd = largestAltitude(gain1);
        System.out.println(gcd);
        int gcd2 = largestAltitude(gain2);
        System.out.println(gcd2);

    }
    public static int largestAltitude(int[] gain) {
        for(int i=1;i<gain.length;i++){
            gain[i]+=gain[i-1];
        }
        int ans=gain[0];
        for(int i=0;i<gain.length;i++){
            ans=Math.max(gain[i],ans);
        }
        if(ans<0) return 0;
        return ans;
    }
}




