package com.datastructure.heap;

public class HeapMain {
    public static void main(String[] args) {
        Heap heap= new Heap();
        heap.insert(99);
        heap.insert(72);
        heap.insert(61);
        heap.insert(58);
        heap.insert(100);
        heap.insert(75);
        System.out.println(heap.getHeap());
        heap.remove();
        System.out.println(heap.getHeap());
        heap.remove();
        System.out.println(heap.getHeap());
    }
}
