package com.example;

public class PriorityQueueFactory {
    public static <E extends Comparable<E>> com.example.PriorityQueue<E> getPriorityQueue(boolean useHeap) {
        return useHeap ? new VectorHeap<>() : new WrapperPriorityQueue<>();
    }
}
