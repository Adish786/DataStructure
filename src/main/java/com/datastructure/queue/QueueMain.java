package com.datastructure.queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);
        queue.dequeue();
        queue.getFirst();
        queue.getLast();
        queue.printQueue();

    }
}
