package com.datastructure.map;

/*
TODO You are asked to design a rate limiter (e.g., max 100 requests/sec per user). How would you implement it in Core Java?
*/
public class TokenBucket {
    final long capacity = 100;
    final long refillPerSec = 100;
    long tokens = capacity;
    long lastRefill = System.nanoTime();
    synchronized boolean allow() {
        long now = System.nanoTime();
        long toAdd = ((now - lastRefill) / 1_000_000_000L) * refillPerSec;
        if (toAdd > 0) { tokens = Math.min(capacity, tokens + toAdd); lastRefill = now;}
        if (tokens > 0) { tokens--; return true; }
        return false;
    }
    public static void main(String[] args) {

    }
}
