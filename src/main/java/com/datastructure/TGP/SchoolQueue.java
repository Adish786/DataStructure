package com.datastructure.TGP;
/*
School Queue
Boys and girls, formed a queue of n people in the assembly. Initially the children stood in the order they entered the assembly. However, after a while the boys started feeling awkward for standing in front of the girls in the queue and they started letting the girls move forward each second.

Let's describe the process more precisely. Let's say that the positions in the queue are sequentially numbered by integers from 1 to n, at that the person in the position number 1 is served first. Then, if at time x a boy stands on the i-th position and a girl stands on the (i + 1)-th position, then at time x + 1 the i-th position will have a girl and the (i + 1)-th position will have a boy. The time is given in seconds.

You've got the initial position of the children, at the initial moment of time. Determine the way the queue is going to look after t seconds.

Input:

The first line contains two integers n and t (1 ≤ n, t ≤ 50), which represent the number of children in the queue and the time after which the queue will transform into the arrangement you need to find.
The next line contains string s, which represents the schoolchildren's initial arrangement.
Output:
***`Return string a, which describes the arrangement after t seconds. ***
Sample Input:
8 3
BBGBGBGB
Sample Output:
GGBGBBBB
Sample Input:
3 1
BGG
Sample Output:
GBG
 */

public class SchoolQueue {
    public  static String solve(int n, int x, String str) {
        char[] queue = str.toCharArray();

        for (int time = 0; time < x; time++) {
            for (int i = 0; i < n - 1; i++) {
                if (queue[i] == 'B' && queue[i + 1] == 'G') {
                    queue[i] = 'G';
                    queue[i + 1] = 'B';
                    i++;
                }
            }
        }
        String result = new String(queue);
        return  result;
    }

    public static void main(String[] args) {
            String str ="BBGBGBGB";
            int n =8;
            int x =3;
        System.out.println(solve(n,x,str));
    }
}
