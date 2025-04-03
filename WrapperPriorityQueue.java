package com.example;
import java.util.PriorityQueue; // Importamos la clase Java, pero usamos la interfaz correcta

public class WrapperPriorityQueue<E extends Comparable<E>> implements com.example.PriorityQueue<E> {
    private PriorityQueue<E> datos;

    public WrapperPriorityQueue() {
        datos = new PriorityQueue<>();
    }

    @Override
    public void add(E element) {
        datos.add(element);
    }

    @Override
    public E remove() {
        return datos.poll();
    }

    @Override
    public boolean isEmpty() {
        return datos.isEmpty();
    }
}
