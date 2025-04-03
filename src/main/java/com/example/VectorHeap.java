package com.example;
import java.util.ArrayList;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private ArrayList<E> heap;

    public VectorHeap() {
        heap = new ArrayList<>();
    }

    @Override
    public void add(E element) {
        heap.add(element);
        upHeap(heap.size() - 1);
    }

    @Override
    public E remove() {
        if (heap.isEmpty()) return null;
        
        E min = heap.get(0);
        if (heap.size() == 1) {
            heap.remove(0);
        } else {
            heap.set(0, heap.remove(heap.size() - 1));
            downHeap(0);
        }
        return min;
    }
    

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void upHeap(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void downHeap(int index) {
        int leftChild, rightChild, smallest;
        while (index < heap.size() / 2) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            smallest = leftChild;
            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(leftChild)) < 0)
                smallest = rightChild;
            if (heap.get(index).compareTo(heap.get(smallest)) <= 0) break;
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}