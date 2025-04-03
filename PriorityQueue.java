package com.example;
/**
 * Interfaz de una cola con prioridad, segun lo que se ha visto en clase.
 * Esta interfaz define los metodos que debe implementar una cola con prioridad.
 */
public interface PriorityQueue<E extends Comparable<E>> {
    void add(E element);
    E remove();
    boolean isEmpty();
}
