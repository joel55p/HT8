package com.example;

/*clase donde se aplica el patron de diseño factory, es decir que  el main ni se ve a preocupar de implementar algo en especifico */
public class PriorityQueueFactory {
    public static <E extends Comparable<E>> com.example.PriorityQueue<E> getPriorityQueue(boolean useHeap) {
        return useHeap ? new VectorHeap<>() : new WrapperPriorityQueue<>(); /*true si vectorHeap o false  el Wrapper */
    }
}
