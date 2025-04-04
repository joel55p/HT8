package com.example;

/*clase que como tal implementa la cola de prioridad en lugar de VectorHeap */
import java.util.PriorityQueue; // Importamos la clase Java, pero usamos la interfaz correcta

public class WrapperPriorityQueue<E extends Comparable<E>> implements com.example.PriorityQueue<E> {
    private PriorityQueue<E> datos; /*Usamos PriorityQueue con base a la interfaz de Java */

    public WrapperPriorityQueue() { /*Constructor, inicia la cola vacia */
        datos = new PriorityQueue<>();
    }

    @Override
    public void add(E element) { /*agrega elemento a cola de prioridad */
        datos.add(element);
    }

    @Override
    public E remove() { /*lo elimina de cola  */
        return datos.poll(); /*el poll() devuelve y elimina  el primer elemento */
    }

    @Override
    public boolean isEmpty() { /*verifica si la cola esta vacia */
        return datos.isEmpty();
    }
}
