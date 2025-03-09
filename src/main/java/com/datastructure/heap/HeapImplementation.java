package com.datastructure.heap;

/*
Implement a max heap from a given array of integers.

Input Format
The first line contains a single integer ( n ), representing the number of elements in the array.
The second line contains ( n ) space-separated integers representing the elements of the array.
Output Format
Print the elements of the array re-arranged into a max heap.
Constraints
1 <= n <= 10^4
1 <= arr[i] <= 10^4, where arr[i] is the i-th element of the array.
Sample Input 1
9
5 3 2 1 6 7 8 9 4
Sample Output 1
9 6 8 4 5 7 2 1 3
Explanation
The output represents the given array re-arranged into a max heap, where every parent node is greater than its child nodes.

Sample Input 2
5
1 2 3 4 5
Sample Output 2
5 4 3 1 2
Explanation
Start by comparing the elements from the last parent node to the root.
For the last parent node (index 1), the two child nodes are 4 and 5. Since 5 is larger than 2, we swap them.
Move up to the root node (index 0). The child nodes are 2 (which has been swapped with 5) and 3. The largest among them is 5, so we swap 5 with 1.
Continue this process until the array satisfies the max heap property, where each parent node is greater than or equal to its children.
Final Max Heap: The array [5, 4, 3, 1, 2] represents a max heap where the root is the largest element (5), and each parent node is greater than its child nodes
 */
public class HeapImplementation {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 6, 7, 8, 9, 4};
        int n = 9;
        buildMaxHeap(arr, n);
    }

    public static void buildMaxHeap(int[] arr, int n) {
        int startIdx = (n / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

}
